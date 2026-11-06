package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "YearlyOutputComparisonMonthRowVO", description = "成品入库汇总(按月查询)")
public class FinishedProductWarehousingSummaryVO {
   private String structureType;
   private BigDecimal beginPutPart;
   private BigDecimal beginFinishPart;

   public static FinishedProductWarehousingSummaryVO.FinishedProductWarehousingSummaryVOBuilder builder() {
      return new FinishedProductWarehousingSummaryVO.FinishedProductWarehousingSummaryVOBuilder();
   }

   public FinishedProductWarehousingSummaryVO() {
   }

   public FinishedProductWarehousingSummaryVO(final String structureType, final BigDecimal beginPutPart, final BigDecimal beginFinishPart) {
      this.structureType = structureType;
      this.beginPutPart = beginPutPart;
      this.beginFinishPart = beginFinishPart;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getBeginPutPart() {
      return this.beginPutPart;
   }

   public BigDecimal getBeginFinishPart() {
      return this.beginFinishPart;
   }

   public FinishedProductWarehousingSummaryVO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public FinishedProductWarehousingSummaryVO setBeginPutPart(final BigDecimal beginPutPart) {
      this.beginPutPart = beginPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryVO setBeginFinishPart(final BigDecimal beginFinishPart) {
      this.beginFinishPart = beginFinishPart;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishedProductWarehousingSummaryVO)) {
         return false;
      }

      FinishedProductWarehousingSummaryVO other = (FinishedProductWarehousingSummaryVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureType = this.getStructureType();
      Object other$structureType = other.getStructureType();
      if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
         Object this$beginPutPart = this.getBeginPutPart();
         Object other$beginPutPart = other.getBeginPutPart();
         if (this$beginPutPart == null ? other$beginPutPart == null : this$beginPutPart.equals(other$beginPutPart)) {
            Object this$beginFinishPart = this.getBeginFinishPart();
            Object other$beginFinishPart = other.getBeginFinishPart();
            return this$beginFinishPart == null ? other$beginFinishPart == null : this$beginFinishPart.equals(other$beginFinishPart);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FinishedProductWarehousingSummaryVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $beginPutPart = this.getBeginPutPart();
      result = result * 59 + ($beginPutPart == null ? 43 : $beginPutPart.hashCode());
      Object $beginFinishPart = this.getBeginFinishPart();
      return result * 59 + ($beginFinishPart == null ? 43 : $beginFinishPart.hashCode());
   }

   @Override
   public String toString() {
      return "FinishedProductWarehousingSummaryVO(structureType="
         + this.getStructureType()
         + ", beginPutPart="
         + this.getBeginPutPart()
         + ", beginFinishPart="
         + this.getBeginFinishPart()
         + ")";
   }

   public static class FinishedProductWarehousingSummaryVOBuilder {
      private String structureType;
      private BigDecimal beginPutPart;
      private BigDecimal beginFinishPart;

      FinishedProductWarehousingSummaryVOBuilder() {
      }

      public FinishedProductWarehousingSummaryVO.FinishedProductWarehousingSummaryVOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public FinishedProductWarehousingSummaryVO.FinishedProductWarehousingSummaryVOBuilder beginPutPart(final BigDecimal beginPutPart) {
         this.beginPutPart = beginPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryVO.FinishedProductWarehousingSummaryVOBuilder beginFinishPart(final BigDecimal beginFinishPart) {
         this.beginFinishPart = beginFinishPart;
         return this;
      }

      public FinishedProductWarehousingSummaryVO build() {
         return new FinishedProductWarehousingSummaryVO(this.structureType, this.beginPutPart, this.beginFinishPart);
      }

      @Override
      public String toString() {
         return "FinishedProductWarehousingSummaryVO.FinishedProductWarehousingSummaryVOBuilder(structureType="
            + this.structureType
            + ", beginPutPart="
            + this.beginPutPart
            + ", beginFinishPart="
            + this.beginFinishPart
            + ")";
      }
   }
}
