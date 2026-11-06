package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回所有审批流程数据")
public class ZhongNanWorkflowBaseInfo {
   @JsonProperty(value = "createTime", namespace = "创建时间")
   private String createTime;
   @JsonProperty(value = "creatorId", namespace = "创建人id")
   private String creatorId;
   @JsonProperty(value = "creatorName", namespace = "创建人姓名")
   private String creatorName;
   @JsonProperty(value = "currentNodeId", namespace = "当前节点id")
   private String currentNodeId;
   @JsonProperty(value = "currentNodeName", namespace = "当前节点名称")
   private String currentNodeName;
   @JsonProperty(value = "lastOperateTime", namespace = "最后操作时间")
   private String lastOperateTime;
   @JsonProperty(value = "lastOperatorId", namespace = "最后操作人id")
   private String lastOperatorId;
   @JsonProperty(value = "lastOperatorName", namespace = "最后操作人姓名")
   private String lastOperatorName;
   @JsonProperty(value = "receiveTime", namespace = "接收时间")
   private String receiveTime;
   @JsonProperty(value = "requestId", namespace = "请求id")
   private String requestId;
   @JsonProperty(value = "requestLevel", namespace = "紧急程度")
   private String requestLevel;
   @JsonProperty(value = "requestName", namespace = "请求标题")
   private String requestName;
   @JsonProperty(value = "status", namespace = "状态")
   private String status;
   @JsonProperty(value = "sysName", namespace = "系统名称")
   private String sysName;
   @JsonProperty(value = "requestmark", namespace = "流程编号")
   private String requestmark;
   @JsonProperty(value = "creatorDepartmentId", namespace = "创建人部门id")
   private String creatorDepartmentId;
   @JsonProperty(value = "creatorDepartmentName", namespace = "创建人部门名称")
   private String creatorDepartmentName;
   @JsonProperty(value = "creatorSubcompanyId", namespace = "创建人分部id")
   private String creatorSubcompanyId;
   @JsonProperty(value = "creatorSubcompanyName", namespace = "分部名称")
   private String creatorSubcompanyName;
   @JsonProperty("流程基本信息")
   private ZhongNanWorkFlowDTO workflowBaseInfo;

   public static ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder builder() {
      return new ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder();
   }

   public ZhongNanWorkflowBaseInfo() {
   }

