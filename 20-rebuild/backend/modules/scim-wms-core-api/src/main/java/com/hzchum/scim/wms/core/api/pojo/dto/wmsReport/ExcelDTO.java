package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.io.Serializable;

public class ExcelDTO implements Serializable {
   private String id;
   private String data;
   private String basicClass;
   private String classifyName;
   private String spec;
   private String material;
   private String lengths;
   private String serialNumber;
   private String projectNumber;
   private String projectName;
   private String areaBatchName;
   private String heatNoAndBatchNo;
   private String measureUnit;
   private String quantity;
   private String accountingUnit;
   private String mete;
   private String taxRate;
   private String unitPrice;
   private String unitPriceExcludingVat;
   private String amount;
   private String amountExcludingVat;
   private String amountNoFreight;
   private String amountExcludingVatNoFreight;
   private String inputVat;
   private String rdRate;
   private String rdFee;
   private String returnTime;
   private String recipient;
   private String workshop;
   private String warehouseName;
   private String sourceSerialNumber;
   private String sourceProject;
   private String remark;
   private String brand;
   private String returnState;
   private String outboundSerialNumber;
   private String departmentName;
   private String transferType;
   private String directionProjectName;
   private String rejectSN;
   private String materialSn;
   private String materialSnNew;
   private String actualTheoryWeight;
   private String source;
   private String direction;
   private String outboundSn;

   public static ExcelDTO.ExcelDTOBuilder builder() {
      return new ExcelDTO.ExcelDTOBuilder();
   }

   public String getId() {
      return this.id;
   }

