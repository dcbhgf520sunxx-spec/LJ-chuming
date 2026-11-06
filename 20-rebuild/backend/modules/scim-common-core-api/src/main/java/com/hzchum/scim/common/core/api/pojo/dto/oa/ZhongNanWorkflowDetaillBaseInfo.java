package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel("OA返回审批流程详情数据数据")
public class ZhongNanWorkflowDetaillBaseInfo {
   @JsonProperty("是否可以编辑")
   private String canEdit;
   @JsonProperty("是否可以预览")
   private String canView;
   @JsonProperty("创建时间")
   private String createTime;
   @JsonProperty("创建人id")
   private String creatorId;
   @JsonProperty("创建人")
   private String creatorName;
   @JsonProperty("当前节点id")
   private String currentNodeId;
   @JsonProperty("当前节点名称")
   private String currentNodeName;
   @JsonProperty("按钮名称")
   private String forwardButtonName;
   @JsonProperty("最后操作时间")
   private String lastOperateTime;
   @JsonProperty("备注")
   private String remark;
   @JsonProperty("请求id")
   private String requestId;
   @JsonProperty("请求标题")
   private String requestName;
   @JsonProperty("请求等级")
   private String requestLevel;
   @JsonProperty("路径状态")
   private String status;
   @JsonProperty("流程基本信息")
   private ZhongNanWorkFlowDTO workflowBaseInfo;
   @JsonProperty("流程基本信息")
   private List<ZhongNanWorkflowMainTableInfo> workflowMainTableInfo;
   @JsonProperty("流程意见")
   private List<ZhongNanWorkflowRequestLogs> workflowRequestLogs;

   public static ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder builder() {
      return new ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder();
   }

   public ZhongNanWorkflowDetaillBaseInfo() {
   }

   public ZhongNanWorkflowDetaillBaseInfo(
      final String canEdit,
      final String canView,
      final String createTime,
      final String creatorId,
      final String creatorName,
      final String currentNodeId,
      final String currentNodeName,
      final String forwardButtonName,
      final String lastOperateTime,
      final String remark,
      final String requestId,
      final String requestName,
      final String requestLevel,
      final String status,
      final ZhongNanWorkFlowDTO workflowBaseInfo,
      final List<ZhongNanWorkflowMainTableInfo> workflowMainTableInfo,
      final List<ZhongNanWorkflowRequestLogs> workflowRequestLogs
   ) {
      this.canEdit = canEdit;
      this.canView = canView;
      this.createTime = createTime;
      this.creatorId = creatorId;
      this.creatorName = creatorName;
      this.currentNodeId = currentNodeId;
      this.currentNodeName = currentNodeName;
      this.forwardButtonName = forwardButtonName;
      this.lastOperateTime = lastOperateTime;
      this.remark = remark;
      this.requestId = requestId;
      this.requestName = requestName;
      this.requestLevel = requestLevel;
      this.status = status;
      this.workflowBaseInfo = workflowBaseInfo;
      this.workflowMainTableInfo = workflowMainTableInfo;
      this.workflowRequestLogs = workflowRequestLogs;
   }

   public String getCanEdit() {
      return this.canEdit;
   }

