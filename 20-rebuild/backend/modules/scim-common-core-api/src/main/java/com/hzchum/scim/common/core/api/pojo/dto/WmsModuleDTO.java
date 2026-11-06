package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsModuleDTO implements Serializable {
   @ApiModelProperty(name = "moduleType", value = "moduleType类型", notes = "moduleType类型 模块类型")
   private Integer moduleType;
   @ApiModelProperty(name = "moduleTypeName", value = "moduleTypeName模块类型名称", notes = "moduleTypeName模块类型名称")
   private String moduleTypeName;
   private List<WmsModuleApproveTemplateDTO> wmsModuleApproveTemplateDTOS;

   public Integer getModuleType() {
      return this.moduleType;
   }

   public String getModuleTypeName() {
      return this.moduleTypeName;
   }

   public List<WmsModuleApproveTemplateDTO> getWmsModuleApproveTemplateDTOS() {
      return this.wmsModuleApproveTemplateDTOS;
   }

   public void setModuleType(final Integer moduleType) {
      this.moduleType = moduleType;
   }

   public void setModuleTypeName(final String moduleTypeName) {
      this.moduleTypeName = moduleTypeName;
   }

   public void setWmsModuleApproveTemplateDTOS(final List<WmsModuleApproveTemplateDTO> wmsModuleApproveTemplateDTOS) {
      this.wmsModuleApproveTemplateDTOS = wmsModuleApproveTemplateDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsModuleDTO)) {
         return false;
      }

      WmsModuleDTO other = (WmsModuleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$moduleType = this.getModuleType();
      Object other$moduleType = other.getModuleType();
      if (this$moduleType == null ? other$moduleType == null : this$moduleType.equals(other$moduleType)) {
         Object this$moduleTypeName = this.getModuleTypeName();
         Object other$moduleTypeName = other.getModuleTypeName();
         if (this$moduleTypeName == null ? other$moduleTypeName == null : this$moduleTypeName.equals(other$moduleTypeName)) {
            Object this$wmsModuleApproveTemplateDTOS = this.getWmsModuleApproveTemplateDTOS();
            Object other$wmsModuleApproveTemplateDTOS = other.getWmsModuleApproveTemplateDTOS();
            return this$wmsModuleApproveTemplateDTOS == null
               ? other$wmsModuleApproveTemplateDTOS == null
               : this$wmsModuleApproveTemplateDTOS.equals(other$wmsModuleApproveTemplateDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsModuleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $moduleType = this.getModuleType();
      result = result * 59 + ($moduleType == null ? 43 : $moduleType.hashCode());
      Object $moduleTypeName = this.getModuleTypeName();
      result = result * 59 + ($moduleTypeName == null ? 43 : $moduleTypeName.hashCode());
      Object $wmsModuleApproveTemplateDTOS = this.getWmsModuleApproveTemplateDTOS();
      return result * 59 + ($wmsModuleApproveTemplateDTOS == null ? 43 : $wmsModuleApproveTemplateDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "WmsModuleDTO(moduleType="
         + this.getModuleType()
         + ", moduleTypeName="
         + this.getModuleTypeName()
         + ", wmsModuleApproveTemplateDTOS="
         + this.getWmsModuleApproveTemplateDTOS()
         + ")";
   }
}
