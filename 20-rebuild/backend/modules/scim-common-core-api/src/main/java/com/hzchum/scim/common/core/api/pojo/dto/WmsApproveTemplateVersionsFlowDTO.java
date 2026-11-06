package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersionsFlow;
import com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsApproveTemplateVersionsFlowDTO extends WmsApproveTemplateVersionsFlow implements Serializable {
   @ApiModelProperty(name = "userSimpleResponseVOS", value = "用戶信息集合", notes = "用戶信息集合")
   private List<UserSimpleResponseVO> userSimpleResponseVOS;
   @ApiModelProperty(name = "wmsApproveRecordDetailDTOS", value = "审批日志信息", notes = "审批日志信息")
   private List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS;
   @ApiModelProperty(name = "wmsApproveFlowOperationDTOS", value = "审批流程操作", notes = "审批流程操作")
   private List<WmsApproveFlowOperationDTO> wmsApproveFlowOperationDTOS;

   public List<UserSimpleResponseVO> getUserSimpleResponseVOS() {
      return this.userSimpleResponseVOS;
   }

   public List<WmsApproveRecordDetailDTO> getWmsApproveRecordDetailDTOS() {
      return this.wmsApproveRecordDetailDTOS;
   }

   public List<WmsApproveFlowOperationDTO> getWmsApproveFlowOperationDTOS() {
      return this.wmsApproveFlowOperationDTOS;
   }

   public void setUserSimpleResponseVOS(final List<UserSimpleResponseVO> userSimpleResponseVOS) {
      this.userSimpleResponseVOS = userSimpleResponseVOS;
   }

   public void setWmsApproveRecordDetailDTOS(final List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS) {
      this.wmsApproveRecordDetailDTOS = wmsApproveRecordDetailDTOS;
   }

   public void setWmsApproveFlowOperationDTOS(final List<WmsApproveFlowOperationDTO> wmsApproveFlowOperationDTOS) {
      this.wmsApproveFlowOperationDTOS = wmsApproveFlowOperationDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveTemplateVersionsFlowDTO)) {
         return false;
      }

      WmsApproveTemplateVersionsFlowDTO other = (WmsApproveTemplateVersionsFlowDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userSimpleResponseVOS = this.getUserSimpleResponseVOS();
      Object other$userSimpleResponseVOS = other.getUserSimpleResponseVOS();
      if (this$userSimpleResponseVOS == null ? other$userSimpleResponseVOS == null : this$userSimpleResponseVOS.equals(other$userSimpleResponseVOS)) {
         Object this$wmsApproveRecordDetailDTOS = this.getWmsApproveRecordDetailDTOS();
         Object other$wmsApproveRecordDetailDTOS = other.getWmsApproveRecordDetailDTOS();
         if (this$wmsApproveRecordDetailDTOS == null
            ? other$wmsApproveRecordDetailDTOS == null
            : this$wmsApproveRecordDetailDTOS.equals(other$wmsApproveRecordDetailDTOS)) {
            Object this$wmsApproveFlowOperationDTOS = this.getWmsApproveFlowOperationDTOS();
            Object other$wmsApproveFlowOperationDTOS = other.getWmsApproveFlowOperationDTOS();
            return this$wmsApproveFlowOperationDTOS == null
               ? other$wmsApproveFlowOperationDTOS == null
               : this$wmsApproveFlowOperationDTOS.equals(other$wmsApproveFlowOperationDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveTemplateVersionsFlowDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userSimpleResponseVOS = this.getUserSimpleResponseVOS();
      result = result * 59 + ($userSimpleResponseVOS == null ? 43 : $userSimpleResponseVOS.hashCode());
      Object $wmsApproveRecordDetailDTOS = this.getWmsApproveRecordDetailDTOS();
      result = result * 59 + ($wmsApproveRecordDetailDTOS == null ? 43 : $wmsApproveRecordDetailDTOS.hashCode());
      Object $wmsApproveFlowOperationDTOS = this.getWmsApproveFlowOperationDTOS();
      return result * 59 + ($wmsApproveFlowOperationDTOS == null ? 43 : $wmsApproveFlowOperationDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveTemplateVersionsFlowDTO(userSimpleResponseVOS="
         + this.getUserSimpleResponseVOS()
         + ", wmsApproveRecordDetailDTOS="
         + this.getWmsApproveRecordDetailDTOS()
         + ", wmsApproveFlowOperationDTOS="
         + this.getWmsApproveFlowOperationDTOS()
         + ")";
   }
}
