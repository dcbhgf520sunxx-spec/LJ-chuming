package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ExcelTarget("MesBuildingAttendanceStandConfigDTO")
@ApiModel("考勤基础配置返回类")
public class MesBuildingAttendanceStandConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "clockType", value = "打卡方式参考枚举ClockTypeEnum", notes = "打卡方式参考枚举ClockTypeEnum")
   private Integer clockType;
   @ApiModelProperty(name = "weekScope", value = "生效范围参考枚举WeekScopeEnum", notes = "生效范围参考枚举WeekScopeEnum")
   private Integer weekScope;
   @ApiModelProperty(name = "weekScopeList", value = "生效范围参考枚举WeekScopeEnum", notes = "生效范围参考枚举WeekScopeEnum")
   private List<Integer> weekScopeList;
   @ApiModelProperty(name = "punchTimes", value = "打卡次数", notes = "打卡次数")
   private Integer punchTimes;
   @ApiModelProperty(name = "isSetAdvance", value = "是否设置提前", notes = "是否设置提前")
   private Boolean isSetAdvance;
   @ApiModelProperty(name = "isSetDelay", value = "是否设置延迟", notes = "是否设置延迟")
   private Boolean isSetDelay;
   @ApiModelProperty(name = "advanceTime", value = "提前时间", notes = "提前时间")
   private Integer advanceTime;
   @ApiModelProperty(name = "delayTime", value = "延后时间", notes = "延后时间")
   private Integer delayTime;
   @ApiModelProperty(name = "pointDTOList", notes = "电子围栏")
   private List<PointDTO> pointDTOList;

   public static MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder builder() {
      return new MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getMorningWorkingTime() {
      return this.morningWorkingTime;
   }

   public LocalDateTime getMorningClosingTime() {
      return this.morningClosingTime;
   }

   public LocalDateTime getAfternoonWorkingTime() {
      return this.afternoonWorkingTime;
   }

   public LocalDateTime getAfternoonClosingTime() {
      return this.afternoonClosingTime;
   }

   public Integer getClockType() {
      return this.clockType;
   }

   public Integer getWeekScope() {
      return this.weekScope;
   }

   public List<Integer> getWeekScopeList() {
      return this.weekScopeList;
   }

   public Integer getPunchTimes() {
      return this.punchTimes;
   }

   public Boolean getIsSetAdvance() {
      return this.isSetAdvance;
   }

   public Boolean getIsSetDelay() {
      return this.isSetDelay;
   }

   public Integer getAdvanceTime() {
      return this.advanceTime;
   }

   public Integer getDelayTime() {
      return this.delayTime;
   }

   public List<PointDTO> getPointDTOList() {
      return this.pointDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
   }

   public void setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
   }

   public void setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
   }

   public void setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
   }

   public void setClockType(final Integer clockType) {
      this.clockType = clockType;
   }

   public void setWeekScope(final Integer weekScope) {
      this.weekScope = weekScope;
   }

   public void setWeekScopeList(final List<Integer> weekScopeList) {
      this.weekScopeList = weekScopeList;
   }

   public void setPunchTimes(final Integer punchTimes) {
      this.punchTimes = punchTimes;
   }

   public void setIsSetAdvance(final Boolean isSetAdvance) {
      this.isSetAdvance = isSetAdvance;
   }

   public void setIsSetDelay(final Boolean isSetDelay) {
      this.isSetDelay = isSetDelay;
   }

   public void setAdvanceTime(final Integer advanceTime) {
      this.advanceTime = advanceTime;
   }

   public void setDelayTime(final Integer delayTime) {
      this.delayTime = delayTime;
   }

   public void setPointDTOList(final List<PointDTO> pointDTOList) {
      this.pointDTOList = pointDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceStandConfigDTO)) {
         return false;
      }

      MesBuildingAttendanceStandConfigDTO other = (MesBuildingAttendanceStandConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$clockType = this.getClockType();
         Object other$clockType = other.getClockType();
         if (this$clockType == null ? other$clockType == null : this$clockType.equals(other$clockType)) {
            Object this$weekScope = this.getWeekScope();
            Object other$weekScope = other.getWeekScope();
            if (this$weekScope == null ? other$weekScope == null : this$weekScope.equals(other$weekScope)) {
               Object this$punchTimes = this.getPunchTimes();
               Object other$punchTimes = other.getPunchTimes();
               if (this$punchTimes == null ? other$punchTimes == null : this$punchTimes.equals(other$punchTimes)) {
                  Object this$isSetAdvance = this.getIsSetAdvance();
                  Object other$isSetAdvance = other.getIsSetAdvance();
                  if (this$isSetAdvance == null ? other$isSetAdvance == null : this$isSetAdvance.equals(other$isSetAdvance)) {
                     Object this$isSetDelay = this.getIsSetDelay();
                     Object other$isSetDelay = other.getIsSetDelay();
                     if (this$isSetDelay == null ? other$isSetDelay == null : this$isSetDelay.equals(other$isSetDelay)) {
                        Object this$advanceTime = this.getAdvanceTime();
                        Object other$advanceTime = other.getAdvanceTime();
                        if (this$advanceTime == null ? other$advanceTime == null : this$advanceTime.equals(other$advanceTime)) {
                           Object this$delayTime = this.getDelayTime();
                           Object other$delayTime = other.getDelayTime();
                           if (this$delayTime == null ? other$delayTime == null : this$delayTime.equals(other$delayTime)) {
                              Object this$morningWorkingTime = this.getMorningWorkingTime();
                              Object other$morningWorkingTime = other.getMorningWorkingTime();
                              if (this$morningWorkingTime == null ? other$morningWorkingTime == null : this$morningWorkingTime.equals(other$morningWorkingTime)
                                 )
                               {
                                 Object this$morningClosingTime = this.getMorningClosingTime();
                                 Object other$morningClosingTime = other.getMorningClosingTime();
                                 if (this$morningClosingTime == null
                                    ? other$morningClosingTime == null
                                    : this$morningClosingTime.equals(other$morningClosingTime)) {
                                    Object this$afternoonWorkingTime = this.getAfternoonWorkingTime();
                                    Object other$afternoonWorkingTime = other.getAfternoonWorkingTime();
                                    if (this$afternoonWorkingTime == null
                                       ? other$afternoonWorkingTime == null
                                       : this$afternoonWorkingTime.equals(other$afternoonWorkingTime)) {
                                       Object this$afternoonClosingTime = this.getAfternoonClosingTime();
                                       Object other$afternoonClosingTime = other.getAfternoonClosingTime();
                                       if (this$afternoonClosingTime == null
                                          ? other$afternoonClosingTime == null
                                          : this$afternoonClosingTime.equals(other$afternoonClosingTime)) {
                                          Object this$weekScopeList = this.getWeekScopeList();
                                          Object other$weekScopeList = other.getWeekScopeList();
                                          if (this$weekScopeList == null ? other$weekScopeList == null : this$weekScopeList.equals(other$weekScopeList)) {
                                             Object this$pointDTOList = this.getPointDTOList();
                                             Object other$pointDTOList = other.getPointDTOList();
                                             return this$pointDTOList == null ? other$pointDTOList == null : this$pointDTOList.equals(other$pointDTOList);
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
      return other instanceof MesBuildingAttendanceStandConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $clockType = this.getClockType();
      result = result * 59 + ($clockType == null ? 43 : $clockType.hashCode());
      Object $weekScope = this.getWeekScope();
      result = result * 59 + ($weekScope == null ? 43 : $weekScope.hashCode());
      Object $punchTimes = this.getPunchTimes();
      result = result * 59 + ($punchTimes == null ? 43 : $punchTimes.hashCode());
      Object $isSetAdvance = this.getIsSetAdvance();
      result = result * 59 + ($isSetAdvance == null ? 43 : $isSetAdvance.hashCode());
      Object $isSetDelay = this.getIsSetDelay();
      result = result * 59 + ($isSetDelay == null ? 43 : $isSetDelay.hashCode());
      Object $advanceTime = this.getAdvanceTime();
      result = result * 59 + ($advanceTime == null ? 43 : $advanceTime.hashCode());
      Object $delayTime = this.getDelayTime();
      result = result * 59 + ($delayTime == null ? 43 : $delayTime.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $weekScopeList = this.getWeekScopeList();
      result = result * 59 + ($weekScopeList == null ? 43 : $weekScopeList.hashCode());
      Object $pointDTOList = this.getPointDTOList();
      return result * 59 + ($pointDTOList == null ? 43 : $pointDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceStandConfigDTO(id="
         + this.getId()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", clockType="
         + this.getClockType()
         + ", weekScope="
         + this.getWeekScope()
         + ", weekScopeList="
         + this.getWeekScopeList()
         + ", punchTimes="
         + this.getPunchTimes()
         + ", isSetAdvance="
         + this.getIsSetAdvance()
         + ", isSetDelay="
         + this.getIsSetDelay()
         + ", advanceTime="
         + this.getAdvanceTime()
         + ", delayTime="
         + this.getDelayTime()
         + ", pointDTOList="
         + this.getPointDTOList()
         + ")";
   }

   public MesBuildingAttendanceStandConfigDTO() {
   }

   public MesBuildingAttendanceStandConfigDTO(
      final Long id,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final Integer clockType,
      final Integer weekScope,
      final List<Integer> weekScopeList,
      final Integer punchTimes,
      final Boolean isSetAdvance,
      final Boolean isSetDelay,
      final Integer advanceTime,
      final Integer delayTime,
      final List<PointDTO> pointDTOList
   ) {
      this.id = id;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.clockType = clockType;
      this.weekScope = weekScope;
      this.weekScopeList = weekScopeList;
      this.punchTimes = punchTimes;
      this.isSetAdvance = isSetAdvance;
      this.isSetDelay = isSetDelay;
      this.advanceTime = advanceTime;
      this.delayTime = delayTime;
      this.pointDTOList = pointDTOList;
   }

   public static class MesBuildingAttendanceStandConfigDTOBuilder {
      private Long id;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private Integer clockType;
      private Integer weekScope;
      private List<Integer> weekScopeList;
      private Integer punchTimes;
      private Boolean isSetAdvance;
      private Boolean isSetDelay;
      private Integer advanceTime;
      private Integer delayTime;
      private List<PointDTO> pointDTOList;

      MesBuildingAttendanceStandConfigDTOBuilder() {
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder clockType(final Integer clockType) {
         this.clockType = clockType;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder weekScope(final Integer weekScope) {
         this.weekScope = weekScope;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder weekScopeList(final List<Integer> weekScopeList) {
         this.weekScopeList = weekScopeList;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder punchTimes(final Integer punchTimes) {
         this.punchTimes = punchTimes;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder isSetAdvance(final Boolean isSetAdvance) {
         this.isSetAdvance = isSetAdvance;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder isSetDelay(final Boolean isSetDelay) {
         this.isSetDelay = isSetDelay;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder advanceTime(final Integer advanceTime) {
         this.advanceTime = advanceTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder delayTime(final Integer delayTime) {
         this.delayTime = delayTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder pointDTOList(final List<PointDTO> pointDTOList) {
         this.pointDTOList = pointDTOList;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTO build() {
         return new MesBuildingAttendanceStandConfigDTO(
            this.id,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.clockType,
            this.weekScope,
            this.weekScopeList,
            this.punchTimes,
            this.isSetAdvance,
            this.isSetDelay,
            this.advanceTime,
            this.delayTime,
            this.pointDTOList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceStandConfigDTO.MesBuildingAttendanceStandConfigDTOBuilder(id="
            + this.id
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", clockType="
            + this.clockType
            + ", weekScope="
            + this.weekScope
            + ", weekScopeList="
            + this.weekScopeList
            + ", punchTimes="
            + this.punchTimes
            + ", isSetAdvance="
            + this.isSetAdvance
            + ", isSetDelay="
            + this.isSetDelay
            + ", advanceTime="
            + this.advanceTime
            + ", delayTime="
            + this.delayTime
            + ", pointDTOList="
            + this.pointDTOList
            + ")";
      }
   }
}
