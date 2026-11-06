package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "APPAutoCutTaskSummaryDTO", description = "自动切割任务")
public class APPAutoCutTaskSummaryDTO {
   @ApiModelProperty(name = "userName", notes = "排产人")
   @JsonProperty("userName")
   private String userName;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   private LocalDateTime schedulingDate;
   @ApiModelProperty(name = "appAutoCutSchedulingDetailList", notes = "排产信息")
   @JsonProperty("appAutoCutSchedulingDetailList")
   @JSONField(name = "appAutoCutSchedulingDetailList")
   private List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList;
   @ApiModelProperty(name = "taskOrderId", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "jobId", notes = "作业Id")
   @JsonProperty("jobId")
   private Long jobId;
   @ApiModelProperty(name = "jobName", notes = "作业名称")
   @JsonProperty("jobName")
   private String jobName;
   @ApiModelProperty(name = "quantity", notes = "钢板数量")
   @JsonProperty("quantity")
   private Integer quantity;
   @ApiModelProperty(name = "partQuantity", notes = "钢板数量")
   @JsonProperty("partQuantity")
   private Integer partQuantity;
   @ApiModelProperty(name = "buGuids", notes = "bu_guids")
   @JsonProperty("buGuids")
   private List<String> buGuids;
   @ApiModelProperty(name = "approveState", value = "材料是否申领 1是 0否 2审批中 3无材料申领")
   @JsonProperty("approveState")
   @JSONField(name = "approveState")
   private Integer approveState;
   @ApiModelProperty("项目")
   private ProjectDetailDO project;

   public static APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder builder() {
      return new APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder();
   }

   public APPAutoCutTaskSummaryDTO() {
   }

