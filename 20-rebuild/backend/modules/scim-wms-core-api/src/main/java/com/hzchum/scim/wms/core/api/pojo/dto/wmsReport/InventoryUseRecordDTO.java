package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryUseRecordDTO {
   private Long id;
   private Boolean boolPartyA;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private Boolean boolOddmentByHalfOut;
   private Integer outboundRelationType;
   private Integer materialIsWhole;
   private Integer basicClass;
   private String specification;
   private BigDecimal quantity;
   private BigDecimal mete;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private ProjectInfo project;
   private Measure measure;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   private BriefIdAndSNDTO receipt;
   private LocalDateTime createTime;
   private String measureUnit;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer measurePrecision;

   public static InventoryUseRecordDTO.InventoryUseRecordDTOBuilder builder() {
      return new InventoryUseRecordDTO.InventoryUseRecordDTOBuilder();
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

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
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

   public BigDecimal getMete() {
      return this.mete;
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

   public ProjectInfo getProject() {
      return this.project;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
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

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
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

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
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

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryUseRecordDTO)) {
         return false;
      }

      InventoryUseRecordDTO other = (InventoryUseRecordDTO)o;
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
                                    Object this$classifySerialNumber = this.getClassifySerialNumber();
                                    Object other$classifySerialNumber = other.getClassifySerialNumber();
                                    if (this$classifySerialNumber == null
                                       ? other$classifySerialNumber == null
                                       : this$classifySerialNumber.equals(other$classifySerialNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                                                                  Object this$project = this.getProject();
                                                                  Object other$project = other.getProject();
                                                                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                     Object this$measure = this.getMeasure();
                                                                     Object other$measure = other.getMeasure();
                                                                     if (this$measure == null ? other$measure == null : this$measure.equals(other$measure)) {
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
                                                                              Object this$receipt = this.getReceipt();
                                                                              Object other$receipt = other.getReceipt();
                                                                              if (this$receipt == null
                                                                                 ? other$receipt == null
                                                                                 : this$receipt.equals(other$receipt)) {
                                                                                 Object this$createTime = this.getCreateTime();
                                                                                 Object other$createTime = other.getCreateTime();
                                                                                 if (this$createTime == null
                                                                                    ? other$createTime == null
                                                                                    : this$createTime.equals(other$createTime)) {
                                                                                    Object this$measureUnit = this.getMeasureUnit();
                                                                                    Object other$measureUnit = other.getMeasureUnit();
                                                                                    if (this$measureUnit == null
                                                                                       ? other$measureUnit == null
                                                                                       : this$measureUnit.equals(other$measureUnit)) {
                                                                                       Object this$accountingUnit = this.getAccountingUnit();
                                                                                       Object other$accountingUnit = other.getAccountingUnit();
                                                                                       return this$accountingUnit == null
                                                                                          ? other$accountingUnit == null
                                                                                          : this$accountingUnit.equals(other$accountingUnit);
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof InventoryUseRecordDTO;
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
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryUseRecordDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
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
         + ", mete="
         + this.getMete()
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
         + ", project="
         + this.getProject()
         + ", measure="
         + this.getMeasure()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
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
         + ")";
   }

   public InventoryUseRecordDTO(
      final Long id,
      final Boolean boolPartyA,
      final Long classifyId,
      final String classifyName,
      final String classifySerialNumber,
      final Boolean boolOddmentByHalfOut,
      final Integer outboundRelationType,
      final Integer materialIsWhole,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final ProjectInfo project,
      final Measure measure,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final BriefIdAndSNDTO receipt,
      final LocalDateTime createTime,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.classifySerialNumber = classifySerialNumber;
      this.boolOddmentByHalfOut = boolOddmentByHalfOut;
      this.outboundRelationType = outboundRelationType;
      this.materialIsWhole = materialIsWhole;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.project = project;
      this.measure = measure;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.receipt = receipt;
      this.createTime = createTime;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
   }

   public InventoryUseRecordDTO() {
   }

   public static class InventoryUseRecordDTOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private Long classifyId;
      private String classifyName;
      private String classifySerialNumber;
      private Boolean boolOddmentByHalfOut;
      private Integer outboundRelationType;
      private Integer materialIsWhole;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private ProjectInfo project;
      private Measure measure;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private BriefIdAndSNDTO receipt;
      private LocalDateTime createTime;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;

      InventoryUseRecordDTOBuilder() {
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder boolOddmentByHalfOut(final Boolean boolOddmentByHalfOut) {
         this.boolOddmentByHalfOut = boolOddmentByHalfOut;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder outboundRelationType(final Integer outboundRelationType) {
         this.outboundRelationType = outboundRelationType;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public InventoryUseRecordDTO.InventoryUseRecordDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public InventoryUseRecordDTO build() {
         return new InventoryUseRecordDTO(
            this.id,
            this.boolPartyA,
            this.classifyId,
            this.classifyName,
            this.classifySerialNumber,
            this.boolOddmentByHalfOut,
            this.outboundRelationType,
            this.materialIsWhole,
            this.basicClass,
            this.specification,
            this.quantity,
            this.mete,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.project,
            this.measure,
            this.workshop,
            this.warehouse,
            this.receipt,
            this.createTime,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision
         );
      }

      @Override
      public String toString() {
         return "InventoryUseRecordDTO.InventoryUseRecordDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", classifySerialNumber="
            + this.classifySerialNumber
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
            + ", mete="
            + this.mete
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
            + ", project="
            + this.project
            + ", measure="
            + this.measure
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
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
            + ")";
      }
   }
}