   public ZhongNanWorkflowBaseInfo(
      final String createTime,
      final String creatorId,
      final String creatorName,
      final String currentNodeId,
      final String currentNodeName,
      final String lastOperateTime,
      final String lastOperatorId,
      final String lastOperatorName,
      final String receiveTime,
      final String requestId,
      final String requestLevel,
      final String requestName,
      final String status,
      final String sysName,
      final String requestmark,
      final String creatorDepartmentId,
      final String creatorDepartmentName,
      final String creatorSubcompanyId,
      final String creatorSubcompanyName,
      final ZhongNanWorkFlowDTO workflowBaseInfo
   ) {
      this.createTime = createTime;
      this.creatorId = creatorId;
      this.creatorName = creatorName;
      this.currentNodeId = currentNodeId;
      this.currentNodeName = currentNodeName;
      this.lastOperateTime = lastOperateTime;
      this.lastOperatorId = lastOperatorId;
      this.lastOperatorName = lastOperatorName;
      this.receiveTime = receiveTime;
      this.requestId = requestId;
      this.requestLevel = requestLevel;
      this.requestName = requestName;
      this.status = status;
      this.sysName = sysName;
      this.requestmark = requestmark;
      this.creatorDepartmentId = creatorDepartmentId;
      this.creatorDepartmentName = creatorDepartmentName;
      this.creatorSubcompanyId = creatorSubcompanyId;
      this.creatorSubcompanyName = creatorSubcompanyName;
      this.workflowBaseInfo = workflowBaseInfo;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getCreatorId() {
      return this.creatorId;
   }

   public String getCreatorName() {
      return this.creatorName;
   }

   public String getCurrentNodeId() {
      return this.currentNodeId;
   }

   public String getCurrentNodeName() {
      return this.currentNodeName;
   }

   public String getLastOperateTime() {
      return this.lastOperateTime;
   }

   public String getLastOperatorId() {
      return this.lastOperatorId;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
   }

   public String getReceiveTime() {
      return this.receiveTime;
   }

   public String getRequestId() {
      return this.requestId;
   }

   public String getRequestLevel() {
      return this.requestLevel;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getStatus() {
      return this.status;
   }

   public String getSysName() {
      return this.sysName;
   }

   public String getRequestmark() {
      return this.requestmark;
   }

   public String getCreatorDepartmentId() {
      return this.creatorDepartmentId;
   }

   public String getCreatorDepartmentName() {
      return this.creatorDepartmentName;
   }

   public String getCreatorSubcompanyId() {
      return this.creatorSubcompanyId;
   }

   public String getCreatorSubcompanyName() {
      return this.creatorSubcompanyName;
   }

   public ZhongNanWorkFlowDTO getWorkflowBaseInfo() {
      return this.workflowBaseInfo;
   }

   @JsonProperty(value = "createTime", namespace = "创建时间")
   public ZhongNanWorkflowBaseInfo setCreateTime(final String createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty(value = "creatorId", namespace = "创建人id")
   public ZhongNanWorkflowBaseInfo setCreatorId(final String creatorId) {
      this.creatorId = creatorId;
      return this;
   }

   @JsonProperty(value = "creatorName", namespace = "创建人姓名")
   public ZhongNanWorkflowBaseInfo setCreatorName(final String creatorName) {
      this.creatorName = creatorName;
      return this;
   }

   @JsonProperty(value = "currentNodeId", namespace = "当前节点id")
   public ZhongNanWorkflowBaseInfo setCurrentNodeId(final String currentNodeId) {
      this.currentNodeId = currentNodeId;
      return this;
   }

   @JsonProperty(value = "currentNodeName", namespace = "当前节点名称")
   public ZhongNanWorkflowBaseInfo setCurrentNodeName(final String currentNodeName) {
      this.currentNodeName = currentNodeName;
      return this;
   }

   @JsonProperty(value = "lastOperateTime", namespace = "最后操作时间")
   public ZhongNanWorkflowBaseInfo setLastOperateTime(final String lastOperateTime) {
      this.lastOperateTime = lastOperateTime;
      return this;
   }

   @JsonProperty(value = "lastOperatorId", namespace = "最后操作人id")
   public ZhongNanWorkflowBaseInfo setLastOperatorId(final String lastOperatorId) {
      this.lastOperatorId = lastOperatorId;
      return this;
   }

   @JsonProperty(value = "lastOperatorName", namespace = "最后操作人姓名")
   public ZhongNanWorkflowBaseInfo setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
      return this;
   }

   @JsonProperty(value = "receiveTime", namespace = "接收时间")
   public ZhongNanWorkflowBaseInfo setReceiveTime(final String receiveTime) {
      this.receiveTime = receiveTime;
      return this;
   }

   @JsonProperty(value = "requestId", namespace = "请求id")
   public ZhongNanWorkflowBaseInfo setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   @JsonProperty(value = "requestLevel", namespace = "紧急程度")
   public ZhongNanWorkflowBaseInfo setRequestLevel(final String requestLevel) {
      this.requestLevel = requestLevel;
      return this;
   }

   @JsonProperty(value = "requestName", namespace = "请求标题")
   public ZhongNanWorkflowBaseInfo setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   @JsonProperty(value = "status", namespace = "状态")
   public ZhongNanWorkflowBaseInfo setStatus(final String status) {
      this.status = status;
      return this;
   }

   @JsonProperty(value = "sysName", namespace = "系统名称")
   public ZhongNanWorkflowBaseInfo setSysName(final String sysName) {
      this.sysName = sysName;
      return this;
   }

   @JsonProperty(value = "requestmark", namespace = "流程编号")
   public ZhongNanWorkflowBaseInfo setRequestmark(final String requestmark) {
      this.requestmark = requestmark;
      return this;
   }

   @JsonProperty(value = "creatorDepartmentId", namespace = "创建人部门id")
   public ZhongNanWorkflowBaseInfo setCreatorDepartmentId(final String creatorDepartmentId) {
      this.creatorDepartmentId = creatorDepartmentId;
      return this;
   }

   @JsonProperty(value = "creatorDepartmentName", namespace = "创建人部门名称")
   public ZhongNanWorkflowBaseInfo setCreatorDepartmentName(final String creatorDepartmentName) {
      this.creatorDepartmentName = creatorDepartmentName;
      return this;
   }

   @JsonProperty(value = "creatorSubcompanyId", namespace = "创建人分部id")
   public ZhongNanWorkflowBaseInfo setCreatorSubcompanyId(final String creatorSubcompanyId) {
      this.creatorSubcompanyId = creatorSubcompanyId;
      return this;
   }

   @JsonProperty(value = "creatorSubcompanyName", namespace = "分部名称")
   public ZhongNanWorkflowBaseInfo setCreatorSubcompanyName(final String creatorSubcompanyName) {
      this.creatorSubcompanyName = creatorSubcompanyName;
      return this;
   }

   @JsonProperty("流程基本信息")
   public ZhongNanWorkflowBaseInfo setWorkflowBaseInfo(final ZhongNanWorkFlowDTO workflowBaseInfo) {
      this.workflowBaseInfo = workflowBaseInfo;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanWorkflowBaseInfo)) {
         return false;
      }

      ZhongNanWorkflowBaseInfo other = (ZhongNanWorkflowBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$creatorId = this.getCreatorId();
         Object other$creatorId = other.getCreatorId();
         if (this$creatorId == null ? other$creatorId == null : this$creatorId.equals(other$creatorId)) {
            Object this$creatorName = this.getCreatorName();
            Object other$creatorName = other.getCreatorName();
            if (this$creatorName == null ? other$creatorName == null : this$creatorName.equals(other$creatorName)) {
               Object this$currentNodeId = this.getCurrentNodeId();
               Object other$currentNodeId = other.getCurrentNodeId();
               if (this$currentNodeId == null ? other$currentNodeId == null : this$currentNodeId.equals(other$currentNodeId)) {
                  Object this$currentNodeName = this.getCurrentNodeName();
                  Object other$currentNodeName = other.getCurrentNodeName();
                  if (this$currentNodeName == null ? other$currentNodeName == null : this$currentNodeName.equals(other$currentNodeName)) {
                     Object this$lastOperateTime = this.getLastOperateTime();
                     Object other$lastOperateTime = other.getLastOperateTime();
                     if (this$lastOperateTime == null ? other$lastOperateTime == null : this$lastOperateTime.equals(other$lastOperateTime)) {
                        Object this$lastOperatorId = this.getLastOperatorId();
                        Object other$lastOperatorId = other.getLastOperatorId();
                        if (this$lastOperatorId == null ? other$lastOperatorId == null : this$lastOperatorId.equals(other$lastOperatorId)) {
                           Object this$lastOperatorName = this.getLastOperatorName();
                           Object other$lastOperatorName = other.getLastOperatorName();
                           if (this$lastOperatorName == null ? other$lastOperatorName == null : this$lastOperatorName.equals(other$lastOperatorName)) {
                              Object this$receiveTime = this.getReceiveTime();
                              Object other$receiveTime = other.getReceiveTime();
                              if (this$receiveTime == null ? other$receiveTime == null : this$receiveTime.equals(other$receiveTime)) {
                                 Object this$requestId = this.getRequestId();
                                 Object other$requestId = other.getRequestId();
                                 if (this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId)) {
                                    Object this$requestLevel = this.getRequestLevel();
                                    Object other$requestLevel = other.getRequestLevel();
                                    if (this$requestLevel == null ? other$requestLevel == null : this$requestLevel.equals(other$requestLevel)) {
                                       Object this$requestName = this.getRequestName();
                                       Object other$requestName = other.getRequestName();
                                       if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
                                          Object this$status = this.getStatus();
                                          Object other$status = other.getStatus();
                                          if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                             Object this$sysName = this.getSysName();
                                             Object other$sysName = other.getSysName();
                                             if (this$sysName == null ? other$sysName == null : this$sysName.equals(other$sysName)) {
                                                Object this$requestmark = this.getRequestmark();
                                                Object other$requestmark = other.getRequestmark();
                                                if (this$requestmark == null ? other$requestmark == null : this$requestmark.equals(other$requestmark)) {
                                                   Object this$creatorDepartmentId = this.getCreatorDepartmentId();
                                                   Object other$creatorDepartmentId = other.getCreatorDepartmentId();
                                                   if (this$creatorDepartmentId == null
                                                      ? other$creatorDepartmentId == null
                                                      : this$creatorDepartmentId.equals(other$creatorDepartmentId)) {
                                                      Object this$creatorDepartmentName = this.getCreatorDepartmentName();
                                                      Object other$creatorDepartmentName = other.getCreatorDepartmentName();
                                                      if (this$creatorDepartmentName == null
                                                         ? other$creatorDepartmentName == null
                                                         : this$creatorDepartmentName.equals(other$creatorDepartmentName)) {
                                                         Object this$creatorSubcompanyId = this.getCreatorSubcompanyId();
                                                         Object other$creatorSubcompanyId = other.getCreatorSubcompanyId();
                                                         if (this$creatorSubcompanyId == null
                                                            ? other$creatorSubcompanyId == null
                                                            : this$creatorSubcompanyId.equals(other$creatorSubcompanyId)) {
                                                            Object this$creatorSubcompanyName = this.getCreatorSubcompanyName();
                                                            Object other$creatorSubcompanyName = other.getCreatorSubcompanyName();
                                                            if (this$creatorSubcompanyName == null
                                                               ? other$creatorSubcompanyName == null
                                                               : this$creatorSubcompanyName.equals(other$creatorSubcompanyName)) {
                                                               Object this$workflowBaseInfo = this.getWorkflowBaseInfo();
                                                               Object other$workflowBaseInfo = other.getWorkflowBaseInfo();
                                                               return this$workflowBaseInfo == null
                                                                  ? other$workflowBaseInfo == null
                                                                  : this$workflowBaseInfo.equals(other$workflowBaseInfo);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZhongNanWorkflowBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $creatorId = this.getCreatorId();
      result = result * 59 + ($creatorId == null ? 43 : $creatorId.hashCode());
      Object $creatorName = this.getCreatorName();
      result = result * 59 + ($creatorName == null ? 43 : $creatorName.hashCode());
      Object $currentNodeId = this.getCurrentNodeId();
      result = result * 59 + ($currentNodeId == null ? 43 : $currentNodeId.hashCode());
      Object $currentNodeName = this.getCurrentNodeName();
      result = result * 59 + ($currentNodeName == null ? 43 : $currentNodeName.hashCode());
      Object $lastOperateTime = this.getLastOperateTime();
      result = result * 59 + ($lastOperateTime == null ? 43 : $lastOperateTime.hashCode());
      Object $lastOperatorId = this.getLastOperatorId();
      result = result * 59 + ($lastOperatorId == null ? 43 : $lastOperatorId.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $receiveTime = this.getReceiveTime();
      result = result * 59 + ($receiveTime == null ? 43 : $receiveTime.hashCode());
      Object $requestId = this.getRequestId();
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $requestLevel = this.getRequestLevel();
      result = result * 59 + ($requestLevel == null ? 43 : $requestLevel.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $sysName = this.getSysName();
      result = result * 59 + ($sysName == null ? 43 : $sysName.hashCode());
      Object $requestmark = this.getRequestmark();
      result = result * 59 + ($requestmark == null ? 43 : $requestmark.hashCode());
      Object $creatorDepartmentId = this.getCreatorDepartmentId();
      result = result * 59 + ($creatorDepartmentId == null ? 43 : $creatorDepartmentId.hashCode());
      Object $creatorDepartmentName = this.getCreatorDepartmentName();
      result = result * 59 + ($creatorDepartmentName == null ? 43 : $creatorDepartmentName.hashCode());
      Object $creatorSubcompanyId = this.getCreatorSubcompanyId();
      result = result * 59 + ($creatorSubcompanyId == null ? 43 : $creatorSubcompanyId.hashCode());
      Object $creatorSubcompanyName = this.getCreatorSubcompanyName();
      result = result * 59 + ($creatorSubcompanyName == null ? 43 : $creatorSubcompanyName.hashCode());
      Object $workflowBaseInfo = this.getWorkflowBaseInfo();
      return result * 59 + ($workflowBaseInfo == null ? 43 : $workflowBaseInfo.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanWorkflowBaseInfo(createTime="
         + this.getCreateTime()
         + ", creatorId="
         + this.getCreatorId()
         + ", creatorName="
         + this.getCreatorName()
         + ", currentNodeId="
         + this.getCurrentNodeId()
         + ", currentNodeName="
         + this.getCurrentNodeName()
         + ", lastOperateTime="
         + this.getLastOperateTime()
         + ", lastOperatorId="
         + this.getLastOperatorId()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", receiveTime="
         + this.getReceiveTime()
         + ", requestId="
         + this.getRequestId()
         + ", requestLevel="
         + this.getRequestLevel()
         + ", requestName="
         + this.getRequestName()
         + ", status="
         + this.getStatus()
         + ", sysName="
         + this.getSysName()
         + ", requestmark="
         + this.getRequestmark()
         + ", creatorDepartmentId="
         + this.getCreatorDepartmentId()
         + ", creatorDepartmentName="
         + this.getCreatorDepartmentName()
         + ", creatorSubcompanyId="
         + this.getCreatorSubcompanyId()
         + ", creatorSubcompanyName="
         + this.getCreatorSubcompanyName()
         + ", workflowBaseInfo="
         + this.getWorkflowBaseInfo()
         + ")";
   }

   public static class ZhongNanWorkflowBaseInfoBuilder {
      private String createTime;
      private String creatorId;
      private String creatorName;
      private String currentNodeId;
      private String currentNodeName;
      private String lastOperateTime;
      private String lastOperatorId;
      private String lastOperatorName;
      private String receiveTime;
      private String requestId;
      private String requestLevel;
      private String requestName;
      private String status;
      private String sysName;
      private String requestmark;
      private String creatorDepartmentId;
      private String creatorDepartmentName;
      private String creatorSubcompanyId;
      private String creatorSubcompanyName;
      private ZhongNanWorkFlowDTO workflowBaseInfo;

      ZhongNanWorkflowBaseInfoBuilder() {
      }

      @JsonProperty(value = "createTime", namespace = "创建时间")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty(value = "creatorId", namespace = "创建人id")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder creatorId(final String creatorId) {
         this.creatorId = creatorId;
         return this;
      }

      @JsonProperty(value = "creatorName", namespace = "创建人姓名")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder creatorName(final String creatorName) {
         this.creatorName = creatorName;
         return this;
      }

      @JsonProperty(value = "currentNodeId", namespace = "当前节点id")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder currentNodeId(final String currentNodeId) {
         this.currentNodeId = currentNodeId;
         return this;
      }

      @JsonProperty(value = "currentNodeName", namespace = "当前节点名称")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder currentNodeName(final String currentNodeName) {
         this.currentNodeName = currentNodeName;
         return this;
      }

      @JsonProperty(value = "lastOperateTime", namespace = "最后操作时间")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder lastOperateTime(final String lastOperateTime) {
         this.lastOperateTime = lastOperateTime;
         return this;
      }

      @JsonProperty(value = "lastOperatorId", namespace = "最后操作人id")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder lastOperatorId(final String lastOperatorId) {
         this.lastOperatorId = lastOperatorId;
         return this;
      }

      @JsonProperty(value = "lastOperatorName", namespace = "最后操作人姓名")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder lastOperatorName(final String lastOperatorName) {
         this.lastOperatorName = lastOperatorName;
         return this;
      }

      @JsonProperty(value = "receiveTime", namespace = "接收时间")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder receiveTime(final String receiveTime) {
         this.receiveTime = receiveTime;
         return this;
      }

      @JsonProperty(value = "requestId", namespace = "请求id")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      @JsonProperty(value = "requestLevel", namespace = "紧急程度")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder requestLevel(final String requestLevel) {
         this.requestLevel = requestLevel;
         return this;
      }

      @JsonProperty(value = "requestName", namespace = "请求标题")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      @JsonProperty(value = "status", namespace = "状态")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder status(final String status) {
         this.status = status;
         return this;
      }

      @JsonProperty(value = "sysName", namespace = "系统名称")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder sysName(final String sysName) {
         this.sysName = sysName;
         return this;
      }

      @JsonProperty(value = "requestmark", namespace = "流程编号")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder requestmark(final String requestmark) {
         this.requestmark = requestmark;
         return this;
      }

      @JsonProperty(value = "creatorDepartmentId", namespace = "创建人部门id")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder creatorDepartmentId(final String creatorDepartmentId) {
         this.creatorDepartmentId = creatorDepartmentId;
         return this;
      }

      @JsonProperty(value = "creatorDepartmentName", namespace = "创建人部门名称")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder creatorDepartmentName(final String creatorDepartmentName) {
         this.creatorDepartmentName = creatorDepartmentName;
         return this;
      }

      @JsonProperty(value = "creatorSubcompanyId", namespace = "创建人分部id")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder creatorSubcompanyId(final String creatorSubcompanyId) {
         this.creatorSubcompanyId = creatorSubcompanyId;
         return this;
      }

      @JsonProperty(value = "creatorSubcompanyName", namespace = "分部名称")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder creatorSubcompanyName(final String creatorSubcompanyName) {
         this.creatorSubcompanyName = creatorSubcompanyName;
         return this;
      }

      @JsonProperty("流程基本信息")
      public ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder workflowBaseInfo(final ZhongNanWorkFlowDTO workflowBaseInfo) {
         this.workflowBaseInfo = workflowBaseInfo;
         return this;
      }

      public ZhongNanWorkflowBaseInfo build() {
         return new ZhongNanWorkflowBaseInfo(
            this.createTime,
            this.creatorId,
            this.creatorName,
            this.currentNodeId,
            this.currentNodeName,
            this.lastOperateTime,
            this.lastOperatorId,
            this.lastOperatorName,
            this.receiveTime,
            this.requestId,
            this.requestLevel,
            this.requestName,
            this.status,
            this.sysName,
            this.requestmark,
            this.creatorDepartmentId,
            this.creatorDepartmentName,
            this.creatorSubcompanyId,
            this.creatorSubcompanyName,
            this.workflowBaseInfo
         );
      }

      @Override
      public String toString() {
         return "ZhongNanWorkflowBaseInfo.ZhongNanWorkflowBaseInfoBuilder(createTime="
            + this.createTime
            + ", creatorId="
            + this.creatorId
            + ", creatorName="
            + this.creatorName
            + ", currentNodeId="
            + this.currentNodeId
            + ", currentNodeName="
            + this.currentNodeName
            + ", lastOperateTime="
            + this.lastOperateTime
            + ", lastOperatorId="
            + this.lastOperatorId
            + ", lastOperatorName="
            + this.lastOperatorName
            + ", receiveTime="
            + this.receiveTime
            + ", requestId="
            + this.requestId
            + ", requestLevel="
            + this.requestLevel
            + ", requestName="
            + this.requestName
            + ", status="
            + this.status
            + ", sysName="
            + this.sysName
            + ", requestmark="
            + this.requestmark
            + ", creatorDepartmentId="
            + this.creatorDepartmentId
            + ", creatorDepartmentName="
            + this.creatorDepartmentName
            + ", creatorSubcompanyId="
            + this.creatorSubcompanyId
            + ", creatorSubcompanyName="
            + this.creatorSubcompanyName
            + ", workflowBaseInfo="
            + this.workflowBaseInfo
            + ")";
      }
   }
}
