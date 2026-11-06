package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnableDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MaterialReturnDTOParam {
   private Integer accountingPrecision;
   private String accountingUnit;
   private Integer basicClass;
   private Long workshopId;
   private Long id;
   private BigDecimal length;
   private BigDecimal maxMete;
   private Integer measurePrecision;
   private String measureUnit;
   @NotNull(message = "请输入核算量")
   private BigDecimal mete;
   private Integer outboundUnitType;
   private BigDecimal quantity;
   private BigDecimal singleMete;
   private BigDecimal theoryWeight;
   private Long warehouseId;
   private BigDecimal width;
   private String remark;
   private ReturnableDTO source;
   private Boolean boolRealReturn;
   private Boolean boolReturns;
   private BigDecimal singleQuantity;
   private BigDecimal singleReturnMete;
   private Boolean boolCross;
   private List<MaterialReturnDTOParam> list;
   private Integer outboundTypeSelection;
   private Integer returnDestination;
   private LocalDateTime realTime;
   private Long remnantId;
   private String dxfUrl;
   private String imgUrl;
   private BigDecimal area;
   private Boolean boolNestSurplus;
   private LocalDateTime getDataTime;

   public static MaterialReturnDTOParam.MaterialReturnDTOParamBuilder builder() {
      return new MaterialReturnDTOParam.MaterialReturnDTOParamBuilder();
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getMaxMete() {
      return this.maxMete;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getSingleMete() {
      return this.singleMete;
   }

   public BigDecimal getTheoryWeight() {
      return this.theoryWeight;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getRemark() {
      return this.remark;
   }

   public ReturnableDTO getSource() {
      return this.source;
   }

   public Boolean getBoolRealReturn() {
      return this.boolRealReturn;
   }

   public Boolean getBoolReturns() {
      return this.boolReturns;
   }

   public BigDecimal getSingleQuantity() {
      return this.singleQuantity;
   }

   public BigDecimal getSingleReturnMete() {
      return this.singleReturnMete;
   }

   public Boolean getBoolCross() {
      return this.boolCross;
   }

   public List<MaterialReturnDTOParam> getList() {
      return this.list;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Integer getReturnDestination() {
      return this.returnDestination;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public Long getRemnantId() {
      return this.remnantId;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public LocalDateTime getGetDataTime() {
      return this.getDataTime;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaxMete(final BigDecimal maxMete) {
      this.maxMete = maxMete;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setSingleMete(final BigDecimal singleMete) {
      this.singleMete = singleMete;
   }

   public void setTheoryWeight(final BigDecimal theoryWeight) {
      this.theoryWeight = theoryWeight;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSource(final ReturnableDTO source) {
      this.source = source;
   }

   public void setBoolRealReturn(final Boolean boolRealReturn) {
      this.boolRealReturn = boolRealReturn;
   }

   public void setBoolReturns(final Boolean boolReturns) {
      this.boolReturns = boolReturns;
   }

   public void setSingleQuantity(final BigDecimal singleQuantity) {
      this.singleQuantity = singleQuantity;
   }

   public void setSingleReturnMete(final BigDecimal singleReturnMete) {
      this.singleReturnMete = singleReturnMete;
   }

   public void setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
   }

   public void setList(final List<MaterialReturnDTOParam> list) {
      this.list = list;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setReturnDestination(final Integer returnDestination) {
      this.returnDestination = returnDestination;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   public void setRemnantId(final Long remnantId) {
      this.remnantId = remnantId;
   }

   public void setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
   }

   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
   }

   public void setGetDataTime(final LocalDateTime getDataTime) {
      this.getDataTime = getDataTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialReturnDTOParam)) {
         return false;
      }

      MaterialReturnDTOParam other = (MaterialReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$accountingPrecision = this.getAccountingPrecision();
      Object other$accountingPrecision = other.getAccountingPrecision();
      if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                  Object this$measurePrecision = this.getMeasurePrecision();
                  Object other$measurePrecision = other.getMeasurePrecision();
                  if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                     Object this$outboundUnitType = this.getOutboundUnitType();
                     Object other$outboundUnitType = other.getOutboundUnitType();
                     if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                        Object this$warehouseId = this.getWarehouseId();
                        Object other$warehouseId = other.getWarehouseId();
                        if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                           Object this$boolRealReturn = this.getBoolRealReturn();
                           Object other$boolRealReturn = other.getBoolRealReturn();
                           if (this$boolRealReturn == null ? other$boolRealReturn == null : this$boolRealReturn.equals(other$boolRealReturn)) {
                              Object this$boolReturns = this.getBoolReturns();
                              Object other$boolReturns = other.getBoolReturns();
                              if (this$boolReturns == null ? other$boolReturns == null : this$boolReturns.equals(other$boolReturns)) {
                                 Object this$boolCross = this.getBoolCross();
                                 Object other$boolCross = other.getBoolCross();
                                 if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
                                    Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                    Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                    if (this$outboundTypeSelection == null
                                       ? other$outboundTypeSelection == null
                                       : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                       Object this$returnDestination = this.getReturnDestination();
                                       Object other$returnDestination = other.getReturnDestination();
                                       if (this$returnDestination == null
                                          ? other$returnDestination == null
                                          : this$returnDestination.equals(other$returnDestination)) {
                                          Object this$remnantId = this.getRemnantId();
                                          Object other$remnantId = other.getRemnantId();
                                          if (this$remnantId == null ? other$remnantId == null : this$remnantId.equals(other$remnantId)) {
                                             Object this$boolNestSurplus = this.getBoolNestSurplus();
                                             Object other$boolNestSurplus = other.getBoolNestSurplus();
                                             if (this$boolNestSurplus == null
                                                ? other$boolNestSurplus == null
                                                : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                                Object this$accountingUnit = this.getAccountingUnit();
                                                Object other$accountingUnit = other.getAccountingUnit();
                                                if (this$accountingUnit == null
                                                   ? other$accountingUnit == null
                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$maxMete = this.getMaxMete();
                                                      Object other$maxMete = other.getMaxMete();
                                                      if (this$maxMete == null ? other$maxMete == null : this$maxMete.equals(other$maxMete)) {
                                                         Object this$measureUnit = this.getMeasureUnit();
                                                         Object other$measureUnit = other.getMeasureUnit();
                                                         if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$quantity = this.getQuantity();
                                                               Object other$quantity = other.getQuantity();
                                                               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                  Object this$singleMete = this.getSingleMete();
                                                                  Object other$singleMete = other.getSingleMete();
                                                                  if (this$singleMete == null
                                                                     ? other$singleMete == null
                                                                     : this$singleMete.equals(other$singleMete)) {
                                                                     Object this$theoryWeight = this.getTheoryWeight();
                                                                     Object other$theoryWeight = other.getTheoryWeight();
                                                                     if (this$theoryWeight == null
                                                                        ? other$theoryWeight == null
                                                                        : this$theoryWeight.equals(other$theoryWeight)) {
                                                                        Object this$width = this.getWidth();
                                                                        Object other$width = other.getWidth();
                                                                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$source = this.getSource();
                                                                              Object other$source = other.getSource();
                                                                              if (this$source == null ? other$source == null : this$source.equals(other$source)
                                                                                 )
                                                                               {
                                                                                 Object this$singleQuantity = this.getSingleQuantity();
                                                                                 Object other$singleQuantity = other.getSingleQuantity();
                                                                                 if (this$singleQuantity == null
                                                                                    ? other$singleQuantity == null
                                                                                    : this$singleQuantity.equals(other$singleQuantity)) {
                                                                                    Object this$singleReturnMete = this.getSingleReturnMete();
                                                                                    Object other$singleReturnMete = other.getSingleReturnMete();
                                                                                    if (this$singleReturnMete == null
                                                                                       ? other$singleReturnMete == null
                                                                                       : this$singleReturnMete.equals(other$singleReturnMete)) {
                                                                                       Object this$list = this.getList();
                                                                                       Object other$list = other.getList();
                                                                                       if (this$list == null
                                                                                          ? other$list == null
                                                                                          : this$list.equals(other$list)) {
                                                                                          Object this$realTime = this.getRealTime();
                                                                                          Object other$realTime = other.getRealTime();
                                                                                          if (this$realTime == null
                                                                                             ? other$realTime == null
                                                                                             : this$realTime.equals(other$realTime)) {
                                                                                             Object this$dxfUrl = this.getDxfUrl();
                                                                                             Object other$dxfUrl = other.getDxfUrl();
                                                                                             if (this$dxfUrl == null
                                                                                                ? other$dxfUrl == null
                                                                                                : this$dxfUrl.equals(other$dxfUrl)) {
                                                                                                Object this$imgUrl = this.getImgUrl();
                                                                                                Object other$imgUrl = other.getImgUrl();
                                                                                                if (this$imgUrl == null
                                                                                                   ? other$imgUrl == null
                                                                                                   : this$imgUrl.equals(other$imgUrl)) {
                                                                                                   Object this$area = this.getArea();
                                                                                                   Object other$area = other.getArea();
                                                                                                   if (this$area == null
                                                                                                      ? other$area == null
                                                                                                      : this$area.equals(other$area)) {
                                                                                                      Object this$getDataTime = this.getGetDataTime();
                                                                                                      Object other$getDataTime = other.getGetDataTime();
                                                                                                      return this$getDataTime == null
                                                                                                         ? other$getDataTime == null
                                                                                                         : this$getDataTime.equals(other$getDataTime);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MaterialReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $boolRealReturn = this.getBoolRealReturn();
      result = result * 59 + ($boolRealReturn == null ? 43 : $boolRealReturn.hashCode());
      Object $boolReturns = this.getBoolReturns();
      result = result * 59 + ($boolReturns == null ? 43 : $boolReturns.hashCode());
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $returnDestination = this.getReturnDestination();
      result = result * 59 + ($returnDestination == null ? 43 : $returnDestination.hashCode());
      Object $remnantId = this.getRemnantId();
      result = result * 59 + ($remnantId == null ? 43 : $remnantId.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $maxMete = this.getMaxMete();
      result = result * 59 + ($maxMete == null ? 43 : $maxMete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $singleMete = this.getSingleMete();
      result = result * 59 + ($singleMete == null ? 43 : $singleMete.hashCode());
      Object $theoryWeight = this.getTheoryWeight();
      result = result * 59 + ($theoryWeight == null ? 43 : $theoryWeight.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $singleQuantity = this.getSingleQuantity();
      result = result * 59 + ($singleQuantity == null ? 43 : $singleQuantity.hashCode());
      Object $singleReturnMete = this.getSingleReturnMete();
      result = result * 59 + ($singleReturnMete == null ? 43 : $singleReturnMete.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $realTime = this.getRealTime();
      result = result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $getDataTime = this.getGetDataTime();
      return result * 59 + ($getDataTime == null ? 43 : $getDataTime.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialReturnDTOParam(accountingPrecision="
         + this.getAccountingPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", basicClass="
         + this.getBasicClass()
         + ", workshopId="
         + this.getWorkshopId()
         + ", id="
         + this.getId()
         + ", length="
         + this.getLength()
         + ", maxMete="
         + this.getMaxMete()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", quantity="
         + this.getQuantity()
         + ", singleMete="
         + this.getSingleMete()
         + ", theoryWeight="
         + this.getTheoryWeight()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", width="
         + this.getWidth()
         + ", remark="
         + this.getRemark()
         + ", source="
         + this.getSource()
         + ", boolRealReturn="
         + this.getBoolRealReturn()
         + ", boolReturns="
         + this.getBoolReturns()
         + ", singleQuantity="
         + this.getSingleQuantity()
         + ", singleReturnMete="
         + this.getSingleReturnMete()
         + ", boolCross="
         + this.getBoolCross()
         + ", list="
         + this.getList()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", returnDestination="
         + this.getReturnDestination()
         + ", realTime="
         + this.getRealTime()
         + ", remnantId="
         + this.getRemnantId()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", area="
         + this.getArea()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", getDataTime="
         + this.getGetDataTime()
         + ")";
   }

   public MaterialReturnDTOParam(
      final Integer accountingPrecision,
      final String accountingUnit,
      final Integer basicClass,
      final Long workshopId,
      final Long id,
      final BigDecimal length,
      final BigDecimal maxMete,
      final Integer measurePrecision,
      final String measureUnit,
      final BigDecimal mete,
      final Integer outboundUnitType,
      final BigDecimal quantity,
      final BigDecimal singleMete,
      final BigDecimal theoryWeight,
      final Long warehouseId,
      final BigDecimal width,
      final String remark,
      final ReturnableDTO source,
      final Boolean boolRealReturn,
      final Boolean boolReturns,
      final BigDecimal singleQuantity,
      final BigDecimal singleReturnMete,
      final Boolean boolCross,
      final List<MaterialReturnDTOParam> list,
      final Integer outboundTypeSelection,
      final Integer returnDestination,
      final LocalDateTime realTime,
      final Long remnantId,
      final String dxfUrl,
      final String imgUrl,
      final BigDecimal area,
      final Boolean boolNestSurplus,
      final LocalDateTime getDataTime
   ) {
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.basicClass = basicClass;
      this.workshopId = workshopId;
      this.id = id;
      this.length = length;
      this.maxMete = maxMete;
      this.measurePrecision = measurePrecision;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.outboundUnitType = outboundUnitType;
      this.quantity = quantity;
      this.singleMete = singleMete;
      this.theoryWeight = theoryWeight;
      this.warehouseId = warehouseId;
      this.width = width;
      this.remark = remark;
      this.source = source;
      this.boolRealReturn = boolRealReturn;
      this.boolReturns = boolReturns;
      this.singleQuantity = singleQuantity;
      this.singleReturnMete = singleReturnMete;
      this.boolCross = boolCross;
      this.list = list;
      this.outboundTypeSelection = outboundTypeSelection;
      this.returnDestination = returnDestination;
      this.realTime = realTime;
      this.remnantId = remnantId;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.area = area;
      this.boolNestSurplus = boolNestSurplus;
      this.getDataTime = getDataTime;
   }

   public MaterialReturnDTOParam() {
   }

   public static class MaterialReturnDTOParamBuilder {
      private Integer accountingPrecision;
      private String accountingUnit;
      private Integer basicClass;
      private Long workshopId;
      private Long id;
      private BigDecimal length;
      private BigDecimal maxMete;
      private Integer measurePrecision;
      private String measureUnit;
      private BigDecimal mete;
      private Integer outboundUnitType;
      private BigDecimal quantity;
      private BigDecimal singleMete;
      private BigDecimal theoryWeight;
      private Long warehouseId;
      private BigDecimal width;
      private String remark;
      private ReturnableDTO source;
      private Boolean boolRealReturn;
      private Boolean boolReturns;
      private BigDecimal singleQuantity;
      private BigDecimal singleReturnMete;
      private Boolean boolCross;
      private List<MaterialReturnDTOParam> list;
      private Integer outboundTypeSelection;
      private Integer returnDestination;
      private LocalDateTime realTime;
      private Long remnantId;
      private String dxfUrl;
      private String imgUrl;
      private BigDecimal area;
      private Boolean boolNestSurplus;
      private LocalDateTime getDataTime;

      MaterialReturnDTOParamBuilder() {
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder maxMete(final BigDecimal maxMete) {
         this.maxMete = maxMete;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder singleMete(final BigDecimal singleMete) {
         this.singleMete = singleMete;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder source(final ReturnableDTO source) {
         this.source = source;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder boolRealReturn(final Boolean boolRealReturn) {
         this.boolRealReturn = boolRealReturn;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder boolReturns(final Boolean boolReturns) {
         this.boolReturns = boolReturns;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder singleQuantity(final BigDecimal singleQuantity) {
         this.singleQuantity = singleQuantity;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder singleReturnMete(final BigDecimal singleReturnMete) {
         this.singleReturnMete = singleReturnMete;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder list(final List<MaterialReturnDTOParam> list) {
         this.list = list;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder returnDestination(final Integer returnDestination) {
         this.returnDestination = returnDestination;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder remnantId(final Long remnantId) {
         this.remnantId = remnantId;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder boolNestSurplus(final Boolean boolNestSurplus) {
         this.boolNestSurplus = boolNestSurplus;
         return this;
      }

      public MaterialReturnDTOParam.MaterialReturnDTOParamBuilder getDataTime(final LocalDateTime getDataTime) {
         this.getDataTime = getDataTime;
         return this;
      }

      public MaterialReturnDTOParam build() {
         return new MaterialReturnDTOParam(
            this.accountingPrecision,
            this.accountingUnit,
            this.basicClass,
            this.workshopId,
            this.id,
            this.length,
            this.maxMete,
            this.measurePrecision,
            this.measureUnit,
            this.mete,
            this.outboundUnitType,
            this.quantity,
            this.singleMete,
            this.theoryWeight,
            this.warehouseId,
            this.width,
            this.remark,
            this.source,
            this.boolRealReturn,
            this.boolReturns,
            this.singleQuantity,
            this.singleReturnMete,
            this.boolCross,
            this.list,
            this.outboundTypeSelection,
            this.returnDestination,
            this.realTime,
            this.remnantId,
            this.dxfUrl,
            this.imgUrl,
            this.area,
            this.boolNestSurplus,
            this.getDataTime
         );
      }

      @Override
      public String toString() {
         return "MaterialReturnDTOParam.MaterialReturnDTOParamBuilder(accountingPrecision="
            + this.accountingPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", basicClass="
            + this.basicClass
            + ", workshopId="
            + this.workshopId
            + ", id="
            + this.id
            + ", length="
            + this.length
            + ", maxMete="
            + this.maxMete
            + ", measurePrecision="
            + this.measurePrecision
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", quantity="
            + this.quantity
            + ", singleMete="
            + this.singleMete
            + ", theoryWeight="
            + this.theoryWeight
            + ", warehouseId="
            + this.warehouseId
            + ", width="
            + this.width
            + ", remark="
            + this.remark
            + ", source="
            + this.source
            + ", boolRealReturn="
            + this.boolRealReturn
            + ", boolReturns="
            + this.boolReturns
            + ", singleQuantity="
            + this.singleQuantity
            + ", singleReturnMete="
            + this.singleReturnMete
            + ", boolCross="
            + this.boolCross
            + ", list="
            + this.list
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", returnDestination="
            + this.returnDestination
            + ", realTime="
            + this.realTime
            + ", remnantId="
            + this.remnantId
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ", area="
            + this.area
            + ", boolNestSurplus="
            + this.boolNestSurplus
            + ", getDataTime="
            + this.getDataTime
            + ")";
      }
   }
}
