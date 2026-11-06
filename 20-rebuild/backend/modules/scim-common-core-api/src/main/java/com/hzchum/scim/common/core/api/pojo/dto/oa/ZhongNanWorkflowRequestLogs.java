package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回审批流程详情流程意见")
public class ZhongNanWorkflowRequestLogs {
   @JsonProperty("是否可以编辑")
   private String annexDocHtmls;
   @JsonProperty("数据id")
   private String id;
   @JsonProperty("节点id")
   private String nodeId;
   @JsonProperty("节点名称")
   private String nodeName;
   @JsonProperty("操作年月日")
   private String operateDate;
   @JsonProperty("操作时分秒")
   private String operateTime;
   @JsonProperty("操作类型")
   private String operateType;
   @JsonProperty("操作部门")
   private String operatorDept;
   @JsonProperty("操作id")
   private String operatorId;
   @JsonProperty("操作人名称")
   private String operatorName;
   @JsonProperty("收到人")
   private String receivedPersons;
   @JsonProperty("意见")
   private String remark;
   @JsonProperty("")
   private String signDocHtmls;
   @JsonProperty("")
   private String signWorkFlowHtmls;

   public static ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder builder() {
      return new ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder();
   }

   public ZhongNanWorkflowRequestLogs() {
   }

   public ZhongNanWorkflowRequestLogs(
      final String annexDocHtmls,
      final String id,
      final String nodeId,
      final String nodeName,
      final String operateDate,
      final String operateTime,
      final String operateType,
      final String operatorDept,
      final String operatorId,
      final String operatorName,
      final String receivedPersons,
      final String remark,
      final String signDocHtmls,
      final String signWorkFlowHtmls
   ) {
      this.annexDocHtmls = annexDocHtmls;
      this.id = id;
      this.nodeId = nodeId;
      this.nodeName = nodeName;
      this.operateDate = operateDate;
      this.operateTime = operateTime;
      this.operateType = operateType;
      this.operatorDept = operatorDept;
      this.operatorId = operatorId;
      this.operatorName = operatorName;
      this.receivedPersons = receivedPersons;
      this.remark = remark;
      this.signDocHtmls = signDocHtmls;
      this.signWorkFlowHtmls = signWorkFlowHtmls;
   }

   public String getAnnexDocHtmls() {
      return this.annexDocHtmls;
   }

   public String getId() {
      return this.id;
   }

   public String getNodeId() {
      return this.nodeId;
   }

   public String getNodeName() {
      return this.nodeName;
   }

   public String getOperateDate() {
      return this.operateDate;
   }

   public String getOperateTime() {
      return this.operateTime;
   }

   public String getOperateType() {
      return this.operateType;
   }

   public String getOperatorDept() {
      return this.operatorDept;
   }

   public String getOperatorId() {
      return this.operatorId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public String getReceivedPersons() {
      return this.receivedPersons;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSignDocHtmls() {
      return this.signDocHtmls;
   }

   public String getSignWorkFlowHtmls() {
      return this.signWorkFlowHtmls;
   }

   @JsonProperty("是否可以编辑")
   public ZhongNanWorkflowRequestLogs setAnnexDocHtmls(final String annexDocHtmls) {
      this.annexDocHtmls = annexDocHtmls;
      return this;
   }

   @JsonProperty("数据id")
   public ZhongNanWorkflowRequestLogs setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("节点id")
   public ZhongNanWorkflowRequestLogs setNodeId(final String nodeId) {
      this.nodeId = nodeId;
      return this;
   }

   @JsonProperty("节点名称")
   public ZhongNanWorkflowRequestLogs setNodeName(final String nodeName) {
      this.nodeName = nodeName;
      return this;
   }

   @JsonProperty("操作年月日")
   public ZhongNanWorkflowRequestLogs setOperateDate(final String operateDate) {
      this.operateDate = operateDate;
      return this;
   }

   @JsonProperty("操作时分秒")
   public ZhongNanWorkflowRequestLogs setOperateTime(final String operateTime) {
      this.operateTime = operateTime;
      return this;
   }

   @JsonProperty("操作类型")
   public ZhongNanWorkflowRequestLogs setOperateType(final String operateType) {
      this.operateType = operateType;
      return this;
   }

   @JsonProperty("操作部门")
   public ZhongNanWorkflowRequestLogs setOperatorDept(final String operatorDept) {
      this.operatorDept = operatorDept;
      return this;
   }

   @JsonProperty("操作id")
   public ZhongNanWorkflowRequestLogs setOperatorId(final String operatorId) {
      this.operatorId = operatorId;
      return this;
   }

   @JsonProperty("操作人名称")
   public ZhongNanWorkflowRequestLogs setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
      return this;
   }

   @JsonProperty("收到人")
   public ZhongNanWorkflowRequestLogs setReceivedPersons(final String receivedPersons) {
      this.receivedPersons = receivedPersons;
      return this;
   }

   @JsonProperty("意见")
   public ZhongNanWorkflowRequestLogs setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("")
   public ZhongNanWorkflowRequestLogs setSignDocHtmls(final String signDocHtmls) {
      this.signDocHtmls = signDocHtmls;
      return this;
   }

   @JsonProperty("")
   public ZhongNanWorkflowRequestLogs setSignWorkFlowHtmls(final String signWorkFlowHtmls) {
      this.signWorkFlowHtmls = signWorkFlowHtmls;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanWorkflowRequestLogs)) {
         return false;
      }