   public APPAutoCutTaskSummaryDTO(
      final String userName,
      final LocalDateTime schedulingDate,
      final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList,
      final Long taskOrderId,
      final Long jobId,
      final String jobName,
      final Integer quantity,
      final Integer partQuantity,
      final List<String> buGuids,
      final Integer approveState,
      final ProjectDetailDO project
   ) {
      this.userName = userName;
      this.schedulingDate = schedulingDate;
      this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
      this.taskOrderId = taskOrderId;
      this.jobId = jobId;
      this.jobName = jobName;
      this.quantity = quantity;
      this.partQuantity = partQuantity;
      this.buGuids = buGuids;
      this.approveState = approveState;
      this.project = project;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getSchedulingDate() {
      return this.schedulingDate;
   }

   public List<APPAutoCutSchedulingDetail> getAppAutoCutSchedulingDetailList() {
      return this.appAutoCutSchedulingDetailList;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public String getJobName() {
      return this.jobName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getPartQuantity() {
      return this.partQuantity;
   }

   public List<String> getBuGuids() {
      return this.buGuids;
   }

   public Integer getApproveState() {
      return this.approveState;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   @JsonProperty("userName")
   public APPAutoCutTaskSummaryDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("schedulingDate")
   public APPAutoCutTaskSummaryDTO setSchedulingDate(final LocalDateTime schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("appAutoCutSchedulingDetailList")
   public APPAutoCutTaskSummaryDTO setAppAutoCutSchedulingDetailList(final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList) {
      this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
      return this;
   }

   @JsonProperty("taskOrderId")
   public APPAutoCutTaskSummaryDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("jobId")
   public APPAutoCutTaskSummaryDTO setJobId(final Long jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("jobName")
   public APPAutoCutTaskSummaryDTO setJobName(final String jobName) {
      this.jobName = jobName;
      return this;
   }

   @JsonProperty("quantity")
   public APPAutoCutTaskSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("partQuantity")
   public APPAutoCutTaskSummaryDTO setPartQuantity(final Integer partQuantity) {
      this.partQuantity = partQuantity;
      return this;
   }

   @JsonProperty("buGuids")
   public APPAutoCutTaskSummaryDTO setBuGuids(final List<String> buGuids) {
      this.buGuids = buGuids;
      return this;
   }

   @JsonProperty("approveState")
   public APPAutoCutTaskSummaryDTO setApproveState(final Integer approveState) {
      this.approveState = approveState;
      return this;
   }

   public APPAutoCutTaskSummaryDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @Override
   public String toString() {
      return "APPAutoCutTaskSummaryDTO(userName="
         + this.getUserName()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", appAutoCutSchedulingDetailList="
         + this.getAppAutoCutSchedulingDetailList()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", jobId="
         + this.getJobId()
         + ", jobName="
         + this.getJobName()
         + ", quantity="
         + this.getQuantity()
         + ", partQuantity="
         + this.getPartQuantity()
         + ", buGuids="
         + this.getBuGuids()
         + ", approveState="
         + this.getApproveState()
         + ", project="
         + this.getProject()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPAutoCutTaskSummaryDTO)) {
         return false;
      }

      APPAutoCutTaskSummaryDTO other = (APPAutoCutTaskSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$partQuantity = this.getPartQuantity();
               Object other$partQuantity = other.getPartQuantity();
               if (this$partQuantity == null ? other$partQuantity == null : this$partQuantity.equals(other$partQuantity)) {
                  Object this$approveState = this.getApproveState();
                  Object other$approveState = other.getApproveState();
                  if (this$approveState == null ? other$approveState == null : this$approveState.equals(other$approveState)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$schedulingDate = this.getSchedulingDate();
                        Object other$schedulingDate = other.getSchedulingDate();
                        if (this$schedulingDate == null ? other$schedulingDate == null : this$schedulingDate.equals(other$schedulingDate)) {
                           Object this$appAutoCutSchedulingDetailList = this.getAppAutoCutSchedulingDetailList();
                           Object other$appAutoCutSchedulingDetailList = other.getAppAutoCutSchedulingDetailList();
                           if (this$appAutoCutSchedulingDetailList == null
                              ? other$appAutoCutSchedulingDetailList == null
                              : this$appAutoCutSchedulingDetailList.equals(other$appAutoCutSchedulingDetailList)) {
                              Object this$jobName = this.getJobName();
                              Object other$jobName = other.getJobName();
                              if (this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName)) {
                                 Object this$buGuids = this.getBuGuids();
                                 Object other$buGuids = other.getBuGuids();
                                 if (this$buGuids == null ? other$buGuids == null : this$buGuids.equals(other$buGuids)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof APPAutoCutTaskSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $partQuantity = this.getPartQuantity();
      result = result * 59 + ($partQuantity == null ? 43 : $partQuantity.hashCode());
      Object $approveState = this.getApproveState();
      result = result * 59 + ($approveState == null ? 43 : $approveState.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $appAutoCutSchedulingDetailList = this.getAppAutoCutSchedulingDetailList();
      result = result * 59 + ($appAutoCutSchedulingDetailList == null ? 43 : $appAutoCutSchedulingDetailList.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $buGuids = this.getBuGuids();
      result = result * 59 + ($buGuids == null ? 43 : $buGuids.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   public static class APPAutoCutTaskSummaryDTOBuilder {
      private String userName;
      private LocalDateTime schedulingDate;
      private List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList;
      private Long taskOrderId;
      private Long jobId;
      private String jobName;
      private Integer quantity;
      private Integer partQuantity;
      private List<String> buGuids;
      private Integer approveState;
      private ProjectDetailDO project;

      APPAutoCutTaskSummaryDTOBuilder() {
      }

      @JsonProperty("userName")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("schedulingDate")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder schedulingDate(final LocalDateTime schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("appAutoCutSchedulingDetailList")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder appAutoCutSchedulingDetailList(
         final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList
      ) {
         this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
         return this;
      }

      @JsonProperty("taskOrderId")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("jobId")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("jobName")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      @JsonProperty("quantity")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("partQuantity")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder partQuantity(final Integer partQuantity) {
         this.partQuantity = partQuantity;
         return this;
      }

      @JsonProperty("buGuids")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder buGuids(final List<String> buGuids) {
         this.buGuids = buGuids;
         return this;
      }

      @JsonProperty("approveState")
      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder approveState(final Integer approveState) {
         this.approveState = approveState;
         return this;
      }

      public APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      public APPAutoCutTaskSummaryDTO build() {
         return new APPAutoCutTaskSummaryDTO(
            this.userName,
            this.schedulingDate,
            this.appAutoCutSchedulingDetailList,
            this.taskOrderId,
            this.jobId,
            this.jobName,
            this.quantity,
            this.partQuantity,
            this.buGuids,
            this.approveState,
            this.project
         );
      }

      @Override
      public String toString() {
         return "APPAutoCutTaskSummaryDTO.APPAutoCutTaskSummaryDTOBuilder(userName="
            + this.userName
            + ", schedulingDate="
            + this.schedulingDate
            + ", appAutoCutSchedulingDetailList="
            + this.appAutoCutSchedulingDetailList
            + ", taskOrderId="
            + this.taskOrderId
            + ", jobId="
            + this.jobId
            + ", jobName="
            + this.jobName
            + ", quantity="
            + this.quantity
            + ", partQuantity="
            + this.partQuantity
            + ", buGuids="
            + this.buGuids
            + ", approveState="
            + this.approveState
            + ", project="
            + this.project
            + ")";
      }
   }
}
