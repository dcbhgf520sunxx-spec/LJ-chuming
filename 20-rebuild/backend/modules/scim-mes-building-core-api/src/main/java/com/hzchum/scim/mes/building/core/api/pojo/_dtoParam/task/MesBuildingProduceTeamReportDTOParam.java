package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingTaskProduceTeamReportDTOParam", description = "")
public class MesBuildingProduceTeamReportDTOParam {
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "boolAssistEnum", notes = "是否是协同")
   @JsonProperty("boolAssistEnum")
   @JSONField(name = "boolAssistEnum")
   private Boolean boolAssistEnum;
   @ApiModelProperty(name = "nextProcessId", notes = "下一道工序id")
   @JsonProperty("nextProcessId")
   @JSONField(name = "nextProcessId")
   private Long nextProcessId;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", notes = "teamId")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "reportType", notes = "上报类型 0正常上报 1异常上报", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Boolean reportType;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;
   @ApiModelProperty(name = "assistGroupId", notes = "协同任务任务上报生产组id", value = "协同任务任务上报生产组id")
   @JsonProperty("assistGroupId")
   @JSONField(name = "assistGroupId")
   private Long assistGroupId;
   @ApiModelProperty(name = "assistLineId", notes = "协同任务任务上报生产线id", value = "协同任务任务上报生产线id")
   @JsonProperty("assistLineId")
   @JSONField(name = "assistLineId")
   private Long assistLineId;
   @ApiModelProperty(name = "productProcessId", value = "总工序id", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "nestTask", value = "任务工单id", notes = "是否是套料任务")
   @JsonProperty("nestTask")
   @JSONField(name = "nestTask")
   private Boolean nestTask;
   @ApiModelProperty("上报人id")
   private Long reportPersonId;
   @ApiModelProperty("任务id")
   private Long taskId;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("打孔数")
   private BigDecimal perforateQuantity;

   public static MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder builder() {
      return new MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder();
   }

   public MesBuildingProduceTeamReportDTOParam(
      final Integer reportQuantity,
      final Boolean boolAssistEnum,
      final Long nextProcessId,
      final Long id,
      final Long teamId,
      final Boolean reportType,
      final List<Integer> numberList,
      final Long assistGroupId,
      final Long assistLineId,
      final Long productProcessId,
      final Long taskOrderId,
      final Boolean nestTask,
      final Long reportPersonId,
      final Long taskId,
      final Long processId,
      final BigDecimal perforateQuantity
   ) {
      this.reportQuantity = reportQuantity;
      this.boolAssistEnum = boolAssistEnum;
      this.nextProcessId = nextProcessId;
      this.id = id;
      this.teamId = teamId;
      this.reportType = reportType;
      this.numberList = numberList;
      this.assistGroupId = assistGroupId;
      this.assistLineId = assistLineId;
      this.productProcessId = productProcessId;
      this.taskOrderId = taskOrderId;
      this.nestTask = nestTask;
      this.reportPersonId = reportPersonId;
      this.taskId = taskId;
      this.processId = processId;
      this.perforateQuantity = perforateQuantity;
   }

   public MesBuildingProduceTeamReportDTOParam() {
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Boolean getBoolAssistEnum() {
      return this.boolAssistEnum;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Boolean getReportType() {
      return this.reportType;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Long getAssistGroupId() {
      return this.assistGroupId;
   }

   public Long getAssistLineId() {
      return this.assistLineId;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Boolean getNestTask() {
      return this.nestTask;
   }

   public Long getReportPersonId() {
      return this.reportPersonId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public BigDecimal getPerforateQuantity() {
      return this.perforateQuantity;
   }

   @JsonProperty("reportQuantity")
   public MesBuildingProduceTeamReportDTOParam setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("boolAssistEnum")
   public MesBuildingProduceTeamReportDTOParam setBoolAssistEnum(final Boolean boolAssistEnum) {
      this.boolAssistEnum = boolAssistEnum;
      return this;
   }

   @JsonProperty("nextProcessId")
   public MesBuildingProduceTeamReportDTOParam setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("id")
   public MesBuildingProduceTeamReportDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceTeamReportDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProduceTeamReportDTOParam setReportType(final Boolean reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("numberList")
   public MesBuildingProduceTeamReportDTOParam setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @JsonProperty("assistGroupId")
   public MesBuildingProduceTeamReportDTOParam setAssistGroupId(final Long assistGroupId) {
      this.assistGroupId = assistGroupId;
      return this;
   }

   @JsonProperty("assistLineId")
   public MesBuildingProduceTeamReportDTOParam setAssistLineId(final Long assistLineId) {
      this.assistLineId = assistLineId;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingProduceTeamReportDTOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingProduceTeamReportDTOParam setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("nestTask")
   public MesBuildingProduceTeamReportDTOParam setNestTask(final Boolean nestTask) {
      this.nestTask = nestTask;
      return this;
   }

   public MesBuildingProduceTeamReportDTOParam setReportPersonId(final Long reportPersonId) {
      this.reportPersonId = reportPersonId;
      return this;
   }

   public MesBuildingProduceTeamReportDTOParam setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingProduceTeamReportDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingProduceTeamReportDTOParam setPerforateQuantity(final BigDecimal perforateQuantity) {
      this.perforateQuantity = perforateQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceTeamReportDTOParam(reportQuantity="
         + this.getReportQuantity()
         + ", boolAssistEnum="
         + this.getBoolAssistEnum()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ", id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ", reportType="
         + this.getReportType()
         + ", numberList="
         + this.getNumberList()
         + ", assistGroupId="
         + this.getAssistGroupId()
         + ", assistLineId="
         + this.getAssistLineId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", nestTask="
         + this.getNestTask()
         + ", reportPersonId="
         + this.getReportPersonId()
         + ", taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", perforateQuantity="
         + this.getPerforateQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceTeamReportDTOParam)) {
         return false;
      }

      MesBuildingProduceTeamReportDTOParam other = (MesBuildingProduceTeamReportDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportQuantity = this.getReportQuantity();
      Object other$reportQuantity = other.getReportQuantity();
      if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
         Object this$boolAssistEnum = this.getBoolAssistEnum();
         Object other$boolAssistEnum = other.getBoolAssistEnum();
         if (this$boolAssistEnum == null ? other$boolAssistEnum == null : this$boolAssistEnum.equals(other$boolAssistEnum)) {
            Object this$nextProcessId = this.getNextProcessId();
            Object other$nextProcessId = other.getNextProcessId();
            if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$reportType = this.getReportType();
                     Object other$reportType = other.getReportType();
                     if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                        Object this$assistGroupId = this.getAssistGroupId();
                        Object other$assistGroupId = other.getAssistGroupId();
                        if (this$assistGroupId == null ? other$assistGroupId == null : this$assistGroupId.equals(other$assistGroupId)) {
                           Object this$assistLineId = this.getAssistLineId();
                           Object other$assistLineId = other.getAssistLineId();
                           if (this$assistLineId == null ? other$assistLineId == null : this$assistLineId.equals(other$assistLineId)) {
                              Object this$productProcessId = this.getProductProcessId();
                              Object other$productProcessId = other.getProductProcessId();
                              if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
                                 Object this$taskOrderId = this.getTaskOrderId();
                                 Object other$taskOrderId = other.getTaskOrderId();
                                 if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                    Object this$nestTask = this.getNestTask();
                                    Object other$nestTask = other.getNestTask();
                                    if (this$nestTask == null ? other$nestTask == null : this$nestTask.equals(other$nestTask)) {
                                       Object this$reportPersonId = this.getReportPersonId();
                                       Object other$reportPersonId = other.getReportPersonId();
                                       if (this$reportPersonId == null ? other$reportPersonId == null : this$reportPersonId.equals(other$reportPersonId)) {
                                          Object this$taskId = this.getTaskId();
                                          Object other$taskId = other.getTaskId();
                                          if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                             Object this$processId = this.getProcessId();
                                             Object other$processId = other.getProcessId();
                                             if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                                Object this$numberList = this.getNumberList();
                                                Object other$numberList = other.getNumberList();
                                                if (this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList)) {
                                                   Object this$perforateQuantity = this.getPerforateQuantity();
                                                   Object other$perforateQuantity = other.getPerforateQuantity();
                                                   return this$perforateQuantity == null
                                                      ? other$perforateQuantity == null
                                                      : this$perforateQuantity.equals(other$perforateQuantity);
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
      return other instanceof MesBuildingProduceTeamReportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $boolAssistEnum = this.getBoolAssistEnum();
      result = result * 59 + ($boolAssistEnum == null ? 43 : $boolAssistEnum.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $assistGroupId = this.getAssistGroupId();
      result = result * 59 + ($assistGroupId == null ? 43 : $assistGroupId.hashCode());
      Object $assistLineId = this.getAssistLineId();
      result = result * 59 + ($assistLineId == null ? 43 : $assistLineId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $nestTask = this.getNestTask();
      result = result * 59 + ($nestTask == null ? 43 : $nestTask.hashCode());
      Object $reportPersonId = this.getReportPersonId();
      result = result * 59 + ($reportPersonId == null ? 43 : $reportPersonId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $numberList = this.getNumberList();
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $perforateQuantity = this.getPerforateQuantity();
      return result * 59 + ($perforateQuantity == null ? 43 : $perforateQuantity.hashCode());
   }

   public static class MesBuildingProduceTeamReportDTOParamBuilder {
      private Integer reportQuantity;
      private Boolean boolAssistEnum;
      private Long nextProcessId;
      private Long id;
      private Long teamId;
      private Boolean reportType;
      private List<Integer> numberList;
      private Long assistGroupId;
      private Long assistLineId;
      private Long productProcessId;
      private Long taskOrderId;
      private Boolean nestTask;
      private Long reportPersonId;
      private Long taskId;
      private Long processId;
      private BigDecimal perforateQuantity;

      MesBuildingProduceTeamReportDTOParamBuilder() {
      }

      @JsonProperty("reportQuantity")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("boolAssistEnum")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder boolAssistEnum(final Boolean boolAssistEnum) {
         this.boolAssistEnum = boolAssistEnum;
         return this;
      }

      @JsonProperty("nextProcessId")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("id")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder reportType(final Boolean reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("numberList")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      @JsonProperty("assistGroupId")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder assistGroupId(final Long assistGroupId) {
         this.assistGroupId = assistGroupId;
         return this;
      }

      @JsonProperty("assistLineId")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder assistLineId(final Long assistLineId) {
         this.assistLineId = assistLineId;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("nestTask")
      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder nestTask(final Boolean nestTask) {
         this.nestTask = nestTask;
         return this;
      }

      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder reportPersonId(final Long reportPersonId) {
         this.reportPersonId = reportPersonId;
         return this;
      }

      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder perforateQuantity(final BigDecimal perforateQuantity) {
         this.perforateQuantity = perforateQuantity;
         return this;
      }

      public MesBuildingProduceTeamReportDTOParam build() {
         return new MesBuildingProduceTeamReportDTOParam(
            this.reportQuantity,
            this.boolAssistEnum,
            this.nextProcessId,
            this.id,
            this.teamId,
            this.reportType,
            this.numberList,
            this.assistGroupId,
            this.assistLineId,
            this.productProcessId,
            this.taskOrderId,
            this.nestTask,
            this.reportPersonId,
            this.taskId,
            this.processId,
            this.perforateQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceTeamReportDTOParam.MesBuildingProduceTeamReportDTOParamBuilder(reportQuantity="
            + this.reportQuantity
            + ", boolAssistEnum="
            + this.boolAssistEnum
            + ", nextProcessId="
            + this.nextProcessId
            + ", id="
            + this.id
            + ", teamId="
            + this.teamId
            + ", reportType="
            + this.reportType
            + ", numberList="
            + this.numberList
            + ", assistGroupId="
            + this.assistGroupId
            + ", assistLineId="
            + this.assistLineId
            + ", productProcessId="
            + this.productProcessId
            + ", taskOrderId="
            + this.taskOrderId
            + ", nestTask="
            + this.nestTask
            + ", reportPersonId="
            + this.reportPersonId
            + ", taskId="
            + this.taskId
            + ", processId="
            + this.processId
            + ", perforateQuantity="
            + this.perforateQuantity
            + ")";
      }
   }
}