      ZhongNanWorkflowRequestLogs other = (ZhongNanWorkflowRequestLogs)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$annexDocHtmls = this.getAnnexDocHtmls();
      Object other$annexDocHtmls = other.getAnnexDocHtmls();
      if (this$annexDocHtmls == null ? other$annexDocHtmls == null : this$annexDocHtmls.equals(other$annexDocHtmls)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$nodeId = this.getNodeId();
            Object other$nodeId = other.getNodeId();
            if (this$nodeId == null ? other$nodeId == null : this$nodeId.equals(other$nodeId)) {
               Object this$nodeName = this.getNodeName();
               Object other$nodeName = other.getNodeName();
               if (this$nodeName == null ? other$nodeName == null : this$nodeName.equals(other$nodeName)) {
                  Object this$operateDate = this.getOperateDate();
                  Object other$operateDate = other.getOperateDate();
                  if (this$operateDate == null ? other$operateDate == null : this$operateDate.equals(other$operateDate)) {
                     Object this$operateTime = this.getOperateTime();
                     Object other$operateTime = other.getOperateTime();
                     if (this$operateTime == null ? other$operateTime == null : this$operateTime.equals(other$operateTime)) {
                        Object this$operateType = this.getOperateType();
                        Object other$operateType = other.getOperateType();
                        if (this$operateType == null ? other$operateType == null : this$operateType.equals(other$operateType)) {
                           Object this$operatorDept = this.getOperatorDept();
                           Object other$operatorDept = other.getOperatorDept();
                           if (this$operatorDept == null ? other$operatorDept == null : this$operatorDept.equals(other$operatorDept)) {
                              Object this$operatorId = this.getOperatorId();
                              Object other$operatorId = other.getOperatorId();
                              if (this$operatorId == null ? other$operatorId == null : this$operatorId.equals(other$operatorId)) {
                                 Object this$operatorName = this.getOperatorName();
                                 Object other$operatorName = other.getOperatorName();
                                 if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                    Object this$receivedPersons = this.getReceivedPersons();
                                    Object other$receivedPersons = other.getReceivedPersons();
                                    if (this$receivedPersons == null ? other$receivedPersons == null : this$receivedPersons.equals(other$receivedPersons)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$signDocHtmls = this.getSignDocHtmls();
                                          Object other$signDocHtmls = other.getSignDocHtmls();
                                          if (this$signDocHtmls == null ? other$signDocHtmls == null : this$signDocHtmls.equals(other$signDocHtmls)) {
                                             Object this$signWorkFlowHtmls = this.getSignWorkFlowHtmls();
                                             Object other$signWorkFlowHtmls = other.getSignWorkFlowHtmls();
                                             return this$signWorkFlowHtmls == null
                                                ? other$signWorkFlowHtmls == null
                                                : this$signWorkFlowHtmls.equals(other$signWorkFlowHtmls);
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
      return other instanceof ZhongNanWorkflowRequestLogs;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $annexDocHtmls = this.getAnnexDocHtmls();
      result = result * 59 + ($annexDocHtmls == null ? 43 : $annexDocHtmls.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $nodeId = this.getNodeId();
      result = result * 59 + ($nodeId == null ? 43 : $nodeId.hashCode());
      Object $nodeName = this.getNodeName();
      result = result * 59 + ($nodeName == null ? 43 : $nodeName.hashCode());
      Object $operateDate = this.getOperateDate();
      result = result * 59 + ($operateDate == null ? 43 : $operateDate.hashCode());
      Object $operateTime = this.getOperateTime();
      result = result * 59 + ($operateTime == null ? 43 : $operateTime.hashCode());
      Object $operateType = this.getOperateType();
      result = result * 59 + ($operateType == null ? 43 : $operateType.hashCode());
      Object $operatorDept = this.getOperatorDept();
      result = result * 59 + ($operatorDept == null ? 43 : $operatorDept.hashCode());
      Object $operatorId = this.getOperatorId();
      result = result * 59 + ($operatorId == null ? 43 : $operatorId.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $receivedPersons = this.getReceivedPersons();
      result = result * 59 + ($receivedPersons == null ? 43 : $receivedPersons.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $signDocHtmls = this.getSignDocHtmls();
      result = result * 59 + ($signDocHtmls == null ? 43 : $signDocHtmls.hashCode());
      Object $signWorkFlowHtmls = this.getSignWorkFlowHtmls();
      return result * 59 + ($signWorkFlowHtmls == null ? 43 : $signWorkFlowHtmls.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanWorkflowRequestLogs(annexDocHtmls="
         + this.getAnnexDocHtmls()
         + ", id="
         + this.getId()
         + ", nodeId="
         + this.getNodeId()
         + ", nodeName="
         + this.getNodeName()
         + ", operateDate="
         + this.getOperateDate()
         + ", operateTime="
         + this.getOperateTime()
         + ", operateType="
         + this.getOperateType()
         + ", operatorDept="
         + this.getOperatorDept()
         + ", operatorId="
         + this.getOperatorId()
         + ", operatorName="
         + this.getOperatorName()
         + ", receivedPersons="
         + this.getReceivedPersons()
         + ", remark="
         + this.getRemark()
         + ", signDocHtmls="
         + this.getSignDocHtmls()
         + ", signWorkFlowHtmls="
         + this.getSignWorkFlowHtmls()
         + ")";
   }

   public static class ZhongNanWorkflowRequestLogsBuilder {
      private String annexDocHtmls;
      private String id;
      private String nodeId;
      private String nodeName;
      private String operateDate;
      private String operateTime;
      private String operateType;
      private String operatorDept;
      private String operatorId;
      private String operatorName;
      private String receivedPersons;
      private String remark;
      private String signDocHtmls;
      private String signWorkFlowHtmls;

      ZhongNanWorkflowRequestLogsBuilder() {
      }

      @JsonProperty("是否可以编辑")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder annexDocHtmls(final String annexDocHtmls) {
         this.annexDocHtmls = annexDocHtmls;
         return this;
      }

      @JsonProperty("数据id")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("节点id")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder nodeId(final String nodeId) {
         this.nodeId = nodeId;
         return this;
      }

      @JsonProperty("节点名称")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder nodeName(final String nodeName) {
         this.nodeName = nodeName;
         return this;
      }

      @JsonProperty("操作年月日")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder operateDate(final String operateDate) {
         this.operateDate = operateDate;
         return this;
      }

      @JsonProperty("操作时分秒")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder operateTime(final String operateTime) {
         this.operateTime = operateTime;
         return this;
      }

      @JsonProperty("操作类型")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder operateType(final String operateType) {
         this.operateType = operateType;
         return this;
      }

      @JsonProperty("操作部门")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder operatorDept(final String operatorDept) {
         this.operatorDept = operatorDept;
         return this;
      }

      @JsonProperty("操作id")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder operatorId(final String operatorId) {
         this.operatorId = operatorId;
         return this;
      }

      @JsonProperty("操作人名称")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      @JsonProperty("收到人")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder receivedPersons(final String receivedPersons) {
         this.receivedPersons = receivedPersons;
         return this;
      }

      @JsonProperty("意见")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder signDocHtmls(final String signDocHtmls) {
         this.signDocHtmls = signDocHtmls;
         return this;
      }

      @JsonProperty("")
      public ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder signWorkFlowHtmls(final String signWorkFlowHtmls) {
         this.signWorkFlowHtmls = signWorkFlowHtmls;
         return this;
      }

      public ZhongNanWorkflowRequestLogs build() {
         return new ZhongNanWorkflowRequestLogs(
            this.annexDocHtmls,
            this.id,
            this.nodeId,
            this.nodeName,
            this.operateDate,
            this.operateTime,
            this.operateType,
            this.operatorDept,
            this.operatorId,
            this.operatorName,
            this.receivedPersons,
            this.remark,
            this.signDocHtmls,
            this.signWorkFlowHtmls
         );
      }

      @Override
      public String toString() {
         return "ZhongNanWorkflowRequestLogs.ZhongNanWorkflowRequestLogsBuilder(annexDocHtmls="
            + this.annexDocHtmls
            + ", id="
            + this.id
            + ", nodeId="
            + this.nodeId
            + ", nodeName="
            + this.nodeName
            + ", operateDate="
            + this.operateDate
            + ", operateTime="
            + this.operateTime
            + ", operateType="
            + this.operateType
            + ", operatorDept="
            + this.operatorDept
            + ", operatorId="
            + this.operatorId
            + ", operatorName="
            + this.operatorName
            + ", receivedPersons="
            + this.receivedPersons
            + ", remark="
            + this.remark
            + ", signDocHtmls="
            + this.signDocHtmls
            + ", signWorkFlowHtmls="
            + this.signWorkFlowHtmls
            + ")";
      }
   }
}
