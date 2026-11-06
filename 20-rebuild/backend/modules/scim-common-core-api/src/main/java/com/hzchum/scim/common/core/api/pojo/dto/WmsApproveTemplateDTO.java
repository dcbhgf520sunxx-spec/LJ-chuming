package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WmsApproveTemplateDTO implements Serializable {
   @ApiModelProperty(name = "moduleType", value = "例:1  枚举ModuleTypeEnum", notes = "例:1  枚举ModuleTypeEnum")
   private Integer moduleType;
   @ApiModelProperty(name = "functionType", value = "例:1  枚举FunctionTypeEnum", notes = "例:1  枚举FunctionTypeEnum")
   private Integer functionType;
   @ApiModelProperty(name = "approveProcessType", value = "审批流程类型 ApproveProcessTypeEnumV2", notes = "审批流程类型 ApproveProcessTypeEnumV2ApproveProcessTypeEnumV2")
   private Integer approveProcessType;
   @ApiModelProperty(name = "name", value = "例:新增申购单审核", notes = "例:新增申购单审核")
   private String name;
   @ApiModelProperty(name = "moduleName", value = "业务模块名称", notes = "业务模块名称")
   private String moduleName;
   @ApiModelProperty(name = "sort", value = "排列顺序", notes = "排列顺序")
   private Integer sort;
   @ApiModelProperty(name = "status", value = "状态 false：未启用  true：启用", notes = "状态 false：未启用  true：启用")
   private Boolean status;
   @ApiModelProperty(name = "wmsApproveTemplateVersionsDTOS", value = "模板版本表", notes = "模板版本表")
   private List<WmsApproveTemplateVersionsDTO> wmsApproveTemplateVersionsDTOS;

   public static WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder builder() {
      return new WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder();
   }

   public Integer getModuleType() {
      return this.moduleType;
   }

   public Integer getFunctionType() {
      return this.functionType;
   }

   public Integer getApproveProcessType() {
      return this.approveProcessType;
   }

   public String getName() {
      return this.name;
   }

   public String getModuleName() {
      return this.moduleName;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public List<WmsApproveTemplateVersionsDTO> getWmsApproveTemplateVersionsDTOS() {
      return this.wmsApproveTemplateVersionsDTOS;
   }

   public void setModuleType(final Integer moduleType) {
      this.moduleType = moduleType;
   }

   public void setFunctionType(final Integer functionType) {
      this.functionType = functionType;
   }

   public void setApproveProcessType(final Integer approveProcessType) {
      this.approveProcessType = approveProcessType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setModuleName(final String moduleName) {
      this.moduleName = moduleName;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setWmsApproveTemplateVersionsDTOS(final List<WmsApproveTemplateVersionsDTO> wmsApproveTemplateVersionsDTOS) {
      this.wmsApproveTemplateVersionsDTOS = wmsApproveTemplateVersionsDTOS;
   }

   public WmsApproveTemplateDTO(
      final Integer moduleType,
      final Integer functionType,
      final Integer approveProcessType,
      final String name,
      final String moduleName,
      final Integer sort,
      final Boolean status,
      final List<WmsApproveTemplateVersionsDTO> wmsApproveTemplateVersionsDTOS
   ) {
      this.moduleType = moduleType;
      this.functionType = functionType;
      this.approveProcessType = approveProcessType;
      this.name = name;
      this.moduleName = moduleName;
      this.sort = sort;
      this.status = status;
      this.wmsApproveTemplateVersionsDTOS = wmsApproveTemplateVersionsDTOS;
   }

   public WmsApproveTemplateDTO() {
   }

   public static class WmsApproveTemplateDTOBuilder {
      private Integer moduleType;
      private Integer functionType;
      private Integer approveProcessType;
      private String name;
      private String moduleName;
      private Integer sort;
      private Boolean status;
      private List<WmsApproveTemplateVersionsDTO> wmsApproveTemplateVersionsDTOS;

      WmsApproveTemplateDTOBuilder() {
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder moduleType(final Integer moduleType) {
         this.moduleType = moduleType;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder functionType(final Integer functionType) {
         this.functionType = functionType;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder approveProcessType(final Integer approveProcessType) {
         this.approveProcessType = approveProcessType;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder moduleName(final String moduleName) {
         this.moduleName = moduleName;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder wmsApproveTemplateVersionsDTOS(
         final List<WmsApproveTemplateVersionsDTO> wmsApproveTemplateVersionsDTOS
      ) {
         this.wmsApproveTemplateVersionsDTOS = wmsApproveTemplateVersionsDTOS;
         return this;
      }

      public WmsApproveTemplateDTO build() {
         return new WmsApproveTemplateDTO(
            this.moduleType,
            this.functionType,
            this.approveProcessType,
            this.name,
            this.moduleName,
            this.sort,
            this.status,
            this.wmsApproveTemplateVersionsDTOS
         );
      }

      @Override
      public String toString() {
         return "WmsApproveTemplateDTO.WmsApproveTemplateDTOBuilder(moduleType="
            + this.moduleType
            + ", functionType="
            + this.functionType
            + ", approveProcessType="
            + this.approveProcessType
            + ", name="
            + this.name
            + ", moduleName="
            + this.moduleName
            + ", sort="
            + this.sort
            + ", status="
            + this.status
            + ", wmsApproveTemplateVersionsDTOS="
            + this.wmsApproveTemplateVersionsDTOS
            + ")";
      }
   }
}
