package com.hzchum.scim.common.core.api.pojo.dtoParam;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersionsFlow;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsApproveTemplateVersionsFlowDTOParam extends WmsApproveTemplateVersionsFlow implements Serializable {
   @ApiModelProperty(name = "userIds", value = "审批人员集合", notes = "审批人员集合")
   private List<String> userIdsList;
   @ApiModelProperty(name = "wmsApproveFlowOperationDTOParam", value = "审批流程操作类", notes = "审批流程操作类")
   private List<WmsApproveFlowOperationDTOParam> wmsApproveFlowOperationDTOParams;

   public List<String> getUserIdsList() {
      return this.userIdsList;
   }

   public List<WmsApproveFlowOperationDTOParam> getWmsApproveFlowOperationDTOParams() {
      return this.wmsApproveFlowOperationDTOParams;
   }

   public void setUserIdsList(final List<String> userIdsList) {
      this.userIdsList = userIdsList;
   }

   public void setWmsApproveFlowOperationDTOParams(final List<WmsApproveFlowOperationDTOParam> wmsApproveFlowOperationDTOParams) {
      this.wmsApproveFlowOperationDTOParams = wmsApproveFlowOperationDTOParams;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WmsApproveTemplateVersionsFlowDTOParam)) {
         return false;
      } else {
         WmsApproveTemplateVersionsFlowDTOParam other = (WmsApproveTemplateVersionsFlowDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userIdsList = this.getUserIdsList();
            Object other$userIdsList = other.getUserIdsList();
            if (this$userIdsList == null ? other$userIdsList == null : this$userIdsList.equals(other$userIdsList)) {
               Object this$wmsApproveFlowOperationDTOParams = this.getWmsApproveFlowOperationDTOParams();
               Object other$wmsApproveFlowOperationDTOParams = other.getWmsApproveFlowOperationDTOParams();
               return this$wmsApproveFlowOperationDTOParams == null
                  ? other$wmsApproveFlowOperationDTOParams == null
                  : this$wmsApproveFlowOperationDTOParams.equals(other$wmsApproveFlowOperationDTOParams);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveTemplateVersionsFlowDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userIdsList = this.getUserIdsList();
      result = result * 59 + ($userIdsList == null ? 43 : $userIdsList.hashCode());
      Object $wmsApproveFlowOperationDTOParams = this.getWmsApproveFlowOperationDTOParams();
      return result * 59 + ($wmsApproveFlowOperationDTOParams == null ? 43 : $wmsApproveFlowOperationDTOParams.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveTemplateVersionsFlowDTOParam(userIdsList="
         + this.getUserIdsList()
         + ", wmsApproveFlowOperationDTOParams="
         + this.getWmsApproveFlowOperationDTOParams()
         + ")";
   }
}
