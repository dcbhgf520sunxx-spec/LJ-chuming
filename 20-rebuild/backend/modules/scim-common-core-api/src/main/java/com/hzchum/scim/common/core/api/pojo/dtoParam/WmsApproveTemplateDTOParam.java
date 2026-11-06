package com.hzchum.scim.common.core.api.pojo.dtoParam;

import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateDTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsApproveTemplateDTOParam extends WmsApproveTemplateDTO implements Serializable {
   @ApiModelProperty(name = "wmsApproveTemplateVersionsFlowDTOParams", value = "审批模板流程", notes = "审批模板流程")
   private List<WmsApproveTemplateVersionsFlowDTOParam> wmsApproveTemplateVersionsFlowDTOParams;
   @ApiModelProperty(name = "delIds", value = "删除审批流程ID", notes = "删除审批流程ID")
   private List<Long> delFlowIds;

   public WmsApproveTemplateDTOParam(final List<WmsApproveTemplateVersionsFlowDTOParam> wmsApproveTemplateVersionsFlowDTOParams, final List<Long> delFlowIds) {
      this.wmsApproveTemplateVersionsFlowDTOParams = wmsApproveTemplateVersionsFlowDTOParams;
      this.delFlowIds = delFlowIds;
   }

   public WmsApproveTemplateDTOParam() {
   }

   public List<WmsApproveTemplateVersionsFlowDTOParam> getWmsApproveTemplateVersionsFlowDTOParams() {
      return this.wmsApproveTemplateVersionsFlowDTOParams;
   }

   public List<Long> getDelFlowIds() {
      return this.delFlowIds;
   }

   public void setWmsApproveTemplateVersionsFlowDTOParams(final List<WmsApproveTemplateVersionsFlowDTOParam> wmsApproveTemplateVersionsFlowDTOParams) {
      this.wmsApproveTemplateVersionsFlowDTOParams = wmsApproveTemplateVersionsFlowDTOParams;
   }

   public void setDelFlowIds(final List<Long> delFlowIds) {
      this.delFlowIds = delFlowIds;
   }
}
