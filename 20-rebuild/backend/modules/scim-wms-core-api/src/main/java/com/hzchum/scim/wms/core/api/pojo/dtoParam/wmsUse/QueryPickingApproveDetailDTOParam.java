package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.util.List;

public class QueryPickingApproveDetailDTOParam {
   private Long pickingId;
   private List<Long> pickingIds;
   private Long taskOrderId;
   private String material;
   private BigDecimal thickness;
   private String specification;
   private Boolean boolProcess;
   private Integer transactStatus;

   public static QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder builder() {
      return new QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder();
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public List<Long> getPickingIds() {
      return this.pickingIds;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Integer getTransactStatus() {
      return this.transactStatus;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setPickingIds(final List<Long> pickingIds) {
      this.pickingIds = pickingIds;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setTransactStatus(final Integer transactStatus) {
      this.transactStatus = transactStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryPickingApproveDetailDTOParam)) {
         return false;
      }

      QueryPickingApproveDetailDTOParam other = (QueryPickingApproveDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingId = this.getPickingId();
      Object other$pickingId = other.getPickingId();
      if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$boolProcess = this.getBoolProcess();
            Object other$boolProcess = other.getBoolProcess();
            if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
               Object this$transactStatus = this.getTransactStatus();
               Object other$transactStatus = other.getTransactStatus();
               if (this$transactStatus == null ? other$transactStatus == null : this$transactStatus.equals(other$transactStatus)) {
                  Object this$pickingIds = this.getPickingIds();
                  Object other$pickingIds = other.getPickingIds();
                  if (this$pickingIds == null ? other$pickingIds == null : this$pickingIds.equals(other$pickingIds)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
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
      return other instanceof QueryPickingApproveDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $transactStatus = this.getTransactStatus();
      result = result * 59 + ($transactStatus == null ? 43 : $transactStatus.hashCode());
      Object $pickingIds = this.getPickingIds();
      result = result * 59 + ($pickingIds == null ? 43 : $pickingIds.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "QueryPickingApproveDetailDTOParam(pickingId="
         + this.getPickingId()
         + ", pickingIds="
         + this.getPickingIds()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", specification="
         + this.getSpecification()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", transactStatus="
         + this.getTransactStatus()
         + ")";
   }

   public QueryPickingApproveDetailDTOParam(
      final Long pickingId,
      final List<Long> pickingIds,
      final Long taskOrderId,
      final String material,
      final BigDecimal thickness,
      final String specification,
      final Boolean boolProcess,
      final Integer transactStatus
   ) {
      this.pickingId = pickingId;
      this.pickingIds = pickingIds;
      this.taskOrderId = taskOrderId;
      this.material = material;
      this.thickness = thickness;
      this.specification = specification;
      this.boolProcess = boolProcess;
      this.transactStatus = transactStatus;
   }

   public QueryPickingApproveDetailDTOParam() {
   }

   public static class QueryPickingApproveDetailDTOParamBuilder {
      private Long pickingId;
      private List<Long> pickingIds;
      private Long taskOrderId;
      private String material;
      private BigDecimal thickness;
      private String specification;
      private Boolean boolProcess;
      private Integer transactStatus;

      QueryPickingApproveDetailDTOParamBuilder() {
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder pickingIds(final List<Long> pickingIds) {
         this.pickingIds = pickingIds;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder transactStatus(final Integer transactStatus) {
         this.transactStatus = transactStatus;
         return this;
      }

      public QueryPickingApproveDetailDTOParam build() {
         return new QueryPickingApproveDetailDTOParam(
            this.pickingId, this.pickingIds, this.taskOrderId, this.material, this.thickness, this.specification, this.boolProcess, this.transactStatus
         );
      }

      @Override
      public String toString() {
         return "QueryPickingApproveDetailDTOParam.QueryPickingApproveDetailDTOParamBuilder(pickingId="
            + this.pickingId
            + ", pickingIds="
            + this.pickingIds
            + ", taskOrderId="
            + this.taskOrderId
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", specification="
            + this.specification
            + ", boolProcess="
            + this.boolProcess
            + ", transactStatus="
            + this.transactStatus
            + ")";
      }
   }
}
