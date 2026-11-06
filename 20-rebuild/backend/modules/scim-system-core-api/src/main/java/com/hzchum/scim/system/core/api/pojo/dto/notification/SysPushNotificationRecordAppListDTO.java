package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;

public class SysPushNotificationRecordAppListDTO {
   @ApiModelProperty(name = "operationalModuleType", value = "模块类型")
   private Integer operationalModuleType;
   @ApiModelProperty(name = "operationalModuleTypeName", value = "模块名称")
   private String operationalModuleTypeName;
   @ApiModelProperty(name = "unRead", value = "未读数")
   private Integer unRead;
   @ApiModelProperty(name = "time", value = "最新时间")
   private String time;
   @ApiModelProperty(name = "content", value = "最新业务")
   private String content;

   public static SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder builder() {
      return new SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder();
   }

   public Integer getOperationalModuleType() {
      return this.operationalModuleType;
   }

   public String getOperationalModuleTypeName() {
      return this.operationalModuleTypeName;
   }

   public Integer getUnRead() {
      return this.unRead;
   }

   public String getTime() {
      return this.time;
   }

   public String getContent() {
      return this.content;
   }

   public void setOperationalModuleType(final Integer operationalModuleType) {
      this.operationalModuleType = operationalModuleType;
   }

   public void setOperationalModuleTypeName(final String operationalModuleTypeName) {
      this.operationalModuleTypeName = operationalModuleTypeName;
   }

   public void setUnRead(final Integer unRead) {
      this.unRead = unRead;
   }

   public void setTime(final String time) {
      this.time = time;
   }

   public void setContent(final String content) {
      this.content = content;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationRecordAppListDTO)) {
         return false;
      }

      SysPushNotificationRecordAppListDTO other = (SysPushNotificationRecordAppListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$operationalModuleType = this.getOperationalModuleType();
      Object other$operationalModuleType = other.getOperationalModuleType();
      if (this$operationalModuleType == null ? other$operationalModuleType == null : this$operationalModuleType.equals(other$operationalModuleType)) {
         Object this$unRead = this.getUnRead();
         Object other$unRead = other.getUnRead();
         if (this$unRead == null ? other$unRead == null : this$unRead.equals(other$unRead)) {
            Object this$operationalModuleTypeName = this.getOperationalModuleTypeName();
            Object other$operationalModuleTypeName = other.getOperationalModuleTypeName();
            if (this$operationalModuleTypeName == null
               ? other$operationalModuleTypeName == null
               : this$operationalModuleTypeName.equals(other$operationalModuleTypeName)) {
               Object this$time = this.getTime();
               Object other$time = other.getTime();
               if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                  Object this$content = this.getContent();
                  Object other$content = other.getContent();
                  return this$content == null ? other$content == null : this$content.equals(other$content);
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
      return other instanceof SysPushNotificationRecordAppListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $operationalModuleType = this.getOperationalModuleType();
      result = result * 59 + ($operationalModuleType == null ? 43 : $operationalModuleType.hashCode());
      Object $unRead = this.getUnRead();
      result = result * 59 + ($unRead == null ? 43 : $unRead.hashCode());
      Object $operationalModuleTypeName = this.getOperationalModuleTypeName();
      result = result * 59 + ($operationalModuleTypeName == null ? 43 : $operationalModuleTypeName.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $content = this.getContent();
      return result * 59 + ($content == null ? 43 : $content.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushNotificationRecordAppListDTO(operationalModuleType="
         + this.getOperationalModuleType()
         + ", operationalModuleTypeName="
         + this.getOperationalModuleTypeName()
         + ", unRead="
         + this.getUnRead()
         + ", time="
         + this.getTime()
         + ", content="
         + this.getContent()
         + ")";
   }

   public SysPushNotificationRecordAppListDTO(
      final Integer operationalModuleType, final String operationalModuleTypeName, final Integer unRead, final String time, final String content
   ) {
      this.operationalModuleType = operationalModuleType;
      this.operationalModuleTypeName = operationalModuleTypeName;
      this.unRead = unRead;
      this.time = time;
      this.content = content;
   }

   public SysPushNotificationRecordAppListDTO() {
   }

   public static class SysPushNotificationRecordAppListDTOBuilder {
      private Integer operationalModuleType;
      private String operationalModuleTypeName;
      private Integer unRead;
      private String time;
      private String content;

      SysPushNotificationRecordAppListDTOBuilder() {
      }

      public SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder operationalModuleType(final Integer operationalModuleType) {
         this.operationalModuleType = operationalModuleType;
         return this;
      }

      public SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder operationalModuleTypeName(final String operationalModuleTypeName) {
         this.operationalModuleTypeName = operationalModuleTypeName;
         return this;
      }

      public SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder unRead(final Integer unRead) {
         this.unRead = unRead;
         return this;
      }

      public SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder time(final String time) {
         this.time = time;
         return this;
      }

      public SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder content(final String content) {
         this.content = content;
         return this;
      }

      public SysPushNotificationRecordAppListDTO build() {
         return new SysPushNotificationRecordAppListDTO(this.operationalModuleType, this.operationalModuleTypeName, this.unRead, this.time, this.content);
      }

      @Override
      public String toString() {
         return "SysPushNotificationRecordAppListDTO.SysPushNotificationRecordAppListDTOBuilder(operationalModuleType="
            + this.operationalModuleType
            + ", operationalModuleTypeName="
            + this.operationalModuleTypeName
            + ", unRead="
            + this.unRead
            + ", time="
            + this.time
            + ", content="
            + this.content
            + ")";
      }
   }
}
