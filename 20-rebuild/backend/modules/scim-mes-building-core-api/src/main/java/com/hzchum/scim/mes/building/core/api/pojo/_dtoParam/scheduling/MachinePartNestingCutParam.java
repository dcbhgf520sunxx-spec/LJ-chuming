package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MachinePartNestingCutParam", description = "切割任务下发请求类")
public class MachinePartNestingCutParam {
   private Integer jobId;
   private Long groupsId;
   private Long productionLineId;
   private String jobNumber;
   private String workshop;
   private Long machineTool;
   private LocalDateTime finishDate;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillCutConfigId", value = "钻孔产线id", notes = "钻孔产线id")
   @JsonProperty("drillCutConfigId")
   @JSONField(name = "drillCutConfigId")
   private Long drillCutConfigId;
   @ApiModelProperty(name = "drillProductionLineId", value = "钻孔产线id", notes = "钻孔产线id")
   @JsonProperty("drillProductionLineId")
   @JSONField(name = "drillProductionLineId")
   private Long drillProductionLineId;
   @ApiModelProperty(name = "drillProcessId", value = "钻孔工序id", notes = "钻孔工序id")
   @JsonProperty("drillProcessId")
   @JSONField(name = "drillProcessId")
   private Long drillProcessId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;
   private List<MachinePartNestingCutJobParam> machinePartNestingCutJobParamList;

   public static MachinePartNestingCutParam.MachinePartNestingCutParamBuilder builder() {
      return new MachinePartNestingCutParam.MachinePartNestingCutParamBuilder();
   }

   public MachinePartNestingCutParam(
      final Integer jobId,
      final Long groupsId,
      final Long productionLineId,
      final String jobNumber,
      final String workshop,
      final Long machineTool,
      final LocalDateTime finishDate,
      final Long drillGroupsId,
      final Long drillCutConfigId,
      final Long drillProductionLineId,
      final Long drillProcessId,
      final LocalDateTime drillAskCompleteTime,
      final List<MachinePartNestingCutJobParam> machinePartNestingCutJobParamList
   ) {
      this.jobId = jobId;
      this.groupsId = groupsId;
      this.productionLineId = productionLineId;
      this.jobNumber = jobNumber;
      this.workshop = workshop;
      this.machineTool = machineTool;
      this.finishDate = finishDate;
      this.drillGroupsId = drillGroupsId;
      this.drillCutConfigId = drillCutConfigId;
      this.drillProductionLineId = drillProductionLineId;
      this.drillProcessId = drillProcessId;
      this.drillAskCompleteTime = drillAskCompleteTime;
      this.machinePartNestingCutJobParamList = machinePartNestingCutJobParamList;
   }

