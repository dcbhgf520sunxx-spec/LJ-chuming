package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SysPushFlowConfigLinkSaveDTOParam", description = "推送记录")
public class SysPushFlowConfigLinkSaveDTOParam {
   @ApiModelProperty(name = "notificationType", notes = "业务类型")
   @NotNull
   private Integer notificationType;
   @ApiModelProperty(name = "children", notes = "流程配置")
   List<SysPushFlowConfigLinkSaveDTOParam> children;

   public static SysPushFlowConfigLinkSaveDTOParam.SysPushFlowConfigLinkSaveDTOParamBuilder builder() {
      return new SysPushFlowConfigLinkSaveDTOParam.SysPushFlowConfigLinkSaveDTOParamBuilder();
   }

   public SysPushFlowConfigLinkSaveDTOParam() {
   }

   public SysPushFlowConfigLinkSaveDTOParam(final Integer notificationType, final List<SysPushFlowConfigLinkSaveDTOParam> children) {
      this.notificationType = notificationType;
      this.children = children;
   }

   public Integer getNotificationType() {
      return this.notificationType;
   }

   public List<SysPushFlowConfigLinkSaveDTOParam> getChildren() {
      return this.children;
   }

   public SysPushFlowConfigLinkSaveDTOParam setNotificationType(final Integer notificationType) {
      this.notificationType = notificationType;
      return this;
   }

   public SysPushFlowConfigLinkSaveDTOParam setChildren(final List<SysPushFlowConfigLinkSaveDTOParam> children) {
      this.children = children;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysPushFlowConfigLinkSaveDTOParam)) {
         return false;
      } else {
         SysPushFlowConfigLinkSaveDTOParam other = (SysPushFlowConfigLinkSaveDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$notificationType = this.getNotificationType();
            Object other$notificationType = other.getNotificationType();
            if (this$notificationType == null ? other$notificationType == null : this$notificationType.equals(other$notificationType)) {
               Object this$children = this.getChildren();
               Object other$children = other.getChildren();
               return this$children == null ? other$children == null : this$children.equals(other$children);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysPushFlowConfigLinkSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $notificationType = this.getNotificationType();
      result = result * 59 + ($notificationType == null ? 43 : $notificationType.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushFlowConfigLinkSaveDTOParam(notificationType=" + this.getNotificationType() + ", children=" + this.getChildren() + ")";
   }

   public static class SysPushFlowConfigLinkSaveDTOParamBuilder {
      private Integer notificationType;
      private List<SysPushFlowConfigLinkSaveDTOParam> children;

      SysPushFlowConfigLinkSaveDTOParamBuilder() {
      }

      public SysPushFlowConfigLinkSaveDTOParam.SysPushFlowConfigLinkSaveDTOParamBuilder notificationType(final Integer notificationType) {
         this.notificationType = notificationType;
         return this;
      }

      public SysPushFlowConfigLinkSaveDTOParam.SysPushFlowConfigLinkSaveDTOParamBuilder children(final List<SysPushFlowConfigLinkSaveDTOParam> children) {
         this.children = children;
         return this;
      }

      public SysPushFlowConfigLinkSaveDTOParam build() {
         return new SysPushFlowConfigLinkSaveDTOParam(this.notificationType, this.children);
      }

      @Override
      public String toString() {
         return "SysPushFlowConfigLinkSaveDTOParam.SysPushFlowConfigLinkSaveDTOParamBuilder(notificationType="
            + this.notificationType
            + ", children="
            + this.children
            + ")";
      }
   }
}
