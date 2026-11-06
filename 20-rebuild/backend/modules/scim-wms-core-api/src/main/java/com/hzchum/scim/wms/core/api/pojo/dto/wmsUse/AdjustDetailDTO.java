package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdjustDetailDTO {
   private Long id;
   private boolean boolPartyA;
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   private String classifyName;
   private String materialSn;
   private Integer basicClass;
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
   private String remark;
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
   private LocalDateTime createTime;
   private String requisitionsSN;
   private Long projectId;
   private ProjectInfo project;
   private Long monomerId;
   private Long areaId;
   private String monomerName;
   private String areaName;
   private BriefIdAndNameDTO warehouse;
   private String adjustSerialNumber;
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal pastAmount;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal pastAmountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal pastInputVAT;
   private BigDecimal adjustAmount;
   private BigDecimal adjustAmountExcludingVat;
   private BigDecimal adjustInputVat;
   private BigDecimal differentAmount;
   private BigDecimal differentAmountExcludingVat;
   private Long inboundDetailId;
   private Long inboundId;
   private Integer inboundWay;

   public static AdjustDetailDTO.AdjustDetailDTOBuilder builder() {
      return new AdjustDetailDTO.AdjustDetailDTOBuilder();
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

   public String getMaterialSn() {
      return this.materialSn;
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

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getRequisitionsSN() {
      return this.requisitionsSN;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public String getAdjustSerialNumber() {
      return this.adjustSerialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getPastAmount() {
      return this.pastAmount;
   }

   public BigDecimal getPastAmountExcludingVAT() {
      return this.pastAmountExcludingVAT;
   }

   public BigDecimal getPastInputVAT() {
      return this.pastInputVAT;
   }

   public BigDecimal getAdjustAmount() {
      return this.adjustAmount;
   }

   public BigDecimal getAdjustAmountExcludingVat() {
      return this.adjustAmountExcludingVat;
   }

   public BigDecimal getAdjustInputVat() {
      return this.adjustInputVat;
   }

   public BigDecimal getDifferentAmount() {
      return this.differentAmount;
   }

   public BigDecimal getDifferentAmountExcludingVat() {
      return this.differentAmountExcludingVat;
   }

   public Long getInboundDetailId() {
      return this.inboundDetailId;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
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

   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
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

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setRequisitionsSN(final String requisitionsSN) {
      this.requisitionsSN = requisitionsSN;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setAdjustSerialNumber(final String adjustSerialNumber) {
      this.adjustSerialNumber = adjustSerialNumber;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPastAmount(final BigDecimal pastAmount) {
      this.pastAmount = pastAmount;
   }

   public void setPastAmountExcludingVAT(final BigDecimal pastAmountExcludingVAT) {
      this.pastAmountExcludingVAT = pastAmountExcludingVAT;
   }

   public void setPastInputVAT(final BigDecimal pastInputVAT) {
      this.pastInputVAT = pastInputVAT;
   }

   public void setAdjustAmount(final BigDecimal adjustAmount) {
      this.adjustAmount = adjustAmount;
   }

   public void setAdjustAmountExcludingVat(final BigDecimal adjustAmountExcludingVat) {
      this.adjustAmountExcludingVat = adjustAmountExcludingVat;
   }

   public void setAdjustInputVat(final BigDecimal adjustInputVat) {
      this.adjustInputVat = adjustInputVat;
   }

   public void setDifferentAmount(final BigDecimal differentAmount) {
      this.differentAmount = differentAmount;
   }

   public void setDifferentAmountExcludingVat(final BigDecimal differentAmountExcludingVat) {
      this.differentAmountExcludingVat = differentAmountExcludingVat;
   }

   public void setInboundDetailId(final Long inboundDetailId) {
      this.inboundDetailId = inboundDetailId;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AdjustDetailDTO)) {
         return false;
      }

      AdjustDetailDTO other = (AdjustDetailDTO)o;
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
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$inboundDetailId = this.getInboundDetailId();
                        Object other$inboundDetailId = other.getInboundDetailId();
                        if (this$inboundDetailId == null ? other$inboundDetailId == null : this$inboundDetailId.equals(other$inboundDetailId)) {
                           Object this$inboundId = this.getInboundId();
                           Object other$inboundId = other.getInboundId();
                           if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                              Object this$inboundWay = this.getInboundWay();
                              Object other$inboundWay = other.getInboundWay();
                              if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                 Object this$classifyName = this.getClassifyName();
                                 Object other$classifyName = other.getClassifyName();
                                 if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                    Object this$materialSn = this.getMaterialSn();
                                    Object other$materialSn = other.getMaterialSn();
                                    if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
                                                                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                     Object this$color = this.getColor();
                                                                     Object other$color = other.getColor();
                                                                     if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                        Object this$mete = this.getMete();
                                                                        Object other$mete = other.getMete();
                                                                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                                                                                          Object this$createTime = this.getCreateTime();
                                                                                          Object other$createTime = other.getCreateTime();
                                                                                          if (this$createTime == null
                                                                                             ? other$createTime == null
                                                                                             : this$createTime.equals(other$createTime)) {
                                                                                             Object this$requisitionsSN = this.getRequisitionsSN();
                                                                                             Object other$requisitionsSN = other.getRequisitionsSN();
                                                                                             if (this$requisitionsSN == null
                                                                                                ? other$requisitionsSN == null
                                                                                                : this$requisitionsSN.equals(other$requisitionsSN)) {
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
                                                                                                         Object this$warehouse = this.getWarehouse();
                                                                                                         Object other$warehouse = other.getWarehouse();
                                                                                                         if (this$warehouse == null
                                                                                                            ? other$warehouse == null
                                                                                                            : this$warehouse.equals(other$warehouse)) {
                                                                                                            Object this$adjustSerialNumber = this.getAdjustSerialNumber();
                                                                                                            Object other$adjustSerialNumber = other.getAdjustSerialNumber();
                                                                                                            if (this$adjustSerialNumber == null
                                                                                                               ? other$adjustSerialNumber == null
                                                                                                               : this$adjustSerialNumber.equals(
                                                                                                                  other$adjustSerialNumber
                                                                                                               )) {
                                                                                                               Object this$serialNumber = this.getSerialNumber();
                                                                                                               Object other$serialNumber = other.getSerialNumber();
                                                                                                               if (this$serialNumber == null
                                                                                                                  ? other$serialNumber == null
                                                                                                                  : this$serialNumber.equals(other$serialNumber)
                                                                                                                  )
                                                                                                                {
                                                                                                                  Object this$pastAmount = this.getPastAmount();
                                                                                                                  Object other$pastAmount = other.getPastAmount();
                                                                                                                  if (this$pastAmount == null
                                                                                                                     ? other$pastAmount == null
                                                                                                                     : this$pastAmount.equals(other$pastAmount)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$pastAmountExcludingVAT = this.getPastAmountExcludingVAT();
                                                                                                                     Object other$pastAmountExcludingVAT = other.getPastAmountExcludingVAT();
                                                                                                                     if (this$pastAmountExcludingVAT == null
                                                                                                                        ? other$pastAmountExcludingVAT == null
                                                                                                                        : this$pastAmountExcludingVAT.equals(
                                                                                                                           other$pastAmountExcludingVAT
                                                                                                                        )) {
                                                                                                                        Object this$pastInputVAT = this.getPastInputVAT();
                                                                                                                        Object other$pastInputVAT = other.getPastInputVAT();
                                                                                                                        if (this$pastInputVAT == null
                                                                                                                           ? other$pastInputVAT == null
                                                                                                                           : this$pastInputVAT.equals(
                                                                                                                              other$pastInputVAT
                                                                                                                           )) {
                                                                                                                           Object this$adjustAmount = this.getAdjustAmount();
                                                                                                                           Object other$adjustAmount = other.getAdjustAmount();
                                                                                                                           if (this$adjustAmount == null
                                                                                                                              ? other$adjustAmount == null
                                                                                                                              : this$adjustAmount.equals(
                                                                                                                                 other$adjustAmount
                                                                                                                              )) {
                                                                                                                              Object this$adjustAmountExcludingVat = this.getAdjustAmountExcludingVat();
                                                                                                                              Object other$adjustAmountExcludingVat = other.getAdjustAmountExcludingVat();
                                                                                                                              if (this$adjustAmountExcludingVat
                                                                                                                                    == null
                                                                                                                                 ? other$adjustAmountExcludingVat
                                                                                                                                    == null
                                                                                                                                 : this$adjustAmountExcludingVat.equals(
                                                                                                                                    other$adjustAmountExcludingVat
                                                                                                                                 )) {
                                                                                                                                 Object this$adjustInputVat = this.getAdjustInputVat();
                                                                                                                                 Object other$adjustInputVat = other.getAdjustInputVat();
                                                                                                                                 if (this$adjustInputVat
                                                                                                                                       == null
                                                                                                                                    ? other$adjustInputVat
                                                                                                                                       == null
                                                                                                                                    : this$adjustInputVat.equals(
                                                                                                                                       other$adjustInputVat
                                                                                                                                    )) {
                                                                                                                                    Object this$differentAmount = this.getDifferentAmount();
                                                                                                                                    Object other$differentAmount = other.getDifferentAmount();
                                                                                                                                    if (this$differentAmount
                                                                                                                                          == null
                                                                                                                                       ? other$differentAmount
                                                                                                                                          == null
                                                                                                                                       : this$differentAmount.equals(
                                                                                                                                          other$differentAmount
                                                                                                                                       )) {
                                                                                                                                       Object this$differentAmountExcludingVat = this.getDifferentAmountExcludingVat();
                                                                                                                                       Object other$differentAmountExcludingVat = other.getDifferentAmountExcludingVat();
                                                                                                                                       return this$differentAmountExcludingVat
                                                                                                                                             == null
                                                                                                                                          ? other$differentAmountExcludingVat
                                                                                                                                             == null
                                                                                                                                          : this$differentAmountExcludingVat.equals(
                                                                                                                                             other$differentAmountExcludingVat
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AdjustDetailDTO;
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $inboundDetailId = this.getInboundDetailId();
      result = result * 59 + ($inboundDetailId == null ? 43 : $inboundDetailId.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
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
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $requisitionsSN = this.getRequisitionsSN();
      result = result * 59 + ($requisitionsSN == null ? 43 : $requisitionsSN.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $adjustSerialNumber = this.getAdjustSerialNumber();
      result = result * 59 + ($adjustSerialNumber == null ? 43 : $adjustSerialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $pastAmount = this.getPastAmount();
      result = result * 59 + ($pastAmount == null ? 43 : $pastAmount.hashCode());
      Object $pastAmountExcludingVAT = this.getPastAmountExcludingVAT();
      result = result * 59 + ($pastAmountExcludingVAT == null ? 43 : $pastAmountExcludingVAT.hashCode());
      Object $pastInputVAT = this.getPastInputVAT();
      result = result * 59 + ($pastInputVAT == null ? 43 : $pastInputVAT.hashCode());
      Object $adjustAmount = this.getAdjustAmount();
      result = result * 59 + ($adjustAmount == null ? 43 : $adjustAmount.hashCode());
      Object $adjustAmountExcludingVat = this.getAdjustAmountExcludingVat();
      result = result * 59 + ($adjustAmountExcludingVat == null ? 43 : $adjustAmountExcludingVat.hashCode());
      Object $adjustInputVat = this.getAdjustInputVat();
      result = result * 59 + ($adjustInputVat == null ? 43 : $adjustInputVat.hashCode());
      Object $differentAmount = this.getDifferentAmount();
      result = result * 59 + ($differentAmount == null ? 43 : $differentAmount.hashCode());
      Object $differentAmountExcludingVat = this.getDifferentAmountExcludingVat();
      return result * 59 + ($differentAmountExcludingVat == null ? 43 : $differentAmountExcludingVat.hashCode());
   }

   @Override
   public String toString() {
      return "AdjustDetailDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.isBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", materialSn="
         + this.getMaterialSn()
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
         + ", createTime="
         + this.getCreateTime()
         + ", requisitionsSN="
         + this.getRequisitionsSN()
         + ", projectId="
         + this.getProjectId()
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
         + ", warehouse="
         + this.getWarehouse()
         + ", adjustSerialNumber="
         + this.getAdjustSerialNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", pastAmount="
         + this.getPastAmount()
         + ", pastAmountExcludingVAT="
         + this.getPastAmountExcludingVAT()
         + ", pastInputVAT="
         + this.getPastInputVAT()
         + ", adjustAmount="
         + this.getAdjustAmount()
         + ", adjustAmountExcludingVat="
         + this.getAdjustAmountExcludingVat()
         + ", adjustInputVat="
         + this.getAdjustInputVat()
         + ", differentAmount="
         + this.getDifferentAmount()
         + ", differentAmountExcludingVat="
         + this.getDifferentAmountExcludingVat()
         + ", inboundDetailId="
         + this.getInboundDetailId()
         + ", inboundId="
         + this.getInboundId()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }

   public AdjustDetailDTO(
      final Long id,
      final boolean boolPartyA,
      final Long classifyId,
      final String classifyName,
      final String materialSn,
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
      final LocalDateTime createTime,
      final String requisitionsSN,
      final Long projectId,
      final ProjectInfo project,
      final Long monomerId,
      final Long areaId,
      final String monomerName,
      final String areaName,
      final BriefIdAndNameDTO warehouse,
      final String adjustSerialNumber,
      final String serialNumber,
      final BigDecimal pastAmount,
      final BigDecimal pastAmountExcludingVAT,
      final BigDecimal pastInputVAT,
      final BigDecimal adjustAmount,
      final BigDecimal adjustAmountExcludingVat,
      final BigDecimal adjustInputVat,
      final BigDecimal differentAmount,
      final BigDecimal differentAmountExcludingVat,
      final Long inboundDetailId,
      final Long inboundId,
      final Integer inboundWay
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.materialSn = materialSn;
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
      this.createTime = createTime;
      this.requisitionsSN = requisitionsSN;
      this.projectId = projectId;
      this.project = project;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.warehouse = warehouse;
      this.adjustSerialNumber = adjustSerialNumber;
      this.serialNumber = serialNumber;
      this.pastAmount = pastAmount;
      this.pastAmountExcludingVAT = pastAmountExcludingVAT;
      this.pastInputVAT = pastInputVAT;
      this.adjustAmount = adjustAmount;
      this.adjustAmountExcludingVat = adjustAmountExcludingVat;
      this.adjustInputVat = adjustInputVat;
      this.differentAmount = differentAmount;
      this.differentAmountExcludingVat = differentAmountExcludingVat;
      this.inboundDetailId = inboundDetailId;
      this.inboundId = inboundId;
      this.inboundWay = inboundWay;
   }

   public AdjustDetailDTO() {
   }

   public static class AdjustDetailDTOBuilder {
      private Long id;
      private boolean boolPartyA;
      private Long classifyId;
      private String classifyName;
      private String materialSn;
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
      private LocalDateTime createTime;
      private String requisitionsSN;
      private Long projectId;
      private ProjectInfo project;
      private Long monomerId;
      private Long areaId;
      private String monomerName;
      private String areaName;
      private BriefIdAndNameDTO warehouse;
      private String adjustSerialNumber;
      private String serialNumber;
      private BigDecimal pastAmount;
      private BigDecimal pastAmountExcludingVAT;
      private BigDecimal pastInputVAT;
      private BigDecimal adjustAmount;
      private BigDecimal adjustAmountExcludingVat;
      private BigDecimal adjustInputVat;
      private BigDecimal differentAmount;
      private BigDecimal differentAmountExcludingVat;
      private Long inboundDetailId;
      private Long inboundId;
      private Integer inboundWay;

      AdjustDetailDTOBuilder() {
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder boolPartyA(final boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder requisitionsSN(final String requisitionsSN) {
         this.requisitionsSN = requisitionsSN;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder adjustSerialNumber(final String adjustSerialNumber) {
         this.adjustSerialNumber = adjustSerialNumber;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder pastAmount(final BigDecimal pastAmount) {
         this.pastAmount = pastAmount;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder pastAmountExcludingVAT(final BigDecimal pastAmountExcludingVAT) {
         this.pastAmountExcludingVAT = pastAmountExcludingVAT;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder pastInputVAT(final BigDecimal pastInputVAT) {
         this.pastInputVAT = pastInputVAT;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder adjustAmount(final BigDecimal adjustAmount) {
         this.adjustAmount = adjustAmount;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder adjustAmountExcludingVat(final BigDecimal adjustAmountExcludingVat) {
         this.adjustAmountExcludingVat = adjustAmountExcludingVat;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder adjustInputVat(final BigDecimal adjustInputVat) {
         this.adjustInputVat = adjustInputVat;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder differentAmount(final BigDecimal differentAmount) {
         this.differentAmount = differentAmount;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder differentAmountExcludingVat(final BigDecimal differentAmountExcludingVat) {
         this.differentAmountExcludingVat = differentAmountExcludingVat;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder inboundDetailId(final Long inboundDetailId) {
         this.inboundDetailId = inboundDetailId;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public AdjustDetailDTO.AdjustDetailDTOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public AdjustDetailDTO build() {
         return new AdjustDetailDTO(
            this.id,
            this.boolPartyA,
            this.classifyId,
            this.classifyName,
            this.materialSn,
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
            this.createTime,
            this.requisitionsSN,
            this.projectId,
            this.project,
            this.monomerId,
            this.areaId,
            this.monomerName,
            this.areaName,
            this.warehouse,
            this.adjustSerialNumber,
            this.serialNumber,
            this.pastAmount,
            this.pastAmountExcludingVAT,
            this.pastInputVAT,
            this.adjustAmount,
            this.adjustAmountExcludingVat,
            this.adjustInputVat,
            this.differentAmount,
            this.differentAmountExcludingVat,
            this.inboundDetailId,
            this.inboundId,
            this.inboundWay
         );
      }

      @Override
      public String toString() {
         return "AdjustDetailDTO.AdjustDetailDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", materialSn="
            + this.materialSn
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
            + ", createTime="
            + this.createTime
            + ", requisitionsSN="
            + this.requisitionsSN
            + ", projectId="
            + this.projectId
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
            + ", warehouse="
            + this.warehouse
            + ", adjustSerialNumber="
            + this.adjustSerialNumber
            + ", serialNumber="
            + this.serialNumber
            + ", pastAmount="
            + this.pastAmount
            + ", pastAmountExcludingVAT="
            + this.pastAmountExcludingVAT
            + ", pastInputVAT="
            + this.pastInputVAT
            + ", adjustAmount="
            + this.adjustAmount
            + ", adjustAmountExcludingVat="
            + this.adjustAmountExcludingVat
            + ", adjustInputVat="
            + this.adjustInputVat
            + ", differentAmount="
            + this.differentAmount
            + ", differentAmountExcludingVat="
            + this.differentAmountExcludingVat
            + ", inboundDetailId="
            + this.inboundDetailId
            + ", inboundId="
            + this.inboundId
            + ", inboundWay="
            + this.inboundWay
            + ")";
      }
   }
}
