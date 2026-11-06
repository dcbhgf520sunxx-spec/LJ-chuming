package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.util.List;

public class MaterialBriefDTOParam {
   private Long materialNum;
   private Long materialId;
   private BigDecimal mete;
   private BigDecimal area;
   private BigDecimal length;
   private List<Long> pickingDetailIds;
   private BigDecimal residueValue;
   private Boolean boolPartA;

   public static MaterialBriefDTOParam.MaterialBriefDTOParamBuilder builder() {
      return new MaterialBriefDTOParam.MaterialBriefDTOParamBuilder();
   }

   public Long getMaterialNum() {
      return this.materialNum;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public List<Long> getPickingDetailIds() {
      return this.pickingDetailIds;
   }

   public BigDecimal getResidueValue() {
      return this.residueValue;
   }

   public Boolean getBoolPartA() {
      return this.boolPartA;
   }

   public void setMaterialNum(final Long materialNum) {
      this.materialNum = materialNum;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setPickingDetailIds(final List<Long> pickingDetailIds) {
      this.pickingDetailIds = pickingDetailIds;
   }

   public void setResidueValue(final BigDecimal residueValue) {
      this.residueValue = residueValue;
   }

   public void setBoolPartA(final Boolean boolPartA) {
      this.boolPartA = boolPartA;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialBriefDTOParam)) {
         return false;
      }

      MaterialBriefDTOParam other = (MaterialBriefDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialNum = this.getMaterialNum();
      Object other$materialNum = other.getMaterialNum();
      if (this$materialNum == null ? other$materialNum == null : this$materialNum.equals(other$materialNum)) {
         Object this$materialId = this.getMaterialId();
         Object other$materialId = other.getMaterialId();
         if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
            Object this$boolPartA = this.getBoolPartA();
            Object other$boolPartA = other.getBoolPartA();
            if (this$boolPartA == null ? other$boolPartA == null : this$boolPartA.equals(other$boolPartA)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$pickingDetailIds = this.getPickingDetailIds();
                        Object other$pickingDetailIds = other.getPickingDetailIds();
                        if (this$pickingDetailIds == null ? other$pickingDetailIds == null : this$pickingDetailIds.equals(other$pickingDetailIds)) {
                           Object this$residueValue = this.getResidueValue();
                           Object other$residueValue = other.getResidueValue();
                           return this$residueValue == null ? other$residueValue == null : this$residueValue.equals(other$residueValue);
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
      return other instanceof MaterialBriefDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialNum = this.getMaterialNum();
      result = result * 59 + ($materialNum == null ? 43 : $materialNum.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $boolPartA = this.getBoolPartA();
      result = result * 59 + ($boolPartA == null ? 43 : $boolPartA.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $pickingDetailIds = this.getPickingDetailIds();
      result = result * 59 + ($pickingDetailIds == null ? 43 : $pickingDetailIds.hashCode());
      Object $residueValue = this.getResidueValue();
      return result * 59 + ($residueValue == null ? 43 : $residueValue.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialBriefDTOParam(materialNum="
         + this.getMaterialNum()
         + ", materialId="
         + this.getMaterialId()
         + ", mete="
         + this.getMete()
         + ", area="
         + this.getArea()
         + ", length="
         + this.getLength()
         + ", pickingDetailIds="
         + this.getPickingDetailIds()
         + ", residueValue="
         + this.getResidueValue()
         + ", boolPartA="
         + this.getBoolPartA()
         + ")";
   }

   public MaterialBriefDTOParam(
      final Long materialNum,
      final Long materialId,
      final BigDecimal mete,
      final BigDecimal area,
      final BigDecimal length,
      final List<Long> pickingDetailIds,
      final BigDecimal residueValue,
      final Boolean boolPartA
   ) {
      this.materialNum = materialNum;
      this.materialId = materialId;
      this.mete = mete;
      this.area = area;
      this.length = length;
      this.pickingDetailIds = pickingDetailIds;
      this.residueValue = residueValue;
      this.boolPartA = boolPartA;
   }

   public MaterialBriefDTOParam() {
   }

   public static class MaterialBriefDTOParamBuilder {
      private Long materialNum;
      private Long materialId;
      private BigDecimal mete;
      private BigDecimal area;
      private BigDecimal length;
      private List<Long> pickingDetailIds;
      private BigDecimal residueValue;
      private Boolean boolPartA;

      MaterialBriefDTOParamBuilder() {
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder materialNum(final Long materialNum) {
         this.materialNum = materialNum;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder pickingDetailIds(final List<Long> pickingDetailIds) {
         this.pickingDetailIds = pickingDetailIds;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder residueValue(final BigDecimal residueValue) {
         this.residueValue = residueValue;
         return this;
      }

      public MaterialBriefDTOParam.MaterialBriefDTOParamBuilder boolPartA(final Boolean boolPartA) {
         this.boolPartA = boolPartA;
         return this;
      }

      public MaterialBriefDTOParam build() {
         return new MaterialBriefDTOParam(
            this.materialNum, this.materialId, this.mete, this.area, this.length, this.pickingDetailIds, this.residueValue, this.boolPartA
         );
      }

      @Override
      public String toString() {
         return "MaterialBriefDTOParam.MaterialBriefDTOParamBuilder(materialNum="
            + this.materialNum
            + ", materialId="
            + this.materialId
            + ", mete="
            + this.mete
            + ", area="
            + this.area
            + ", length="
            + this.length
            + ", pickingDetailIds="
            + this.pickingDetailIds
            + ", residueValue="
            + this.residueValue
            + ", boolPartA="
            + this.boolPartA
            + ")";
      }
   }
}
