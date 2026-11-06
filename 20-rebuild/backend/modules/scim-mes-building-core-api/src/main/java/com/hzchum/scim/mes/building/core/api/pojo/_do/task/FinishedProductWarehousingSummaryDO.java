package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "FinishedProductWarehousingSummaryDO", description = "成品入库汇总(按月查询)")
public class FinishedProductWarehousingSummaryDO {
   private Integer typeNumber;
   private String structureType;
   private BigDecimal beginPutPart;
   private BigDecimal beginFinishProduct;
   private BigDecimal beginHalfProduct;
   private BigDecimal beginConvertFinishProduct;
   private BigDecimal thisMonthPutPart;
   private BigDecimal thisMonthFinishProduct;
   private BigDecimal thisMonthHalfProduct;
   private BigDecimal thisMonthConvertFinishProduct;
   private BigDecimal totalPutPart;
   private BigDecimal totalFinishProduct;
   private BigDecimal thisMonthFinishOutput;
   private Long workshopId;
   private String workshopName;
   private String remark;

   public static FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder builder() {
      return new FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder();
   }

   public FinishedProductWarehousingSummaryDO() {
   }

   public FinishedProductWarehousingSummaryDO(
      final Integer typeNumber,
      final String structureType,
      final BigDecimal beginPutPart,
      final BigDecimal beginFinishProduct,
      final BigDecimal beginHalfProduct,
      final BigDecimal beginConvertFinishProduct,
      final BigDecimal thisMonthPutPart,
      final BigDecimal thisMonthFinishProduct,
      final BigDecimal thisMonthHalfProduct,
      final BigDecimal thisMonthConvertFinishProduct,
      final BigDecimal totalPutPart,
      final BigDecimal totalFinishProduct,
      final BigDecimal thisMonthFinishOutput,
      final Long workshopId,
      final String workshopName,
      final String remark
   ) {
      this.typeNumber = typeNumber;
      this.structureType = structureType;
      this.beginPutPart = beginPutPart;
      this.beginFinishProduct = beginFinishProduct;
      this.beginHalfProduct = beginHalfProduct;
      this.beginConvertFinishProduct = beginConvertFinishProduct;
      this.thisMonthPutPart = thisMonthPutPart;
      this.thisMonthFinishProduct = thisMonthFinishProduct;
      this.thisMonthHalfProduct = thisMonthHalfProduct;
      this.thisMonthConvertFinishProduct = thisMonthConvertFinishProduct;
      this.totalPutPart = totalPutPart;
      this.totalFinishProduct = totalFinishProduct;
      this.thisMonthFinishOutput = thisMonthFinishOutput;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.remark = remark;
   }

