package com.hzchum.scim.rest.pojo.vo.mes.building.request.abnormal.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.AbnormalHandleDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.TaskChangeDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "HandlePreviewVORequest", description = "")
public class HandlePreviewVORequest {
   @ApiModelProperty(name = "abnormalId", notes = "异常id", value = "异常id")
   @JsonProperty("abnormalId")
   @JSONField(name = "abnormalId")
   private Long abnormalId;
   @ApiModelProperty(name = "taskList", notes = "任务列表", value = "任务列表")
   @JsonProperty("taskList")
   @JSONField(name = "taskList")
   private List<TaskChangeDTOParam> taskList;
   @ApiModelProperty(name = "reportList", notes = "上报列表", value = "上报列表")
   @JsonProperty("reportList")
   @JSONField(name = "reportList")
   private List<AbnormalHandleDTOParam> reportList;

   public static HandlePreviewVORequest.HandlePreviewVORequestBuilder builder() {
      return new HandlePreviewVORequest.HandlePreviewVORequestBuilder();
   }

   public HandlePreviewVORequest(final Long abnormalId, final List<TaskChangeDTOParam> taskList, final List<AbnormalHandleDTOParam> reportList) {
      this.abnormalId = abnormalId;
      this.taskList = taskList;
      this.reportList = reportList;
   }

   public HandlePreviewVORequest() {
   }

   public Long getAbnormalId() {
      return this.abnormalId;
   }

   public List<TaskChangeDTOParam> getTaskList() {
      return this.taskList;
   }

   public List<AbnormalHandleDTOParam> getReportList() {
      return this.reportList;
   }

   @JsonProperty("abnormalId")
   public HandlePreviewVORequest setAbnormalId(final Long abnormalId) {
      this.abnormalId = abnormalId;
      return this;
   }

   @JsonProperty("taskList")
   public HandlePreviewVORequest setTaskList(final List<TaskChangeDTOParam> taskList) {
      this.taskList = taskList;
      return this;
   }

   @JsonProperty("reportList")
   public HandlePreviewVORequest setReportList(final List<AbnormalHandleDTOParam> reportList) {
      this.reportList = reportList;
      return this;
   }

   @Override
   public String toString() {
      return "HandlePreviewVORequest(abnormalId=" + this.getAbnormalId() + ", taskList=" + this.getTaskList() + ", reportList=" + this.getReportList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof HandlePreviewVORequest)) {
         return false;
      }

      HandlePreviewVORequest other = (HandlePreviewVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$abnormalId = this.getAbnormalId();
      Object other$abnormalId = other.getAbnormalId();
      if (this$abnormalId == null ? other$abnormalId == null : this$abnormalId.equals(other$abnormalId)) {
         Object this$taskList = this.getTaskList();
         Object other$taskList = other.getTaskList();
         if (this$taskList == null ? other$taskList == null : this$taskList.equals(other$taskList)) {
            Object this$reportList = this.getReportList();
            Object other$reportList = other.getReportList();
            return this$reportList == null ? other$reportList == null : this$reportList.equals(other$reportList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof HandlePreviewVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $abnormalId = this.getAbnormalId();
      result = result * 59 + ($abnormalId == null ? 43 : $abnormalId.hashCode());
      Object $taskList = this.getTaskList();
      result = result * 59 + ($taskList == null ? 43 : $taskList.hashCode());
      Object $reportList = this.getReportList();
      return result * 59 + ($reportList == null ? 43 : $reportList.hashCode());
   }

   public static class HandlePreviewVORequestBuilder {
      private Long abnormalId;
      private List<TaskChangeDTOParam> taskList;
      private List<AbnormalHandleDTOParam> reportList;

      HandlePreviewVORequestBuilder() {
      }

      @JsonProperty("abnormalId")
      public HandlePreviewVORequest.HandlePreviewVORequestBuilder abnormalId(final Long abnormalId) {
         this.abnormalId = abnormalId;
         return this;
      }

      @JsonProperty("taskList")
      public HandlePreviewVORequest.HandlePreviewVORequestBuilder taskList(final List<TaskChangeDTOParam> taskList) {
         this.taskList = taskList;
         return this;
      }

      @JsonProperty("reportList")
      public HandlePreviewVORequest.HandlePreviewVORequestBuilder reportList(final List<AbnormalHandleDTOParam> reportList) {
         this.reportList = reportList;
         return this;
      }

      public HandlePreviewVORequest build() {
         return new HandlePreviewVORequest(this.abnormalId, this.taskList, this.reportList);
      }

      @Override
      public String toString() {
         return "HandlePreviewVORequest.HandlePreviewVORequestBuilder(abnormalId="
            + this.abnormalId
            + ", taskList="
            + this.taskList
            + ", reportList="
            + this.reportList
            + ")";
      }
   }
}
