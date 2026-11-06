package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutboundDetailDTOForMes {
   private Long id;
   private Long classifyId;
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
   private ProjectInfo project;
   private String monomerName;
   private String areaName;
   private ProjectInfo sourceProject;
   private Long factoryId;
   private BriefIdAndNameDTO factory;
   private BriefIdAndNameDTO warehouse;
   private String nationalStandard;
   private LocalDateTime outboundTime;
   private String measureUnit;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer measurePrecision;
   @ApiModelProperty("办理人")
   private String reviewerName;

   public static OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder builder() {
      return new OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder();
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

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public ProjectInfo getSourceProject() {
      return this.sourceProject;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public BriefIdAndNameDTO getFactory() {
      return this.factory;
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

   public String getReviewerName() {
      return this.reviewerName;
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

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setSourceProject(final ProjectInfo sourceProject) {
      this.sourceProject = sourceProject;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setFactory(final BriefIdAndNameDTO factory) {
      this.factory = factory;
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

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDetailDTOForMes)) {
         return false;
      }

      OutboundDetailDTOForMes other = (OutboundDetailDTOForMes)o;
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
                           Object this$factoryId = this.getFactoryId();
                           Object other$factoryId = other.getFactoryId();
                           if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                              Object this$accountingPrecision = this.getAccountingPrecision();
                              Object other$accountingPrecision = other.getAccountingPrecision();
                              if (this$accountingPrecision == null
                                 ? other$accountingPrecision == null
                                 : this$accountingPrecision.equals(other$accountingPrecision)) {
                                 Object this$measurePrecision = this.getMeasurePrecision();
                                 Object other$measurePrecision = other.getMeasurePrecision();
                                 if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
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
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$color = this.getColor();
                                                               Object other$color = other.getColor();
                                                               if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                  Object this$recipient = this.getRecipient();
                                                                  Object other$recipient = other.getRecipient();
                                                                  if (this$recipient == null ? other$recipient == null : this$recipient.equals(other$recipient)
                                                                     )
                                                                   {
                                                                     Object this$workshop = this.getWorkshop();
                                                                     Object other$workshop = other.getWorkshop();
                                                                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
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
                                                                                 Object this$sourceProject = this.getSourceProject();
                                                                                 Object other$sourceProject = other.getSourceProject();
                                                                                 if (this$sourceProject == null
                                                                                    ? other$sourceProject == null
                                                                                    : this$sourceProject.equals(other$sourceProject)) {
                                                                                    Object this$factory = this.getFactory();
                                                                                    Object other$factory = other.getFactory();
                                                                                    if (this$factory == null
                                                                                       ? other$factory == null
                                                                                       : this$factory.equals(other$factory)) {
                                                                                       Object this$warehouse = this.getWarehouse();
                                                                                       Object other$warehouse = other.getWarehouse();
                                                                                       if (this$warehouse == null
                                                                                          ? other$warehouse == null
                                                                                          : this$warehouse.equals(other$warehouse)) {
                                                                                          Object this$nationalStandard = this.getNationalStandard();
                                                                                          Object other$nationalStandard = other.getNationalStandard();
                                                                                          if (this$nationalStandard == null
                                                                                             ? other$nationalStandard == null
                                                                                             : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                             Object this$outboundTime = this.getOutboundTime();
                                                                                             Object other$outboundTime = other.getOutboundTime();
                                                                                             if (this$outboundTime == null
                                                                                                ? other$outboundTime == null
                                                                                                : this$outboundTime.equals(other$outboundTime)) {
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
                                                                                                      Object this$reviewerName = this.getReviewerName();
                                                                                                      Object other$reviewerName = other.getReviewerName();
                                                                                                      return this$reviewerName == null
                                                                                                         ? other$reviewerName == null
                                                                                                         : this$reviewerName.equals(other$reviewerName);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof OutboundDetailDTOForMes;
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
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $sourceProject = this.getSourceProject();
      result = result * 59 + ($sourceProject == null ? 43 : $sourceProject.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
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
      Object $reviewerName = this.getReviewerName();
      return result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailDTOForMes(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
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
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", sourceProject="
         + this.getSourceProject()
         + ", factoryId="
         + this.getFactoryId()
         + ", factory="
         + this.getFactory()
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
         + ", reviewerName="
         + this.getReviewerName()
         + ")";
   }

   public OutboundDetailDTOForMes(
      final Long id,
      final Long classifyId,
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
      final ProjectInfo project,
      final String monomerName,
      final String areaName,
      final ProjectInfo sourceProject,
      final Long factoryId,
      final BriefIdAndNameDTO factory,
      final BriefIdAndNameDTO warehouse,
      final String nationalStandard,
      final LocalDateTime outboundTime,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final String reviewerName
   ) {
      this.id = id;
      this.classifyId = classifyId;
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
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.sourceProject = sourceProject;
      this.factoryId = factoryId;
      this.factory = factory;
      this.warehouse = warehouse;
      this.nationalStandard = nationalStandard;
      this.outboundTime = outboundTime;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.reviewerName = reviewerName;
   }

   public OutboundDetailDTOForMes() {
   }

   public static class OutboundDetailDTOForMesBuilder {
      private Long id;
      private Long classifyId;
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
      private ProjectInfo project;
      private String monomerName;
      private String areaName;
      private ProjectInfo sourceProject;
      private Long factoryId;
      private BriefIdAndNameDTO factory;
      private BriefIdAndNameDTO warehouse;
      private String nationalStandard;
      private LocalDateTime outboundTime;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private String reviewerName;

      OutboundDetailDTOForMesBuilder() {
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder materialOutboundMode(final Integer materialOutboundMode) {
         this.materialOutboundMode = materialOutboundMode;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder outboundRelationType(final Integer outboundRelationType) {
         this.outboundRelationType = outboundRelationType;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder recipient(final BriefDeptAndNameDTO recipient) {
         this.recipient = recipient;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder sourceProject(final ProjectInfo sourceProject) {
         this.sourceProject = sourceProject;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder factory(final BriefIdAndNameDTO factory) {
         this.factory = factory;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public OutboundDetailDTOForMes build() {
         return new OutboundDetailDTOForMes(
            this.id,
            this.classifyId,
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
            this.project,
            this.monomerName,
            this.areaName,
            this.sourceProject,
            this.factoryId,
            this.factory,
            this.warehouse,
            this.nationalStandard,
            this.outboundTime,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision,
            this.reviewerName
         );
      }

      @Override
      public String toString() {
         return "OutboundDetailDTOForMes.OutboundDetailDTOForMesBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
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
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", sourceProject="
            + this.sourceProject
            + ", factoryId="
            + this.factoryId
            + ", factory="
            + this.factory
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
            + ", reviewerName="
            + this.reviewerName
            + ")";
      }
   }
}
