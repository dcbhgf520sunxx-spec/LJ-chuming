package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReturnDetailDTO {
   private Long id;
   private Boolean boolPartyA;
   private String specification;
   private Long classifyId;
   private Integer basicClass;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private String color;
   private String brand;
   private String heatNoAndBatchNo;
   private BigDecimal quantity;
   private BigDecimal mete;
   private BigDecimal singleReturnMete;
   private BigDecimal singleQuantity;
   private String monomerName;
   private String areaName;
   private ProjectInfoDTO project;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   private Long sourceWorkshopId;
   private String remark;
   private String nationalStandard;
   private ReturnableDTO source;
   private Boolean boolReturns;
   private LocalDateTime realTime;
   private List<ReturnDetailDTO> list;
   private Boolean boolRemnant;
   private Long outboundDetailId;
   private BigDecimal amount;
   private BigDecimal amountExcludingVat;
   private BigDecimal inputVat;
   private BigDecimal unitPriceExcludingVat;
   private BigDecimal unitPrice;
   private String materialSnNew;

   public static ReturnDetailDTO.ReturnDetailDTOBuilder builder() {
      return new ReturnDetailDTO.ReturnDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getClassifyId() {
      return this.classifyId;
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

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getSingleReturnMete() {
      return this.singleReturnMete;
   }

   public BigDecimal getSingleQuantity() {
      return this.singleQuantity;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public ReturnableDTO getSource() {
      return this.source;
   }

   public Boolean getBoolReturns() {
      return this.boolReturns;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public List<ReturnDetailDTO> getList() {
      return this.list;
   }

   public Boolean getBoolRemnant() {
      return this.boolRemnant;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setSingleReturnMete(final BigDecimal singleReturnMete) {
      this.singleReturnMete = singleReturnMete;
   }

   public void setSingleQuantity(final BigDecimal singleQuantity) {
      this.singleQuantity = singleQuantity;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setSource(final ReturnableDTO source) {
      this.source = source;
   }

   public void setBoolReturns(final Boolean boolReturns) {
      this.boolReturns = boolReturns;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   public void setList(final List<ReturnDetailDTO> list) {
      this.list = list;
   }

   public void setBoolRemnant(final Boolean boolRemnant) {
      this.boolRemnant = boolRemnant;
   }

   public void setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDetailDTO)) {
         return false;
      }

      ReturnDetailDTO other = (ReturnDetailDTO)o;
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
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$sourceWorkshopId = this.getSourceWorkshopId();
                  Object other$sourceWorkshopId = other.getSourceWorkshopId();
                  if (this$sourceWorkshopId == null ? other$sourceWorkshopId == null : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                     Object this$boolReturns = this.getBoolReturns();
                     Object other$boolReturns = other.getBoolReturns();
                     if (this$boolReturns == null ? other$boolReturns == null : this$boolReturns.equals(other$boolReturns)) {
                        Object this$boolRemnant = this.getBoolRemnant();
                        Object other$boolRemnant = other.getBoolRemnant();
                        if (this$boolRemnant == null ? other$boolRemnant == null : this$boolRemnant.equals(other$boolRemnant)) {
                           Object this$outboundDetailId = this.getOutboundDetailId();
                           Object other$outboundDetailId = other.getOutboundDetailId();
                           if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$color = this.getColor();
                                          Object other$color = other.getColor();
                                          if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                             Object this$brand = this.getBrand();
                                             Object other$brand = other.getBrand();
                                             if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                if (this$heatNoAndBatchNo == null
                                                   ? other$heatNoAndBatchNo == null
                                                   : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                   Object this$quantity = this.getQuantity();
                                                   Object other$quantity = other.getQuantity();
                                                   if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                      Object this$mete = this.getMete();
                                                      Object other$mete = other.getMete();
                                                      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                         Object this$singleReturnMete = this.getSingleReturnMete();
                                                         Object other$singleReturnMete = other.getSingleReturnMete();
                                                         if (this$singleReturnMete == null
                                                            ? other$singleReturnMete == null
                                                            : this$singleReturnMete.equals(other$singleReturnMete)) {
                                                            Object this$singleQuantity = this.getSingleQuantity();
                                                            Object other$singleQuantity = other.getSingleQuantity();
                                                            if (this$singleQuantity == null
                                                               ? other$singleQuantity == null
                                                               : this$singleQuantity.equals(other$singleQuantity)) {
                                                               Object this$monomerName = this.getMonomerName();
                                                               Object other$monomerName = other.getMonomerName();
                                                               if (this$monomerName == null
                                                                  ? other$monomerName == null
                                                                  : this$monomerName.equals(other$monomerName)) {
                                                                  Object this$areaName = this.getAreaName();
                                                                  Object other$areaName = other.getAreaName();
                                                                  if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                                     Object this$project = this.getProject();
                                                                     Object other$project = other.getProject();
                                                                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$nationalStandard = this.getNationalStandard();
                                                                                 Object other$nationalStandard = other.getNationalStandard();
                                                                                 if (this$nationalStandard == null
                                                                                    ? other$nationalStandard == null
                                                                                    : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                    Object this$source = this.getSource();
                                                                                    Object other$source = other.getSource();
                                                                                    if (this$source == null
                                                                                       ? other$source == null
                                                                                       : this$source.equals(other$source)) {
                                                                                       Object this$realTime = this.getRealTime();
                                                                                       Object other$realTime = other.getRealTime();
                                                                                       if (this$realTime == null
                                                                                          ? other$realTime == null
                                                                                          : this$realTime.equals(other$realTime)) {
                                                                                          Object this$list = this.getList();
                                                                                          Object other$list = other.getList();
                                                                                          if (this$list == null
                                                                                             ? other$list == null
                                                                                             : this$list.equals(other$list)) {
                                                                                             Object this$amount = this.getAmount();
                                                                                             Object other$amount = other.getAmount();
                                                                                             if (this$amount == null
                                                                                                ? other$amount == null
                                                                                                : this$amount.equals(other$amount)) {
                                                                                                Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                if (this$amountExcludingVat == null
                                                                                                   ? other$amountExcludingVat == null
                                                                                                   : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                                   Object this$inputVat = this.getInputVat();
                                                                                                   Object other$inputVat = other.getInputVat();
                                                                                                   if (this$inputVat == null
                                                                                                      ? other$inputVat == null
                                                                                                      : this$inputVat.equals(other$inputVat)) {
                                                                                                      Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                      Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                      if (this$unitPriceExcludingVat == null
                                                                                                         ? other$unitPriceExcludingVat == null
                                                                                                         : this$unitPriceExcludingVat.equals(
                                                                                                            other$unitPriceExcludingVat
                                                                                                         )) {
                                                                                                         Object this$unitPrice = this.getUnitPrice();
                                                                                                         Object other$unitPrice = other.getUnitPrice();
                                                                                                         if (this$unitPrice == null
                                                                                                            ? other$unitPrice == null
                                                                                                            : this$unitPrice.equals(other$unitPrice)) {
                                                                                                            Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                            Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                            return this$materialSnNew == null
                                                                                                               ? other$materialSnNew == null
                                                                                                               : this$materialSnNew.equals(other$materialSnNew);
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ReturnDetailDTO;
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
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $boolReturns = this.getBoolReturns();
      result = result * 59 + ($boolReturns == null ? 43 : $boolReturns.hashCode());
      Object $boolRemnant = this.getBoolRemnant();
      result = result * 59 + ($boolRemnant == null ? 43 : $boolRemnant.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $singleReturnMete = this.getSingleReturnMete();
      result = result * 59 + ($singleReturnMete == null ? 43 : $singleReturnMete.hashCode());
      Object $singleQuantity = this.getSingleQuantity();
      result = result * 59 + ($singleQuantity == null ? 43 : $singleQuantity.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $realTime = this.getRealTime();
      result = result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnDetailDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", specification="
         + this.getSpecification()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", singleReturnMete="
         + this.getSingleReturnMete()
         + ", singleQuantity="
         + this.getSingleQuantity()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", remark="
         + this.getRemark()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", source="
         + this.getSource()
         + ", boolReturns="
         + this.getBoolReturns()
         + ", realTime="
         + this.getRealTime()
         + ", list="
         + this.getList()
         + ", boolRemnant="
         + this.getBoolRemnant()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ")";
   }

   public ReturnDetailDTO(
      final Long id,
      final Boolean boolPartyA,
      final String specification,
      final Long classifyId,
      final Integer basicClass,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final String brand,
      final String heatNoAndBatchNo,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal singleReturnMete,
      final BigDecimal singleQuantity,
      final String monomerName,
      final String areaName,
      final ProjectInfoDTO project,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final Long sourceWorkshopId,
      final String remark,
      final String nationalStandard,
      final ReturnableDTO source,
      final Boolean boolReturns,
      final LocalDateTime realTime,
      final List<ReturnDetailDTO> list,
      final Boolean boolRemnant,
      final Long outboundDetailId,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal unitPrice,
      final String materialSnNew
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.specification = specification;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.quantity = quantity;
      this.mete = mete;
      this.singleReturnMete = singleReturnMete;
      this.singleQuantity = singleQuantity;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.project = project;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.sourceWorkshopId = sourceWorkshopId;
      this.remark = remark;
      this.nationalStandard = nationalStandard;
      this.source = source;
      this.boolReturns = boolReturns;
      this.realTime = realTime;
      this.list = list;
      this.boolRemnant = boolRemnant;
      this.outboundDetailId = outboundDetailId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.unitPrice = unitPrice;
      this.materialSnNew = materialSnNew;
   }

   public ReturnDetailDTO() {
   }

   public static class ReturnDetailDTOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private String specification;
      private Long classifyId;
      private Integer basicClass;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private String brand;
      private String heatNoAndBatchNo;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal singleReturnMete;
      private BigDecimal singleQuantity;
      private String monomerName;
      private String areaName;
      private ProjectInfoDTO project;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private Long sourceWorkshopId;
      private String remark;
      private String nationalStandard;
      private ReturnableDTO source;
      private Boolean boolReturns;
      private LocalDateTime realTime;
      private List<ReturnDetailDTO> list;
      private Boolean boolRemnant;
      private Long outboundDetailId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal unitPrice;
      private String materialSnNew;

      ReturnDetailDTOBuilder() {
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder singleReturnMete(final BigDecimal singleReturnMete) {
         this.singleReturnMete = singleReturnMete;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder singleQuantity(final BigDecimal singleQuantity) {
         this.singleQuantity = singleQuantity;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder source(final ReturnableDTO source) {
         this.source = source;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder boolReturns(final Boolean boolReturns) {
         this.boolReturns = boolReturns;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder list(final List<ReturnDetailDTO> list) {
         this.list = list;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder boolRemnant(final Boolean boolRemnant) {
         this.boolRemnant = boolRemnant;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ReturnDetailDTO.ReturnDetailDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public ReturnDetailDTO build() {
         return new ReturnDetailDTO(
            this.id,
            this.boolPartyA,
            this.specification,
            this.classifyId,
            this.basicClass,
            this.length,
            this.width,
            this.thickness,
            this.color,
            this.brand,
            this.heatNoAndBatchNo,
            this.quantity,
            this.mete,
            this.singleReturnMete,
            this.singleQuantity,
            this.monomerName,
            this.areaName,
            this.project,
            this.workshop,
            this.warehouse,
            this.sourceWorkshopId,
            this.remark,
            this.nationalStandard,
            this.source,
            this.boolReturns,
            this.realTime,
            this.list,
            this.boolRemnant,
            this.outboundDetailId,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.unitPriceExcludingVat,
            this.unitPrice,
            this.materialSnNew
         );
      }

      @Override
      public String toString() {
         return "ReturnDetailDTO.ReturnDetailDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", specification="
            + this.specification
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", singleReturnMete="
            + this.singleReturnMete
            + ", singleQuantity="
            + this.singleQuantity
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", remark="
            + this.remark
            + ", nationalStandard="
            + this.nationalStandard
            + ", source="
            + this.source
            + ", boolReturns="
            + this.boolReturns
            + ", realTime="
            + this.realTime
            + ", list="
            + this.list
            + ", boolRemnant="
            + this.boolRemnant
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", unitPrice="
            + this.unitPrice
            + ", materialSnNew="
            + this.materialSnNew
            + ")";
      }
   }
}
