package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AppTaskOrderSummaryDTO", description = "可生产的任务工单")
public class AppTaskOrderSummaryDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "schedulingId", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "assistGroupId", value = "班组id", notes = "班组id")
   private Long assistGroupId;
   @ApiModelProperty(name = "assistLineId", notes = "协同任务任务上报生产线id", value = "协同任务任务上报生产线id")
   private Long assistLineId;
   @ApiModelProperty(name = "completeQuantity", notes = "完成任务数")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "cutName", notes = "切割名称")
   @JsonProperty("cutName")
   @JSONField(name = "cutName")
   private String cutName;
   @ApiModelProperty(name = "cutType", notes = "切割方式名称")
   @JsonProperty("cutType")
   @JSONField(name = "cutType")
   private Integer cutType;
   @ApiModelProperty(name = "netWeight", notes = "重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "boolAssist", notes = "是否协同")
   @JsonProperty("boolAssist")
   @JSONField(name = "boolAssist")
   private Boolean boolAssist;
   @ApiModelProperty(name = "userName", notes = "排产人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   private LocalDateTime schedulingDate;
   @ApiModelProperty(name = "cutTypeName", notes = "切割方式名称")
   @JsonProperty("cutTypeName")
   @JSONField(name = "cutTypeName")
   private String cutTypeName;
   @ApiModelProperty(name = "bcGuid", notes = "钢板id")
   @JsonProperty("bcGuid")
   @JSONField(name = "bcGuid")
   private String bcGuid;
   @ApiModelProperty(name = "jobId", notes = "工单id")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   private Long jobId;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess;
   @ApiModelProperty(name = "approveState", value = "材料是否申领 1是 0否 2审批中 3无材料申领")
   @JsonProperty("approveState")
   @JSONField(name = "approveState")
   private Integer approveState;

   public static AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder builder() {
      return new AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder();
   }

   public AppTaskOrderSummaryDTO() {
   }

   public AppTaskOrderSummaryDTO(
      final Long id,
      final Long schedulingId,
      final ProjectDetailDO project,
      final Integer quantity,
      final Long assistGroupId,
      final Long assistLineId,
      final Integer completeQuantity,
      final LocalDateTime askCompleteTime,
      final String orderNumber,
      final String cutName,
      final Integer cutType,
      final BigDecimal netWeight,
      final Boolean boolAssist,
      final String userName,
      final LocalDateTime schedulingDate,
      final String cutTypeName,
      final String bcGuid,
      final Long jobId,
      final Boolean boolProcess,
      final Integer approveState
   ) {
      this.id = id;
      this.schedulingId = schedulingId;
      this.project = project;
      this.quantity = quantity;
      this.assistGroupId = assistGroupId;
      this.assistLineId = assistLineId;
      this.completeQuantity = completeQuantity;
      this.askCompleteTime = askCompleteTime;
      this.orderNumber = orderNumber;
      this.cutName = cutName;
      this.cutType = cutType;
      this.netWeight = netWeight;
      this.boolAssist = boolAssist;
      this.userName = userName;
      this.schedulingDate = schedulingDate;
      this.cutTypeName = cutTypeName;
      this.bcGuid = bcGuid;
      this.jobId = jobId;
      this.boolProcess = boolProcess;
      this.approveState = approveState;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getAssistGroupId() {
      return this.assistGroupId;
   }

   public Long getAssistLineId() {
      return this.assistLineId;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getCutName() {
      return this.cutName;
   }

   public Integer getCutType() {
      return this.cutType;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getSchedulingDate() {
      return this.schedulingDate;
   }

   public String getCutTypeName() {
      return this.cutTypeName;
   }

   public String getBcGuid() {
      return this.bcGuid;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Integer getApproveState() {
      return this.approveState;
   }

   @JsonProperty("id")
   public AppTaskOrderSummaryDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("schedulingId")
   public AppTaskOrderSummaryDTO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("project")
   public AppTaskOrderSummaryDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskOrderSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public AppTaskOrderSummaryDTO setAssistGroupId(final Long assistGroupId) {
      this.assistGroupId = assistGroupId;
      return this;
   }

   public AppTaskOrderSummaryDTO setAssistLineId(final Long assistLineId) {
      this.assistLineId = assistLineId;
      return this;
   }

   @JsonProperty("completeQuantity")
   public AppTaskOrderSummaryDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskOrderSummaryDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTaskOrderSummaryDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("cutName")
   public AppTaskOrderSummaryDTO setCutName(final String cutName) {
      this.cutName = cutName;
      return this;
   }

   @JsonProperty("cutType")
   public AppTaskOrderSummaryDTO setCutType(final Integer cutType) {
      this.cutType = cutType;
      return this;
   }

   @JsonProperty("netWeight")
   public AppTaskOrderSummaryDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("boolAssist")
   public AppTaskOrderSummaryDTO setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
      return this;
   }

   @JsonProperty("userName")
   public AppTaskOrderSummaryDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("schedulingDate")
   public AppTaskOrderSummaryDTO setSchedulingDate(final LocalDateTime schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("cutTypeName")
   public AppTaskOrderSummaryDTO setCutTypeName(final String cutTypeName) {
      this.cutTypeName = cutTypeName;
      return this;
   }

   @JsonProperty("bcGuid")
   public AppTaskOrderSummaryDTO setBcGuid(final String bcGuid) {
      this.bcGuid = bcGuid;
      return this;
   }

   @JsonProperty("jobId")
   public AppTaskOrderSummaryDTO setJobId(final Long jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("boolProcess")
   public AppTaskOrderSummaryDTO setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @JsonProperty("approveState")
   public AppTaskOrderSummaryDTO setApproveState(final Integer approveState) {
      this.approveState = approveState;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskOrderSummaryDTO(id="
         + this.getId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", assistGroupId="
         + this.getAssistGroupId()
         + ", assistLineId="
         + this.getAssistLineId()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", cutName="
         + this.getCutName()
         + ", cutType="
         + this.getCutType()
         + ", netWeight="
         + this.getNetWeight()
         + ", boolAssist="
         + this.getBoolAssist()
         + ", userName="
         + this.getUserName()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", cutTypeName="
         + this.getCutTypeName()
         + ", bcGuid="
         + this.getBcGuid()
         + ", jobId="
         + this.getJobId()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", approveState="
         + this.getApproveState()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskOrderSummaryDTO)) {
         return false;
      }

      AppTaskOrderSummaryDTO other = (AppTaskOrderSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$schedulingId = this.getSchedulingId();
         Object other$schedulingId = other.getSchedulingId();
         if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$assistGroupId = this.getAssistGroupId();
               Object other$assistGroupId = other.getAssistGroupId();
               if (this$assistGroupId == null ? other$assistGroupId == null : this$assistGroupId.equals(other$assistGroupId)) {
                  Object this$assistLineId = this.getAssistLineId();
                  Object other$assistLineId = other.getAssistLineId();
                  if (this$assistLineId == null ? other$assistLineId == null : this$assistLineId.equals(other$assistLineId)) {
                     Object this$completeQuantity = this.getCompleteQuantity();
                     Object other$completeQuantity = other.getCompleteQuantity();
                     if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                        Object this$cutType = this.getCutType();
                        Object other$cutType = other.getCutType();
                        if (this$cutType == null ? other$cutType == null : this$cutType.equals(other$cutType)) {
                           Object this$boolAssist = this.getBoolAssist();
                           Object other$boolAssist = other.getBoolAssist();
                           if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
                              Object this$jobId = this.getJobId();
                              Object other$jobId = other.getJobId();
                              if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                                 Object this$boolProcess = this.getBoolProcess();
                                 Object other$boolProcess = other.getBoolProcess();
                                 if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                    Object this$approveState = this.getApproveState();
                                    Object other$approveState = other.getApproveState();
                                    if (this$approveState == null ? other$approveState == null : this$approveState.equals(other$approveState)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$askCompleteTime = this.getAskCompleteTime();
                                          Object other$askCompleteTime = other.getAskCompleteTime();
                                          if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)
                                             )
                                           {
                                             Object this$orderNumber = this.getOrderNumber();
                                             Object other$orderNumber = other.getOrderNumber();
                                             if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                                Object this$cutName = this.getCutName();
                                                Object other$cutName = other.getCutName();
                                                if (this$cutName == null ? other$cutName == null : this$cutName.equals(other$cutName)) {
                                                   Object this$netWeight = this.getNetWeight();
                                                   Object other$netWeight = other.getNetWeight();
                                                   if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                      Object this$userName = this.getUserName();
                                                      Object other$userName = other.getUserName();
                                                      if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                         Object this$schedulingDate = this.getSchedulingDate();
                                                         Object other$schedulingDate = other.getSchedulingDate();
                                                         if (this$schedulingDate == null
                                                            ? other$schedulingDate == null
                                                            : this$schedulingDate.equals(other$schedulingDate)) {
                                                            Object this$cutTypeName = this.getCutTypeName();
                                                            Object other$cutTypeName = other.getCutTypeName();
                                                            if (this$cutTypeName == null
                                                               ? other$cutTypeName == null
                                                               : this$cutTypeName.equals(other$cutTypeName)) {
                                                               Object this$bcGuid = this.getBcGuid();
                                                               Object other$bcGuid = other.getBcGuid();
                                                               return this$bcGuid == null ? other$bcGuid == null : this$bcGuid.equals(other$bcGuid);
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
      return other instanceof AppTaskOrderSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assistGroupId = this.getAssistGroupId();
      result = result * 59 + ($assistGroupId == null ? 43 : $assistGroupId.hashCode());
      Object $assistLineId = this.getAssistLineId();
      result = result * 59 + ($assistLineId == null ? 43 : $assistLineId.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $cutType = this.getCutType();
      result = result * 59 + ($cutType == null ? 43 : $cutType.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $approveState = this.getApproveState();
      result = result * 59 + ($approveState == null ? 43 : $approveState.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $cutName = this.getCutName();
      result = result * 59 + ($cutName == null ? 43 : $cutName.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $cutTypeName = this.getCutTypeName();
      result = result * 59 + ($cutTypeName == null ? 43 : $cutTypeName.hashCode());
      Object $bcGuid = this.getBcGuid();
      return result * 59 + ($bcGuid == null ? 43 : $bcGuid.hashCode());
   }

   public static class AppTaskOrderSummaryDTOBuilder {
      private Long id;
      private Long schedulingId;
      private ProjectDetailDO project;
      private Integer quantity;
      private Long assistGroupId;
      private Long assistLineId;
      private Integer completeQuantity;
      private LocalDateTime askCompleteTime;
      private String orderNumber;
      private String cutName;
      private Integer cutType;
      private BigDecimal netWeight;
      private Boolean boolAssist;
      private String userName;
      private LocalDateTime schedulingDate;
      private String cutTypeName;
      private String bcGuid;
      private Long jobId;
      private Boolean boolProcess;
      private Integer approveState;

      AppTaskOrderSummaryDTOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("schedulingId")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("project")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder assistGroupId(final Long assistGroupId) {
         this.assistGroupId = assistGroupId;
         return this;
      }

      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder assistLineId(final Long assistLineId) {
         this.assistLineId = assistLineId;
         return this;
      }

      @JsonProperty("completeQuantity")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("cutName")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder cutName(final String cutName) {
         this.cutName = cutName;
         return this;
      }

      @JsonProperty("cutType")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder cutType(final Integer cutType) {
         this.cutType = cutType;
         return this;
      }

      @JsonProperty("netWeight")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("boolAssist")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      @JsonProperty("userName")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("schedulingDate")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder schedulingDate(final LocalDateTime schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("cutTypeName")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder cutTypeName(final String cutTypeName) {
         this.cutTypeName = cutTypeName;
         return this;
      }

      @JsonProperty("bcGuid")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder bcGuid(final String bcGuid) {
         this.bcGuid = bcGuid;
         return this;
      }

      @JsonProperty("jobId")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("boolProcess")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      @JsonProperty("approveState")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder approveState(final Integer approveState) {
         this.approveState = approveState;
         return this;
      }

      public AppTaskOrderSummaryDTO build() {
         return new AppTaskOrderSummaryDTO(
            this.id,
            this.schedulingId,
            this.project,
            this.quantity,
            this.assistGroupId,
            this.assistLineId,
            this.completeQuantity,
            this.askCompleteTime,
            this.orderNumber,
            this.cutName,
            this.cutType,
            this.netWeight,
            this.boolAssist,
            this.userName,
            this.schedulingDate,
            this.cutTypeName,
            this.bcGuid,
            this.jobId,
            this.boolProcess,
            this.approveState
         );
      }

      @Override
      public String toString() {
         return "AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder(id="
            + this.id
            + ", schedulingId="
            + this.schedulingId
            + ", project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", assistGroupId="
            + this.assistGroupId
            + ", assistLineId="
            + this.assistLineId
            + ", completeQuantity="
            + this.completeQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", orderNumber="
            + this.orderNumber
            + ", cutName="
            + this.cutName
            + ", cutType="
            + this.cutType
            + ", netWeight="
            + this.netWeight
            + ", boolAssist="
            + this.boolAssist
            + ", userName="
            + this.userName
            + ", schedulingDate="
            + this.schedulingDate
            + ", cutTypeName="
            + this.cutTypeName
            + ", bcGuid="
            + this.bcGuid
            + ", jobId="
            + this.jobId
            + ", boolProcess="
            + this.boolProcess
            + ", approveState="
            + this.approveState
            + ")";
      }
   }
}