   public MachinePartNestingCutParam() {
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getJobNumber() {
      return this.jobNumber;
   }

   public String getWorkshop() {
      return this.workshop;
   }

   public Long getMachineTool() {
      return this.machineTool;
   }

   public LocalDateTime getFinishDate() {
      return this.finishDate;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public Long getDrillCutConfigId() {
      return this.drillCutConfigId;
   }

   public Long getDrillProductionLineId() {
      return this.drillProductionLineId;
   }

   public Long getDrillProcessId() {
      return this.drillProcessId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
   }

   public List<MachinePartNestingCutJobParam> getMachinePartNestingCutJobParamList() {
      return this.machinePartNestingCutJobParamList;
   }

   public MachinePartNestingCutParam setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public MachinePartNestingCutParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   public MachinePartNestingCutParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MachinePartNestingCutParam setJobNumber(final String jobNumber) {
      this.jobNumber = jobNumber;
      return this;
   }

   public MachinePartNestingCutParam setWorkshop(final String workshop) {
      this.workshop = workshop;
      return this;
   }

   public MachinePartNestingCutParam setMachineTool(final Long machineTool) {
      this.machineTool = machineTool;
      return this;
   }

   public MachinePartNestingCutParam setFinishDate(final LocalDateTime finishDate) {
      this.finishDate = finishDate;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MachinePartNestingCutParam setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillCutConfigId")
   public MachinePartNestingCutParam setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
      return this;
   }

   @JsonProperty("drillProductionLineId")
   public MachinePartNestingCutParam setDrillProductionLineId(final Long drillProductionLineId) {
      this.drillProductionLineId = drillProductionLineId;
      return this;
   }

   @JsonProperty("drillProcessId")
   public MachinePartNestingCutParam setDrillProcessId(final Long drillProcessId) {
      this.drillProcessId = drillProcessId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MachinePartNestingCutParam setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   public MachinePartNestingCutParam setMachinePartNestingCutJobParamList(final List<MachinePartNestingCutJobParam> machinePartNestingCutJobParamList) {
      this.machinePartNestingCutJobParamList = machinePartNestingCutJobParamList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingCutParam)) {
         return false;
      }

      MachinePartNestingCutParam other = (MachinePartNestingCutParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$machineTool = this.getMachineTool();
               Object other$machineTool = other.getMachineTool();
               if (this$machineTool == null ? other$machineTool == null : this$machineTool.equals(other$machineTool)) {
                  Object this$drillGroupsId = this.getDrillGroupsId();
                  Object other$drillGroupsId = other.getDrillGroupsId();
                  if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
                     Object this$drillCutConfigId = this.getDrillCutConfigId();
                     Object other$drillCutConfigId = other.getDrillCutConfigId();
                     if (this$drillCutConfigId == null ? other$drillCutConfigId == null : this$drillCutConfigId.equals(other$drillCutConfigId)) {
                        Object this$drillProductionLineId = this.getDrillProductionLineId();
                        Object other$drillProductionLineId = other.getDrillProductionLineId();
                        if (this$drillProductionLineId == null
                           ? other$drillProductionLineId == null
                           : this$drillProductionLineId.equals(other$drillProductionLineId)) {
                           Object this$drillProcessId = this.getDrillProcessId();
                           Object other$drillProcessId = other.getDrillProcessId();
                           if (this$drillProcessId == null ? other$drillProcessId == null : this$drillProcessId.equals(other$drillProcessId)) {
                              Object this$jobNumber = this.getJobNumber();
                              Object other$jobNumber = other.getJobNumber();
                              if (this$jobNumber == null ? other$jobNumber == null : this$jobNumber.equals(other$jobNumber)) {
                                 Object this$workshop = this.getWorkshop();
                                 Object other$workshop = other.getWorkshop();
                                 if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                    Object this$finishDate = this.getFinishDate();
                                    Object other$finishDate = other.getFinishDate();
                                    if (this$finishDate == null ? other$finishDate == null : this$finishDate.equals(other$finishDate)) {
                                       Object this$drillAskCompleteTime = this.getDrillAskCompleteTime();
                                       Object other$drillAskCompleteTime = other.getDrillAskCompleteTime();
                                       if (this$drillAskCompleteTime == null
                                          ? other$drillAskCompleteTime == null
                                          : this$drillAskCompleteTime.equals(other$drillAskCompleteTime)) {
                                          Object this$machinePartNestingCutJobParamList = this.getMachinePartNestingCutJobParamList();
                                          Object other$machinePartNestingCutJobParamList = other.getMachinePartNestingCutJobParamList();
                                          return this$machinePartNestingCutJobParamList == null
                                             ? other$machinePartNestingCutJobParamList == null
                                             : this$machinePartNestingCutJobParamList.equals(other$machinePartNestingCutJobParamList);
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
      return other instanceof MachinePartNestingCutParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $machineTool = this.getMachineTool();
      result = result * 59 + ($machineTool == null ? 43 : $machineTool.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $drillProductionLineId = this.getDrillProductionLineId();
      result = result * 59 + ($drillProductionLineId == null ? 43 : $drillProductionLineId.hashCode());
      Object $drillProcessId = this.getDrillProcessId();
      result = result * 59 + ($drillProcessId == null ? 43 : $drillProcessId.hashCode());
      Object $jobNumber = this.getJobNumber();
      result = result * 59 + ($jobNumber == null ? 43 : $jobNumber.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $finishDate = this.getFinishDate();
      result = result * 59 + ($finishDate == null ? 43 : $finishDate.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      result = result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
      Object $machinePartNestingCutJobParamList = this.getMachinePartNestingCutJobParamList();
      return result * 59 + ($machinePartNestingCutJobParamList == null ? 43 : $machinePartNestingCutJobParamList.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartNestingCutParam(jobId="
         + this.getJobId()
         + ", groupsId="
         + this.getGroupsId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", jobNumber="
         + this.getJobNumber()
         + ", workshop="
         + this.getWorkshop()
         + ", machineTool="
         + this.getMachineTool()
         + ", finishDate="
         + this.getFinishDate()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ", drillProductionLineId="
         + this.getDrillProductionLineId()
         + ", drillProcessId="
         + this.getDrillProcessId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ", machinePartNestingCutJobParamList="
         + this.getMachinePartNestingCutJobParamList()
         + ")";
   }

   public static class MachinePartNestingCutParamBuilder {
      private Integer jobId;
      private Long groupsId;
      private Long productionLineId;
      private String jobNumber;
      private String workshop;
      private Long machineTool;
      private LocalDateTime finishDate;
      private Long drillGroupsId;
      private Long drillCutConfigId;
      private Long drillProductionLineId;
      private Long drillProcessId;
      private LocalDateTime drillAskCompleteTime;
      private List<MachinePartNestingCutJobParam> machinePartNestingCutJobParamList;

      MachinePartNestingCutParamBuilder() {
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder jobNumber(final String jobNumber) {
         this.jobNumber = jobNumber;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder workshop(final String workshop) {
         this.workshop = workshop;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder machineTool(final Long machineTool) {
         this.machineTool = machineTool;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder finishDate(final LocalDateTime finishDate) {
         this.finishDate = finishDate;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillCutConfigId")
      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder drillCutConfigId(final Long drillCutConfigId) {
         this.drillCutConfigId = drillCutConfigId;
         return this;
      }

      @JsonProperty("drillProductionLineId")
      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder drillProductionLineId(final Long drillProductionLineId) {
         this.drillProductionLineId = drillProductionLineId;
         return this;
      }

      @JsonProperty("drillProcessId")
      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder drillProcessId(final Long drillProcessId) {
         this.drillProcessId = drillProcessId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder drillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      public MachinePartNestingCutParam.MachinePartNestingCutParamBuilder machinePartNestingCutJobParamList(
         final List<MachinePartNestingCutJobParam> machinePartNestingCutJobParamList
      ) {
         this.machinePartNestingCutJobParamList = machinePartNestingCutJobParamList;
         return this;
      }

      public MachinePartNestingCutParam build() {
         return new MachinePartNestingCutParam(
            this.jobId,
            this.groupsId,
            this.productionLineId,
            this.jobNumber,
            this.workshop,
            this.machineTool,
            this.finishDate,
            this.drillGroupsId,
            this.drillCutConfigId,
            this.drillProductionLineId,
            this.drillProcessId,
            this.drillAskCompleteTime,
            this.machinePartNestingCutJobParamList
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingCutParam.MachinePartNestingCutParamBuilder(jobId="
            + this.jobId
            + ", groupsId="
            + this.groupsId
            + ", productionLineId="
            + this.productionLineId
            + ", jobNumber="
            + this.jobNumber
            + ", workshop="
            + this.workshop
            + ", machineTool="
            + this.machineTool
            + ", finishDate="
            + this.finishDate
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillCutConfigId="
            + this.drillCutConfigId
            + ", drillProductionLineId="
            + this.drillProductionLineId
            + ", drillProcessId="
            + this.drillProcessId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ", machinePartNestingCutJobParamList="
            + this.machinePartNestingCutJobParamList
            + ")";
      }
   }
}
