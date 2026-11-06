package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartNestingMaterialeamDTOParam", description = "零件套料排产零件查询")
public class MachinePartNestingMaterialeamDTOParam {
   @ApiModelProperty("年月集合")
   @JsonProperty("monthList")
   @JSONField(name = "monthList")
   private List<Long> monthList;
   @ApiModelProperty("工单号集合")
   @JsonProperty("taskOrderIds")
   @JSONField(name = "taskOrderIds")
   private List<Long> taskOrderIds;
   @ApiModelProperty("项目id集合")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;
   @ApiModelProperty("生产组id")
   @JsonProperty("groupsIds")
   @JSONField(name = "groupsIds")
   private List<Long> groupsIds;
   @ApiModelProperty("组装后的日期")
   @JsonProperty("yearMonth")
   @JSONField(name = "yearMonth")
   private String yearMonth;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "steelPlateTypeEnum", notes = "板材类型")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   private Integer steelPlateTypeEnum;

   public static MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder builder() {
      return new MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder();
   }

   public MachinePartNestingMaterialeamDTOParam(
      final List<Long> monthList,
      final List<Long> taskOrderIds,
      final List<Long> projectIds,
      final List<Long> groupsIds,
      final String yearMonth,
      final Integer taskTypeEnum,
      final Integer steelPlateTypeEnum
   ) {
      this.monthList = monthList;
      this.taskOrderIds = taskOrderIds;
      this.projectIds = projectIds;
      this.groupsIds = groupsIds;
      this.yearMonth = yearMonth;
      this.taskTypeEnum = taskTypeEnum;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public MachinePartNestingMaterialeamDTOParam() {
   }

   public List<Long> getMonthList() {
      return this.monthList;
   }

   public List<Long> getTaskOrderIds() {
      return this.taskOrderIds;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public List<Long> getGroupsIds() {
      return this.groupsIds;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   @JsonProperty("monthList")
   public MachinePartNestingMaterialeamDTOParam setMonthList(final List<Long> monthList) {
      this.monthList = monthList;
      return this;
   }

   @JsonProperty("taskOrderIds")
   public MachinePartNestingMaterialeamDTOParam setTaskOrderIds(final List<Long> taskOrderIds) {
      this.taskOrderIds = taskOrderIds;
      return this;
   }

   @JsonProperty("projectIds")
   public MachinePartNestingMaterialeamDTOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("groupsIds")
   public MachinePartNestingMaterialeamDTOParam setGroupsIds(final List<Long> groupsIds) {
      this.groupsIds = groupsIds;
      return this;
   }

   @JsonProperty("yearMonth")
   public MachinePartNestingMaterialeamDTOParam setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MachinePartNestingMaterialeamDTOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public MachinePartNestingMaterialeamDTOParam setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingMaterialeamDTOParam(monthList="
         + this.getMonthList()
         + ", taskOrderIds="
         + this.getTaskOrderIds()
         + ", projectIds="
         + this.getProjectIds()
         + ", groupsIds="
         + this.getGroupsIds()
         + ", yearMonth="
         + this.getYearMonth()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingMaterialeamDTOParam)) {
         return false;
      }

      MachinePartNestingMaterialeamDTOParam other = (MachinePartNestingMaterialeamDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
         Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
         Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
         if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
            Object this$monthList = this.getMonthList();
            Object other$monthList = other.getMonthList();
            if (this$monthList == null ? other$monthList == null : this$monthList.equals(other$monthList)) {
               Object this$taskOrderIds = this.getTaskOrderIds();
               Object other$taskOrderIds = other.getTaskOrderIds();
               if (this$taskOrderIds == null ? other$taskOrderIds == null : this$taskOrderIds.equals(other$taskOrderIds)) {
                  Object this$projectIds = this.getProjectIds();
                  Object other$projectIds = other.getProjectIds();
                  if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                     Object this$groupsIds = this.getGroupsIds();
                     Object other$groupsIds = other.getGroupsIds();
                     if (this$groupsIds == null ? other$groupsIds == null : this$groupsIds.equals(other$groupsIds)) {
                        Object this$yearMonth = this.getYearMonth();
                        Object other$yearMonth = other.getYearMonth();
                        return this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth);
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
      return other instanceof MachinePartNestingMaterialeamDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $monthList = this.getMonthList();
      result = result * 59 + ($monthList == null ? 43 : $monthList.hashCode());
      Object $taskOrderIds = this.getTaskOrderIds();
      result = result * 59 + ($taskOrderIds == null ? 43 : $taskOrderIds.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $groupsIds = this.getGroupsIds();
      result = result * 59 + ($groupsIds == null ? 43 : $groupsIds.hashCode());
      Object $yearMonth = this.getYearMonth();
      return result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
   }

   public static class MachinePartNestingMaterialeamDTOParamBuilder {
      private List<Long> monthList;
      private List<Long> taskOrderIds;
      private List<Long> projectIds;
      private List<Long> groupsIds;
      private String yearMonth;
      private Integer taskTypeEnum;
      private Integer steelPlateTypeEnum;

      MachinePartNestingMaterialeamDTOParamBuilder() {
      }

      @JsonProperty("monthList")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder monthList(final List<Long> monthList) {
         this.monthList = monthList;
         return this;
      }

      @JsonProperty("taskOrderIds")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder taskOrderIds(final List<Long> taskOrderIds) {
         this.taskOrderIds = taskOrderIds;
         return this;
      }

      @JsonProperty("projectIds")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("groupsIds")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder groupsIds(final List<Long> groupsIds) {
         this.groupsIds = groupsIds;
         return this;
      }

      @JsonProperty("yearMonth")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public MachinePartNestingMaterialeamDTOParam build() {
         return new MachinePartNestingMaterialeamDTOParam(
            this.monthList, this.taskOrderIds, this.projectIds, this.groupsIds, this.yearMonth, this.taskTypeEnum, this.steelPlateTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingMaterialeamDTOParam.MachinePartNestingMaterialeamDTOParamBuilder(monthList="
            + this.monthList
            + ", taskOrderIds="
            + this.taskOrderIds
            + ", projectIds="
            + this.projectIds
            + ", groupsIds="
            + this.groupsIds
            + ", yearMonth="
            + this.yearMonth
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ")";
      }
   }
}
