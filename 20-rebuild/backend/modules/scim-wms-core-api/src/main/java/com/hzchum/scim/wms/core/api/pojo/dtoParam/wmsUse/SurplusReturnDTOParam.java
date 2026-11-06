package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnableDTO;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class SurplusReturnDTOParam {
   private Integer accountingPrecision;
   private String accountingUnit;
   private Integer basicClass;
   private Long factoryId;
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

   public static SurplusReturnDTOParam.SurplusReturnDTOParamBuilder builder() {
      return new SurplusReturnDTOParam.SurplusReturnDTOParamBuilder();
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

   public Long getFactoryId() {
      return this.factoryId;
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

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SurplusReturnDTOParam)) {
         return false;
      }

      SurplusReturnDTOParam other = (SurplusReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$accountingPrecision = this.getAccountingPrecision();
      Object other$accountingPrecision = other.getAccountingPrecision();
      if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
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
                                 Object this$accountingUnit = this.getAccountingUnit();
                                 Object other$accountingUnit = other.getAccountingUnit();
                                 if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
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
                                                   if (this$singleMete == null ? other$singleMete == null : this$singleMete.equals(other$singleMete)) {
                                                      Object this$theoryWeight = this.getTheoryWeight();
                                                      Object other$theoryWeight = other.getTheoryWeight();
                                                      if (this$theoryWeight == null ? other$theoryWeight == null : this$theoryWeight.equals(other$theoryWeight)
                                                         )
                                                       {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$source = this.getSource();
                                                               Object other$source = other.getSource();
                                                               return this$source == null ? other$source == null : this$source.equals(other$source);
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof SurplusReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
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
      return result * 59 + ($source == null ? 43 : $source.hashCode());
   }

   @Override
   public String toString() {
      return "SurplusReturnDTOParam(accountingPrecision="
         + this.getAccountingPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", basicClass="
         + this.getBasicClass()
         + ", factoryId="
         + this.getFactoryId()
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
         + ")";
   }

   public SurplusReturnDTOParam(
      final Integer accountingPrecision,
      final String accountingUnit,
      final Integer basicClass,
      final Long factoryId,
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
      final Boolean boolReturns
   ) {
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.basicClass = basicClass;
      this.factoryId = factoryId;
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
   }

   public SurplusReturnDTOParam() {
   }

   public static class SurplusReturnDTOParamBuilder {
      private Integer accountingPrecision;
      private String accountingUnit;
      private Integer basicClass;
      private Long factoryId;
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

      SurplusReturnDTOParamBuilder() {
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder maxMete(final BigDecimal maxMete) {
         this.maxMete = maxMete;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder singleMete(final BigDecimal singleMete) {
         this.singleMete = singleMete;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder source(final ReturnableDTO source) {
         this.source = source;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder boolRealReturn(final Boolean boolRealReturn) {
         this.boolRealReturn = boolRealReturn;
         return this;
      }

      public SurplusReturnDTOParam.SurplusReturnDTOParamBuilder boolReturns(final Boolean boolReturns) {
         this.boolReturns = boolReturns;
         return this;
      }

      public SurplusReturnDTOParam build() {
         return new SurplusReturnDTOParam(
            this.accountingPrecision,
            this.accountingUnit,
            this.basicClass,
            this.factoryId,
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
            this.boolReturns
         );
      }

      @Override
      public String toString() {
         return "SurplusReturnDTOParam.SurplusReturnDTOParamBuilder(accountingPrecision="
            + this.accountingPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", basicClass="
            + this.basicClass
            + ", factoryId="
            + this.factoryId
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
            + ")";
      }
   }
}
