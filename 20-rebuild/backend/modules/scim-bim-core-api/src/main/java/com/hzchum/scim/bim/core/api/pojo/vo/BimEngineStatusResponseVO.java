package com.hzchum.scim.bim.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;

@ApiModel("bim文件状态返回类VO")
public class BimEngineStatusResponseVO {
   @ApiModelProperty(name = "fileId", value = "文件id")
   private Long fileId;
   @ApiModelProperty(name = "name", value = "文件名称")
   private String name;
   @ApiModelProperty(name = "priority", value = "优先级")
   private Integer priority;
   @ApiModelProperty(name = "status", value = "上传状态")
   private String status;
   @ApiModelProperty(name = "status", value = "集成状态")
   private String integrationStatus;
   @ApiModelProperty(name = "thumbnail", value = "缩略图")
   private String[] thumbnail;
   @ApiModelProperty(name = "reason", value = "失败原因")
   private String reason;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private String createTime;
   @ApiModelProperty(name = "databagId", value = "数据包id")
   private String databagId;
   @ApiModelProperty(name = "modelType", value = "模型类型")
   private String modelType;
   @ApiModelProperty(name = "viewToken", value = "viewToken")
   private String viewToken;

   public static BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder builder() {
      return new BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder();
   }

   public BimEngineStatusResponseVO() {
   }

   public BimEngineStatusResponseVO(
      final Long fileId,
      final String name,
      final Integer priority,
      final String status,
      final String integrationStatus,
      final String[] thumbnail,
      final String reason,
      final String createTime,
      final String databagId,
      final String modelType,
      final String viewToken
   ) {
      this.fileId = fileId;
      this.name = name;
      this.priority = priority;
      this.status = status;
      this.integrationStatus = integrationStatus;
      this.thumbnail = thumbnail;
      this.reason = reason;
      this.createTime = createTime;
      this.databagId = databagId;
      this.modelType = modelType;
      this.viewToken = viewToken;
   }

