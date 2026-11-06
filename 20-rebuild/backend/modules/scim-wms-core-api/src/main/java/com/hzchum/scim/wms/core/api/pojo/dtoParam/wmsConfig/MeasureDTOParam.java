package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import javax.validation.constraints.NotBlank;

public class MeasureDTOParam {
   private Long id;
   private String measureUnit;
   private Integer measurePrecision;
   @NotBlank(message = "核算单位不能为空")
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer outboundUnitType;

   public Long getId() {
      return this.id;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MeasureDTOParam)) {
         return false;
      }

      MeasureDTOParam other = (MeasureDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$measurePrecision = this.getMeasurePrecision();
         Object other$measurePrecision = other.getMeasurePrecision();
         if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
            Object this$accountingPrecision = this.getAccountingPrecision();
            Object other$accountingPrecision = other.getAccountingPrecision();
            if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
               Object this$outboundUnitType = this.getOutboundUnitType();
               Object other$outboundUnitType = other.getOutboundUnitType();
               if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                  Object this$measureUnit = this.getMeasureUnit();
                  Object other$measureUnit = other.getMeasureUnit();
                  if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                     Object this$accountingUnit = this.getAccountingUnit();
                     Object other$accountingUnit = other.getAccountingUnit();
                     return this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MeasureDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "MeasureDTOParam(id="
         + this.getId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ")";
   }

   public MeasureDTOParam(
      final Long id,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer outboundUnitType
   ) {
      this.id = id;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.outboundUnitType = outboundUnitType;
   }

   public MeasureDTOParam() {
   }
}