   public String getData() {
      return this.data;
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpec() {
      return this.spec;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getLengths() {
      return this.lengths;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectNumber() {
      return this.projectNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getQuantity() {
      return this.quantity;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMete() {
      return this.mete;
   }

   public String getTaxRate() {
      return this.taxRate;
   }

   public String getUnitPrice() {
      return this.unitPrice;
   }

   public String getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public String getAmount() {
      return this.amount;
   }

   public String getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public String getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public String getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public String getInputVat() {
      return this.inputVat;
   }

   public String getRdRate() {
      return this.rdRate;
   }

   public String getRdFee() {
      return this.rdFee;
   }

   public String getReturnTime() {
      return this.returnTime;
   }

   public String getRecipient() {
      return this.recipient;
   }

   public String getWorkshop() {
      return this.workshop;
   }

   public String getWarehouseName() {
      return this.warehouseName;
   }

   public String getSourceSerialNumber() {
      return this.sourceSerialNumber;
   }

   public String getSourceProject() {
      return this.sourceProject;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getReturnState() {
      return this.returnState;
   }

   public String getOutboundSerialNumber() {
      return this.outboundSerialNumber;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getTransferType() {
      return this.transferType;
   }

   public String getDirectionProjectName() {
      return this.directionProjectName;
   }

   public String getRejectSN() {
      return this.rejectSN;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public String getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public String getSource() {
      return this.source;
   }

   public String getDirection() {
      return this.direction;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setData(final String data) {
      this.data = data;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setLengths(final String lengths) {
      this.lengths = lengths;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectNumber(final String projectNumber) {
      this.projectNumber = projectNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final String quantity) {
      this.quantity = quantity;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final String mete) {
      this.mete = mete;
   }

   public void setTaxRate(final String taxRate) {
      this.taxRate = taxRate;
   }

   public void setUnitPrice(final String unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVat(final String unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   public void setAmount(final String amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final String amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setAmountNoFreight(final String amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setAmountExcludingVatNoFreight(final String amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
   }

   public void setInputVat(final String inputVat) {
      this.inputVat = inputVat;
   }

   public void setRdRate(final String rdRate) {
      this.rdRate = rdRate;
   }

   public void setRdFee(final String rdFee) {
      this.rdFee = rdFee;
   }

   public void setReturnTime(final String returnTime) {
      this.returnTime = returnTime;
   }

   public void setRecipient(final String recipient) {
      this.recipient = recipient;
   }

   public void setWorkshop(final String workshop) {
      this.workshop = workshop;
   }

   public void setWarehouseName(final String warehouseName) {
      this.warehouseName = warehouseName;
   }

   public void setSourceSerialNumber(final String sourceSerialNumber) {
      this.sourceSerialNumber = sourceSerialNumber;
   }

   public void setSourceProject(final String sourceProject) {
      this.sourceProject = sourceProject;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setReturnState(final String returnState) {
      this.returnState = returnState;
   }

   public void setOutboundSerialNumber(final String outboundSerialNumber) {
      this.outboundSerialNumber = outboundSerialNumber;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   public void setTransferType(final String transferType) {
      this.transferType = transferType;
   }

   public void setDirectionProjectName(final String directionProjectName) {
      this.directionProjectName = directionProjectName;
   }

   public void setRejectSN(final String rejectSN) {
      this.rejectSN = rejectSN;
   }

   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setActualTheoryWeight(final String actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public void setSource(final String source) {
      this.source = source;
   }

   public void setDirection(final String direction) {
      this.direction = direction;
   }

   public void setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExcelDTO)) {
         return false;
      }

      ExcelDTO other = (ExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$data = this.getData();
         Object other$data = other.getData();
         if (this$data == null ? other$data == null : this$data.equals(other$data)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                  Object this$spec = this.getSpec();
                  Object other$spec = other.getSpec();
                  if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$lengths = this.getLengths();
                        Object other$lengths = other.getLengths();
                        if (this$lengths == null ? other$lengths == null : this$lengths.equals(other$lengths)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$projectNumber = this.getProjectNumber();
                              Object other$projectNumber = other.getProjectNumber();
                              if (this$projectNumber == null ? other$projectNumber == null : this$projectNumber.equals(other$projectNumber)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$areaBatchName = this.getAreaBatchName();
                                    Object other$areaBatchName = other.getAreaBatchName();
                                    if (this$areaBatchName == null ? other$areaBatchName == null : this$areaBatchName.equals(other$areaBatchName)) {
                                       Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                       Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                       if (this$heatNoAndBatchNo == null
                                          ? other$heatNoAndBatchNo == null
                                          : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                          Object this$measureUnit = this.getMeasureUnit();
                                          Object other$measureUnit = other.getMeasureUnit();
                                          if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$accountingUnit = this.getAccountingUnit();
                                                Object other$accountingUnit = other.getAccountingUnit();
                                                if (this$accountingUnit == null
                                                   ? other$accountingUnit == null
                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$taxRate = this.getTaxRate();
                                                      Object other$taxRate = other.getTaxRate();
                                                      if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                         Object this$unitPrice = this.getUnitPrice();
                                                         Object other$unitPrice = other.getUnitPrice();
                                                         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                            Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                            Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                            if (this$unitPriceExcludingVat == null
                                                               ? other$unitPriceExcludingVat == null
                                                               : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                                               Object this$amount = this.getAmount();
                                                               Object other$amount = other.getAmount();
                                                               if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                  Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                  Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                  if (this$amountExcludingVat == null
                                                                     ? other$amountExcludingVat == null
                                                                     : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                     Object this$amountNoFreight = this.getAmountNoFreight();
                                                                     Object other$amountNoFreight = other.getAmountNoFreight();
                                                                     if (this$amountNoFreight == null
                                                                        ? other$amountNoFreight == null
                                                                        : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                        Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                        Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                        if (this$amountExcludingVatNoFreight == null
                                                                           ? other$amountExcludingVatNoFreight == null
                                                                           : this$amountExcludingVatNoFreight.equals(other$amountExcludingVatNoFreight)) {
                                                                           Object this$inputVat = this.getInputVat();
                                                                           Object other$inputVat = other.getInputVat();
                                                                           if (this$inputVat == null
                                                                              ? other$inputVat == null
                                                                              : this$inputVat.equals(other$inputVat)) {
                                                                              Object this$rdRate = this.getRdRate();
                                                                              Object other$rdRate = other.getRdRate();
                                                                              if (this$rdRate == null ? other$rdRate == null : this$rdRate.equals(other$rdRate)
                                                                                 )
                                                                               {
                                                                                 Object this$rdFee = this.getRdFee();
                                                                                 Object other$rdFee = other.getRdFee();
                                                                                 if (this$rdFee == null ? other$rdFee == null : this$rdFee.equals(other$rdFee)) {
                                                                                    Object this$returnTime = this.getReturnTime();
                                                                                    Object other$returnTime = other.getReturnTime();
                                                                                    if (this$returnTime == null
                                                                                       ? other$returnTime == null
                                                                                       : this$returnTime.equals(other$returnTime)) {
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
                                                                                             Object this$warehouseName = this.getWarehouseName();
                                                                                             Object other$warehouseName = other.getWarehouseName();
                                                                                             if (this$warehouseName == null
                                                                                                ? other$warehouseName == null
                                                                                                : this$warehouseName.equals(other$warehouseName)) {
                                                                                                Object this$sourceSerialNumber = this.getSourceSerialNumber();
                                                                                                Object other$sourceSerialNumber = other.getSourceSerialNumber();
                                                                                                if (this$sourceSerialNumber == null
                                                                                                   ? other$sourceSerialNumber == null
                                                                                                   : this$sourceSerialNumber.equals(other$sourceSerialNumber)) {
                                                                                                   Object this$sourceProject = this.getSourceProject();
                                                                                                   Object other$sourceProject = other.getSourceProject();
                                                                                                   if (this$sourceProject == null
                                                                                                      ? other$sourceProject == null
                                                                                                      : this$sourceProject.equals(other$sourceProject)) {
                                                                                                      Object this$remark = this.getRemark();
                                                                                                      Object other$remark = other.getRemark();
                                                                                                      if (this$remark == null
                                                                                                         ? other$remark == null
                                                                                                         : this$remark.equals(other$remark)) {
                                                                                                         Object this$brand = this.getBrand();
                                                                                                         Object other$brand = other.getBrand();
                                                                                                         if (this$brand == null
                                                                                                            ? other$brand == null
                                                                                                            : this$brand.equals(other$brand)) {
                                                                                                            Object this$returnState = this.getReturnState();
                                                                                                            Object other$returnState = other.getReturnState();
                                                                                                            if (this$returnState == null
                                                                                                               ? other$returnState == null
                                                                                                               : this$returnState.equals(other$returnState)) {
                                                                                                               Object this$outboundSerialNumber = this.getOutboundSerialNumber();
                                                                                                               Object other$outboundSerialNumber = other.getOutboundSerialNumber();
                                                                                                               if (this$outboundSerialNumber == null
                                                                                                                  ? other$outboundSerialNumber == null
                                                                                                                  : this$outboundSerialNumber.equals(
                                                                                                                     other$outboundSerialNumber
                                                                                                                  )) {
                                                                                                                  Object this$departmentName = this.getDepartmentName();
                                                                                                                  Object other$departmentName = other.getDepartmentName();
                                                                                                                  if (this$departmentName == null
                                                                                                                     ? other$departmentName == null
                                                                                                                     : this$departmentName.equals(
                                                                                                                        other$departmentName
                                                                                                                     )) {
                                                                                                                     Object this$transferType = this.getTransferType();
                                                                                                                     Object other$transferType = other.getTransferType();
                                                                                                                     if (this$transferType == null
                                                                                                                        ? other$transferType == null
                                                                                                                        : this$transferType.equals(
                                                                                                                           other$transferType
                                                                                                                        )) {
                                                                                                                        Object this$directionProjectName = this.getDirectionProjectName();
                                                                                                                        Object other$directionProjectName = other.getDirectionProjectName();
                                                                                                                        if (this$directionProjectName == null
                                                                                                                           ? other$directionProjectName == null
                                                                                                                           : this$directionProjectName.equals(
                                                                                                                              other$directionProjectName
                                                                                                                           )) {
                                                                                                                           Object this$rejectSN = this.getRejectSN();
                                                                                                                           Object other$rejectSN = other.getRejectSN();
                                                                                                                           if (this$rejectSN == null
                                                                                                                              ? other$rejectSN == null
                                                                                                                              : this$rejectSN.equals(
                                                                                                                                 other$rejectSN
                                                                                                                              )) {
                                                                                                                              Object this$materialSn = this.getMaterialSn();
                                                                                                                              Object other$materialSn = other.getMaterialSn();
                                                                                                                              if (this$materialSn == null
                                                                                                                                 ? other$materialSn == null
                                                                                                                                 : this$materialSn.equals(
                                                                                                                                    other$materialSn
                                                                                                                                 )) {
                                                                                                                                 Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                                                 Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                                                 if (this$materialSnNew == null
                                                                                                                                    ? other$materialSnNew
                                                                                                                                       == null
                                                                                                                                    : this$materialSnNew.equals(
                                                                                                                                       other$materialSnNew
                                                                                                                                    )) {
                                                                                                                                    Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                                                                                                    Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                                                                                                    if (this$actualTheoryWeight
                                                                                                                                          == null
                                                                                                                                       ? other$actualTheoryWeight
                                                                                                                                          == null
                                                                                                                                       : this$actualTheoryWeight.equals(
                                                                                                                                          other$actualTheoryWeight
                                                                                                                                       )) {
                                                                                                                                       Object this$source = this.getSource();
                                                                                                                                       Object other$source = other.getSource();
                                                                                                                                       if (this$source == null
                                                                                                                                          ? other$source
                                                                                                                                             == null
                                                                                                                                          : this$source.equals(
                                                                                                                                             other$source
                                                                                                                                          )) {
                                                                                                                                          Object this$direction = this.getDirection();
                                                                                                                                          Object other$direction = other.getDirection();
                                                                                                                                          if (this$direction
                                                                                                                                                == null
                                                                                                                                             ? other$direction
                                                                                                                                                == null
                                                                                                                                             : this$direction.equals(
                                                                                                                                                other$direction
                                                                                                                                             )) {
                                                                                                                                             Object this$outboundSn = this.getOutboundSn();
                                                                                                                                             Object other$outboundSn = other.getOutboundSn();
                                                                                                                                             return this$outboundSn
                                                                                                                                                   == null
                                                                                                                                                ? other$outboundSn
                                                                                                                                                   == null
                                                                                                                                                : this$outboundSn.equals(
                                                                                                                                                   other$outboundSn
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $data = this.getData();
      result = result * 59 + ($data == null ? 43 : $data.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $lengths = this.getLengths();
      result = result * 59 + ($lengths == null ? 43 : $lengths.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectNumber = this.getProjectNumber();
      result = result * 59 + ($projectNumber == null ? 43 : $projectNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $rdRate = this.getRdRate();
      result = result * 59 + ($rdRate == null ? 43 : $rdRate.hashCode());
      Object $rdFee = this.getRdFee();
      result = result * 59 + ($rdFee == null ? 43 : $rdFee.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $recipient = this.getRecipient();
      result = result * 59 + ($recipient == null ? 43 : $recipient.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouseName = this.getWarehouseName();
      result = result * 59 + ($warehouseName == null ? 43 : $warehouseName.hashCode());
      Object $sourceSerialNumber = this.getSourceSerialNumber();
      result = result * 59 + ($sourceSerialNumber == null ? 43 : $sourceSerialNumber.hashCode());
      Object $sourceProject = this.getSourceProject();
      result = result * 59 + ($sourceProject == null ? 43 : $sourceProject.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $returnState = this.getReturnState();
      result = result * 59 + ($returnState == null ? 43 : $returnState.hashCode());
      Object $outboundSerialNumber = this.getOutboundSerialNumber();
      result = result * 59 + ($outboundSerialNumber == null ? 43 : $outboundSerialNumber.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $directionProjectName = this.getDirectionProjectName();
      result = result * 59 + ($directionProjectName == null ? 43 : $directionProjectName.hashCode());
      Object $rejectSN = this.getRejectSN();
      result = result * 59 + ($rejectSN == null ? 43 : $rejectSN.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      result = result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $direction = this.getDirection();
      result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
      Object $outboundSn = this.getOutboundSn();
      return result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
   }

   @Override
   public String toString() {
      return "ExcelDTO(id="
         + this.getId()
         + ", data="
         + this.getData()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", spec="
         + this.getSpec()
         + ", material="
         + this.getMaterial()
         + ", lengths="
         + this.getLengths()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectNumber="
         + this.getProjectNumber()
         + ", projectName="
         + this.getProjectName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", taxRate="
         + this.getTaxRate()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", inputVat="
         + this.getInputVat()
         + ", rdRate="
         + this.getRdRate()
         + ", rdFee="
         + this.getRdFee()
         + ", returnTime="
         + this.getReturnTime()
         + ", recipient="
         + this.getRecipient()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouseName="
         + this.getWarehouseName()
         + ", sourceSerialNumber="
         + this.getSourceSerialNumber()
         + ", sourceProject="
         + this.getSourceProject()
         + ", remark="
         + this.getRemark()
         + ", brand="
         + this.getBrand()
         + ", returnState="
         + this.getReturnState()
         + ", outboundSerialNumber="
         + this.getOutboundSerialNumber()
         + ", departmentName="
         + this.getDepartmentName()
         + ", transferType="
         + this.getTransferType()
         + ", directionProjectName="
         + this.getDirectionProjectName()
         + ", rejectSN="
         + this.getRejectSN()
         + ", materialSn="
         + this.getMaterialSn()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", source="
         + this.getSource()
         + ", direction="
         + this.getDirection()
         + ", outboundSn="
         + this.getOutboundSn()
         + ")";
   }

   public ExcelDTO(
      final String id,
      final String data,
      final String basicClass,
      final String classifyName,
      final String spec,
      final String material,
      final String lengths,
      final String serialNumber,
      final String projectNumber,
      final String projectName,
      final String areaBatchName,
      final String heatNoAndBatchNo,
      final String measureUnit,
      final String quantity,
      final String accountingUnit,
      final String mete,
      final String taxRate,
      final String unitPrice,
      final String unitPriceExcludingVat,
      final String amount,
      final String amountExcludingVat,
      final String amountNoFreight,
      final String amountExcludingVatNoFreight,
      final String inputVat,
      final String rdRate,
      final String rdFee,
      final String returnTime,
      final String recipient,
      final String workshop,
      final String warehouseName,
      final String sourceSerialNumber,
      final String sourceProject,
      final String remark,
      final String brand,
      final String returnState,
      final String outboundSerialNumber,
      final String departmentName,
      final String transferType,
      final String directionProjectName,
      final String rejectSN,
      final String materialSn,
      final String materialSnNew,
      final String actualTheoryWeight,
      final String source,
      final String direction,
      final String outboundSn
   ) {
      this.id = id;
      this.data = data;
      this.basicClass = basicClass;
      this.classifyName = classifyName;
      this.spec = spec;
      this.material = material;
      this.lengths = lengths;
      this.serialNumber = serialNumber;
      this.projectNumber = projectNumber;
      this.projectName = projectName;
      this.areaBatchName = areaBatchName;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.taxRate = taxRate;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVat = inputVat;
      this.rdRate = rdRate;
      this.rdFee = rdFee;
      this.returnTime = returnTime;
      this.recipient = recipient;
      this.workshop = workshop;
      this.warehouseName = warehouseName;
      this.sourceSerialNumber = sourceSerialNumber;
      this.sourceProject = sourceProject;
      this.remark = remark;
      this.brand = brand;
      this.returnState = returnState;
      this.outboundSerialNumber = outboundSerialNumber;
      this.departmentName = departmentName;
      this.transferType = transferType;
      this.directionProjectName = directionProjectName;
      this.rejectSN = rejectSN;
      this.materialSn = materialSn;
      this.materialSnNew = materialSnNew;
      this.actualTheoryWeight = actualTheoryWeight;
      this.source = source;
      this.direction = direction;
      this.outboundSn = outboundSn;
   }

   public ExcelDTO() {
   }

   public static class ExcelDTOBuilder {
      private String id;
      private String data;
      private String basicClass;
      private String classifyName;
      private String spec;
      private String material;
      private String lengths;
      private String serialNumber;
      private String projectNumber;
      private String projectName;
      private String areaBatchName;
      private String heatNoAndBatchNo;
      private String measureUnit;
      private String quantity;
      private String accountingUnit;
      private String mete;
      private String taxRate;
      private String unitPrice;
      private String unitPriceExcludingVat;
      private String amount;
      private String amountExcludingVat;
      private String amountNoFreight;
      private String amountExcludingVatNoFreight;
      private String inputVat;
      private String rdRate;
      private String rdFee;
      private String returnTime;
      private String recipient;
      private String workshop;
      private String warehouseName;
      private String sourceSerialNumber;
      private String sourceProject;
      private String remark;
      private String brand;
      private String returnState;
      private String outboundSerialNumber;
      private String departmentName;
      private String transferType;
      private String directionProjectName;
      private String rejectSN;
      private String materialSn;
      private String materialSnNew;
      private String actualTheoryWeight;
      private String source;
      private String direction;
      private String outboundSn;

      ExcelDTOBuilder() {
      }

      public ExcelDTO.ExcelDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder data(final String data) {
         this.data = data;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder basicClass(final String basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder lengths(final String lengths) {
         this.lengths = lengths;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder projectNumber(final String projectNumber) {
         this.projectNumber = projectNumber;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder quantity(final String quantity) {
         this.quantity = quantity;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder mete(final String mete) {
         this.mete = mete;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder taxRate(final String taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder unitPrice(final String unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder unitPriceExcludingVat(final String unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder amount(final String amount) {
         this.amount = amount;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder amountExcludingVat(final String amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder amountNoFreight(final String amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder amountExcludingVatNoFreight(final String amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder inputVat(final String inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder rdRate(final String rdRate) {
         this.rdRate = rdRate;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder rdFee(final String rdFee) {
         this.rdFee = rdFee;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder returnTime(final String returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder recipient(final String recipient) {
         this.recipient = recipient;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder workshop(final String workshop) {
         this.workshop = workshop;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder warehouseName(final String warehouseName) {
         this.warehouseName = warehouseName;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder sourceSerialNumber(final String sourceSerialNumber) {
         this.sourceSerialNumber = sourceSerialNumber;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder sourceProject(final String sourceProject) {
         this.sourceProject = sourceProject;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder returnState(final String returnState) {
         this.returnState = returnState;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder outboundSerialNumber(final String outboundSerialNumber) {
         this.outboundSerialNumber = outboundSerialNumber;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder transferType(final String transferType) {
         this.transferType = transferType;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder directionProjectName(final String directionProjectName) {
         this.directionProjectName = directionProjectName;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder rejectSN(final String rejectSN) {
         this.rejectSN = rejectSN;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder actualTheoryWeight(final String actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder source(final String source) {
         this.source = source;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder direction(final String direction) {
         this.direction = direction;
         return this;
      }

      public ExcelDTO.ExcelDTOBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public ExcelDTO build() {
         return new ExcelDTO(
            this.id,
            this.data,
            this.basicClass,
            this.classifyName,
            this.spec,
            this.material,
            this.lengths,
            this.serialNumber,
            this.projectNumber,
            this.projectName,
            this.areaBatchName,
            this.heatNoAndBatchNo,
            this.measureUnit,
            this.quantity,
            this.accountingUnit,
            this.mete,
            this.taxRate,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.amount,
            this.amountExcludingVat,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVat,
            this.rdRate,
            this.rdFee,
            this.returnTime,
            this.recipient,
            this.workshop,
            this.warehouseName,
            this.sourceSerialNumber,
            this.sourceProject,
            this.remark,
            this.brand,
            this.returnState,
            this.outboundSerialNumber,
            this.departmentName,
            this.transferType,
            this.directionProjectName,
            this.rejectSN,
            this.materialSn,
            this.materialSnNew,
            this.actualTheoryWeight,
            this.source,
            this.direction,
            this.outboundSn
         );
      }

      @Override
      public String toString() {
         return "ExcelDTO.ExcelDTOBuilder(id="
            + this.id
            + ", data="
            + this.data
            + ", basicClass="
            + this.basicClass
            + ", classifyName="
            + this.classifyName
            + ", spec="
            + this.spec
            + ", material="
            + this.material
            + ", lengths="
            + this.lengths
            + ", serialNumber="
            + this.serialNumber
            + ", projectNumber="
            + this.projectNumber
            + ", projectName="
            + this.projectName
            + ", areaBatchName="
            + this.areaBatchName
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", taxRate="
            + this.taxRate
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", inputVat="
            + this.inputVat
            + ", rdRate="
            + this.rdRate
            + ", rdFee="
            + this.rdFee
            + ", returnTime="
            + this.returnTime
            + ", recipient="
            + this.recipient
            + ", workshop="
            + this.workshop
            + ", warehouseName="
            + this.warehouseName
            + ", sourceSerialNumber="
            + this.sourceSerialNumber
            + ", sourceProject="
            + this.sourceProject
            + ", remark="
            + this.remark
            + ", brand="
            + this.brand
            + ", returnState="
            + this.returnState
            + ", outboundSerialNumber="
            + this.outboundSerialNumber
            + ", departmentName="
            + this.departmentName
            + ", transferType="
            + this.transferType
            + ", directionProjectName="
            + this.directionProjectName
            + ", rejectSN="
            + this.rejectSN
            + ", materialSn="
            + this.materialSn
            + ", materialSnNew="
            + this.materialSnNew
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", source="
            + this.source
            + ", direction="
            + this.direction
            + ", outboundSn="
            + this.outboundSn
            + ")";
      }
   }
}
