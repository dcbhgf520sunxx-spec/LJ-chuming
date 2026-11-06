package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;

public class SysPushApproveConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "appKey", value = "appKey（企微：corpId）", notes = "AppKey")
   private String appKey;
   @ApiModelProperty(name = "appSecret", value = "appSecret（企微：corpSecret）", notes = "秘钥")
   private String appSecret;
   @ApiModelProperty(name = "robotCode", value = "robotCode（企微：agentId）", notes = "工具人code")
   private String robotCode;
   @ApiModelProperty(name = "appType", value = "1,钉钉，2，企微", notes = "1,钉钉，2，企微")
   private Integer appType;
   @ApiModelProperty(name = "status", value = "状态：1开启，0禁用", notes = "状态：1开启，0禁用")
   private Integer status;

   public static SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder builder() {
      return new SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getAppKey() {
      return this.appKey;
   }

   public String getAppSecret() {
      return this.appSecret;
   }

   public String getRobotCode() {
      return this.robotCode;
   }

   public Integer getAppType() {
      return this.appType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAppKey(final String appKey) {
      this.appKey = appKey;
   }

   public void setAppSecret(final String appSecret) {
      this.appSecret = appSecret;
   }

   public void setRobotCode(final String robotCode) {
      this.robotCode = robotCode;
   }

   public void setAppType(final Integer appType) {
      this.appType = appType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushApproveConfigDTO)) {
         return false;
      }

      SysPushApproveConfigDTO other = (SysPushApproveConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$appType = this.getAppType();
         Object other$appType = other.getAppType();
         if (this$appType == null ? other$appType == null : this$appType.equals(other$appType)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$appKey = this.getAppKey();
               Object other$appKey = other.getAppKey();
               if (this$appKey == null ? other$appKey == null : this$appKey.equals(other$appKey)) {
                  Object this$appSecret = this.getAppSecret();
                  Object other$appSecret = other.getAppSecret();
                  if (this$appSecret == null ? other$appSecret == null : this$appSecret.equals(other$appSecret)) {
                     Object this$robotCode = this.getRobotCode();
                     Object other$robotCode = other.getRobotCode();
                     return this$robotCode == null ? other$robotCode == null : this$robotCode.equals(other$robotCode);
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
      return other instanceof SysPushApproveConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $appType = this.getAppType();
      result = result * 59 + ($appType == null ? 43 : $appType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $appKey = this.getAppKey();
      result = result * 59 + ($appKey == null ? 43 : $appKey.hashCode());
      Object $appSecret = this.getAppSecret();
      result = result * 59 + ($appSecret == null ? 43 : $appSecret.hashCode());
      Object $robotCode = this.getRobotCode();
      return result * 59 + ($robotCode == null ? 43 : $robotCode.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushApproveConfigDTO(id="
         + this.getId()
         + ", appKey="
         + this.getAppKey()
         + ", appSecret="
         + this.getAppSecret()
         + ", robotCode="
         + this.getRobotCode()
         + ", appType="
         + this.getAppType()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public SysPushApproveConfigDTO(
      final Long id, final String appKey, final String appSecret, final String robotCode, final Integer appType, final Integer status
   ) {
      this.id = id;
      this.appKey = appKey;
      this.appSecret = appSecret;
      this.robotCode = robotCode;
      this.appType = appType;
      this.status = status;
   }

   public SysPushApproveConfigDTO() {
   }

   public static class SysPushApproveConfigDTOBuilder {
      private Long id;
      private String appKey;
      private String appSecret;
      private String robotCode;
      private Integer appType;
      private Integer status;

      SysPushApproveConfigDTOBuilder() {
      }

      public SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder appKey(final String appKey) {
         this.appKey = appKey;
         return this;
      }

      public SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder appSecret(final String appSecret) {
         this.appSecret = appSecret;
         return this;
      }

      public SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder robotCode(final String robotCode) {
         this.robotCode = robotCode;
         return this;
      }

      public SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder appType(final Integer appType) {
         this.appType = appType;
         return this;
      }

      public SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SysPushApproveConfigDTO build() {
         return new SysPushApproveConfigDTO(this.id, this.appKey, this.appSecret, this.robotCode, this.appType, this.status);
      }

      @Override
      public String toString() {
         return "SysPushApproveConfigDTO.SysPushApproveConfigDTOBuilder(id="
            + this.id
            + ", appKey="
            + this.appKey
            + ", appSecret="
            + this.appSecret
            + ", robotCode="
            + this.robotCode
            + ", appType="
            + this.appType
            + ", status="
            + this.status
            + ")";
      }
   }
}
