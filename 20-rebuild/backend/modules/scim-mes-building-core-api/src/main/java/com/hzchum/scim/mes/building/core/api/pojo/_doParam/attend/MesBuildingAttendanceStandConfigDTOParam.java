package com.hzchum.scim.mes.building.core.api.pojo._doParam.attend;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockNumberEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.attend.PointDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingAttendanceStandConfigDTOParam", description = "考勤常规配置参数")
public class MesBuildingAttendanceStandConfigDTOParam {
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
   @NotNull(message = "打卡方式不能为空")
   @EnumValidator(value = ClockTypeEnum.class, message = "打卡方式不正确！")
   private Integer clockType;
   @ApiModelProperty(name = "weekScope", value = "生效范围参考枚举WeekScopeEnum", notes = "生效范围参考枚举WeekScopeEnum")
   @NotNull(message = "生效日期不正确！")
   private Integer weekScope;
   @ApiModelProperty(name = "punchTimes", value = "打卡次数", notes = "打卡次数")
   @NotNull(message = "打卡次数不正确！")
   @EnumValidator(value = ClockNumberEnum.class, message = "打卡次数不正确！")
   private Integer punchTimes;
   @ApiModelProperty(name = "isSetAdvance", value = "是否设置提前", notes = "是否设置提前")
   @NotNull(message = "是否提前不能为空！")
   private Boolean isSetAdvance;
   @ApiModelProperty(name = "isSetDelay", value = "是否设置延迟", notes = "是否设置延迟")
   @NotNull(message = "是否延迟不能为空！")
   private Boolean isSetDelay;
   @ApiModelProperty(name = "advanceTime", value = "提前时间", notes = "提前时间")
   private Integer advanceTime;
   @ApiModelProperty(name = "delayTime", value = "延后时间", notes = "延后时间")
   private Integer delayTime;
   @ApiModelProperty(name = "points", notes = "电子围栏")
   private List<PointDO> points;

   public static MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder builder() {
      return new MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder();
   }

   public MesBuildingAttendanceStandConfigDTOParam() {
   }

   public MesBuildingAttendanceStandConfigDTOParam(
      final Long id,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final Integer clockType,
      final Integer weekScope,
      final Integer punchTimes,
      final Boolean isSetAdvance,
      final Boolean isSetDelay,
      final Integer advanceTime,
      final Integer delayTime,
      final List<PointDO> points
   ) {
      this.id = id;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.clockType = clockType;
      this.weekScope = weekScope;
      this.punchTimes = punchTimes;
      this.isSetAdvance = isSetAdvance;
      this.isSetDelay = isSetDelay;
      this.advanceTime = advanceTime;
      this.delayTime = delayTime;
      this.points = points;
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

   public List<PointDO> getPoints() {
      return this.points;
   }

   public MesBuildingAttendanceStandConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setClockType(final Integer clockType) {
      this.clockType = clockType;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setWeekScope(final Integer weekScope) {
      this.weekScope = weekScope;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setPunchTimes(final Integer punchTimes) {
      this.punchTimes = punchTimes;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setIsSetAdvance(final Boolean isSetAdvance) {
      this.isSetAdvance = isSetAdvance;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setIsSetDelay(final Boolean isSetDelay) {
      this.isSetDelay = isSetDelay;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setAdvanceTime(final Integer advanceTime) {
      this.advanceTime = advanceTime;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setDelayTime(final Integer delayTime) {
      this.delayTime = delayTime;
      return this;
   }

   public MesBuildingAttendanceStandConfigDTOParam setPoints(final List<PointDO> points) {
      this.points = points;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceStandConfigDTOParam)) {
         return false;
      }

      MesBuildingAttendanceStandConfigDTOParam other = (MesBuildingAttendanceStandConfigDTOParam)o;
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
                                          Object this$points = this.getPoints();
                                          Object other$points = other.getPoints();
                                          return this$points == null ? other$points == null : this$points.equals(other$points);
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
      return other instanceof MesBuildingAttendanceStandConfigDTOParam;
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
      Object $points = this.getPoints();
      return result * 59 + ($points == null ? 43 : $points.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceStandConfigDTOParam(id="
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
         + ", points="
         + this.getPoints()
         + ")";
   }

   public static class MesBuildingAttendanceStandConfigDTOParamBuilder {
      private Long id;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private Integer clockType;
      private Integer weekScope;
      private Integer punchTimes;
      private Boolean isSetAdvance;
      private Boolean isSetDelay;
      private Integer advanceTime;
      private Integer delayTime;
      private List<PointDO> points;

      MesBuildingAttendanceStandConfigDTOParamBuilder() {
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder afternoonWorkingTime(
         final LocalDateTime afternoonWorkingTime
      ) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder afternoonClosingTime(
         final LocalDateTime afternoonClosingTime
      ) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder clockType(final Integer clockType) {
         this.clockType = clockType;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder weekScope(final Integer weekScope) {
         this.weekScope = weekScope;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder punchTimes(final Integer punchTimes) {
         this.punchTimes = punchTimes;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder isSetAdvance(final Boolean isSetAdvance) {
         this.isSetAdvance = isSetAdvance;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder isSetDelay(final Boolean isSetDelay) {
         this.isSetDelay = isSetDelay;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder advanceTime(final Integer advanceTime) {
         this.advanceTime = advanceTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder delayTime(final Integer delayTime) {
         this.delayTime = delayTime;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder points(final List<PointDO> points) {
         this.points = points;
         return this;
      }

      public MesBuildingAttendanceStandConfigDTOParam build() {
         return new MesBuildingAttendanceStandConfigDTOParam(
            this.id,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.clockType,
            this.weekScope,
            this.punchTimes,
            this.isSetAdvance,
            this.isSetDelay,
            this.advanceTime,
            this.delayTime,
            this.points
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceStandConfigDTOParam.MesBuildingAttendanceStandConfigDTOParamBuilder(id="
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
            + ", points="
            + this.points
            + ")";
      }
   }
}
