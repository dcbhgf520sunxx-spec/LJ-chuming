package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StatisticsDetailDTO {
   private Long id;
   private Boolean boolPartyA;
   private Long classifyId;
   private String classifyName;
   private Boolean boolOddmentByHalfOut;
   private Integer outboundRelationType;
   private Integer materialIsWhole;
   private Integer basicClass;
   private String specification;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private Integer invoiceType;
   private BigDecimal mete;
   private ProjectInfo project;
   private String monomerName;
   private String areaName;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO mesWorkshop;
   private BriefIdAndNameDTO warehouse;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private BigDecimal unitPriceNoFreight;
   private BigDecimal unitPriceExcludingVATNoFreight;
   private BigDecimal amountNoFreight;
   private BigDecimal amountExcludingVATNoFreight;
   private BigDecimal inputVATNoFreight;
   private BriefIdAndSNDTO receipt;
   private LocalDateTime createTime;
   private String measureUnit;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer measurePrecision;
   private String materialSnNew;
   private Measure measure;
   private String classifySerialNumber;

   public static StatisticsDetailDTO.StatisticsDetailDTOBuilder builder() {
      return new StatisticsDetailDTO.StatisticsDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
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

   public Boolean getBoolOddmentByHalfOut() {
      return this.boolOddmentByHalfOut;
   }

   public Integer getOutboundRelationType() {
      return this.outboundRelationType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
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

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getMete() {
      return this.mete;
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

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
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

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVATNoFreight() {
      return this.unitPriceExcludingVATNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVATNoFreight() {
      return this.amountExcludingVATNoFreight;
   }

   public BigDecimal getInputVATNoFreight() {
      return this.inputVATNoFreight;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setBoolOddmentByHalfOut(final Boolean boolOddmentByHalfOut) {
      this.boolOddmentByHalfOut = boolOddmentByHalfOut;
   }

   public void setOutboundRelationType(final Integer outboundRelationType) {
      this.outboundRelationType = outboundRelationType;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
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

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setMesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
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

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setUnitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setAmountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
   }

   public void setInputVATNoFreight(final BigDecimal inputVATNoFreight) {
      this.inputVATNoFreight = inputVATNoFreight;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
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

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
   }

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsDetailDTO)) {
         return false;
      }

      StatisticsDetailDTO other = (StatisticsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$boolOddmentByHalfOut = this.getBoolOddmentByHalfOut();
               Object other$boolOddmentByHalfOut = other.getBoolOddmentByHalfOut();
               if (this$boolOddmentByHalfOut == null ? other$boolOddmentByHalfOut == null : this$boolOddmentByHalfOut.equals(other$boolOddmentByHalfOut)) {
                  Object this$outboundRelationType = this.getOutboundRelationType();
                  Object other$outboundRelationType = other.getOutboundRelationType();
                  if (this$outboundRelationType == null ? other$outboundRelationType == null : this$outboundRelationType.equals(other$outboundRelationType)) {
                     Object this$materialIsWhole = this.getMaterialIsWhole();
                     Object other$materialIsWhole = other.getMaterialIsWhole();
                     if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                        Object this$basicClass = this.getBasicClass();
                        Object other$basicClass = other.getBasicClass();
                        if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                           Object this$invoiceType = this.getInvoiceType();
                           Object other$invoiceType = other.getInvoiceType();
                           if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                              Object this$accountingPrecision = this.getAccountingPrecision();
                              Object other$accountingPrecision = other.getAccountingPrecision();
                              if (this$accountingPrecision == null
                                 ? other$accountingPrecision == null
                                 : this$accountingPrecision.equals(other$accountingPrecision)) {
                                 Object this$measurePrecision = this.getMeasurePrecision();
                                 Object other$measurePrecision = other.getMeasurePrecision();
                                 if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                    Object this$classifyName = this.getClassifyName();
                                    Object other$classifyName = other.getClassifyName();
                                    if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
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
                                                         Object this$color = this.getColor();
                                                         Object other$color = other.getColor();
                                                         if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                            Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                            Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                            if (this$heatNoAndBatchNo == null
                                                               ? other$heatNoAndBatchNo == null
                                                               : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                               Object this$mete = this.getMete();
                                                               Object other$mete = other.getMete();
                                                               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                  Object this$project = this.getProject();
                                                                  Object other$project = other.getProject();
                                                                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                                                                 Object this$warehouse = this.getWarehouse();
                                                                                 Object other$warehouse = other.getWarehouse();
                                                                                 if (this$warehouse == null
                                                                                    ? other$warehouse == null
                                                                                    : this$warehouse.equals(other$warehouse)) {
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
                                                                                                   Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                   Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                   if (this$unitPriceNoFreight == null
                                                                                                      ? other$unitPriceNoFreight == null
                                                                                                      : this$unitPriceNoFreight.equals(other$unitPriceNoFreight)
                                                                                                      )
                                                                                                    {
                                                                                                      Object this$unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
                                                                                                      Object other$unitPriceExcludingVATNoFreight = other.getUnitPriceExcludingVATNoFreight();
                                                                                                      if (this$unitPriceExcludingVATNoFreight == null
                                                                                                         ? other$unitPriceExcludingVATNoFreight == null
                                                                                                         : this$unitPriceExcludingVATNoFreight.equals(
                                                                                                            other$unitPriceExcludingVATNoFreight
                                                                                                         )) {
                                                                                                         Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                         Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                         if (this$amountNoFreight == null
                                                                                                            ? other$amountNoFreight == null
                                                                                                            : this$amountNoFreight.equals(other$amountNoFreight)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
                                                                                                            Object other$amountExcludingVATNoFreight = other.getAmountExcludingVATNoFreight();
                                                                                                            if (this$amountExcludingVATNoFreight == null
                                                                                                               ? other$amountExcludingVATNoFreight == null
                                                                                                               : this$amountExcludingVATNoFreight.equals(
                                                                                                                  other$amountExcludingVATNoFreight
                                                                                                               )) {
                                                                                                               Object this$inputVATNoFreight = this.getInputVATNoFreight();
                                                                                                               Object other$inputVATNoFreight = other.getInputVATNoFreight();
                                                                                                               if (this$inputVATNoFreight == null
                                                                                                                  ? other$inputVATNoFreight == null
                                                                                                                  : this$inputVATNoFreight.equals(
                                                                                                                     other$inputVATNoFreight
                                                                                                                  )) {
                                                                                                                  Object this$receipt = this.getReceipt();
                                                                                                                  Object other$receipt = other.getReceipt();
                                                                                                                  if (this$receipt == null
                                                                                                                     ? other$receipt == null
                                                                                                                     : this$receipt.equals(other$receipt)) {
                                                                                                                     Object this$createTime = this.getCreateTime();
                                                                                                                     Object other$createTime = other.getCreateTime();
                                                                                                                     if (this$createTime == null
                                                                                                                        ? other$createTime == null
                                                                                                                        : this$createTime.equals(
                                                                                                                           other$createTime
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
                                                                                                                           if (this$accountingUnit == null
                                                                                                                              ? other$accountingUnit == null
                                                                                                                              : this$accountingUnit.equals(
                                                                                                                                 other$accountingUnit
                                                                                                                              )) {
                                                                                                                              Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                                              Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                                              if (this$materialSnNew == null
                                                                                                                                 ? other$materialSnNew == null
                                                                                                                                 : this$materialSnNew.equals(
                                                                                                                                    other$materialSnNew
                                                                                                                                 )) {
                                                                                                                                 Object this$measure = this.getMeasure();
                                                                                                                                 Object other$measure = other.getMeasure();
                                                                                                                                 if (this$measure == null
                                                                                                                                    ? other$measure == null
                                                                                                                                    : this$measure.equals(
                                                                                                                                       other$measure
                                                                                                                                    )) {
                                                                                                                                    Object this$classifySerialNumber = this.getClassifySerialNumber();
                                                                                                                                    Object other$classifySerialNumber = other.getClassifySerialNumber();
                                                                                                                                    return this$classifySerialNumber
                                                                                                                                          == null
                                                                                                                                       ? other$classifySerialNumber
                                                                                                                                          == null
                                                                                                                                       : this$classifySerialNumber.equals(
                                                                                                                                          other$classifySerialNumber
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StatisticsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolOddmentByHalfOut = this.getBoolOddmentByHalfOut();
      result = result * 59 + ($boolOddmentByHalfOut == null ? 43 : $boolOddmentByHalfOut.hashCode());
      Object $outboundRelationType = this.getOutboundRelationType();
      result = result * 59 + ($outboundRelationType == null ? 43 : $outboundRelationType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
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
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
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
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
      result = result * 59 + ($unitPriceExcludingVATNoFreight == null ? 43 : $unitPriceExcludingVATNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
      result = result * 59 + ($amountExcludingVATNoFreight == null ? 43 : $amountExcludingVATNoFreight.hashCode());
      Object $inputVATNoFreight = this.getInputVATNoFreight();
      result = result * 59 + ($inputVATNoFreight == null ? 43 : $inputVATNoFreight.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      return result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "StatisticsDetailDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolOddmentByHalfOut="
         + this.getBoolOddmentByHalfOut()
         + ", outboundRelationType="
         + this.getOutboundRelationType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
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
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", mete="
         + this.getMete()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", workshop="
         + this.getWorkshop()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", warehouse="
         + this.getWarehouse()
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
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVATNoFreight="
         + this.getUnitPriceExcludingVATNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVATNoFreight="
         + this.getAmountExcludingVATNoFreight()
         + ", inputVATNoFreight="
         + this.getInputVATNoFreight()
         + ", receipt="
         + this.getReceipt()
         + ", createTime="
         + this.getCreateTime()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", measure="
         + this.getMeasure()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ")";
   }

   public StatisticsDetailDTO(
      final Long id,
      final Boolean boolPartyA,
      final Long classifyId,
      final String classifyName,
      final Boolean boolOddmentByHalfOut,
      final Integer outboundRelationType,
      final Integer materialIsWhole,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final Integer invoiceType,
      final BigDecimal mete,
      final ProjectInfo project,
      final String monomerName,
      final String areaName,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO mesWorkshop,
      final BriefIdAndNameDTO warehouse,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal inputVATNoFreight,
      final BriefIdAndSNDTO receipt,
      final LocalDateTime createTime,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final String materialSnNew,
      final Measure measure,
      final String classifySerialNumber
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.boolOddmentByHalfOut = boolOddmentByHalfOut;
      this.outboundRelationType = outboundRelationType;
      this.materialIsWhole = materialIsWhole;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.invoiceType = invoiceType;
      this.mete = mete;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.workshop = workshop;
      this.mesWorkshop = mesWorkshop;
      this.warehouse = warehouse;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.inputVATNoFreight = inputVATNoFreight;
      this.receipt = receipt;
      this.createTime = createTime;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.materialSnNew = materialSnNew;
      this.measure = measure;
      this.classifySerialNumber = classifySerialNumber;
   }

   public StatisticsDetailDTO() {
   }

   public static class StatisticsDetailDTOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private Long classifyId;
      private String classifyName;
      private Boolean boolOddmentByHalfOut;
      private Integer outboundRelationType;
      private Integer materialIsWhole;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private Integer invoiceType;
      private BigDecimal mete;
      private ProjectInfo project;
      private String monomerName;
      private String areaName;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO mesWorkshop;
      private BriefIdAndNameDTO warehouse;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal inputVATNoFreight;
      private BriefIdAndSNDTO receipt;
      private LocalDateTime createTime;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private String materialSnNew;
      private Measure measure;
      private String classifySerialNumber;

      StatisticsDetailDTOBuilder() {
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder boolOddmentByHalfOut(final Boolean boolOddmentByHalfOut) {
         this.boolOddmentByHalfOut = boolOddmentByHalfOut;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder outboundRelationType(final Integer outboundRelationType) {
         this.outboundRelationType = outboundRelationType;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder mesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder inputVATNoFreight(final BigDecimal inputVATNoFreight) {
         this.inputVATNoFreight = inputVATNoFreight;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public StatisticsDetailDTO.StatisticsDetailDTOBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public StatisticsDetailDTO build() {
         return new StatisticsDetailDTO(
            this.id,
            this.boolPartyA,
            this.classifyId,
            this.classifyName,
            this.boolOddmentByHalfOut,
            this.outboundRelationType,
            this.materialIsWhole,
            this.basicClass,
            this.specification,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.invoiceType,
            this.mete,
            this.project,
            this.monomerName,
            this.areaName,
            this.workshop,
            this.mesWorkshop,
            this.warehouse,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVATNoFreight,
            this.amountNoFreight,
            this.amountExcludingVATNoFreight,
            this.inputVATNoFreight,
            this.receipt,
            this.createTime,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision,
            this.materialSnNew,
            this.measure,
            this.classifySerialNumber
         );
      }

      @Override
      public String toString() {
         return "StatisticsDetailDTO.StatisticsDetailDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", boolOddmentByHalfOut="
            + this.boolOddmentByHalfOut
            + ", outboundRelationType="
            + this.outboundRelationType
            + ", materialIsWhole="
            + this.materialIsWhole
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
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", invoiceType="
            + this.invoiceType
            + ", mete="
            + this.mete
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", workshop="
            + this.workshop
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", warehouse="
            + this.warehouse
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
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVATNoFreight="
            + this.unitPriceExcludingVATNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVATNoFreight="
            + this.amountExcludingVATNoFreight
            + ", inputVATNoFreight="
            + this.inputVATNoFreight
            + ", receipt="
            + this.receipt
            + ", createTime="
            + this.createTime
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", materialSnNew="
            + this.materialSnNew
            + ", measure="
            + this.measure
            + ", classifySerialNumber="
            + this.classifySerialNumber
            + ")";
      }
   }
}
