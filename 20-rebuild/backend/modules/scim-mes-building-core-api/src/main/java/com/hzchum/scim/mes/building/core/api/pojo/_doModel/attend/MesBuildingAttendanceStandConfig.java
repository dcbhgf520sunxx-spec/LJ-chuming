package com.hzchum.scim.mes.building.core.api.pojo._doModel.attend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingAttendanceStandConfig对象", description = "")
@Entity
@TableName("mes_building_attendance_stand_config")
@Table(name = "mes_building_attendance_stand_config")
@org.hibernate.annotations.Table(appliesTo = "mes_building_attendance_stand_config")
public class MesBuildingAttendanceStandConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "isBaseConfig", value = "是否是通用配置", notes = "是否是通用配置")
   @TableField("is_base_config")
   @Column(name = "is_base_config", columnDefinition = "tinyint(1)  COMMENT '是否是通用配置'", nullable = true)
   private Boolean isBaseConfig;
   @ApiModelProperty(name = "attendanceDate", value = "考勤日期", notes = "考勤日期")
   @TableField("attendance_date")
   @Column(name = "attendance_date", columnDefinition = "date  COMMENT '考勤日期'", nullable = true)
   private LocalDate attendanceDate;
   @ApiModelProperty(name = "clockType", value = "打卡方式参考枚举ClockTypeEnum", notes = "打卡方式参考枚举ClockTypeEnum")
   @TableField("clock_type")
   @Column(name = "clock_type", columnDefinition = "int(5)  COMMENT '打卡方式参考枚举ClockTypeEnum'", nullable = false)
   private Integer clockType;
   @ApiModelProperty(name = "weekScope", value = "生效范围参考枚举WeekScopeEnum", notes = "生效范围参考枚举WeekScopeEnum")
   @TableField("week_scope")
   @Column(name = "week_scope", columnDefinition = "int(11)  COMMENT '生效范围参考枚举WeekScopeEnum'", nullable = false)
   private Integer weekScope;
   @ApiModelProperty(name = "punchTimes", value = "打卡次数", notes = "打卡次数")
   @TableField("punch_times")
   @Column(name = "punch_times", columnDefinition = "int(5)  COMMENT '打卡次数'", nullable = false)
   private Integer punchTimes;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   @TableField("morning_working_time")
   @Column(name = "morning_working_time", columnDefinition = "datetime  COMMENT '上午上班打卡时间'", nullable = true)
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   @TableField("morning_closing_time")
   @Column(name = "morning_closing_time", columnDefinition = "datetime  COMMENT '上午下班打卡时间'", nullable = true)
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   @TableField("afternoon_working_time")
   @Column(name = "afternoon_working_time", columnDefinition = "datetime  COMMENT '下午上班打卡时间'", nullable = true)
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   @TableField("afternoon_closing_time")
   @Column(name = "afternoon_closing_time", columnDefinition = "datetime  COMMENT '下午下班打卡时间'", nullable = true)
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "isSetAdvance", value = "是否设置提前", notes = "是否设置提前")
   @TableField("is_set_advance")
   @Column(name = "is_set_advance", columnDefinition = "tinyint(1)  COMMENT '是否设置提前'", nullable = true)
   private Boolean isSetAdvance;
   @ApiModelProperty(name = "isSetDelay", value = "是否设置延迟", notes = "是否设置延迟")
   @TableField("is_set_delay")
   @Column(name = "is_set_delay", columnDefinition = "tinyint(1)  COMMENT '是否设置延迟'", nullable = true)
   private Boolean isSetDelay;
   @ApiModelProperty(name = "advanceTime", value = "提前时间", notes = "提前时间")
   @TableField("advance_time")
   @Column(name = "advance_time", columnDefinition = "int(11)  COMMENT '提前时间'", nullable = true)
   private Integer advanceTime;
   @ApiModelProperty(name = "delayTime", value = "延后时间", notes = "延后时间")
   @TableField("delay_time")
   @Column(name = "delay_time", columnDefinition = "int(11)  COMMENT '延后时间'", nullable = true)
   private Integer delayTime;
   @ApiModelProperty(name = "fenceJson", value = "点位json", notes = "点位json")
   @TableField("fence_json")
   @Column(name = "fence_json", columnDefinition = "text  COMMENT '点位json'", nullable = true)
   private String fenceJson;

   public static MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder builder() {
      return new MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder();
   }

   public MesBuildingAttendanceStandConfig() {
   }

   public MesBuildingAttendanceStandConfig(
      final Long id,
      final Boolean isBaseConfig,
      final LocalDate attendanceDate,
      final Integer clockType,
      final Integer weekScope,
      final Integer punchTimes,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final Boolean isSetAdvance,
      final Boolean isSetDelay,
      final Integer advanceTime,
      final Integer delayTime,
      final String fenceJson
   ) {
      this.id = id;
      this.isBaseConfig = isBaseConfig;
      this.attendanceDate = attendanceDate;
      this.clockType = clockType;
      this.weekScope = weekScope;
      this.punchTimes = punchTimes;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.isSetAdvance = isSetAdvance;
      this.isSetDelay = isSetDelay;
      this.advanceTime = advanceTime;
      this.delayTime = delayTime;
      this.fenceJson = fenceJson;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getIsBaseConfig() {
      return this.isBaseConfig;
   }

   public LocalDate getAttendanceDate() {
      return this.attendanceDate;
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

   public String getFenceJson() {
      return this.fenceJson;
   }

   public MesBuildingAttendanceStandConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAttendanceStandConfig setIsBaseConfig(final Boolean isBaseConfig) {
      this.isBaseConfig = isBaseConfig;
      return this;
   }

   public MesBuildingAttendanceStandConfig setAttendanceDate(final LocalDate attendanceDate) {
      this.attendanceDate = attendanceDate;
      return this;
   }

   public MesBuildingAttendanceStandConfig setClockType(final Integer clockType) {
      this.clockType = clockType;
      return this;
   }

   public MesBuildingAttendanceStandConfig setWeekScope(final Integer weekScope) {
      this.weekScope = weekScope;
      return this;
   }

   public MesBuildingAttendanceStandConfig setPunchTimes(final Integer punchTimes) {
      this.punchTimes = punchTimes;
      return this;
   }

   public MesBuildingAttendanceStandConfig setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfig setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfig setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfig setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public MesBuildingAttendanceStandConfig setIsSetAdvance(final Boolean isSetAdvance) {
      this.isSetAdvance = isSetAdvance;
      return this;
   }

   public MesBuildingAttendanceStandConfig setIsSetDelay(final Boolean isSetDelay) {
      this.isSetDelay = isSetDelay;
      return this;
   }

   public MesBuildingAttendanceStandConfig setAdvanceTime(final Integer advanceTime) {
      this.advanceTime = advanceTime;
      return this;
   }

   public MesBuildingAttendanceStandConfig setDelayTime(final Integer delayTime) {
      this.delayTime = delayTime;
      return this;
   }

   public MesBuildingAttendanceStandConfig setFenceJson(final String fenceJson) {
      this.fenceJson = fenceJson;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceStandConfig(id="
         + this.getId()
         + ", isBaseConfig="
         + this.getIsBaseConfig()
         + ", attendanceDate="
         + this.getAttendanceDate()
         + ", clockType="
         + this.getClockType()
         + ", weekScope="
         + this.getWeekScope()
         + ", punchTimes="
         + this.getPunchTimes()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", isSetAdvance="
         + this.getIsSetAdvance()
         + ", isSetDelay="
         + this.getIsSetDelay()
         + ", advanceTime="
         + this.getAdvanceTime()
         + ", delayTime="
         + this.getDelayTime()
         + ", fenceJson="
         + this.getFenceJson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceStandConfig)) {
         return false;
      }

      MesBuildingAttendanceStandConfig other = (MesBuildingAttendanceStandConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isBaseConfig = this.getIsBaseConfig();
         Object other$isBaseConfig = other.getIsBaseConfig();
         if (this$isBaseConfig == null ? other$isBaseConfig == null : this$isBaseConfig.equals(other$isBaseConfig)) {
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
                                 Object this$attendanceDate = this.getAttendanceDate();
                                 Object other$attendanceDate = other.getAttendanceDate();
                                 if (this$attendanceDate == null ? other$attendanceDate == null : this$attendanceDate.equals(other$attendanceDate)) {
                                    Object this$morningWorkingTime = this.getMorningWorkingTime();
                                    Object other$morningWorkingTime = other.getMorningWorkingTime();
                                    if (this$morningWorkingTime == null
                                       ? other$morningWorkingTime == null
                                       : this$morningWorkingTime.equals(other$morningWorkingTime)) {
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
                                                Object this$fenceJson = this.getFenceJson();
                                                Object other$fenceJson = other.getFenceJson();
                                                return this$fenceJson == null ? other$fenceJson == null : this$fenceJson.equals(other$fenceJson);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAttendanceStandConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isBaseConfig = this.getIsBaseConfig();
      result = result * 59 + ($isBaseConfig == null ? 43 : $isBaseConfig.hashCode());
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
      Object $attendanceDate = this.getAttendanceDate();
      result = result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $fenceJson = this.getFenceJson();
      return result * 59 + ($fenceJson == null ? 43 : $fenceJson.hashCode());
   }

   public static class MesBuildingAttendanceStandConfigBuilder {
      private Long id;
      private Boolean isBaseConfig;
      private LocalDate attendanceDate;
      private Integer clockType;
      private Integer weekScope;
      private Integer punchTimes;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private Boolean isSetAdvance;
      private Boolean isSetDelay;
      private Integer advanceTime;
      private Integer delayTime;
      private String fenceJson;

      MesBuildingAttendanceStandConfigBuilder() {
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder isBaseConfig(final Boolean isBaseConfig) {
         this.isBaseConfig = isBaseConfig;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder attendanceDate(final LocalDate attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder clockType(final Integer clockType) {
         this.clockType = clockType;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder weekScope(final Integer weekScope) {
         this.weekScope = weekScope;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder punchTimes(final Integer punchTimes) {
         this.punchTimes = punchTimes;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder isSetAdvance(final Boolean isSetAdvance) {
         this.isSetAdvance = isSetAdvance;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder isSetDelay(final Boolean isSetDelay) {
         this.isSetDelay = isSetDelay;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder advanceTime(final Integer advanceTime) {
         this.advanceTime = advanceTime;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder delayTime(final Integer delayTime) {
         this.delayTime = delayTime;
         return this;
      }

      public MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder fenceJson(final String fenceJson) {
         this.fenceJson = fenceJson;
         return this;
      }

      public MesBuildingAttendanceStandConfig build() {
         return new MesBuildingAttendanceStandConfig(
            this.id,
            this.isBaseConfig,
            this.attendanceDate,
            this.clockType,
            this.weekScope,
            this.punchTimes,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.isSetAdvance,
            this.isSetDelay,
            this.advanceTime,
            this.delayTime,
            this.fenceJson
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceStandConfig.MesBuildingAttendanceStandConfigBuilder(id="
            + this.id
            + ", isBaseConfig="
            + this.isBaseConfig
            + ", attendanceDate="
            + this.attendanceDate
            + ", clockType="
            + this.clockType
            + ", weekScope="
            + this.weekScope
            + ", punchTimes="
            + this.punchTimes
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", isSetAdvance="
            + this.isSetAdvance
            + ", isSetDelay="
            + this.isSetDelay
            + ", advanceTime="
            + this.advanceTime
            + ", delayTime="
            + this.delayTime
            + ", fenceJson="
            + this.fenceJson
            + ")";
      }
   }
}
