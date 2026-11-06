package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("作业下的钢板Param")
public class JobSteelPlateParam {
   @ApiModelProperty("作业id")
   private Integer jobId;
   @ApiModelProperty("零件切割配置id")
   private Long machinePartCuttingConfigId;
   @ApiModelProperty("完成日期")
   private LocalDateTime finishDate;
   @ApiModelProperty("钻孔生产组id")
   private Long drillGroupsId;
   @ApiModelProperty("钻孔班组id")
   private Long drillTeamId;
   @ApiModelProperty("钻孔切割配置id")
   private Long drillCutConfigId;
   @ApiModelProperty("钻孔生产线id")
   private Long drillProductionLineId;
   @ApiModelProperty("钻孔工序id")
   private Long drillProcessId;
   @ApiModelProperty("钻孔要求完成日期")
   private LocalDateTime drillAskCompleteTime;
   @ApiModelProperty("钢板idList")
   private List<Long> nestingResultIdList;
   @ApiModelProperty("是否二次排产(0:否,1:是)")
   private Boolean boolSecondaryScheduling;
   @ApiModelProperty("删除范围(1:删除套料板和零件,2:仅删除套料板)")
   private Integer deleteScope;

   public Integer getJobId() {
      return this.jobId;
   }

   public Long getMachinePartCuttingConfigId() {
      return this.machinePartCuttingConfigId;
   }

   public LocalDateTime getFinishDate() {
      return this.finishDate;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public Long getDrillTeamId() {
      return this.drillTeamId;
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

   public List<Long> getNestingResultIdList() {
      return this.nestingResultIdList;
   }

   public Boolean getBoolSecondaryScheduling() {
      return this.boolSecondaryScheduling;
   }

   public Integer getDeleteScope() {
      return this.deleteScope;
   }

   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   public void setMachinePartCuttingConfigId(final Long machinePartCuttingConfigId) {
      this.machinePartCuttingConfigId = machinePartCuttingConfigId;
   }

   public void setFinishDate(final LocalDateTime finishDate) {
      this.finishDate = finishDate;
   }

   public void setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
   }

   public void setDrillTeamId(final Long drillTeamId) {
      this.drillTeamId = drillTeamId;
   }

   public void setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
   }

   public void setDrillProductionLineId(final Long drillProductionLineId) {
      this.drillProductionLineId = drillProductionLineId;
   }

   public void setDrillProcessId(final Long drillProcessId) {
      this.drillProcessId = drillProcessId;
   }

   public void setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
   }

   public void setNestingResultIdList(final List<Long> nestingResultIdList) {
      this.nestingResultIdList = nestingResultIdList;
   }

   public void setBoolSecondaryScheduling(final Boolean boolSecondaryScheduling) {
      this.boolSecondaryScheduling = boolSecondaryScheduling;
   }

   public void setDeleteScope(final Integer deleteScope) {
      this.deleteScope = deleteScope;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JobSteelPlateParam)) {
         return false;
      }

      JobSteelPlateParam other = (JobSteelPlateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$machinePartCuttingConfigId = this.getMachinePartCuttingConfigId();
         Object other$machinePartCuttingConfigId = other.getMachinePartCuttingConfigId();
         if (this$machinePartCuttingConfigId == null
            ? other$machinePartCuttingConfigId == null
            : this$machinePartCuttingConfigId.equals(other$machinePartCuttingConfigId)) {
            Object this$drillGroupsId = this.getDrillGroupsId();
            Object other$drillGroupsId = other.getDrillGroupsId();
            if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
               Object this$drillTeamId = this.getDrillTeamId();
               Object other$drillTeamId = other.getDrillTeamId();
               if (this$drillTeamId == null ? other$drillTeamId == null : this$drillTeamId.equals(other$drillTeamId)) {
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
                           Object this$boolSecondaryScheduling = this.getBoolSecondaryScheduling();
                           Object other$boolSecondaryScheduling = other.getBoolSecondaryScheduling();
                           if (this$boolSecondaryScheduling == null
                              ? other$boolSecondaryScheduling == null
                              : this$boolSecondaryScheduling.equals(other$boolSecondaryScheduling)) {
                              Object this$deleteScope = this.getDeleteScope();
                              Object other$deleteScope = other.getDeleteScope();
                              if (this$deleteScope == null ? other$deleteScope == null : this$deleteScope.equals(other$deleteScope)) {
                                 Object this$finishDate = this.getFinishDate();
                                 Object other$finishDate = other.getFinishDate();
                                 if (this$finishDate == null ? other$finishDate == null : this$finishDate.equals(other$finishDate)) {
                                    Object this$drillAskCompleteTime = this.getDrillAskCompleteTime();
                                    Object other$drillAskCompleteTime = other.getDrillAskCompleteTime();
                                    if (this$drillAskCompleteTime == null
                                       ? other$drillAskCompleteTime == null
                                       : this$drillAskCompleteTime.equals(other$drillAskCompleteTime)) {
                                       Object this$nestingResultIdList = this.getNestingResultIdList();
                                       Object other$nestingResultIdList = other.getNestingResultIdList();
                                       return this$nestingResultIdList == null
                                          ? other$nestingResultIdList == null
                                          : this$nestingResultIdList.equals(other$nestingResultIdList);
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
      return other instanceof JobSteelPlateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $machinePartCuttingConfigId = this.getMachinePartCuttingConfigId();
      result = result * 59 + ($machinePartCuttingConfigId == null ? 43 : $machinePartCuttingConfigId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $drillTeamId = this.getDrillTeamId();
      result = result * 59 + ($drillTeamId == null ? 43 : $drillTeamId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $drillProductionLineId = this.getDrillProductionLineId();
      result = result * 59 + ($drillProductionLineId == null ? 43 : $drillProductionLineId.hashCode());
      Object $drillProcessId = this.getDrillProcessId();
      result = result * 59 + ($drillProcessId == null ? 43 : $drillProcessId.hashCode());
      Object $boolSecondaryScheduling = this.getBoolSecondaryScheduling();
      result = result * 59 + ($boolSecondaryScheduling == null ? 43 : $boolSecondaryScheduling.hashCode());
      Object $deleteScope = this.getDeleteScope();
      result = result * 59 + ($deleteScope == null ? 43 : $deleteScope.hashCode());
      Object $finishDate = this.getFinishDate();
      result = result * 59 + ($finishDate == null ? 43 : $finishDate.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      result = result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
      Object $nestingResultIdList = this.getNestingResultIdList();
      return result * 59 + ($nestingResultIdList == null ? 43 : $nestingResultIdList.hashCode());
   }

   @Override
   public String toString() {
      return "JobSteelPlateParam(jobId="
         + this.getJobId()
         + ", machinePartCuttingConfigId="
         + this.getMachinePartCuttingConfigId()
         + ", finishDate="
         + this.getFinishDate()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillTeamId="
         + this.getDrillTeamId()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ", drillProductionLineId="
         + this.getDrillProductionLineId()
         + ", drillProcessId="
         + this.getDrillProcessId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ", nestingResultIdList="
         + this.getNestingResultIdList()
         + ", boolSecondaryScheduling="
         + this.getBoolSecondaryScheduling()
         + ", deleteScope="
         + this.getDeleteScope()
         + ")";
   }
}
