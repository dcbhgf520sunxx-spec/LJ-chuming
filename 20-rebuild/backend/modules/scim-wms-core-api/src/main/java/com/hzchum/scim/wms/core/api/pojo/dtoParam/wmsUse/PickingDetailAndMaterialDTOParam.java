package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class PickingDetailAndMaterialDTOParam {
   private Long pickingDetailId;
   private Long pickingId;
   private Long materialNum;
   private BigDecimal value;

   public static PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder builder() {
      return new PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder();
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getMaterialNum() {
      return this.materialNum;
   }

   public BigDecimal getValue() {
      return this.value;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setMaterialNum(final Long materialNum) {
      this.materialNum = materialNum;
   }

   public void setValue(final BigDecimal value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingDetailAndMaterialDTOParam)) {
         return false;
      }

      PickingDetailAndMaterialDTOParam other = (PickingDetailAndMaterialDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingDetailId = this.getPickingDetailId();
      Object other$pickingDetailId = other.getPickingDetailId();
      if (this$pickingDetailId == null ? other$pickingDetailId == null : this$pickingDetailId.equals(other$pickingDetailId)) {
         Object this$pickingId = this.getPickingId();
         Object other$pickingId = other.getPickingId();
         if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
            Object this$materialNum = this.getMaterialNum();
            Object other$materialNum = other.getMaterialNum();
            if (this$materialNum == null ? other$materialNum == null : this$materialNum.equals(other$materialNum)) {
               Object this$value = this.getValue();
               Object other$value = other.getValue();
               return this$value == null ? other$value == null : this$value.equals(other$value);
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
      return other instanceof PickingDetailAndMaterialDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $materialNum = this.getMaterialNum();
      result = result * 59 + ($materialNum == null ? 43 : $materialNum.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "PickingDetailAndMaterialDTOParam(pickingDetailId="
         + this.getPickingDetailId()
         + ", pickingId="
         + this.getPickingId()
         + ", materialNum="
         + this.getMaterialNum()
         + ", value="
         + this.getValue()
         + ")";
   }

   public PickingDetailAndMaterialDTOParam(final Long pickingDetailId, final Long pickingId, final Long materialNum, final BigDecimal value) {
      this.pickingDetailId = pickingDetailId;
      this.pickingId = pickingId;
      this.materialNum = materialNum;
      this.value = value;
   }

   public PickingDetailAndMaterialDTOParam() {
   }

   public static class PickingDetailAndMaterialDTOParamBuilder {
      private Long pickingDetailId;
      private Long pickingId;
      private Long materialNum;
      private BigDecimal value;

      PickingDetailAndMaterialDTOParamBuilder() {
      }

      public PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder materialNum(final Long materialNum) {
         this.materialNum = materialNum;
         return this;
      }

      public PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder value(final BigDecimal value) {
         this.value = value;
         return this;
      }

      public PickingDetailAndMaterialDTOParam build() {
         return new PickingDetailAndMaterialDTOParam(this.pickingDetailId, this.pickingId, this.materialNum, this.value);
      }

      @Override
      public String toString() {
         return "PickingDetailAndMaterialDTOParam.PickingDetailAndMaterialDTOParamBuilder(pickingDetailId="
            + this.pickingDetailId
            + ", pickingId="
            + this.pickingId
            + ", materialNum="
            + this.materialNum
            + ", value="
            + this.value
            + ")";
      }
   }
}
