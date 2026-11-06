package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.util.List;

public class PickingDetailBriefDTOParam {
   private Long pickingId;
   private Long pickingDetailId;
   private BigDecimal needValue;
   private BigDecimal allotValue;
   private BigDecimal unValue;
   private List<Long> materialNums;
   private Integer status;
   private BigDecimal auditValue;

   public static PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder builder() {
      return new PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder();
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public BigDecimal getNeedValue() {
      return this.needValue;
   }

   public BigDecimal getAllotValue() {
      return this.allotValue;
   }

   public BigDecimal getUnValue() {
      return this.unValue;
   }

   public List<Long> getMaterialNums() {
      return this.materialNums;
   }

   public Integer getStatus() {
      return this.status;
   }

   public BigDecimal getAuditValue() {
      return this.auditValue;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
   }

   public void setNeedValue(final BigDecimal needValue) {
      this.needValue = needValue;
   }

   public void setAllotValue(final BigDecimal allotValue) {
      this.allotValue = allotValue;
   }

   public void setUnValue(final BigDecimal unValue) {
      this.unValue = unValue;
   }

   public void setMaterialNums(final List<Long> materialNums) {
      this.materialNums = materialNums;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setAuditValue(final BigDecimal auditValue) {
      this.auditValue = auditValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingDetailBriefDTOParam)) {
         return false;
      }

      PickingDetailBriefDTOParam other = (PickingDetailBriefDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingId = this.getPickingId();
      Object other$pickingId = other.getPickingId();
      if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
         Object this$pickingDetailId = this.getPickingDetailId();
         Object other$pickingDetailId = other.getPickingDetailId();
         if (this$pickingDetailId == null ? other$pickingDetailId == null : this$pickingDetailId.equals(other$pickingDetailId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$needValue = this.getNeedValue();
               Object other$needValue = other.getNeedValue();
               if (this$needValue == null ? other$needValue == null : this$needValue.equals(other$needValue)) {
                  Object this$allotValue = this.getAllotValue();
                  Object other$allotValue = other.getAllotValue();
                  if (this$allotValue == null ? other$allotValue == null : this$allotValue.equals(other$allotValue)) {
                     Object this$unValue = this.getUnValue();
                     Object other$unValue = other.getUnValue();
                     if (this$unValue == null ? other$unValue == null : this$unValue.equals(other$unValue)) {
                        Object this$materialNums = this.getMaterialNums();
                        Object other$materialNums = other.getMaterialNums();
                        if (this$materialNums == null ? other$materialNums == null : this$materialNums.equals(other$materialNums)) {
                           Object this$auditValue = this.getAuditValue();
                           Object other$auditValue = other.getAuditValue();
                           return this$auditValue == null ? other$auditValue == null : this$auditValue.equals(other$auditValue);
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
      return other instanceof PickingDetailBriefDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $needValue = this.getNeedValue();
      result = result * 59 + ($needValue == null ? 43 : $needValue.hashCode());
      Object $allotValue = this.getAllotValue();
      result = result * 59 + ($allotValue == null ? 43 : $allotValue.hashCode());
      Object $unValue = this.getUnValue();
      result = result * 59 + ($unValue == null ? 43 : $unValue.hashCode());
      Object $materialNums = this.getMaterialNums();
      result = result * 59 + ($materialNums == null ? 43 : $materialNums.hashCode());
      Object $auditValue = this.getAuditValue();
      return result * 59 + ($auditValue == null ? 43 : $auditValue.hashCode());
   }

   @Override
   public String toString() {
      return "PickingDetailBriefDTOParam(pickingId="
         + this.getPickingId()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", needValue="
         + this.getNeedValue()
         + ", allotValue="
         + this.getAllotValue()
         + ", unValue="
         + this.getUnValue()
         + ", materialNums="
         + this.getMaterialNums()
         + ", status="
         + this.getStatus()
         + ", auditValue="
         + this.getAuditValue()
         + ")";
   }

   public PickingDetailBriefDTOParam(
      final Long pickingId,
      final Long pickingDetailId,
      final BigDecimal needValue,
      final BigDecimal allotValue,
      final BigDecimal unValue,
      final List<Long> materialNums,
      final Integer status,
      final BigDecimal auditValue
   ) {
      this.pickingId = pickingId;
      this.pickingDetailId = pickingDetailId;
      this.needValue = needValue;
      this.allotValue = allotValue;
      this.unValue = unValue;
      this.materialNums = materialNums;
      this.status = status;
      this.auditValue = auditValue;
   }

   public PickingDetailBriefDTOParam() {
   }

   public static class PickingDetailBriefDTOParamBuilder {
      private Long pickingId;
      private Long pickingDetailId;
      private BigDecimal needValue;
      private BigDecimal allotValue;
      private BigDecimal unValue;
      private List<Long> materialNums;
      private Integer status;
      private BigDecimal auditValue;

      PickingDetailBriefDTOParamBuilder() {
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder needValue(final BigDecimal needValue) {
         this.needValue = needValue;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder allotValue(final BigDecimal allotValue) {
         this.allotValue = allotValue;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder unValue(final BigDecimal unValue) {
         this.unValue = unValue;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder materialNums(final List<Long> materialNums) {
         this.materialNums = materialNums;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder auditValue(final BigDecimal auditValue) {
         this.auditValue = auditValue;
         return this;
      }

      public PickingDetailBriefDTOParam build() {
         return new PickingDetailBriefDTOParam(
            this.pickingId, this.pickingDetailId, this.needValue, this.allotValue, this.unValue, this.materialNums, this.status, this.auditValue
         );
      }

      @Override
      public String toString() {
         return "PickingDetailBriefDTOParam.PickingDetailBriefDTOParamBuilder(pickingId="
            + this.pickingId
            + ", pickingDetailId="
            + this.pickingDetailId
            + ", needValue="
            + this.needValue
            + ", allotValue="
            + this.allotValue
            + ", unValue="
            + this.unValue
            + ", materialNums="
            + this.materialNums
            + ", status="
            + this.status
            + ", auditValue="
            + this.auditValue
            + ")";
      }
   }
}
