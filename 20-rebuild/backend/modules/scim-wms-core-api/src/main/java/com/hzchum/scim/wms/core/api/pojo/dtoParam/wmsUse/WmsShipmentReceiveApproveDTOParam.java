package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class WmsShipmentReceiveApproveDTOParam {
   private Long projectId;
   private String remark;
   private List<WmsShipmentReceiveApproveDetailDTOParam> wmsShipmentReceiveApproveDetailDTOParamList;

   WmsShipmentReceiveApproveDTOParam(
      final Long projectId, final String remark, final List<WmsShipmentReceiveApproveDetailDTOParam> wmsShipmentReceiveApproveDetailDTOParamList
   ) {
      this.projectId = projectId;
      this.remark = remark;
      this.wmsShipmentReceiveApproveDetailDTOParamList = wmsShipmentReceiveApproveDetailDTOParamList;
   }

   public static WmsShipmentReceiveApproveDTOParam.WmsShipmentReceiveApproveDTOParamBuilder builder() {
      return new WmsShipmentReceiveApproveDTOParam.WmsShipmentReceiveApproveDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<WmsShipmentReceiveApproveDetailDTOParam> getWmsShipmentReceiveApproveDetailDTOParamList() {
      return this.wmsShipmentReceiveApproveDetailDTOParamList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setWmsShipmentReceiveApproveDetailDTOParamList(final List<WmsShipmentReceiveApproveDetailDTOParam> wmsShipmentReceiveApproveDetailDTOParamList) {
      this.wmsShipmentReceiveApproveDetailDTOParamList = wmsShipmentReceiveApproveDetailDTOParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsShipmentReceiveApproveDTOParam)) {
         return false;
      }

      WmsShipmentReceiveApproveDTOParam other = (WmsShipmentReceiveApproveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$wmsShipmentReceiveApproveDetailDTOParamList = this.getWmsShipmentReceiveApproveDetailDTOParamList();
            Object other$wmsShipmentReceiveApproveDetailDTOParamList = other.getWmsShipmentReceiveApproveDetailDTOParamList();
            return this$wmsShipmentReceiveApproveDetailDTOParamList == null
               ? other$wmsShipmentReceiveApproveDetailDTOParamList == null
               : this$wmsShipmentReceiveApproveDetailDTOParamList.equals(other$wmsShipmentReceiveApproveDetailDTOParamList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsShipmentReceiveApproveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $wmsShipmentReceiveApproveDetailDTOParamList = this.getWmsShipmentReceiveApproveDetailDTOParamList();
      return result * 59 + ($wmsShipmentReceiveApproveDetailDTOParamList == null ? 43 : $wmsShipmentReceiveApproveDetailDTOParamList.hashCode());
   }

   @Override
   public String toString() {
      return "WmsShipmentReceiveApproveDTOParam(projectId="
         + this.getProjectId()
         + ", remark="
         + this.getRemark()
         + ", wmsShipmentReceiveApproveDetailDTOParamList="
         + this.getWmsShipmentReceiveApproveDetailDTOParamList()
         + ")";
   }

   public static class WmsShipmentReceiveApproveDTOParamBuilder {
      private Long projectId;
      private String remark;
      private List<WmsShipmentReceiveApproveDetailDTOParam> wmsShipmentReceiveApproveDetailDTOParamList;

      WmsShipmentReceiveApproveDTOParamBuilder() {
      }

      public WmsShipmentReceiveApproveDTOParam.WmsShipmentReceiveApproveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsShipmentReceiveApproveDTOParam.WmsShipmentReceiveApproveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsShipmentReceiveApproveDTOParam.WmsShipmentReceiveApproveDTOParamBuilder wmsShipmentReceiveApproveDetailDTOParamList(
         final List<WmsShipmentReceiveApproveDetailDTOParam> wmsShipmentReceiveApproveDetailDTOParamList
      ) {
         this.wmsShipmentReceiveApproveDetailDTOParamList = wmsShipmentReceiveApproveDetailDTOParamList;
         return this;
      }

      public WmsShipmentReceiveApproveDTOParam build() {
         return new WmsShipmentReceiveApproveDTOParam(this.projectId, this.remark, this.wmsShipmentReceiveApproveDetailDTOParamList);
      }

      @Override
      public String toString() {
         return "WmsShipmentReceiveApproveDTOParam.WmsShipmentReceiveApproveDTOParamBuilder(projectId="
            + this.projectId
            + ", remark="
            + this.remark
            + ", wmsShipmentReceiveApproveDetailDTOParamList="
            + this.wmsShipmentReceiveApproveDetailDTOParamList
            + ")";
      }
   }
}