   public String getCanView() {
      return this.canView;
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

   public String getForwardButtonName() {
      return this.forwardButtonName;
   }

   public String getLastOperateTime() {
      return this.lastOperateTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getRequestId() {
      return this.requestId;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getRequestLevel() {
      return this.requestLevel;
   }

   public String getStatus() {
      return this.status;
   }

   public ZhongNanWorkFlowDTO getWorkflowBaseInfo() {
      return this.workflowBaseInfo;
   }

   public List<ZhongNanWorkflowMainTableInfo> getWorkflowMainTableInfo() {
      return this.workflowMainTableInfo;
   }

   public List<ZhongNanWorkflowRequestLogs> getWorkflowRequestLogs() {
      return this.workflowRequestLogs;
   }

   @JsonProperty("是否可以编辑")
   public ZhongNanWorkflowDetaillBaseInfo setCanEdit(final String canEdit) {
      this.canEdit = canEdit;
      return this;
   }

   @JsonProperty("是否可以预览")
   public ZhongNanWorkflowDetaillBaseInfo setCanView(final String canView) {
      this.canView = canView;
      return this;
   }

   @JsonProperty("创建时间")
   public ZhongNanWorkflowDetaillBaseInfo setCreateTime(final String createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("创建人id")
   public ZhongNanWorkflowDetaillBaseInfo setCreatorId(final String creatorId) {
      this.creatorId = creatorId;
      return this;
   }

   @JsonProperty("创建人")
   public ZhongNanWorkflowDetaillBaseInfo setCreatorName(final String creatorName) {
      this.creatorName = creatorName;
      return this;
   }

   @JsonProperty("当前节点id")
   public ZhongNanWorkflowDetaillBaseInfo setCurrentNodeId(final String currentNodeId) {
      this.currentNodeId = currentNodeId;
      return this;
   }

   @JsonProperty("当前节点名称")
   public ZhongNanWorkflowDetaillBaseInfo setCurrentNodeName(final String currentNodeName) {
      this.currentNodeName = currentNodeName;
      return this;
   }

   @JsonProperty("按钮名称")
   public ZhongNanWorkflowDetaillBaseInfo setForwardButtonName(final String forwardButtonName) {
      this.forwardButtonName = forwardButtonName;
      return this;
   }

   @JsonProperty("最后操作时间")
   public ZhongNanWorkflowDetaillBaseInfo setLastOperateTime(final String lastOperateTime) {
      this.lastOperateTime = lastOperateTime;
      return this;
   }

   @JsonProperty("备注")
   public ZhongNanWorkflowDetaillBaseInfo setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("请求id")
   public ZhongNanWorkflowDetaillBaseInfo setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   @JsonProperty("请求标题")
   public ZhongNanWorkflowDetaillBaseInfo setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   @JsonProperty("请求等级")
   public ZhongNanWorkflowDetaillBaseInfo setRequestLevel(final String requestLevel) {
      this.requestLevel = requestLevel;
      return this;
   }

   @JsonProperty("路径状态")
   public ZhongNanWorkflowDetaillBaseInfo setStatus(final String status) {
      this.status = status;
      return this;
   }

   @JsonProperty("流程基本信息")
   public ZhongNanWorkflowDetaillBaseInfo setWorkflowBaseInfo(final ZhongNanWorkFlowDTO workflowBaseInfo) {
      this.workflowBaseInfo = workflowBaseInfo;
      return this;
   }

   @JsonProperty("流程基本信息")
   public ZhongNanWorkflowDetaillBaseInfo setWorkflowMainTableInfo(final List<ZhongNanWorkflowMainTableInfo> workflowMainTableInfo) {
      this.workflowMainTableInfo = workflowMainTableInfo;
      return this;
   }

   @JsonProperty("流程意见")
   public ZhongNanWorkflowDetaillBaseInfo setWorkflowRequestLogs(final List<ZhongNanWorkflowRequestLogs> workflowRequestLogs) {
      this.workflowRequestLogs = workflowRequestLogs;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanWorkflowDetaillBaseInfo)) {
         return false;
      }

      ZhongNanWorkflowDetaillBaseInfo other = (ZhongNanWorkflowDetaillBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$canEdit = this.getCanEdit();
      Object other$canEdit = other.getCanEdit();
      if (this$canEdit == null ? other$canEdit == null : this$canEdit.equals(other$canEdit)) {
         Object this$canView = this.getCanView();
         Object other$canView = other.getCanView();
         if (this$canView == null ? other$canView == null : this$canView.equals(other$canView)) {
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
                           Object this$forwardButtonName = this.getForwardButtonName();
                           Object other$forwardButtonName = other.getForwardButtonName();
                           if (this$forwardButtonName == null ? other$forwardButtonName == null : this$forwardButtonName.equals(other$forwardButtonName)) {
                              Object this$lastOperateTime = this.getLastOperateTime();
                              Object other$lastOperateTime = other.getLastOperateTime();
                              if (this$lastOperateTime == null ? other$lastOperateTime == null : this$lastOperateTime.equals(other$lastOperateTime)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$requestId = this.getRequestId();
                                    Object other$requestId = other.getRequestId();
                                    if (this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId)) {
                                       Object this$requestName = this.getRequestName();
                                       Object other$requestName = other.getRequestName();
                                       if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
                                          Object this$requestLevel = this.getRequestLevel();
                                          Object other$requestLevel = other.getRequestLevel();
                                          if (this$requestLevel == null ? other$requestLevel == null : this$requestLevel.equals(other$requestLevel)) {
                                             Object this$status = this.getStatus();
                                             Object other$status = other.getStatus();
                                             if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                Object this$workflowBaseInfo = this.getWorkflowBaseInfo();
                                                Object other$workflowBaseInfo = other.getWorkflowBaseInfo();
                                                if (this$workflowBaseInfo == null
                                                   ? other$workflowBaseInfo == null
                                                   : this$workflowBaseInfo.equals(other$workflowBaseInfo)) {
                                                   Object this$workflowMainTableInfo = this.getWorkflowMainTableInfo();
                                                   Object other$workflowMainTableInfo = other.getWorkflowMainTableInfo();
                                                   if (this$workflowMainTableInfo == null
                                                      ? other$workflowMainTableInfo == null
                                                      : this$workflowMainTableInfo.equals(other$workflowMainTableInfo)) {
                                                      Object this$workflowRequestLogs = this.getWorkflowRequestLogs();
                                                      Object other$workflowRequestLogs = other.getWorkflowRequestLogs();
                                                      return this$workflowRequestLogs == null
                                                         ? other$workflowRequestLogs == null
                                                         : this$workflowRequestLogs.equals(other$workflowRequestLogs);
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
      return other instanceof ZhongNanWorkflowDetaillBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $canEdit = this.getCanEdit();
      result = result * 59 + ($canEdit == null ? 43 : $canEdit.hashCode());
      Object $canView = this.getCanView();
      result = result * 59 + ($canView == null ? 43 : $canView.hashCode());
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
      Object $forwardButtonName = this.getForwardButtonName();
      result = result * 59 + ($forwardButtonName == null ? 43 : $forwardButtonName.hashCode());
      Object $lastOperateTime = this.getLastOperateTime();
      result = result * 59 + ($lastOperateTime == null ? 43 : $lastOperateTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $requestId = this.getRequestId();
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $requestLevel = this.getRequestLevel();
      result = result * 59 + ($requestLevel == null ? 43 : $requestLevel.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $workflowBaseInfo = this.getWorkflowBaseInfo();
      result = result * 59 + ($workflowBaseInfo == null ? 43 : $workflowBaseInfo.hashCode());
      Object $workflowMainTableInfo = this.getWorkflowMainTableInfo();
      result = result * 59 + ($workflowMainTableInfo == null ? 43 : $workflowMainTableInfo.hashCode());
      Object $workflowRequestLogs = this.getWorkflowRequestLogs();
      return result * 59 + ($workflowRequestLogs == null ? 43 : $workflowRequestLogs.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanWorkflowDetaillBaseInfo(canEdit="
         + this.getCanEdit()
         + ", canView="
         + this.getCanView()
         + ", createTime="
         + this.getCreateTime()
         + ", creatorId="
         + this.getCreatorId()
         + ", creatorName="
         + this.getCreatorName()
         + ", currentNodeId="
         + this.getCurrentNodeId()
         + ", currentNodeName="
         + this.getCurrentNodeName()
         + ", forwardButtonName="
         + this.getForwardButtonName()
         + ", lastOperateTime="
         + this.getLastOperateTime()
         + ", remark="
         + this.getRemark()
         + ", requestId="
         + this.getRequestId()
         + ", requestName="
         + this.getRequestName()
         + ", requestLevel="
         + this.getRequestLevel()
         + ", status="
         + this.getStatus()
         + ", workflowBaseInfo="
         + this.getWorkflowBaseInfo()
         + ", workflowMainTableInfo="
         + this.getWorkflowMainTableInfo()
         + ", workflowRequestLogs="
         + this.getWorkflowRequestLogs()
         + ")";
   }

   public static class ZhongNanWorkflowDetaillBaseInfoBuilder {
      private String canEdit;
      private String canView;
      private String createTime;
      private String creatorId;
      private String creatorName;
      private String currentNodeId;
      private String currentNodeName;
      private String forwardButtonName;
      private String lastOperateTime;
      private String remark;
      private String requestId;
      private String requestName;
      private String requestLevel;
      private String status;
      private ZhongNanWorkFlowDTO workflowBaseInfo;
      private List<ZhongNanWorkflowMainTableInfo> workflowMainTableInfo;
      private List<ZhongNanWorkflowRequestLogs> workflowRequestLogs;

      ZhongNanWorkflowDetaillBaseInfoBuilder() {
      }

      @JsonProperty("是否可以编辑")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder canEdit(final String canEdit) {
         this.canEdit = canEdit;
         return this;
      }

      @JsonProperty("是否可以预览")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder canView(final String canView) {
         this.canView = canView;
         return this;
      }

      @JsonProperty("创建时间")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("创建人id")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder creatorId(final String creatorId) {
         this.creatorId = creatorId;
         return this;
      }

      @JsonProperty("创建人")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder creatorName(final String creatorName) {
         this.creatorName = creatorName;
         return this;
      }

      @JsonProperty("当前节点id")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder currentNodeId(final String currentNodeId) {
         this.currentNodeId = currentNodeId;
         return this;
      }

      @JsonProperty("当前节点名称")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder currentNodeName(final String currentNodeName) {
         this.currentNodeName = currentNodeName;
         return this;
      }

      @JsonProperty("按钮名称")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder forwardButtonName(final String forwardButtonName) {
         this.forwardButtonName = forwardButtonName;
         return this;
      }

      @JsonProperty("最后操作时间")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder lastOperateTime(final String lastOperateTime) {
         this.lastOperateTime = lastOperateTime;
         return this;
      }

      @JsonProperty("备注")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("请求id")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      @JsonProperty("请求标题")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      @JsonProperty("请求等级")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder requestLevel(final String requestLevel) {
         this.requestLevel = requestLevel;
         return this;
      }

      @JsonProperty("路径状态")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder status(final String status) {
         this.status = status;
         return this;
      }

      @JsonProperty("流程基本信息")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder workflowBaseInfo(final ZhongNanWorkFlowDTO workflowBaseInfo) {
         this.workflowBaseInfo = workflowBaseInfo;
         return this;
      }

      @JsonProperty("流程基本信息")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder workflowMainTableInfo(
         final List<ZhongNanWorkflowMainTableInfo> workflowMainTableInfo
      ) {
         this.workflowMainTableInfo = workflowMainTableInfo;
         return this;
      }

      @JsonProperty("流程意见")
      public ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder workflowRequestLogs(
         final List<ZhongNanWorkflowRequestLogs> workflowRequestLogs
      ) {
         this.workflowRequestLogs = workflowRequestLogs;
         return this;
      }

      public ZhongNanWorkflowDetaillBaseInfo build() {
         return new ZhongNanWorkflowDetaillBaseInfo(
            this.canEdit,
            this.canView,
            this.createTime,
            this.creatorId,
            this.creatorName,
            this.currentNodeId,
            this.currentNodeName,
            this.forwardButtonName,
            this.lastOperateTime,
            this.remark,
            this.requestId,
            this.requestName,
            this.requestLevel,
            this.status,
            this.workflowBaseInfo,
            this.workflowMainTableInfo,
            this.workflowRequestLogs
         );
      }

      @Override
      public String toString() {
         return "ZhongNanWorkflowDetaillBaseInfo.ZhongNanWorkflowDetaillBaseInfoBuilder(canEdit="
            + this.canEdit
            + ", canView="
            + this.canView
            + ", createTime="
            + this.createTime
            + ", creatorId="
            + this.creatorId
            + ", creatorName="
            + this.creatorName
            + ", currentNodeId="
            + this.currentNodeId
            + ", currentNodeName="
            + this.currentNodeName
            + ", forwardButtonName="
            + this.forwardButtonName
            + ", lastOperateTime="
            + this.lastOperateTime
            + ", remark="
            + this.remark
            + ", requestId="
            + this.requestId
            + ", requestName="
            + this.requestName
            + ", requestLevel="
            + this.requestLevel
            + ", status="
            + this.status
            + ", workflowBaseInfo="
            + this.workflowBaseInfo
            + ", workflowMainTableInfo="
            + this.workflowMainTableInfo
            + ", workflowRequestLogs="
            + this.workflowRequestLogs
            + ")";
      }
   }
}
