package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class BatchTransferDTOParam {
   private Long workshopId;
   private Long projectId;
   private Long warehouseId;
   private Integer transferType;
   private List<BatchOutboundDetailDTOParam> list;

   public static BatchTransferDTOParam.BatchTransferDTOParamBuilder builder() {
      return new BatchTransferDTOParam.BatchTransferDTOParamBuilder();
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public List<BatchOutboundDetailDTOParam> getList() {
      return this.list;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setList(final List<BatchOutboundDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchTransferDTOParam)) {
         return false;
      }

      BatchTransferDTOParam other = (BatchTransferDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$transferType = this.getTransferType();
               Object other$transferType = other.getTransferType();
               if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                  Object this$list = this.getList();
                  Object other$list = other.getList();
                  return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof BatchTransferDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "BatchTransferDTOParam(workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", transferType="
         + this.getTransferType()
         + ", list="
         + this.getList()
         + ")";
   }

   public BatchTransferDTOParam(
      final Long workshopId, final Long projectId, final Long warehouseId, final Integer transferType, final List<BatchOutboundDetailDTOParam> list
   ) {
      this.workshopId = workshopId;
      this.projectId = projectId;
      this.warehouseId = warehouseId;
      this.transferType = transferType;
      this.list = list;
   }

   public BatchTransferDTOParam() {
   }

   public static class BatchTransferDTOParamBuilder {
      private Long workshopId;
      private Long projectId;
      private Long warehouseId;
      private Integer transferType;
      private List<BatchOutboundDetailDTOParam> list;

      BatchTransferDTOParamBuilder() {
      }

      public BatchTransferDTOParam.BatchTransferDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public BatchTransferDTOParam.BatchTransferDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BatchTransferDTOParam.BatchTransferDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public BatchTransferDTOParam.BatchTransferDTOParamBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public BatchTransferDTOParam.BatchTransferDTOParamBuilder list(final List<BatchOutboundDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public BatchTransferDTOParam build() {
         return new BatchTransferDTOParam(this.workshopId, this.projectId, this.warehouseId, this.transferType, this.list);
      }

      @Override
      public String toString() {
         return "BatchTransferDTOParam.BatchTransferDTOParamBuilder(workshopId="
            + this.workshopId
            + ", projectId="
            + this.projectId
            + ", warehouseId="
            + this.warehouseId
            + ", transferType="
            + this.transferType
            + ", list="
            + this.list
            + ")";
      }
   }
}