   public Long getFileId() {
      return this.fileId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getPriority() {
      return this.priority;
   }

   public String getStatus() {
      return this.status;
   }

   public String getIntegrationStatus() {
      return this.integrationStatus;
   }

   public String[] getThumbnail() {
      return this.thumbnail;
   }

   public String getReason() {
      return this.reason;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getDatabagId() {
      return this.databagId;
   }

   public String getModelType() {
      return this.modelType;
   }

   public String getViewToken() {
      return this.viewToken;
   }

   public void setFileId(final Long fileId) {
      this.fileId = fileId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPriority(final Integer priority) {
      this.priority = priority;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setIntegrationStatus(final String integrationStatus) {
      this.integrationStatus = integrationStatus;
   }

   public void setThumbnail(final String[] thumbnail) {
      this.thumbnail = thumbnail;
   }

   public void setReason(final String reason) {
      this.reason = reason;
   }

   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   public void setDatabagId(final String databagId) {
      this.databagId = databagId;
   }

   public void setModelType(final String modelType) {
      this.modelType = modelType;
   }

   public void setViewToken(final String viewToken) {
      this.viewToken = viewToken;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimEngineStatusResponseVO)) {
         return false;
      }

      BimEngineStatusResponseVO other = (BimEngineStatusResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$fileId = this.getFileId();
      Object other$fileId = other.getFileId();
      if (this$fileId == null ? other$fileId == null : this$fileId.equals(other$fileId)) {
         Object this$priority = this.getPriority();
         Object other$priority = other.getPriority();
         if (this$priority == null ? other$priority == null : this$priority.equals(other$priority)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$integrationStatus = this.getIntegrationStatus();
                  Object other$integrationStatus = other.getIntegrationStatus();
                  if (this$integrationStatus == null ? other$integrationStatus == null : this$integrationStatus.equals(other$integrationStatus)) {
                     if (!Arrays.deepEquals(this.getThumbnail(), other.getThumbnail())) {
                        return false;
                     }

                     Object this$reason = this.getReason();
                     Object other$reason = other.getReason();
                     if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$databagId = this.getDatabagId();
                           Object other$databagId = other.getDatabagId();
                           if (this$databagId == null ? other$databagId == null : this$databagId.equals(other$databagId)) {
                              Object this$modelType = this.getModelType();
                              Object other$modelType = other.getModelType();
                              if (this$modelType == null ? other$modelType == null : this$modelType.equals(other$modelType)) {
                                 Object this$viewToken = this.getViewToken();
                                 Object other$viewToken = other.getViewToken();
                                 return this$viewToken == null ? other$viewToken == null : this$viewToken.equals(other$viewToken);
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
      return other instanceof BimEngineStatusResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fileId = this.getFileId();
      result = result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
      Object $priority = this.getPriority();
      result = result * 59 + ($priority == null ? 43 : $priority.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $integrationStatus = this.getIntegrationStatus();
      result = result * 59 + ($integrationStatus == null ? 43 : $integrationStatus.hashCode());
      result = result * 59 + Arrays.deepHashCode(this.getThumbnail());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $databagId = this.getDatabagId();
      result = result * 59 + ($databagId == null ? 43 : $databagId.hashCode());
      Object $modelType = this.getModelType();
      result = result * 59 + ($modelType == null ? 43 : $modelType.hashCode());
      Object $viewToken = this.getViewToken();
      return result * 59 + ($viewToken == null ? 43 : $viewToken.hashCode());
   }

   @Override
   public String toString() {
      return "BimEngineStatusResponseVO(fileId="
         + this.getFileId()
         + ", name="
         + this.getName()
         + ", priority="
         + this.getPriority()
         + ", status="
         + this.getStatus()
         + ", integrationStatus="
         + this.getIntegrationStatus()
         + ", thumbnail="
         + Arrays.deepToString(this.getThumbnail())
         + ", reason="
         + this.getReason()
         + ", createTime="
         + this.getCreateTime()
         + ", databagId="
         + this.getDatabagId()
         + ", modelType="
         + this.getModelType()
         + ", viewToken="
         + this.getViewToken()
         + ")";
   }

   public static class BimEngineStatusResponseVOBuilder {
      private Long fileId;
      private String name;
      private Integer priority;
      private String status;
      private String integrationStatus;
      private String[] thumbnail;
      private String reason;
      private String createTime;
      private String databagId;
      private String modelType;
      private String viewToken;

      BimEngineStatusResponseVOBuilder() {
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder fileId(final Long fileId) {
         this.fileId = fileId;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder priority(final Integer priority) {
         this.priority = priority;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder integrationStatus(final String integrationStatus) {
         this.integrationStatus = integrationStatus;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder thumbnail(final String[] thumbnail) {
         this.thumbnail = thumbnail;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder reason(final String reason) {
         this.reason = reason;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder databagId(final String databagId) {
         this.databagId = databagId;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder modelType(final String modelType) {
         this.modelType = modelType;
         return this;
      }

      public BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder viewToken(final String viewToken) {
         this.viewToken = viewToken;
         return this;
      }

      public BimEngineStatusResponseVO build() {
         return new BimEngineStatusResponseVO(
            this.fileId,
            this.name,
            this.priority,
            this.status,
            this.integrationStatus,
            this.thumbnail,
            this.reason,
            this.createTime,
            this.databagId,
            this.modelType,
            this.viewToken
         );
      }

      @Override
      public String toString() {
         return "BimEngineStatusResponseVO.BimEngineStatusResponseVOBuilder(fileId="
            + this.fileId
            + ", name="
            + this.name
            + ", priority="
            + this.priority
            + ", status="
            + this.status
            + ", integrationStatus="
            + this.integrationStatus
            + ", thumbnail="
            + Arrays.deepToString(this.thumbnail)
            + ", reason="
            + this.reason
            + ", createTime="
            + this.createTime
            + ", databagId="
            + this.databagId
            + ", modelType="
            + this.modelType
            + ", viewToken="
            + this.viewToken
            + ")";
      }
   }
}
