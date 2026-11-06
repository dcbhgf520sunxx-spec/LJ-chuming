package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SysPushFlowConfigDetailSaveDTOParam", description = "推送保存")
public class SysPushFlowConfigDetailSaveDTOParam {
   @ApiModelProperty(name = "id", notes = "流程id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "流程名称")
   @NotNull(message = "流程名称不能为空")
   private String name;
   @ApiModelProperty(name = "sysPushFlowConfigLinkSaveDTOParam", notes = "流程")
   @NotNull(message = "流程树结构不能为空")
   private SysPushFlowConfigLinkSaveDTOParam sysPushFlowConfigLinkSaveDTOParam;

   public static SysPushFlowConfigDetailSaveDTOParam.SysPushFlowConfigDetailSaveDTOParamBuilder builder() {
      return new SysPushFlowConfigDetailSaveDTOParam.SysPushFlowConfigDetailSaveDTOParamBuilder();
   }

   public SysPushFlowConfigDetailSaveDTOParam() {
   }

   public SysPushFlowConfigDetailSaveDTOParam(final Long id, final String name, final SysPushFlowConfigLinkSaveDTOParam sysPushFlowConfigLinkSaveDTOParam) {
      this.id = id;
      this.name = name;
      this.sysPushFlowConfigLinkSaveDTOParam = sysPushFlowConfigLinkSaveDTOParam;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public SysPushFlowConfigLinkSaveDTOParam getSysPushFlowConfigLinkSaveDTOParam() {
      return this.sysPushFlowConfigLinkSaveDTOParam;
   }

   public SysPushFlowConfigDetailSaveDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushFlowConfigDetailSaveDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   public SysPushFlowConfigDetailSaveDTOParam setSysPushFlowConfigLinkSaveDTOParam(final SysPushFlowConfigLinkSaveDTOParam sysPushFlowConfigLinkSaveDTOParam) {
      this.sysPushFlowConfigLinkSaveDTOParam = sysPushFlowConfigLinkSaveDTOParam;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushFlowConfigDetailSaveDTOParam)) {
         return false;
      }

      SysPushFlowConfigDetailSaveDTOParam other = (SysPushFlowConfigDetailSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$sysPushFlowConfigLinkSaveDTOParam = this.getSysPushFlowConfigLinkSaveDTOParam();
            Object other$sysPushFlowConfigLinkSaveDTOParam = other.getSysPushFlowConfigLinkSaveDTOParam();
            return this$sysPushFlowConfigLinkSaveDTOParam == null
               ? other$sysPushFlowConfigLinkSaveDTOParam == null
               : this$sysPushFlowConfigLinkSaveDTOParam.equals(other$sysPushFlowConfigLinkSaveDTOParam);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysPushFlowConfigDetailSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $sysPushFlowConfigLinkSaveDTOParam = this.getSysPushFlowConfigLinkSaveDTOParam();
      return result * 59 + ($sysPushFlowConfigLinkSaveDTOParam == null ? 43 : $sysPushFlowConfigLinkSaveDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushFlowConfigDetailSaveDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sysPushFlowConfigLinkSaveDTOParam="
         + this.getSysPushFlowConfigLinkSaveDTOParam()
         + ")";
   }

   public static class SysPushFlowConfigDetailSaveDTOParamBuilder {
      private Long id;
      private String name;
      private SysPushFlowConfigLinkSaveDTOParam sysPushFlowConfigLinkSaveDTOParam;

      SysPushFlowConfigDetailSaveDTOParamBuilder() {
      }

      public SysPushFlowConfigDetailSaveDTOParam.SysPushFlowConfigDetailSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushFlowConfigDetailSaveDTOParam.SysPushFlowConfigDetailSaveDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysPushFlowConfigDetailSaveDTOParam.SysPushFlowConfigDetailSaveDTOParamBuilder sysPushFlowConfigLinkSaveDTOParam(
         final SysPushFlowConfigLinkSaveDTOParam sysPushFlowConfigLinkSaveDTOParam
      ) {
         this.sysPushFlowConfigLinkSaveDTOParam = sysPushFlowConfigLinkSaveDTOParam;
         return this;
      }

      public SysPushFlowConfigDetailSaveDTOParam build() {
         return new SysPushFlowConfigDetailSaveDTOParam(this.id, this.name, this.sysPushFlowConfigLinkSaveDTOParam);
      }

      @Override
      public String toString() {
         return "SysPushFlowConfigDetailSaveDTOParam.SysPushFlowConfigDetailSaveDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sysPushFlowConfigLinkSaveDTOParam="
            + this.sysPushFlowConfigLinkSaveDTOParam
            + ")";
      }
   }
}
