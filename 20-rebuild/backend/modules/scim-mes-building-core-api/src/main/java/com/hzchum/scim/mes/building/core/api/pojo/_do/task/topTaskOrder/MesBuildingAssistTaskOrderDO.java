package com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProcessDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingAssistTaskOrderDO", description = "任务工单信息")
public class MesBuildingAssistTaskOrderDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "processList", value = "工序信息", notes = "工序信息")
   @JsonProperty("processList")
   @JSONField(name = "processList")
   private List<MesBuildingAssistProcessDTO> processList;

   public static MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder builder() {
      return new MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder();
   }

   public MesBuildingAssistTaskOrderDO() {
   }

   public MesBuildingAssistTaskOrderDO(
      final Long id,
      final Integer taskTypeEnum,
      final GroupsCurrencyDO groups,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final LocalDateTime askCompleteTime,
      final String orderNumber,
      final List<MesBuildingAssistProcessDTO> processList
   ) {
      this.id = id;
      this.taskTypeEnum = taskTypeEnum;
      this.groups = groups;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.askCompleteTime = askCompleteTime;
      this.orderNumber = orderNumber;
      this.processList = processList;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public List<MesBuildingAssistProcessDTO> getProcessList() {
      return this.processList;
   }

   @JsonProperty("id")
   public MesBuildingAssistTaskOrderDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingAssistTaskOrderDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("groups")
   public MesBuildingAssistTaskOrderDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingAssistTaskOrderDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingAssistTaskOrderDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingAssistTaskOrderDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingAssistTaskOrderDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("processList")
   public MesBuildingAssistTaskOrderDO setProcessList(final List<MesBuildingAssistProcessDTO> processList) {
      this.processList = processList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistTaskOrderDO(id="
         + this.getId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", groups="
         + this.getGroups()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", processList="
         + this.getProcessList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistTaskOrderDO)) {
         return false;
      }

      MesBuildingAssistTaskOrderDO other = (MesBuildingAssistTaskOrderDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$groups = this.getGroups();
            Object other$groups = other.getGroups();
            if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
               Object this$workshop = this.getWorkshop();
               Object other$workshop = other.getWorkshop();
               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                  Object this$productionLine = this.getProductionLine();
                  Object other$productionLine = other.getProductionLine();
                  if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                     Object this$askCompleteTime = this.getAskCompleteTime();
                     Object other$askCompleteTime = other.getAskCompleteTime();
                     if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                        Object this$orderNumber = this.getOrderNumber();
                        Object other$orderNumber = other.getOrderNumber();
                        if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                           Object this$processList = this.getProcessList();
                           Object other$processList = other.getProcessList();
                           return this$processList == null ? other$processList == null : this$processList.equals(other$processList);
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
      return other instanceof MesBuildingAssistTaskOrderDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $processList = this.getProcessList();
      return result * 59 + ($processList == null ? 43 : $processList.hashCode());
   }

   public static class MesBuildingAssistTaskOrderDOBuilder {
      private Long id;
      private Integer taskTypeEnum;
      private GroupsCurrencyDO groups;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private LocalDateTime askCompleteTime;
      private String orderNumber;
      private List<MesBuildingAssistProcessDTO> processList;

      MesBuildingAssistTaskOrderDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("groups")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("processList")
      public MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder processList(final List<MesBuildingAssistProcessDTO> processList) {
         this.processList = processList;
         return this;
      }

      public MesBuildingAssistTaskOrderDO build() {
         return new MesBuildingAssistTaskOrderDO(
            this.id, this.taskTypeEnum, this.groups, this.workshop, this.productionLine, this.askCompleteTime, this.orderNumber, this.processList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistTaskOrderDO.MesBuildingAssistTaskOrderDOBuilder(id="
            + this.id
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", groups="
            + this.groups
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", orderNumber="
            + this.orderNumber
            + ", processList="
            + this.processList
            + ")";
      }
   }
}
