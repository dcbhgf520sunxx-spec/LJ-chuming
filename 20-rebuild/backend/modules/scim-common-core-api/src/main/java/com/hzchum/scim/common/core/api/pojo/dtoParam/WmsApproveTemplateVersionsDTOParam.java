package com.hzchum.scim.common.core.api.pojo.dtoParam;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsApproveTemplateVersionsDTOParam extends WmsApproveTemplateVersions implements Serializable {
   @ApiModelProperty(name = "objIdsList", value = "objIdsList", notes = "对象ID集合")
   private List<String> objIdsList;
   @ApiModelProperty(name = "wmsApproveTemplateVersionsFlowDTOParams", value = "审批流程集合", notes = "审批流程集合")
   private List<WmsApproveTemplateVersionsFlowDTOParam> wmsApproveTemplateVersionsFlowDTOParams;
   @ApiModelProperty(name = "mountMessageDTO", value = "挂载信息数据", notes = "挂载信息数据")
   private MountMessageDTO mountMessageDTO;

   public List<String> getObjIdsList() {
      return this.objIdsList;
   }

   public List<WmsApproveTemplateVersionsFlowDTOParam> getWmsApproveTemplateVersionsFlowDTOParams() {
      return this.wmsApproveTemplateVersionsFlowDTOParams;
   }

   public MountMessageDTO getMountMessageDTO() {
      return this.mountMessageDTO;
   }

   public void setObjIdsList(final List<String> objIdsList) {
      this.objIdsList = objIdsList;
   }

   public void setWmsApproveTemplateVersionsFlowDTOParams(final List<WmsApproveTemplateVersionsFlowDTOParam> wmsApproveTemplateVersionsFlowDTOParams) {
      this.wmsApproveTemplateVersionsFlowDTOParams = wmsApproveTemplateVersionsFlowDTOParams;
   }

   public void setMountMessageDTO(final MountMessageDTO mountMessageDTO) {
      this.mountMessageDTO = mountMessageDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveTemplateVersionsDTOParam)) {
         return false;
      }

      WmsApproveTemplateVersionsDTOParam other = (WmsApproveTemplateVersionsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$objIdsList = this.getObjIdsList();
      Object other$objIdsList = other.getObjIdsList();
      if (this$objIdsList == null ? other$objIdsList == null : this$objIdsList.equals(other$objIdsList)) {
         Object this$wmsApproveTemplateVersionsFlowDTOParams = this.getWmsApproveTemplateVersionsFlowDTOParams();
         Object other$wmsApproveTemplateVersionsFlowDTOParams = other.getWmsApproveTemplateVersionsFlowDTOParams();
         if (this$wmsApproveTemplateVersionsFlowDTOParams == null
            ? other$wmsApproveTemplateVersionsFlowDTOParams == null
            : this$wmsApproveTemplateVersionsFlowDTOParams.equals(other$wmsApproveTemplateVersionsFlowDTOParams)) {
            Object this$mountMessageDTO = this.getMountMessageDTO();
            Object other$mountMessageDTO = other.getMountMessageDTO();
            return this$mountMessageDTO == null ? other$mountMessageDTO == null : this$mountMessageDTO.equals(other$mountMessageDTO);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveTemplateVersionsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $objIdsList = this.getObjIdsList();
      result = result * 59 + ($objIdsList == null ? 43 : $objIdsList.hashCode());
      Object $wmsApproveTemplateVersionsFlowDTOParams = this.getWmsApproveTemplateVersionsFlowDTOParams();
      result = result * 59 + ($wmsApproveTemplateVersionsFlowDTOParams == null ? 43 : $wmsApproveTemplateVersionsFlowDTOParams.hashCode());
      Object $mountMessageDTO = this.getMountMessageDTO();
      return result * 59 + ($mountMessageDTO == null ? 43 : $mountMessageDTO.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveTemplateVersionsDTOParam(objIdsList="
         + this.getObjIdsList()
         + ", wmsApproveTemplateVersionsFlowDTOParams="
         + this.getWmsApproveTemplateVersionsFlowDTOParams()
         + ", mountMessageDTO="
         + this.getMountMessageDTO()
         + ")";
   }
}
