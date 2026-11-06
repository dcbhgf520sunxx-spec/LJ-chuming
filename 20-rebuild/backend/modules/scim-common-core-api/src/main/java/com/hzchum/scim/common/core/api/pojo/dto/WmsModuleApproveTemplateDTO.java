package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WmsModuleApproveTemplateDTO implements Serializable {
   @ApiModelProperty(name = "functionType", value = "功能流程类型", notes = "功能流程类型")
   private Integer functionType;
   @ApiModelProperty(name = "approveProcessType", value = "审批流程类型", notes = "审批流程类型")
   private Integer approveProcessType;
   @ApiModelProperty(name = "approveProcessName", value = "approveProcessName类型", notes = "approveProcessName类型")
   private String approveProcessName;

   public Integer getFunctionType() {
      return this.functionType;
   }

   public Integer getApproveProcessType() {
      return this.approveProcessType;
   }

   public String getApproveProcessName() {
      return this.approveProcessName;
   }

   public void setFunctionType(final Integer functionType) {
      this.functionType = functionType;
   }

   public void setApproveProcessType(final Integer approveProcessType) {
      this.approveProcessType = approveProcessType;
   }

   public void setApproveProcessName(final String approveProcessName) {
      this.approveProcessName = approveProcessName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsModuleApproveTemplateDTO)) {
         return false;
      }

      WmsModuleApproveTemplateDTO other = (WmsModuleApproveTemplateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$functionType = this.getFunctionType();
      Object other$functionType = other.getFunctionType();
      if (this$functionType == null ? other$functionType == null : this$functionType.equals(other$functionType)) {
         Object this$approveProcessType = this.getApproveProcessType();
         Object other$approveProcessType = other.getApproveProcessType();
         if (this$approveProcessType == null ? other$approveProcessType == null : this$approveProcessType.equals(other$approveProcessType)) {
            Object this$approveProcessName = this.getApproveProcessName();
            Object other$approveProcessName = other.getApproveProcessName();
            return this$approveProcessName == null ? other$approveProcessName == null : this$approveProcessName.equals(other$approveProcessName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsModuleApproveTemplateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $functionType = this.getFunctionType();
      result = result * 59 + ($functionType == null ? 43 : $functionType.hashCode());
      Object $approveProcessType = this.getApproveProcessType();
      result = result * 59 + ($approveProcessType == null ? 43 : $approveProcessType.hashCode());
      Object $approveProcessName = this.getApproveProcessName();
      return result * 59 + ($approveProcessName == null ? 43 : $approveProcessName.hashCode());
   }

   @Override
   public String toString() {
      return "WmsModuleApproveTemplateDTO(functionType="
         + this.getFunctionType()
         + ", approveProcessType="
         + this.getApproveProcessType()
         + ", approveProcessName="
         + this.getApproveProcessName()
         + ")";
   }
}
