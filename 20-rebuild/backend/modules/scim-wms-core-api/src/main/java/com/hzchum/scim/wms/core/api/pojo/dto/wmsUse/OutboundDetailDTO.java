package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndSerialNumberDO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OutboundDetailDTO {
   private Long id;
   private Long classifyId;
   private String classifyName;
   private Boolean boolPartyA;
   private Integer materialOutboundMode;
   private Integer basicClass;
   private String specification;
   private Integer outboundRelationType;
   private Integer outboundUnitType;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String heatNoAndBatchNo;
   private String remark;
   private BigDecimal mete;
   private String color;
   private BriefDeptAndNameDTO recipient;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO mesWorkshop;
   private ProjectInfo project;
   private String monomerName;
   private String areaName;
   private String areaBatchName;
   private ProjectInfo sourceProject;
   private Long workshopId;
   private Long sourceWorkshopId;
   private BriefIdAndNameDTO warehouse;
   private String nationalStandard;
   private LocalDateTime outboundTime;
   private String measureUnit;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer measurePrecision;
   private BigDecimal amount;
   private BigDecimal amountExcludingVat;
   private Boolean boolBasicClassChange;
   @ApiModelProperty("办理人")
   private String reviewerName;
   private Integer outboundAddress;
   private Long returnableId;
   private IdAndSerialNumberDO purchase;
   private OutboundDetailSellDTO outboundDetailSellDTO;
   private BigDecimal wmsRestitutionNum;
   private BigDecimal wmsRestitutionMete;
   private BigDecimal wmsWastageNum;
   private BigDecimal wmsWastageMete;
   private BigDecimal YearMete;
   private BigDecimal MonthMete;
   private BigDecimal aboveMonthMete;
   private Integer materialIsWhole;
   private String surplusSn;
   private Long pickingDetailId;
   private String outboundSerialNumber;
   private String recipientName;
   private List<MaterialConsumingDTO> consumingDTO;
   private String consumingUnit;
   private Long materialCodeConfigId;
   private String materialSnNew;
   private BigDecimal actualTheoryWeight;
   private Long materialInventoryId;
   private MaterialInventoryDTO materialInventoryDTO;
   private Integer halfMode;
   private BigDecimal halfSize;

   public static OutboundDetailDTO.OutboundDetailDTOBuilder builder() {
      return new OutboundDetailDTO.OutboundDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getMaterialOutboundMode() {
      return this.materialOutboundMode;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getOutboundRelationType() {
      return this.outboundRelationType;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
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

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getColor() {
      return this.color;
   }

   public BriefDeptAndNameDTO getRecipient() {
      return this.recipient;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
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

   public ProjectInfo getSourceProject() {
      return this.sourceProject;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
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

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public Boolean getBoolBasicClassChange() {
      return this.boolBasicClassChange;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public Long getReturnableId() {
      return this.returnableId;
   }

   public IdAndSerialNumberDO getPurchase() {
      return this.purchase;
   }

   public OutboundDetailSellDTO getOutboundDetailSellDTO() {
      return this.outboundDetailSellDTO;
   }

   public BigDecimal getWmsRestitutionNum() {
      return this.wmsRestitutionNum;
   }

   public BigDecimal getWmsRestitutionMete() {
      return this.wmsRestitutionMete;
   }

   public BigDecimal getWmsWastageNum() {
      return this.wmsWastageNum;
   }

   public BigDecimal getWmsWastageMete() {
      return this.wmsWastageMete;
   }

   public BigDecimal getYearMete() {
      return this.YearMete;
   }

   public BigDecimal getMonthMete() {
      return this.MonthMete;
   }

   public BigDecimal getAboveMonthMete() {
      return this.aboveMonthMete;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public String getOutboundSerialNumber() {
      return this.outboundSerialNumber;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public List<MaterialConsumingDTO> getConsumingDTO() {
      return this.consumingDTO;
   }

   public String getConsumingUnit() {
      return this.consumingUnit;
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

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public MaterialInventoryDTO getMaterialInventoryDTO() {
      return this.materialInventoryDTO;
   }

   public Integer getHalfMode() {
      return this.halfMode;
   }

   public BigDecimal getHalfSize() {
      return this.halfSize;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setMaterialOutboundMode(final Integer materialOutboundMode) {
      this.materialOutboundMode = materialOutboundMode;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setOutboundRelationType(final Integer outboundRelationType) {
      this.outboundRelationType = outboundRelationType;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setRecipient(final BriefDeptAndNameDTO recipient) {
      this.recipient = recipient;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setMesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
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

   public void setSourceProject(final ProjectInfo sourceProject) {
      this.sourceProject = sourceProject;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
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

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setBoolBasicClassChange(final Boolean boolBasicClassChange) {
      this.boolBasicClassChange = boolBasicClassChange;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   public void setReturnableId(final Long returnableId) {
      this.returnableId = returnableId;
   }

   public void setPurchase(final IdAndSerialNumberDO purchase) {
      this.purchase = purchase;
   }

   public void setOutboundDetailSellDTO(final OutboundDetailSellDTO outboundDetailSellDTO) {
      this.outboundDetailSellDTO = outboundDetailSellDTO;
   }

   public void setWmsRestitutionNum(final BigDecimal wmsRestitutionNum) {
      this.wmsRestitutionNum = wmsRestitutionNum;
   }

   public void setWmsRestitutionMete(final BigDecimal wmsRestitutionMete) {
      this.wmsRestitutionMete = wmsRestitutionMete;
   }

   public void setWmsWastageNum(final BigDecimal wmsWastageNum) {
      this.wmsWastageNum = wmsWastageNum;
   }

   public void setWmsWastageMete(final BigDecimal wmsWastageMete) {
      this.wmsWastageMete = wmsWastageMete;
   }

   public void setYearMete(final BigDecimal YearMete) {
      this.YearMete = YearMete;
   }

   public void setMonthMete(final BigDecimal MonthMete) {
      this.MonthMete = MonthMete;
   }

   public void setAboveMonthMete(final BigDecimal aboveMonthMete) {
      this.aboveMonthMete = aboveMonthMete;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
   }

   public void setOutboundSerialNumber(final String outboundSerialNumber) {
      this.outboundSerialNumber = outboundSerialNumber;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setConsumingDTO(final List<MaterialConsumingDTO> consumingDTO) {
      this.consumingDTO = consumingDTO;
   }

   public void setConsumingUnit(final String consumingUnit) {
      this.consumingUnit = consumingUnit;
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

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setMaterialInventoryDTO(final MaterialInventoryDTO materialInventoryDTO) {
      this.materialInventoryDTO = materialInventoryDTO;
   }

   public void setHalfMode(final Integer halfMode) {
      this.halfMode = halfMode;
   }

   public void setHalfSize(final BigDecimal halfSize) {
      this.halfSize = halfSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDetailDTO)) {
         return false;
      }

      OutboundDetailDTO other = (OutboundDetailDTO)o;
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
               Object this$materialOutboundMode = this.getMaterialOutboundMode();
               Object other$materialOutboundMode = other.getMaterialOutboundMode();
               if (this$materialOutboundMode == null ? other$materialOutboundMode == null : this$materialOutboundMode.equals(other$materialOutboundMode)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$outboundRelationType = this.getOutboundRelationType();
                     Object other$outboundRelationType = other.getOutboundRelationType();
                     if (this$outboundRelationType == null ? other$outboundRelationType == null : this$outboundRelationType.equals(other$outboundRelationType)) {
                        Object this$outboundUnitType = this.getOutboundUnitType();
                        Object other$outboundUnitType = other.getOutboundUnitType();
                        if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$sourceWorkshopId = this.getSourceWorkshopId();
                              Object other$sourceWorkshopId = other.getSourceWorkshopId();
                              if (this$sourceWorkshopId == null ? other$sourceWorkshopId == null : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                 Object this$accountingPrecision = this.getAccountingPrecision();
                                 Object other$accountingPrecision = other.getAccountingPrecision();
                                 if (this$accountingPrecision == null
                                    ? other$accountingPrecision == null
                                    : this$accountingPrecision.equals(other$accountingPrecision)) {
                                    Object this$measurePrecision = this.getMeasurePrecision();
                                    Object other$measurePrecision = other.getMeasurePrecision();
                                    if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                       Object this$boolBasicClassChange = this.getBoolBasicClassChange();
                                       Object other$boolBasicClassChange = other.getBoolBasicClassChange();
                                       if (this$boolBasicClassChange == null
                                          ? other$boolBasicClassChange == null
                                          : this$boolBasicClassChange.equals(other$boolBasicClassChange)) {
                                          Object this$outboundAddress = this.getOutboundAddress();
                                          Object other$outboundAddress = other.getOutboundAddress();
                                          if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)
                                             )
                                           {
                                             Object this$returnableId = this.getReturnableId();
                                             Object other$returnableId = other.getReturnableId();
                                             if (this$returnableId == null ? other$returnableId == null : this$returnableId.equals(other$returnableId)) {
                                                Object this$materialIsWhole = this.getMaterialIsWhole();
                                                Object other$materialIsWhole = other.getMaterialIsWhole();
                                                if (this$materialIsWhole == null
                                                   ? other$materialIsWhole == null
                                                   : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                   Object this$pickingDetailId = this.getPickingDetailId();
                                                   Object other$pickingDetailId = other.getPickingDetailId();
                                                   if (this$pickingDetailId == null
                                                      ? other$pickingDetailId == null
                                                      : this$pickingDetailId.equals(other$pickingDetailId)) {
                                                      Object this$materialCodeConfigId = this.getMaterialCodeConfigId();
                                                      Object other$materialCodeConfigId = other.getMaterialCodeConfigId();
                                                      if (this$materialCodeConfigId == null
                                                         ? other$materialCodeConfigId == null
                                                         : this$materialCodeConfigId.equals(other$materialCodeConfigId)) {
                                                         Object this$materialInventoryId = this.getMaterialInventoryId();
                                                         Object other$materialInventoryId = other.getMaterialInventoryId();
                                                         if (this$materialInventoryId == null
                                                            ? other$materialInventoryId == null
                                                            : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                            Object this$halfMode = this.getHalfMode();
                                                            Object other$halfMode = other.getHalfMode();
                                                            if (this$halfMode == null ? other$halfMode == null : this$halfMode.equals(other$halfMode)) {
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
                                                                        if (this$thickness == null
                                                                           ? other$thickness == null
                                                                           : this$thickness.equals(other$thickness)) {
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
                                                                                             Object this$color = this.getColor();
                                                                                             Object other$color = other.getColor();
                                                                                             if (this$color == null
                                                                                                ? other$color == null
                                                                                                : this$color.equals(other$color)) {
                                                                                                Object this$recipient = this.getRecipient();
                                                                                                Object other$recipient = other.getRecipient();
                                                                                                if (this$recipient == null
                                                                                                   ? other$recipient == null
                                                                                                   : this$recipient.equals(other$recipient)) {
                                                                                                   Object this$workshop = this.getWorkshop();
                                                                                                   Object other$workshop = other.getWorkshop();
                                                                                                   if (this$workshop == null
                                                                                                      ? other$workshop == null
                                                                                                      : this$workshop.equals(other$workshop)) {
                                                                                                      Object this$mesWorkshop = this.getMesWorkshop();
                                                                                                      Object other$mesWorkshop = other.getMesWorkshop();
                                                                                                      if (this$mesWorkshop == null
                                                                                                         ? other$mesWorkshop == null
                                                                                                         : this$mesWorkshop.equals(other$mesWorkshop)) {
                                                                                                         Object this$project = this.getProject();
                                                                                                         Object other$project = other.getProject();
                                                                                                         if (this$project == null
                                                                                                            ? other$project == null
                                                                                                            : this$project.equals(other$project)) {
                                                                                                            Object this$monomerName = this.getMonomerName();
                                                                                                            Object other$monomerName = other.getMonomerName();
                                                                                                            if (this$monomerName == null
                                                                                                               ? other$monomerName == null
                                                                                                               : this$monomerName.equals(other$monomerName)) {
                                                                                                               Object this$areaName = this.getAreaName();
                                                                                                               Object other$areaName = other.getAreaName();
                                                                                                               if (this$areaName == null
                                                                                                                  ? other$areaName == null
                                                                                                                  : this$areaName.equals(other$areaName)) {
                                                                                                                  Object this$areaBatchName = this.getAreaBatchName();
                                                                                                                  Object other$areaBatchName = other.getAreaBatchName();
                                                                                                                  if (this$areaBatchName == null
                                                                                                                     ? other$areaBatchName == null
                                                                                                                     : this$areaBatchName.equals(
                                                                                                                        other$areaBatchName
                                                                                                                     )) {
                                                                                                                     Object this$sourceProject = this.getSourceProject();
                                                                                                                     Object other$sourceProject = other.getSourceProject();
                                                                                                                     if (this$sourceProject == null
                                                                                                                        ? other$sourceProject == null
                                                                                                                        : this$sourceProject.equals(
                                                                                                                           other$sourceProject
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
                                                                                                                              ? other$nationalStandard == null
                                                                                                                              : this$nationalStandard.equals(
                                                                                                                                 other$nationalStandard
                                                                                                                              )) {
                                                                                                                              Object this$outboundTime = this.getOutboundTime();
                                                                                                                              Object other$outboundTime = other.getOutboundTime();
                                                                                                                              if (this$outboundTime == null
                                                                                                                                 ? other$outboundTime == null
                                                                                                                                 : this$outboundTime.equals(
                                                                                                                                    other$outboundTime
                                                                                                                                 )) {
                                                                                                                                 Object this$measureUnit = this.getMeasureUnit();
                                                                                                                                 Object other$measureUnit = other.getMeasureUnit();
                                                                                                                                 if (this$measureUnit == null
                                                                                                                                    ? other$measureUnit == null
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
                                                                                                                                       Object this$amount = this.getAmount();
                                                                                                                                       Object other$amount = other.getAmount();
                                                                                                                                       if (this$amount == null
                                                                                                                                          ? other$amount
                                                                                                                                             == null
                                                                                                                                          : this$amount.equals(
                                                                                                                                             other$amount
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
                                                                                                                                             Object this$reviewerName = this.getReviewerName();
                                                                                                                                             Object other$reviewerName = other.getReviewerName();
                                                                                                                                             if (this$reviewerName
                                                                                                                                                   == null
                                                                                                                                                ? other$reviewerName
                                                                                                                                                   == null
                                                                                                                                                : this$reviewerName.equals(
                                                                                                                                                   other$reviewerName
                                                                                                                                                )) {
                                                                                                                                                Object this$purchase = this.getPurchase();
                                                                                                                                                Object other$purchase = other.getPurchase();
                                                                                                                                                if (this$purchase
                                                                                                                                                      == null
                                                                                                                                                   ? other$purchase
                                                                                                                                                      == null
                                                                                                                                                   : this$purchase.equals(
                                                                                                                                                      other$purchase
                                                                                                                                                   )) {
                                                                                                                                                   Object this$outboundDetailSellDTO = this.getOutboundDetailSellDTO();
                                                                                                                                                   Object other$outboundDetailSellDTO = other.getOutboundDetailSellDTO();
                                                                                                                                                   if (this$outboundDetailSellDTO
                                                                                                                                                         == null
                                                                                                                                                      ? other$outboundDetailSellDTO
                                                                                                                                                         == null
                                                                                                                                                      : this$outboundDetailSellDTO.equals(
                                                                                                                                                         other$outboundDetailSellDTO
                                                                                                                                                      )) {
                                                                                                                                                      Object this$wmsRestitutionNum = this.getWmsRestitutionNum();
                                                                                                                                                      Object other$wmsRestitutionNum = other.getWmsRestitutionNum();
                                                                                                                                                      if (this$wmsRestitutionNum
                                                                                                                                                            == null
                                                                                                                                                         ? other$wmsRestitutionNum
                                                                                                                                                            == null
                                                                                                                                                         : this$wmsRestitutionNum.equals(
                                                                                                                                                            other$wmsRestitutionNum
                                                                                                                                                         )) {
                                                                                                                                                         Object this$wmsRestitutionMete = this.getWmsRestitutionMete();
                                                                                                                                                         Object other$wmsRestitutionMete = other.getWmsRestitutionMete();
                                                                                                                                                         if (this$wmsRestitutionMete
                                                                                                                                                               == null
                                                                                                                                                            ? other$wmsRestitutionMete
                                                                                                                                                               == null
                                                                                                                                                            : this$wmsRestitutionMete.equals(
                                                                                                                                                               other$wmsRestitutionMete
                                                                                                                                                            )) {
                                                                                                                                                            Object this$wmsWastageNum = this.getWmsWastageNum();
                                                                                                                                                            Object other$wmsWastageNum = other.getWmsWastageNum();
                                                                                                                                                            if (this$wmsWastageNum
                                                                                                                                                                  == null
                                                                                                                                                               ? other$wmsWastageNum
                                                                                                                                                                  == null
                                                                                                                                                               : this$wmsWastageNum.equals(
                                                                                                                                                                  other$wmsWastageNum
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$wmsWastageMete = this.getWmsWastageMete();
                                                                                                                                                               Object other$wmsWastageMete = other.getWmsWastageMete();
                                                                                                                                                               if (this$wmsWastageMete
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$wmsWastageMete
                                                                                                                                                                     == null
                                                                                                                                                                  : this$wmsWastageMete.equals(
                                                                                                                                                                     other$wmsWastageMete
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$YearMete = this.getYearMete();
                                                                                                                                                                  Object other$YearMete = other.getYearMete();
                                                                                                                                                                  if (this$YearMete
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$YearMete
                                                                                                                                                                        == null
                                                                                                                                                                     : this$YearMete.equals(
                                                                                                                                                                        other$YearMete
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$MonthMete = this.getMonthMete();
                                                                                                                                                                     Object other$MonthMete = other.getMonthMete();
                                                                                                                                                                     if (this$MonthMete
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$MonthMete
                                                                                                                                                                           == null
                                                                                                                                                                        : this$MonthMete.equals(
                                                                                                                                                                           other$MonthMete
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$aboveMonthMete = this.getAboveMonthMete();
                                                                                                                                                                        Object other$aboveMonthMete = other.getAboveMonthMete();
                                                                                                                                                                        if (this$aboveMonthMete
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$aboveMonthMete
                                                                                                                                                                              == null
                                                                                                                                                                           : this$aboveMonthMete.equals(
                                                                                                                                                                              other$aboveMonthMete
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$surplusSn = this.getSurplusSn();
                                                                                                                                                                           Object other$surplusSn = other.getSurplusSn();
                                                                                                                                                                           if (this$surplusSn
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$surplusSn
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$surplusSn.equals(
                                                                                                                                                                                 other$surplusSn
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
                                                                                                                                                                                 Object this$recipientName = this.getRecipientName();
                                                                                                                                                                                 Object other$recipientName = other.getRecipientName();
                                                                                                                                                                                 if (this$recipientName
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$recipientName
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$recipientName.equals(
                                                                                                                                                                                       other$recipientName
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$consumingDTO = this.getConsumingDTO();
                                                                                                                                                                                    Object other$consumingDTO = other.getConsumingDTO();
                                                                                                                                                                                    if (this$consumingDTO
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$consumingDTO
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$consumingDTO.equals(
                                                                                                                                                                                          other$consumingDTO
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$consumingUnit = this.getConsumingUnit();
                                                                                                                                                                                       Object other$consumingUnit = other.getConsumingUnit();
                                                                                                                                                                                       if (this$consumingUnit
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$consumingUnit
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$consumingUnit.equals(
                                                                                                                                                                                             other$consumingUnit
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
                                                                                                                                                                                                Object this$materialInventoryDTO = this.getMaterialInventoryDTO();
                                                                                                                                                                                                Object other$materialInventoryDTO = other.getMaterialInventoryDTO();
                                                                                                                                                                                                if (this$materialInventoryDTO
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$materialInventoryDTO
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$materialInventoryDTO.equals(
                                                                                                                                                                                                      other$materialInventoryDTO
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$halfSize = this.getHalfSize();
                                                                                                                                                                                                   Object other$halfSize = other.getHalfSize();
                                                                                                                                                                                                   return this$halfSize
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$halfSize
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$halfSize.equals(
                                                                                                                                                                                                         other$halfSize
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutboundDetailDTO;
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
      Object $materialOutboundMode = this.getMaterialOutboundMode();
      result = result * 59 + ($materialOutboundMode == null ? 43 : $materialOutboundMode.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $outboundRelationType = this.getOutboundRelationType();
      result = result * 59 + ($outboundRelationType == null ? 43 : $outboundRelationType.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $boolBasicClassChange = this.getBoolBasicClassChange();
      result = result * 59 + ($boolBasicClassChange == null ? 43 : $boolBasicClassChange.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $returnableId = this.getReturnableId();
      result = result * 59 + ($returnableId == null ? 43 : $returnableId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $materialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($materialCodeConfigId == null ? 43 : $materialCodeConfigId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $halfMode = this.getHalfMode();
      result = result * 59 + ($halfMode == null ? 43 : $halfMode.hashCode());
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
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $recipient = this.getRecipient();
      result = result * 59 + ($recipient == null ? 43 : $recipient.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $sourceProject = this.getSourceProject();
      result = result * 59 + ($sourceProject == null ? 43 : $sourceProject.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $purchase = this.getPurchase();
      result = result * 59 + ($purchase == null ? 43 : $purchase.hashCode());
      Object $outboundDetailSellDTO = this.getOutboundDetailSellDTO();
      result = result * 59 + ($outboundDetailSellDTO == null ? 43 : $outboundDetailSellDTO.hashCode());
      Object $wmsRestitutionNum = this.getWmsRestitutionNum();
      result = result * 59 + ($wmsRestitutionNum == null ? 43 : $wmsRestitutionNum.hashCode());
      Object $wmsRestitutionMete = this.getWmsRestitutionMete();
      result = result * 59 + ($wmsRestitutionMete == null ? 43 : $wmsRestitutionMete.hashCode());
      Object $wmsWastageNum = this.getWmsWastageNum();
      result = result * 59 + ($wmsWastageNum == null ? 43 : $wmsWastageNum.hashCode());
      Object $wmsWastageMete = this.getWmsWastageMete();
      result = result * 59 + ($wmsWastageMete == null ? 43 : $wmsWastageMete.hashCode());
      Object $YearMete = this.getYearMete();
      result = result * 59 + ($YearMete == null ? 43 : $YearMete.hashCode());
      Object $MonthMete = this.getMonthMete();
      result = result * 59 + ($MonthMete == null ? 43 : $MonthMete.hashCode());
      Object $aboveMonthMete = this.getAboveMonthMete();
      result = result * 59 + ($aboveMonthMete == null ? 43 : $aboveMonthMete.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $outboundSerialNumber = this.getOutboundSerialNumber();
      result = result * 59 + ($outboundSerialNumber == null ? 43 : $outboundSerialNumber.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $consumingDTO = this.getConsumingDTO();
      result = result * 59 + ($consumingDTO == null ? 43 : $consumingDTO.hashCode());
      Object $consumingUnit = this.getConsumingUnit();
      result = result * 59 + ($consumingUnit == null ? 43 : $consumingUnit.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      result = result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
      Object $materialInventoryDTO = this.getMaterialInventoryDTO();
      result = result * 59 + ($materialInventoryDTO == null ? 43 : $materialInventoryDTO.hashCode());
      Object $halfSize = this.getHalfSize();
      return result * 59 + ($halfSize == null ? 43 : $halfSize.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", materialOutboundMode="
         + this.getMaterialOutboundMode()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", outboundRelationType="
         + this.getOutboundRelationType()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
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
         + ", remark="
         + this.getRemark()
         + ", mete="
         + this.getMete()
         + ", color="
         + this.getColor()
         + ", recipient="
         + this.getRecipient()
         + ", workshop="
         + this.getWorkshop()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", sourceProject="
         + this.getSourceProject()
         + ", workshopId="
         + this.getWorkshopId()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", warehouse="
         + this.getWarehouse()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", boolBasicClassChange="
         + this.getBoolBasicClassChange()
         + ", reviewerName="
         + this.getReviewerName()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", returnableId="
         + this.getReturnableId()
         + ", purchase="
         + this.getPurchase()
         + ", outboundDetailSellDTO="
         + this.getOutboundDetailSellDTO()
         + ", wmsRestitutionNum="
         + this.getWmsRestitutionNum()
         + ", wmsRestitutionMete="
         + this.getWmsRestitutionMete()
         + ", wmsWastageNum="
         + this.getWmsWastageNum()
         + ", wmsWastageMete="
         + this.getWmsWastageMete()
         + ", YearMete="
         + this.getYearMete()
         + ", MonthMete="
         + this.getMonthMete()
         + ", aboveMonthMete="
         + this.getAboveMonthMete()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", outboundSerialNumber="
         + this.getOutboundSerialNumber()
         + ", recipientName="
         + this.getRecipientName()
         + ", consumingDTO="
         + this.getConsumingDTO()
         + ", consumingUnit="
         + this.getConsumingUnit()
         + ", materialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", materialInventoryDTO="
         + this.getMaterialInventoryDTO()
         + ", halfMode="
         + this.getHalfMode()
         + ", halfSize="
         + this.getHalfSize()
         + ")";
   }

   public OutboundDetailDTO(
      final Long id,
      final Long classifyId,
      final String classifyName,
      final Boolean boolPartyA,
      final Integer materialOutboundMode,
      final Integer basicClass,
      final String specification,
      final Integer outboundRelationType,
      final Integer outboundUnitType,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String heatNoAndBatchNo,
      final String remark,
      final BigDecimal mete,
      final String color,
      final BriefDeptAndNameDTO recipient,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO mesWorkshop,
      final ProjectInfo project,
      final String monomerName,
      final String areaName,
      final String areaBatchName,
      final ProjectInfo sourceProject,
      final Long workshopId,
      final Long sourceWorkshopId,
      final BriefIdAndNameDTO warehouse,
      final String nationalStandard,
      final LocalDateTime outboundTime,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final Boolean boolBasicClassChange,
      final String reviewerName,
      final Integer outboundAddress,
      final Long returnableId,
      final IdAndSerialNumberDO purchase,
      final OutboundDetailSellDTO outboundDetailSellDTO,
      final BigDecimal wmsRestitutionNum,
      final BigDecimal wmsRestitutionMete,
      final BigDecimal wmsWastageNum,
      final BigDecimal wmsWastageMete,
      final BigDecimal YearMete,
      final BigDecimal MonthMete,
      final BigDecimal aboveMonthMete,
      final Integer materialIsWhole,
      final String surplusSn,
      final Long pickingDetailId,
      final String outboundSerialNumber,
      final String recipientName,
      final List<MaterialConsumingDTO> consumingDTO,
      final String consumingUnit,
      final Long materialCodeConfigId,
      final String materialSnNew,
      final BigDecimal actualTheoryWeight,
      final Long materialInventoryId,
      final MaterialInventoryDTO materialInventoryDTO,
      final Integer halfMode,
      final BigDecimal halfSize
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.boolPartyA = boolPartyA;
      this.materialOutboundMode = materialOutboundMode;
      this.basicClass = basicClass;
      this.specification = specification;
      this.outboundRelationType = outboundRelationType;
      this.outboundUnitType = outboundUnitType;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.remark = remark;
      this.mete = mete;
      this.color = color;
      this.recipient = recipient;
      this.workshop = workshop;
      this.mesWorkshop = mesWorkshop;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.areaBatchName = areaBatchName;
      this.sourceProject = sourceProject;
      this.workshopId = workshopId;
      this.sourceWorkshopId = sourceWorkshopId;
      this.warehouse = warehouse;
      this.nationalStandard = nationalStandard;
      this.outboundTime = outboundTime;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.boolBasicClassChange = boolBasicClassChange;
      this.reviewerName = reviewerName;
      this.outboundAddress = outboundAddress;
      this.returnableId = returnableId;
      this.purchase = purchase;
      this.outboundDetailSellDTO = outboundDetailSellDTO;
      this.wmsRestitutionNum = wmsRestitutionNum;
      this.wmsRestitutionMete = wmsRestitutionMete;
      this.wmsWastageNum = wmsWastageNum;
      this.wmsWastageMete = wmsWastageMete;
      this.YearMete = YearMete;
      this.MonthMete = MonthMete;
      this.aboveMonthMete = aboveMonthMete;
      this.materialIsWhole = materialIsWhole;
      this.surplusSn = surplusSn;
      this.pickingDetailId = pickingDetailId;
      this.outboundSerialNumber = outboundSerialNumber;
      this.recipientName = recipientName;
      this.consumingDTO = consumingDTO;
      this.consumingUnit = consumingUnit;
      this.materialCodeConfigId = materialCodeConfigId;
      this.materialSnNew = materialSnNew;
      this.actualTheoryWeight = actualTheoryWeight;
      this.materialInventoryId = materialInventoryId;
      this.materialInventoryDTO = materialInventoryDTO;
      this.halfMode = halfMode;
      this.halfSize = halfSize;
   }

   public OutboundDetailDTO() {
   }

   public static class OutboundDetailDTOBuilder {
      private Long id;
      private Long classifyId;
      private String classifyName;
      private Boolean boolPartyA;
      private Integer materialOutboundMode;
      private Integer basicClass;
      private String specification;
      private Integer outboundRelationType;
      private Integer outboundUnitType;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String heatNoAndBatchNo;
      private String remark;
      private BigDecimal mete;
      private String color;
      private BriefDeptAndNameDTO recipient;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO mesWorkshop;
      private ProjectInfo project;
      private String monomerName;
      private String areaName;
      private String areaBatchName;
      private ProjectInfo sourceProject;
      private Long workshopId;
      private Long sourceWorkshopId;
      private BriefIdAndNameDTO warehouse;
      private String nationalStandard;
      private LocalDateTime outboundTime;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private Boolean boolBasicClassChange;
      private String reviewerName;
      private Integer outboundAddress;
      private Long returnableId;
      private IdAndSerialNumberDO purchase;
      private OutboundDetailSellDTO outboundDetailSellDTO;
      private BigDecimal wmsRestitutionNum;
      private BigDecimal wmsRestitutionMete;
      private BigDecimal wmsWastageNum;
      private BigDecimal wmsWastageMete;
      private BigDecimal YearMete;
      private BigDecimal MonthMete;
      private BigDecimal aboveMonthMete;
      private Integer materialIsWhole;
      private String surplusSn;
      private Long pickingDetailId;
      private String outboundSerialNumber;
      private String recipientName;
      private List<MaterialConsumingDTO> consumingDTO;
      private String consumingUnit;
      private Long materialCodeConfigId;
      private String materialSnNew;
      private BigDecimal actualTheoryWeight;
      private Long materialInventoryId;
      private MaterialInventoryDTO materialInventoryDTO;
      private Integer halfMode;
      private BigDecimal halfSize;

      OutboundDetailDTOBuilder() {
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder materialOutboundMode(final Integer materialOutboundMode) {
         this.materialOutboundMode = materialOutboundMode;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder outboundRelationType(final Integer outboundRelationType) {
         this.outboundRelationType = outboundRelationType;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder recipient(final BriefDeptAndNameDTO recipient) {
         this.recipient = recipient;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder mesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder sourceProject(final ProjectInfo sourceProject) {
         this.sourceProject = sourceProject;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder boolBasicClassChange(final Boolean boolBasicClassChange) {
         this.boolBasicClassChange = boolBasicClassChange;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder returnableId(final Long returnableId) {
         this.returnableId = returnableId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder purchase(final IdAndSerialNumberDO purchase) {
         this.purchase = purchase;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder outboundDetailSellDTO(final OutboundDetailSellDTO outboundDetailSellDTO) {
         this.outboundDetailSellDTO = outboundDetailSellDTO;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder wmsRestitutionNum(final BigDecimal wmsRestitutionNum) {
         this.wmsRestitutionNum = wmsRestitutionNum;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder wmsRestitutionMete(final BigDecimal wmsRestitutionMete) {
         this.wmsRestitutionMete = wmsRestitutionMete;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder wmsWastageNum(final BigDecimal wmsWastageNum) {
         this.wmsWastageNum = wmsWastageNum;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder wmsWastageMete(final BigDecimal wmsWastageMete) {
         this.wmsWastageMete = wmsWastageMete;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder YearMete(final BigDecimal YearMete) {
         this.YearMete = YearMete;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder MonthMete(final BigDecimal MonthMete) {
         this.MonthMete = MonthMete;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder aboveMonthMete(final BigDecimal aboveMonthMete) {
         this.aboveMonthMete = aboveMonthMete;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder outboundSerialNumber(final String outboundSerialNumber) {
         this.outboundSerialNumber = outboundSerialNumber;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder consumingDTO(final List<MaterialConsumingDTO> consumingDTO) {
         this.consumingDTO = consumingDTO;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder consumingUnit(final String consumingUnit) {
         this.consumingUnit = consumingUnit;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder materialCodeConfigId(final Long materialCodeConfigId) {
         this.materialCodeConfigId = materialCodeConfigId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder materialInventoryDTO(final MaterialInventoryDTO materialInventoryDTO) {
         this.materialInventoryDTO = materialInventoryDTO;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder halfMode(final Integer halfMode) {
         this.halfMode = halfMode;
         return this;
      }

      public OutboundDetailDTO.OutboundDetailDTOBuilder halfSize(final BigDecimal halfSize) {
         this.halfSize = halfSize;
         return this;
      }

      public OutboundDetailDTO build() {
         return new OutboundDetailDTO(
            this.id,
            this.classifyId,
            this.classifyName,
            this.boolPartyA,
            this.materialOutboundMode,
            this.basicClass,
            this.specification,
            this.outboundRelationType,
            this.outboundUnitType,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.heatNoAndBatchNo,
            this.remark,
            this.mete,
            this.color,
            this.recipient,
            this.workshop,
            this.mesWorkshop,
            this.project,
            this.monomerName,
            this.areaName,
            this.areaBatchName,
            this.sourceProject,
            this.workshopId,
            this.sourceWorkshopId,
            this.warehouse,
            this.nationalStandard,
            this.outboundTime,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision,
            this.amount,
            this.amountExcludingVat,
            this.boolBasicClassChange,
            this.reviewerName,
            this.outboundAddress,
            this.returnableId,
            this.purchase,
            this.outboundDetailSellDTO,
            this.wmsRestitutionNum,
            this.wmsRestitutionMete,
            this.wmsWastageNum,
            this.wmsWastageMete,
            this.YearMete,
            this.MonthMete,
            this.aboveMonthMete,
            this.materialIsWhole,
            this.surplusSn,
            this.pickingDetailId,
            this.outboundSerialNumber,
            this.recipientName,
            this.consumingDTO,
            this.consumingUnit,
            this.materialCodeConfigId,
            this.materialSnNew,
            this.actualTheoryWeight,
            this.materialInventoryId,
            this.materialInventoryDTO,
            this.halfMode,
            this.halfSize
         );
      }

      @Override
      public String toString() {
         return "OutboundDetailDTO.OutboundDetailDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", boolPartyA="
            + this.boolPartyA
            + ", materialOutboundMode="
            + this.materialOutboundMode
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", outboundRelationType="
            + this.outboundRelationType
            + ", outboundUnitType="
            + this.outboundUnitType
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
            + ", remark="
            + this.remark
            + ", mete="
            + this.mete
            + ", color="
            + this.color
            + ", recipient="
            + this.recipient
            + ", workshop="
            + this.workshop
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", areaBatchName="
            + this.areaBatchName
            + ", sourceProject="
            + this.sourceProject
            + ", workshopId="
            + this.workshopId
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", warehouse="
            + this.warehouse
            + ", nationalStandard="
            + this.nationalStandard
            + ", outboundTime="
            + this.outboundTime
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", boolBasicClassChange="
            + this.boolBasicClassChange
            + ", reviewerName="
            + this.reviewerName
            + ", outboundAddress="
            + this.outboundAddress
            + ", returnableId="
            + this.returnableId
            + ", purchase="
            + this.purchase
            + ", outboundDetailSellDTO="
            + this.outboundDetailSellDTO
            + ", wmsRestitutionNum="
            + this.wmsRestitutionNum
            + ", wmsRestitutionMete="
            + this.wmsRestitutionMete
            + ", wmsWastageNum="
            + this.wmsWastageNum
            + ", wmsWastageMete="
            + this.wmsWastageMete
            + ", YearMete="
            + this.YearMete
            + ", MonthMete="
            + this.MonthMete
            + ", aboveMonthMete="
            + this.aboveMonthMete
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", surplusSn="
            + this.surplusSn
            + ", pickingDetailId="
            + this.pickingDetailId
            + ", outboundSerialNumber="
            + this.outboundSerialNumber
            + ", recipientName="
            + this.recipientName
            + ", consumingDTO="
            + this.consumingDTO
            + ", consumingUnit="
            + this.consumingUnit
            + ", materialCodeConfigId="
            + this.materialCodeConfigId
            + ", materialSnNew="
            + this.materialSnNew
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", materialInventoryDTO="
            + this.materialInventoryDTO
            + ", halfMode="
            + this.halfMode
            + ", halfSize="
            + this.halfSize
            + ")";
      }
   }
}
