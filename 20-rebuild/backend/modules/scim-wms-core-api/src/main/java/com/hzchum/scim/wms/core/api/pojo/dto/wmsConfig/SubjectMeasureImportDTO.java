package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SubjectMeasureImportDTO {
   @Excel(name = "序号")
   private Integer orderNo;
   @Excel(name = "一级科目")
   private String nameA;
   @Excel(name = "二级科目")
   private String nameB;
   @Excel(name = "三级科目")
   private String nameC;
   @Excel(name = "计量单位")
   private String measureUnit;
   @Excel(name = "小数精度(计量)")
   private String measurePrecision;
   @Excel(name = "核算单位")
   private String accountingUnit;
   @Excel(name = "小数精度(核算)")
   private String accountingPrecision;
   @Excel(name = "出库单位")
   private String outboundUnitType;

   public static SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder builder() {
      return new SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder();
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getNameA() {
      return this.nameA;
   }

   public String getNameB() {
      return this.nameB;
   }

   public String getNameC() {
      return this.nameC;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setNameA(final String nameA) {
      this.nameA = nameA;
   }

   public void setNameB(final String nameB) {
      this.nameB = nameB;
   }

   public void setNameC(final String nameC) {
      this.nameC = nameC;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final String measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final String accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setOutboundUnitType(final String outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectMeasureImportDTO)) {
         return false;
      }

      SubjectMeasureImportDTO other = (SubjectMeasureImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$nameA = this.getNameA();
         Object other$nameA = other.getNameA();
         if (this$nameA == null ? other$nameA == null : this$nameA.equals(other$nameA)) {
            Object this$nameB = this.getNameB();
            Object other$nameB = other.getNameB();
            if (this$nameB == null ? other$nameB == null : this$nameB.equals(other$nameB)) {
               Object this$nameC = this.getNameC();
               Object other$nameC = other.getNameC();
               if (this$nameC == null ? other$nameC == null : this$nameC.equals(other$nameC)) {
                  Object this$measureUnit = this.getMeasureUnit();
                  Object other$measureUnit = other.getMeasureUnit();
                  if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                     Object this$measurePrecision = this.getMeasurePrecision();
                     Object other$measurePrecision = other.getMeasurePrecision();
                     if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                        Object this$accountingUnit = this.getAccountingUnit();
                        Object other$accountingUnit = other.getAccountingUnit();
                        if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                           Object this$accountingPrecision = this.getAccountingPrecision();
                           Object other$accountingPrecision = other.getAccountingPrecision();
                           if (this$accountingPrecision == null
                              ? other$accountingPrecision == null
                              : this$accountingPrecision.equals(other$accountingPrecision)) {
                              Object this$outboundUnitType = this.getOutboundUnitType();
                              Object other$outboundUnitType = other.getOutboundUnitType();
                              return this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType);
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof SubjectMeasureImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $nameA = this.getNameA();
      result = result * 59 + ($nameA == null ? 43 : $nameA.hashCode());
      Object $nameB = this.getNameB();
      result = result * 59 + ($nameB == null ? 43 : $nameB.hashCode());
      Object $nameC = this.getNameC();
      result = result * 59 + ($nameC == null ? 43 : $nameC.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      return result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectMeasureImportDTO(orderNo="
         + this.getOrderNo()
         + ", nameA="
         + this.getNameA()
         + ", nameB="
         + this.getNameB()
         + ", nameC="
         + this.getNameC()
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

   public SubjectMeasureImportDTO(
      final Integer orderNo,
      final String nameA,
      final String nameB,
      final String nameC,
      final String measureUnit,
      final String measurePrecision,
      final String accountingUnit,
      final String accountingPrecision,
      final String outboundUnitType
   ) {
      this.orderNo = orderNo;
      this.nameA = nameA;
      this.nameB = nameB;
      this.nameC = nameC;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.outboundUnitType = outboundUnitType;
   }

   public SubjectMeasureImportDTO() {
   }

   public static class SubjectMeasureImportDTOBuilder {
      private Integer orderNo;
      private String nameA;
      private String nameB;
      private String nameC;
      private String measureUnit;
      private String measurePrecision;
      private String accountingUnit;
      private String accountingPrecision;
      private String outboundUnitType;

      SubjectMeasureImportDTOBuilder() {
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder nameA(final String nameA) {
         this.nameA = nameA;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder nameB(final String nameB) {
         this.nameB = nameB;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder nameC(final String nameC) {
         this.nameC = nameC;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder measurePrecision(final String measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder accountingPrecision(final String accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder outboundUnitType(final String outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public SubjectMeasureImportDTO build() {
         return new SubjectMeasureImportDTO(
            this.orderNo,
            this.nameA,
            this.nameB,
            this.nameC,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.accountingPrecision,
            this.outboundUnitType
         );
      }

      @Override
      public String toString() {
         return "SubjectMeasureImportDTO.SubjectMeasureImportDTOBuilder(orderNo="
            + this.orderNo
            + ", nameA="
            + this.nameA
            + ", nameB="
            + this.nameB
            + ", nameC="
            + this.nameC
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", outboundUnitType="
            + this.outboundUnitType
            + ")";
      }
   }
}
