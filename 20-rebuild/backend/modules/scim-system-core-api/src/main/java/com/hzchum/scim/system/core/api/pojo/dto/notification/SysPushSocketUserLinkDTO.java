package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "SysPushSocketUserLinkDTO", description = "wocket")
public class SysPushSocketUserLinkDTO {
   @ApiModelProperty(name = "notificationTypeEnumName", value = "通知业务", notes = "通知业务")
   private String notificationTypeEnumName;
   @ApiModelProperty(name = "operationalModuleTypeEnumName", value = "业务模块", notes = "业务模块")
   private String operationalModuleTypeEnumName;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务模块", notes = "业务模块")
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "contentDetails", notes = "消息推送内容详情")
   private String contentDetails;
   @ApiModelProperty(name = "userIdDTOList", notes = "userId和DataID")
   List<SysPushSocketUserIdDTO> userIdDTOList;

   public static SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder builder() {
      return new SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder();
   }

   public SysPushSocketUserLinkDTO() {
   }

   public SysPushSocketUserLinkDTO(
      final String notificationTypeEnumName,
      final String operationalModuleTypeEnumName,
      final Integer operationalModuleTypeEnum,
      final String contentDetails,
      final List<SysPushSocketUserIdDTO> userIdDTOList
   ) {
      this.notificationTypeEnumName = notificationTypeEnumName;
      this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.contentDetails = contentDetails;
      this.userIdDTOList = userIdDTOList;
   }

   public String getNotificationTypeEnumName() {
      return this.notificationTypeEnumName;
   }

   public String getOperationalModuleTypeEnumName() {
      return this.operationalModuleTypeEnumName;
   }

   public Integer getOperationalModuleTypeEnum() {
      return this.operationalModuleTypeEnum;
   }

   public String getContentDetails() {
      return this.contentDetails;
   }

   public List<SysPushSocketUserIdDTO> getUserIdDTOList() {
      return this.userIdDTOList;
   }

   public SysPushSocketUserLinkDTO setNotificationTypeEnumName(final String notificationTypeEnumName) {
      this.notificationTypeEnumName = notificationTypeEnumName;
      return this;
   }

   public SysPushSocketUserLinkDTO setOperationalModuleTypeEnumName(final String operationalModuleTypeEnumName) {
      this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
      return this;
   }

   public SysPushSocketUserLinkDTO setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      return this;
   }

   public SysPushSocketUserLinkDTO setContentDetails(final String contentDetails) {
      this.contentDetails = contentDetails;
      return this;
   }

   public SysPushSocketUserLinkDTO setUserIdDTOList(final List<SysPushSocketUserIdDTO> userIdDTOList) {
      this.userIdDTOList = userIdDTOList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushSocketUserLinkDTO)) {
         return false;
      }

      SysPushSocketUserLinkDTO other = (SysPushSocketUserLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      Object other$operationalModuleTypeEnum = other.getOperationalModuleTypeEnum();
      if (this$operationalModuleTypeEnum == null
         ? other$operationalModuleTypeEnum == null
         : this$operationalModuleTypeEnum.equals(other$operationalModuleTypeEnum)) {
         Object this$notificationTypeEnumName = this.getNotificationTypeEnumName();
         Object other$notificationTypeEnumName = other.getNotificationTypeEnumName();
         if (this$notificationTypeEnumName == null
            ? other$notificationTypeEnumName == null
            : this$notificationTypeEnumName.equals(other$notificationTypeEnumName)) {
            Object this$operationalModuleTypeEnumName = this.getOperationalModuleTypeEnumName();
            Object other$operationalModuleTypeEnumName = other.getOperationalModuleTypeEnumName();
            if (this$operationalModuleTypeEnumName == null
               ? other$operationalModuleTypeEnumName == null
               : this$operationalModuleTypeEnumName.equals(other$operationalModuleTypeEnumName)) {
               Object this$contentDetails = this.getContentDetails();
               Object other$contentDetails = other.getContentDetails();
               if (this$contentDetails == null ? other$contentDetails == null : this$contentDetails.equals(other$contentDetails)) {
                  Object this$userIdDTOList = this.getUserIdDTOList();
                  Object other$userIdDTOList = other.getUserIdDTOList();
                  return this$userIdDTOList == null ? other$userIdDTOList == null : this$userIdDTOList.equals(other$userIdDTOList);
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
      return other instanceof SysPushSocketUserLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnumName = this.getNotificationTypeEnumName();
      result = result * 59 + ($notificationTypeEnumName == null ? 43 : $notificationTypeEnumName.hashCode());
      Object $operationalModuleTypeEnumName = this.getOperationalModuleTypeEnumName();
      result = result * 59 + ($operationalModuleTypeEnumName == null ? 43 : $operationalModuleTypeEnumName.hashCode());
      Object $contentDetails = this.getContentDetails();
      result = result * 59 + ($contentDetails == null ? 43 : $contentDetails.hashCode());
      Object $userIdDTOList = this.getUserIdDTOList();
      return result * 59 + ($userIdDTOList == null ? 43 : $userIdDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushSocketUserLinkDTO(notificationTypeEnumName="
         + this.getNotificationTypeEnumName()
         + ", operationalModuleTypeEnumName="
         + this.getOperationalModuleTypeEnumName()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", contentDetails="
         + this.getContentDetails()
         + ", userIdDTOList="
         + this.getUserIdDTOList()
         + ")";
   }

   public static class SysPushSocketUserLinkDTOBuilder {
      private String notificationTypeEnumName;
      private String operationalModuleTypeEnumName;
      private Integer operationalModuleTypeEnum;
      private String contentDetails;
      private List<SysPushSocketUserIdDTO> userIdDTOList;

      SysPushSocketUserLinkDTOBuilder() {
      }

      public SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder notificationTypeEnumName(final String notificationTypeEnumName) {
         this.notificationTypeEnumName = notificationTypeEnumName;
         return this;
      }

      public SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder operationalModuleTypeEnumName(final String operationalModuleTypeEnumName) {
         this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
         return this;
      }

      public SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder contentDetails(final String contentDetails) {
         this.contentDetails = contentDetails;
         return this;
      }

      public SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder userIdDTOList(final List<SysPushSocketUserIdDTO> userIdDTOList) {
         this.userIdDTOList = userIdDTOList;
         return this;
      }

      public SysPushSocketUserLinkDTO build() {
         return new SysPushSocketUserLinkDTO(
            this.notificationTypeEnumName, this.operationalModuleTypeEnumName, this.operationalModuleTypeEnum, this.contentDetails, this.userIdDTOList
         );
      }

      @Override
      public String toString() {
         return "SysPushSocketUserLinkDTO.SysPushSocketUserLinkDTOBuilder(notificationTypeEnumName="
            + this.notificationTypeEnumName
            + ", operationalModuleTypeEnumName="
            + this.operationalModuleTypeEnumName
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", contentDetails="
            + this.contentDetails
            + ", userIdDTOList="
            + this.userIdDTOList
            + ")";
      }
   }
}
