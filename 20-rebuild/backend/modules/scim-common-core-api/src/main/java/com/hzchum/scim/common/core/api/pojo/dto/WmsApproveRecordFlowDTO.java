package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsApproveRecordFlowDTO implements Serializable {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty("属于什么操作 - 新增 - 作废 - 撤销")
   private String name;
   @ApiModelProperty("审批流程简单信息")
   private List<WmsApproveFlowDTO> wmsApproveFlowDTOS;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<WmsApproveFlowDTO> getWmsApproveFlowDTOS() {
      return this.wmsApproveFlowDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWmsApproveFlowDTOS(final List<WmsApproveFlowDTO> wmsApproveFlowDTOS) {
      this.wmsApproveFlowDTOS = wmsApproveFlowDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveRecordFlowDTO)) {
         return false;
      }

      WmsApproveRecordFlowDTO other = (WmsApproveRecordFlowDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$wmsApproveFlowDTOS = this.getWmsApproveFlowDTOS();
            Object other$wmsApproveFlowDTOS = other.getWmsApproveFlowDTOS();
            return this$wmsApproveFlowDTOS == null ? other$wmsApproveFlowDTOS == null : this$wmsApproveFlowDTOS.equals(other$wmsApproveFlowDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveRecordFlowDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $wmsApproveFlowDTOS = this.getWmsApproveFlowDTOS();
      return result * 59 + ($wmsApproveFlowDTOS == null ? 43 : $wmsApproveFlowDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveRecordFlowDTO(id=" + this.getId() + ", name=" + this.getName() + ", wmsApproveFlowDTOS=" + this.getWmsApproveFlowDTOS() + ")";
   }
}