   public Integer getTypeNumber() {
      return this.typeNumber;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getBeginPutPart() {
      return this.beginPutPart;
   }

   public BigDecimal getBeginFinishProduct() {
      return this.beginFinishProduct;
   }

   public BigDecimal getBeginHalfProduct() {
      return this.beginHalfProduct;
   }

   public BigDecimal getBeginConvertFinishProduct() {
      return this.beginConvertFinishProduct;
   }

   public BigDecimal getThisMonthPutPart() {
      return this.thisMonthPutPart;
   }

   public BigDecimal getThisMonthFinishProduct() {
      return this.thisMonthFinishProduct;
   }

   public BigDecimal getThisMonthHalfProduct() {
      return this.thisMonthHalfProduct;
   }

   public BigDecimal getThisMonthConvertFinishProduct() {
      return this.thisMonthConvertFinishProduct;
   }

   public BigDecimal getTotalPutPart() {
      return this.totalPutPart;
   }

   public BigDecimal getTotalFinishProduct() {
      return this.totalFinishProduct;
   }

   public BigDecimal getThisMonthFinishOutput() {
      return this.thisMonthFinishOutput;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getRemark() {
      return this.remark;
   }

   public FinishedProductWarehousingSummaryDO setTypeNumber(final Integer typeNumber) {
      this.typeNumber = typeNumber;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setBeginPutPart(final BigDecimal beginPutPart) {
      this.beginPutPart = beginPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setBeginFinishProduct(final BigDecimal beginFinishProduct) {
      this.beginFinishProduct = beginFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setBeginHalfProduct(final BigDecimal beginHalfProduct) {
      this.beginHalfProduct = beginHalfProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setBeginConvertFinishProduct(final BigDecimal beginConvertFinishProduct) {
      this.beginConvertFinishProduct = beginConvertFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setThisMonthPutPart(final BigDecimal thisMonthPutPart) {
      this.thisMonthPutPart = thisMonthPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setThisMonthFinishProduct(final BigDecimal thisMonthFinishProduct) {
      this.thisMonthFinishProduct = thisMonthFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setThisMonthHalfProduct(final BigDecimal thisMonthHalfProduct) {
      this.thisMonthHalfProduct = thisMonthHalfProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setThisMonthConvertFinishProduct(final BigDecimal thisMonthConvertFinishProduct) {
      this.thisMonthConvertFinishProduct = thisMonthConvertFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setTotalPutPart(final BigDecimal totalPutPart) {
      this.totalPutPart = totalPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setTotalFinishProduct(final BigDecimal totalFinishProduct) {
      this.totalFinishProduct = totalFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setThisMonthFinishOutput(final BigDecimal thisMonthFinishOutput) {
      this.thisMonthFinishOutput = thisMonthFinishOutput;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public FinishedProductWarehousingSummaryDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishedProductWarehousingSummaryDO)) {
         return false;
      }

      FinishedProductWarehousingSummaryDO other = (FinishedProductWarehousingSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeNumber = this.getTypeNumber();
      Object other$typeNumber = other.getTypeNumber();
      if (this$typeNumber == null ? other$typeNumber == null : this$typeNumber.equals(other$typeNumber)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$structureType = this.getStructureType();
            Object other$structureType = other.getStructureType();
            if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
               Object this$beginPutPart = this.getBeginPutPart();
               Object other$beginPutPart = other.getBeginPutPart();
               if (this$beginPutPart == null ? other$beginPutPart == null : this$beginPutPart.equals(other$beginPutPart)) {
                  Object this$beginFinishProduct = this.getBeginFinishProduct();
                  Object other$beginFinishProduct = other.getBeginFinishProduct();
                  if (this$beginFinishProduct == null ? other$beginFinishProduct == null : this$beginFinishProduct.equals(other$beginFinishProduct)) {
                     Object this$beginHalfProduct = this.getBeginHalfProduct();
                     Object other$beginHalfProduct = other.getBeginHalfProduct();
                     if (this$beginHalfProduct == null ? other$beginHalfProduct == null : this$beginHalfProduct.equals(other$beginHalfProduct)) {
                        Object this$beginConvertFinishProduct = this.getBeginConvertFinishProduct();
                        Object other$beginConvertFinishProduct = other.getBeginConvertFinishProduct();
                        if (this$beginConvertFinishProduct == null
                           ? other$beginConvertFinishProduct == null
                           : this$beginConvertFinishProduct.equals(other$beginConvertFinishProduct)) {
                           Object this$thisMonthPutPart = this.getThisMonthPutPart();
                           Object other$thisMonthPutPart = other.getThisMonthPutPart();
                           if (this$thisMonthPutPart == null ? other$thisMonthPutPart == null : this$thisMonthPutPart.equals(other$thisMonthPutPart)) {
                              Object this$thisMonthFinishProduct = this.getThisMonthFinishProduct();
                              Object other$thisMonthFinishProduct = other.getThisMonthFinishProduct();
                              if (this$thisMonthFinishProduct == null
                                 ? other$thisMonthFinishProduct == null
                                 : this$thisMonthFinishProduct.equals(other$thisMonthFinishProduct)) {
                                 Object this$thisMonthHalfProduct = this.getThisMonthHalfProduct();
                                 Object other$thisMonthHalfProduct = other.getThisMonthHalfProduct();
                                 if (this$thisMonthHalfProduct == null
                                    ? other$thisMonthHalfProduct == null
                                    : this$thisMonthHalfProduct.equals(other$thisMonthHalfProduct)) {
                                    Object this$thisMonthConvertFinishProduct = this.getThisMonthConvertFinishProduct();
                                    Object other$thisMonthConvertFinishProduct = other.getThisMonthConvertFinishProduct();
                                    if (this$thisMonthConvertFinishProduct == null
                                       ? other$thisMonthConvertFinishProduct == null
                                       : this$thisMonthConvertFinishProduct.equals(other$thisMonthConvertFinishProduct)) {
                                       Object this$totalPutPart = this.getTotalPutPart();
                                       Object other$totalPutPart = other.getTotalPutPart();
                                       if (this$totalPutPart == null ? other$totalPutPart == null : this$totalPutPart.equals(other$totalPutPart)) {
                                          Object this$totalFinishProduct = this.getTotalFinishProduct();
                                          Object other$totalFinishProduct = other.getTotalFinishProduct();
                                          if (this$totalFinishProduct == null
                                             ? other$totalFinishProduct == null
                                             : this$totalFinishProduct.equals(other$totalFinishProduct)) {
                                             Object this$thisMonthFinishOutput = this.getThisMonthFinishOutput();
                                             Object other$thisMonthFinishOutput = other.getThisMonthFinishOutput();
                                             if (this$thisMonthFinishOutput == null
                                                ? other$thisMonthFinishOutput == null
                                                : this$thisMonthFinishOutput.equals(other$thisMonthFinishOutput)) {
                                                Object this$workshopName = this.getWorkshopName();
                                                Object other$workshopName = other.getWorkshopName();
                                                if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof FinishedProductWarehousingSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeNumber = this.getTypeNumber();
      result = result * 59 + ($typeNumber == null ? 43 : $typeNumber.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $beginPutPart = this.getBeginPutPart();
      result = result * 59 + ($beginPutPart == null ? 43 : $beginPutPart.hashCode());
      Object $beginFinishProduct = this.getBeginFinishProduct();
      result = result * 59 + ($beginFinishProduct == null ? 43 : $beginFinishProduct.hashCode());
      Object $beginHalfProduct = this.getBeginHalfProduct();
      result = result * 59 + ($beginHalfProduct == null ? 43 : $beginHalfProduct.hashCode());
      Object $beginConvertFinishProduct = this.getBeginConvertFinishProduct();
      result = result * 59 + ($beginConvertFinishProduct == null ? 43 : $beginConvertFinishProduct.hashCode());
      Object $thisMonthPutPart = this.getThisMonthPutPart();
      result = result * 59 + ($thisMonthPutPart == null ? 43 : $thisMonthPutPart.hashCode());
      Object $thisMonthFinishProduct = this.getThisMonthFinishProduct();
      result = result * 59 + ($thisMonthFinishProduct == null ? 43 : $thisMonthFinishProduct.hashCode());
      Object $thisMonthHalfProduct = this.getThisMonthHalfProduct();
      result = result * 59 + ($thisMonthHalfProduct == null ? 43 : $thisMonthHalfProduct.hashCode());
      Object $thisMonthConvertFinishProduct = this.getThisMonthConvertFinishProduct();
      result = result * 59 + ($thisMonthConvertFinishProduct == null ? 43 : $thisMonthConvertFinishProduct.hashCode());
      Object $totalPutPart = this.getTotalPutPart();
      result = result * 59 + ($totalPutPart == null ? 43 : $totalPutPart.hashCode());
      Object $totalFinishProduct = this.getTotalFinishProduct();
      result = result * 59 + ($totalFinishProduct == null ? 43 : $totalFinishProduct.hashCode());
      Object $thisMonthFinishOutput = this.getThisMonthFinishOutput();
      result = result * 59 + ($thisMonthFinishOutput == null ? 43 : $thisMonthFinishOutput.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "FinishedProductWarehousingSummaryDO(typeNumber="
         + this.getTypeNumber()
         + ", structureType="
         + this.getStructureType()
         + ", beginPutPart="
         + this.getBeginPutPart()
         + ", beginFinishProduct="
         + this.getBeginFinishProduct()
         + ", beginHalfProduct="
         + this.getBeginHalfProduct()
         + ", beginConvertFinishProduct="
         + this.getBeginConvertFinishProduct()
         + ", thisMonthPutPart="
         + this.getThisMonthPutPart()
         + ", thisMonthFinishProduct="
         + this.getThisMonthFinishProduct()
         + ", thisMonthHalfProduct="
         + this.getThisMonthHalfProduct()
         + ", thisMonthConvertFinishProduct="
         + this.getThisMonthConvertFinishProduct()
         + ", totalPutPart="
         + this.getTotalPutPart()
         + ", totalFinishProduct="
         + this.getTotalFinishProduct()
         + ", thisMonthFinishOutput="
         + this.getThisMonthFinishOutput()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class FinishedProductWarehousingSummaryDOBuilder {
      private Integer typeNumber;
      private String structureType;
      private BigDecimal beginPutPart;
      private BigDecimal beginFinishProduct;
      private BigDecimal beginHalfProduct;
      private BigDecimal beginConvertFinishProduct;
      private BigDecimal thisMonthPutPart;
      private BigDecimal thisMonthFinishProduct;
      private BigDecimal thisMonthHalfProduct;
      private BigDecimal thisMonthConvertFinishProduct;
      private BigDecimal totalPutPart;
      private BigDecimal totalFinishProduct;
      private BigDecimal thisMonthFinishOutput;
      private Long workshopId;
      private String workshopName;
      private String remark;

      FinishedProductWarehousingSummaryDOBuilder() {
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder typeNumber(final Integer typeNumber) {
         this.typeNumber = typeNumber;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder beginPutPart(final BigDecimal beginPutPart) {
         this.beginPutPart = beginPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder beginFinishProduct(final BigDecimal beginFinishProduct) {
         this.beginFinishProduct = beginFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder beginHalfProduct(final BigDecimal beginHalfProduct) {
         this.beginHalfProduct = beginHalfProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder beginConvertFinishProduct(
         final BigDecimal beginConvertFinishProduct
      ) {
         this.beginConvertFinishProduct = beginConvertFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder thisMonthPutPart(final BigDecimal thisMonthPutPart) {
         this.thisMonthPutPart = thisMonthPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder thisMonthFinishProduct(final BigDecimal thisMonthFinishProduct) {
         this.thisMonthFinishProduct = thisMonthFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder thisMonthHalfProduct(final BigDecimal thisMonthHalfProduct) {
         this.thisMonthHalfProduct = thisMonthHalfProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder thisMonthConvertFinishProduct(
         final BigDecimal thisMonthConvertFinishProduct
      ) {
         this.thisMonthConvertFinishProduct = thisMonthConvertFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder totalPutPart(final BigDecimal totalPutPart) {
         this.totalPutPart = totalPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder totalFinishProduct(final BigDecimal totalFinishProduct) {
         this.totalFinishProduct = totalFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder thisMonthFinishOutput(final BigDecimal thisMonthFinishOutput) {
         this.thisMonthFinishOutput = thisMonthFinishOutput;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public FinishedProductWarehousingSummaryDO build() {
         return new FinishedProductWarehousingSummaryDO(
            this.typeNumber,
            this.structureType,
            this.beginPutPart,
            this.beginFinishProduct,
            this.beginHalfProduct,
            this.beginConvertFinishProduct,
            this.thisMonthPutPart,
            this.thisMonthFinishProduct,
            this.thisMonthHalfProduct,
            this.thisMonthConvertFinishProduct,
            this.totalPutPart,
            this.totalFinishProduct,
            this.thisMonthFinishOutput,
            this.workshopId,
            this.workshopName,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "FinishedProductWarehousingSummaryDO.FinishedProductWarehousingSummaryDOBuilder(typeNumber="
            + this.typeNumber
            + ", structureType="
            + this.structureType
            + ", beginPutPart="
            + this.beginPutPart
            + ", beginFinishProduct="
            + this.beginFinishProduct
            + ", beginHalfProduct="
            + this.beginHalfProduct
            + ", beginConvertFinishProduct="
            + this.beginConvertFinishProduct
            + ", thisMonthPutPart="
            + this.thisMonthPutPart
            + ", thisMonthFinishProduct="
            + this.thisMonthFinishProduct
            + ", thisMonthHalfProduct="
            + this.thisMonthHalfProduct
            + ", thisMonthConvertFinishProduct="
            + this.thisMonthConvertFinishProduct
            + ", totalPutPart="
            + this.totalPutPart
            + ", totalFinishProduct="
            + this.totalFinishProduct
            + ", thisMonthFinishOutput="
            + this.thisMonthFinishOutput
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
