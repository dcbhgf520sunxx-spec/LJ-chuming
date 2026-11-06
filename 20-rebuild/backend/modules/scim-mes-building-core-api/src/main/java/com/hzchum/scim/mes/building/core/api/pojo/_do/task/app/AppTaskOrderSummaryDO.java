package com.hzchum.scim.mes.building.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AppTaskOrderSummaryDO", description = "可生产的任务工单")
public class AppTaskOrderSummaryDO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "orderNumber", notes = "工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
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
   @ApiModelProperty(name = "completeQuantity", notes = "完成任务数")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "cutName", notes = "切割名称")
   @JsonProperty("cutName")
   @JSONField(name = "cutName")
   private String cutName;
   @ApiModelProperty(name = "cutType", notes = "切割方式名称")
   @JsonProperty("cutType")
   @JSONField(name = "cutType")
   private Integer cutType;
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
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "netWeight", notes = "重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "bcGuid", notes = "钢板id")
   @JsonProperty("bcGuid")
   @JSONField(name = "bcGuid")
   private String bcGuid;
   @ApiModelProperty(name = "jobId", notes = "工单id")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   private Long jobId;
   @ApiModelProperty(name = "cuttingReportMethod", value = "切割报工方式", notes = "切割报工方式")
   @JsonProperty("cuttingReportMethod")
   @JSONField(name = "cuttingReportMethod")
   private Integer cuttingReportMethod;
   @ApiModelProperty(name = "drillReportMethod", value = "钻孔报工方式", notes = "钻孔报工方式")
   @JsonProperty("drillReportMethod")
   @JSONField(name = "drillReportMethod")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess;
   @ApiModelProperty(name = "approveState", value = "材料是否申领 1是 0否 2审批中")
   @JsonProperty("approveState")
   @JSONField(name = "approveState")
   private Integer approveState;

   public static AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder builder() {
      return new AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder();
   }

   public AppTaskOrderSummaryDO() {
   }

   public AppTaskOrderSummaryDO(
      final Long id,
      final String orderNumber,
      final Long schedulingId,
      final ProjectDetailDO project,
      final Integer quantity,
      final Integer completeQuantity,
      final String cutName,
      final Integer cutType,
      final String userName,
      final LocalDateTime schedulingDate,
      final String cutTypeName,
      final LocalDateTime askCompleteTime,
      final BigDecimal netWeight,
      final String bcGuid,
      final Long jobId,
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Boolean boolProcess,
      final Integer approveState
   ) {
      this.id = id;
      this.orderNumber = orderNumber;
      this.schedulingId = schedulingId;
      this.project = project;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.cutName = cutName;
      this.cutType = cutType;
      this.userName = userName;
      this.schedulingDate = schedulingDate;
      this.cutTypeName = cutTypeName;
      this.askCompleteTime = askCompleteTime;
      this.netWeight = netWeight;
      this.bcGuid = bcGuid;
      this.jobId = jobId;
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.boolProcess = boolProcess;
      this.approveState = approveState;
   }

   public Long getId() {
      return this.id;
   }

   public String getOrderNumber() {
      return this.orderNumber;
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

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getCutName() {
      return this.cutName;
   }

   public Integer getCutType() {
      return this.cutType;
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

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public String getBcGuid() {
      return this.bcGuid;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public Integer getCuttingReportMethod() {
      return this.cuttingReportMethod;
   }

   public Integer getDrillReportMethod() {
      return this.drillReportMethod;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Integer getApproveState() {
      return this.approveState;
   }

   @JsonProperty("id")
   public AppTaskOrderSummaryDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTaskOrderSummaryDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("schedulingId")
   public AppTaskOrderSummaryDO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("project")
   public AppTaskOrderSummaryDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskOrderSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public AppTaskOrderSummaryDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("cutName")
   public AppTaskOrderSummaryDO setCutName(final String cutName) {
      this.cutName = cutName;
      return this;
   }

   @JsonProperty("cutType")
   public AppTaskOrderSummaryDO setCutType(final Integer cutType) {
      this.cutType = cutType;
      return this;
   }

   @JsonProperty("userName")
   public AppTaskOrderSummaryDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("schedulingDate")
   public AppTaskOrderSummaryDO setSchedulingDate(final LocalDateTime schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("cutTypeName")
   public AppTaskOrderSummaryDO setCutTypeName(final String cutTypeName) {
      this.cutTypeName = cutTypeName;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskOrderSummaryDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("netWeight")
   public AppTaskOrderSummaryDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("bcGuid")
   public AppTaskOrderSummaryDO setBcGuid(final String bcGuid) {
      this.bcGuid = bcGuid;
      return this;
   }

   @JsonProperty("jobId")
   public AppTaskOrderSummaryDO setJobId(final Long jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("cuttingReportMethod")
   public AppTaskOrderSummaryDO setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   @JsonProperty("drillReportMethod")
   public AppTaskOrderSummaryDO setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("boolProcess")
   public AppTaskOrderSummaryDO setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @JsonProperty("approveState")
   public AppTaskOrderSummaryDO setApproveState(final Integer approveState) {
      this.approveState = approveState;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskOrderSummaryDO(id="
         + this.getId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", cutName="
         + this.getCutName()
         + ", cutType="
         + this.getCutType()
         + ", userName="
         + this.getUserName()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", cutTypeName="
         + this.getCutTypeName()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", netWeight="
         + this.getNetWeight()
         + ", bcGuid="
         + this.getBcGuid()
         + ", jobId="
         + this.getJobId()
         + ", cuttingReportMethod="
         + this.getCuttingReportMethod()
         + ", drillReportMethod="
         + this.getDrillReportMethod()
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

      if (!(o instanceof AppTaskOrderSummaryDO)) {
         return false;
      }

      AppTaskOrderSummaryDO other = (AppTaskOrderSummaryDO)o;
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
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$cutType = this.getCutType();
                  Object other$cutType = other.getCutType();
                  if (this$cutType == null ? other$cutType == null : this$cutType.equals(other$cutType)) {
                     Object this$jobId = this.getJobId();
                     Object other$jobId = other.getJobId();
                     if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                        Object this$cuttingReportMethod = this.getCuttingReportMethod();
                        Object other$cuttingReportMethod = other.getCuttingReportMethod();
                        if (this$cuttingReportMethod == null ? other$cuttingReportMethod == null : this$cuttingReportMethod.equals(other$cuttingReportMethod)) {
                           Object this$drillReportMethod = this.getDrillReportMethod();
                           Object other$drillReportMethod = other.getDrillReportMethod();
                           if (this$drillReportMethod == null ? other$drillReportMethod == null : this$drillReportMethod.equals(other$drillReportMethod)) {
                              Object this$boolProcess = this.getBoolProcess();
                              Object other$boolProcess = other.getBoolProcess();
                              if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                 Object this$approveState = this.getApproveState();
                                 Object other$approveState = other.getApproveState();
                                 if (this$approveState == null ? other$approveState == null : this$approveState.equals(other$approveState)) {
                                    Object this$orderNumber = this.getOrderNumber();
                                    Object other$orderNumber = other.getOrderNumber();
                                    if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$cutName = this.getCutName();
                                          Object other$cutName = other.getCutName();
                                          if (this$cutName == null ? other$cutName == null : this$cutName.equals(other$cutName)) {
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
                                                   if (this$cutTypeName == null ? other$cutTypeName == null : this$cutTypeName.equals(other$cutTypeName)) {
                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                      if (this$askCompleteTime == null
                                                         ? other$askCompleteTime == null
                                                         : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppTaskOrderSummaryDO;
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
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $cutType = this.getCutType();
      result = result * 59 + ($cutType == null ? 43 : $cutType.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $cuttingReportMethod = this.getCuttingReportMethod();
      result = result * 59 + ($cuttingReportMethod == null ? 43 : $cuttingReportMethod.hashCode());
      Object $drillReportMethod = this.getDrillReportMethod();
      result = result * 59 + ($drillReportMethod == null ? 43 : $drillReportMethod.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $approveState = this.getApproveState();
      result = result * 59 + ($approveState == null ? 43 : $approveState.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $cutName = this.getCutName();
      result = result * 59 + ($cutName == null ? 43 : $cutName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $cutTypeName = this.getCutTypeName();
      result = result * 59 + ($cutTypeName == null ? 43 : $cutTypeName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $bcGuid = this.getBcGuid();
      return result * 59 + ($bcGuid == null ? 43 : $bcGuid.hashCode());
   }

   public static class AppTaskOrderSummaryDOBuilder {
      private Long id;
      private String orderNumber;
      private Long schedulingId;
      private ProjectDetailDO project;
      private Integer quantity;
      private Integer completeQuantity;
      private String cutName;
      private Integer cutType;
      private String userName;
      private LocalDateTime schedulingDate;
      private String cutTypeName;
      private LocalDateTime askCompleteTime;
      private BigDecimal netWeight;
      private String bcGuid;
      private Long jobId;
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Boolean boolProcess;
      private Integer approveState;

      AppTaskOrderSummaryDOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("schedulingId")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("project")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("cutName")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder cutName(final String cutName) {
         this.cutName = cutName;
         return this;
      }

      @JsonProperty("cutType")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder cutType(final Integer cutType) {
         this.cutType = cutType;
         return this;
      }

      @JsonProperty("userName")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("schedulingDate")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder schedulingDate(final LocalDateTime schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("cutTypeName")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder cutTypeName(final String cutTypeName) {
         this.cutTypeName = cutTypeName;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("netWeight")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("bcGuid")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder bcGuid(final String bcGuid) {
         this.bcGuid = bcGuid;
         return this;
      }

      @JsonProperty("jobId")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("cuttingReportMethod")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      @JsonProperty("drillReportMethod")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("boolProcess")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      @JsonProperty("approveState")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder approveState(final Integer approveState) {
         this.approveState = approveState;
         return this;
      }

      public AppTaskOrderSummaryDO build() {
         return new AppTaskOrderSummaryDO(
            this.id,
            this.orderNumber,
            this.schedulingId,
            this.project,
            this.quantity,
            this.completeQuantity,
            this.cutName,
            this.cutType,
            this.userName,
            this.schedulingDate,
            this.cutTypeName,
            this.askCompleteTime,
            this.netWeight,
            this.bcGuid,
            this.jobId,
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.boolProcess,
            this.approveState
         );
      }

      @Override
      public String toString() {
         return "AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder(id="
            + this.id
            + ", orderNumber="
            + this.orderNumber
            + ", schedulingId="
            + this.schedulingId
            + ", project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", cutName="
            + this.cutName
            + ", cutType="
            + this.cutType
            + ", userName="
            + this.userName
            + ", schedulingDate="
            + this.schedulingDate
            + ", cutTypeName="
            + this.cutTypeName
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", netWeight="
            + this.netWeight
            + ", bcGuid="
            + this.bcGuid
            + ", jobId="
            + this.jobId
            + ", cuttingReportMethod="
            + this.cuttingReportMethod
            + ", drillReportMethod="
            + this.drillReportMethod
            + ", boolProcess="
            + this.boolProcess
            + ", approveState="
            + this.approveState
            + ")";
      }
   }
}
