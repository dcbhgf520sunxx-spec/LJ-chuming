package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SysPushFlowConfigLinkDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "pId", notes = "父id")
   private Long pId;
   @ApiModelProperty(name = "notificationType", notes = "业务类型")
   private Integer notificationType;
   @ApiModelProperty(name = "notificationTypeName", notes = "业务名称")
   private String notificationTypeName;
   @ApiModelProperty(name = "arrivalConfiguration", notes = "是否拥有业务到达配置")
   private Boolean arrivalConfiguration;
   @ApiModelProperty(name = "completionConfiguration", notes = "是否拥有业务完成配置")
   private Boolean completionConfiguration;
   @ApiModelProperty(name = "children", notes = "流程配置")
   List<SysPushFlowConfigLinkDTO> children;

   public static SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder builder() {
      return new SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getPId() {
      return this.pId;
   }

   public Integer getNotificationType() {
      return this.notificationType;
   }

   public String getNotificationTypeName() {
      return this.notificationTypeName;
   }

   public Boolean getArrivalConfiguration() {
      return this.arrivalConfiguration;
   }

   public Boolean getCompletionConfiguration() {
      return this.completionConfiguration;
   }

   public List<SysPushFlowConfigLinkDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPId(final Long pId) {
      this.pId = pId;
   }

   public void setNotificationType(final Integer notificationType) {
      this.notificationType = notificationType;
   }

   public void setNotificationTypeName(final String notificationTypeName) {
      this.notificationTypeName = notificationTypeName;
   }

   public void setArrivalConfiguration(final Boolean arrivalConfiguration) {
      this.arrivalConfiguration = arrivalConfiguration;
   }

   public void setCompletionConfiguration(final Boolean completionConfiguration) {
      this.completionConfiguration = completionConfiguration;
   }

   public void setChildren(final List<SysPushFlowConfigLinkDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushFlowConfigLinkDTO)) {
         return false;
      }

      SysPushFlowConfigLinkDTO other = (SysPushFlowConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pId = this.getPId();
         Object other$pId = other.getPId();
         if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
            Object this$notificationType = this.getNotificationType();
            Object other$notificationType = other.getNotificationType();
            if (this$notificationType == null ? other$notificationType == null : this$notificationType.equals(other$notificationType)) {
               Object this$arrivalConfiguration = this.getArrivalConfiguration();
               Object other$arrivalConfiguration = other.getArrivalConfiguration();
               if (this$arrivalConfiguration == null ? other$arrivalConfiguration == null : this$arrivalConfiguration.equals(other$arrivalConfiguration)) {
                  Object this$completionConfiguration = this.getCompletionConfiguration();
                  Object other$completionConfiguration = other.getCompletionConfiguration();
                  if (this$completionConfiguration == null
                     ? other$completionConfiguration == null
                     : this$completionConfiguration.equals(other$completionConfiguration)) {
                     Object this$notificationTypeName = this.getNotificationTypeName();
                     Object other$notificationTypeName = other.getNotificationTypeName();
                     if (this$notificationTypeName == null ? other$notificationTypeName == null : this$notificationTypeName.equals(other$notificationTypeName)) {
                        Object this$children = this.getChildren();
                        Object other$children = other.getChildren();
                        return this$children == null ? other$children == null : this$children.equals(other$children);
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysPushFlowConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $notificationType = this.getNotificationType();
      result = result * 59 + ($notificationType == null ? 43 : $notificationType.hashCode());
      Object $arrivalConfiguration = this.getArrivalConfiguration();
      result = result * 59 + ($arrivalConfiguration == null ? 43 : $arrivalConfiguration.hashCode());
      Object $completionConfiguration = this.getCompletionConfiguration();
      result = result * 59 + ($completionConfiguration == null ? 43 : $completionConfiguration.hashCode());
      Object $notificationTypeName = this.getNotificationTypeName();
      result = result * 59 + ($notificationTypeName == null ? 43 : $notificationTypeName.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushFlowConfigLinkDTO(id="
         + this.getId()
         + ", pId="
         + this.getPId()
         + ", notificationType="
         + this.getNotificationType()
         + ", notificationTypeName="
         + this.getNotificationTypeName()
         + ", arrivalConfiguration="
         + this.getArrivalConfiguration()
         + ", completionConfiguration="
         + this.getCompletionConfiguration()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public SysPushFlowConfigLinkDTO(
      final Long id,
      final Long pId,
      final Integer notificationType,
      final String notificationTypeName,
      final Boolean arrivalConfiguration,
      final Boolean completionConfiguration,
      final List<SysPushFlowConfigLinkDTO> children
   ) {
      this.id = id;
      this.pId = pId;
      this.notificationType = notificationType;
      this.notificationTypeName = notificationTypeName;
      this.arrivalConfiguration = arrivalConfiguration;
      this.completionConfiguration = completionConfiguration;
      this.children = children;
   }

   public SysPushFlowConfigLinkDTO() {
   }

   public static class SysPushFlowConfigLinkDTOBuilder {
      private Long id;
      private Long pId;
      private Integer notificationType;
      private String notificationTypeName;
      private Boolean arrivalConfiguration;
      private Boolean completionConfiguration;
      private List<SysPushFlowConfigLinkDTO> children;

      SysPushFlowConfigLinkDTOBuilder() {
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder pId(final Long pId) {
         this.pId = pId;
         return this;
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder notificationType(final Integer notificationType) {
         this.notificationType = notificationType;
         return this;
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder notificationTypeName(final String notificationTypeName) {
         this.notificationTypeName = notificationTypeName;
         return this;
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder arrivalConfiguration(final Boolean arrivalConfiguration) {
         this.arrivalConfiguration = arrivalConfiguration;
         return this;
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder completionConfiguration(final Boolean completionConfiguration) {
         this.completionConfiguration = completionConfiguration;
         return this;
      }

      public SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder children(final List<SysPushFlowConfigLinkDTO> children) {
         this.children = children;
         return this;
      }

      public SysPushFlowConfigLinkDTO build() {
         return new SysPushFlowConfigLinkDTO(
            this.id, this.pId, this.notificationType, this.notificationTypeName, this.arrivalConfiguration, this.completionConfiguration, this.children
         );
      }

      @Override
      public String toString() {
         return "SysPushFlowConfigLinkDTO.SysPushFlowConfigLinkDTOBuilder(id="
            + this.id
            + ", pId="
            + this.pId
            + ", notificationType="
            + this.notificationType
            + ", notificationTypeName="
            + this.notificationTypeName
            + ", arrivalConfiguration="
            + this.arrivalConfiguration
            + ", completionConfiguration="
            + this.completionConfiguration
            + ", children="
            + this.children
            + ")";
      }
   }
}
