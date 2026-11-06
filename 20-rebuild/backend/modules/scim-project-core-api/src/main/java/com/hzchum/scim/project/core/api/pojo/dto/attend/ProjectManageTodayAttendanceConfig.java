package com.hzchum.scim.project.core.api.pojo.dto.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("app人员当日打卡信息")
public class ProjectManageTodayAttendanceConfig {
   @ApiModelProperty(name = "isNeedClock", value = "是否需要打卡", notes = "是否需要打卡")
   private Boolean isNeedClock;
   @ApiModelProperty(name = "isOutScope", value = "允许迟到早退", notes = "允许迟到早退")
   private Boolean isOutScope;
   @ApiModelProperty(name = "isNeedPicture", value = "是否需要拍照", notes = "是否需要拍照")
   private Boolean isNeedPicture;
   @ApiModelProperty(name = "isNeedFence", value = "是否需要电子围栏", notes = "是否需要电子围栏")
   private Boolean isNeedFence;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "overtimeWorkingTime", value = "加班上班打卡时间", notes = "加班上班打卡时间")
   private LocalDateTime overtimeWorkingTime;
   @ApiModelProperty(name = "overtimeClosingTime", value = "加班下班打卡时间", notes = "加班下班打卡时间")
   private LocalDateTime overtimeClosingTime;
   @ApiModelProperty(name = "morningWorkingTimeConfig", value = "配置时间", notes = "配置时间")
   private LocalDateTime morningWorkingTimeConfig;
   @ApiModelProperty(name = "morningClosingTimeConfig", value = "配置时间", notes = "配置时间")
   private LocalDateTime morningClosingTimeConfig;
   @ApiModelProperty(name = "afternoonWorkingTimeConfig", value = "配置时间", notes = "配置时间")
   private LocalDateTime afternoonWorkingTimeConfig;
   @ApiModelProperty(name = "afternoonClosingTimeConfig", value = "配置时间", notes = "配置时间")
   private LocalDateTime afternoonClosingTimeConfig;
   @ApiModelProperty(name = "fenceDTOList", value = "电子围栏范围", notes = "电子围栏范围")
   private List<ProjectManageAttendanceFenceDTO> fenceDTOList;

   public static ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder builder() {
      return new ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder();
   }

   public ProjectManageTodayAttendanceConfig() {
   }

   public ProjectManageTodayAttendanceConfig(
      final Boolean isNeedClock,
      final Boolean isOutScope,
      final Boolean isNeedPicture,
      final Boolean isNeedFence,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final LocalDateTime morningWorkingTimeConfig,
      final LocalDateTime morningClosingTimeConfig,
      final LocalDateTime afternoonWorkingTimeConfig,
      final LocalDateTime afternoonClosingTimeConfig,
      final List<ProjectManageAttendanceFenceDTO> fenceDTOList
   ) {
      this.isNeedClock = isNeedClock;
      this.isOutScope = isOutScope;
      this.isNeedPicture = isNeedPicture;
      this.isNeedFence = isNeedFence;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.morningWorkingTimeConfig = morningWorkingTimeConfig;
      this.morningClosingTimeConfig = morningClosingTimeConfig;
      this.afternoonWorkingTimeConfig = afternoonWorkingTimeConfig;
      this.afternoonClosingTimeConfig = afternoonClosingTimeConfig;
      this.fenceDTOList = fenceDTOList;
   }

   public Boolean getIsNeedClock() {
      return this.isNeedClock;
   }

   public Boolean getIsOutScope() {
      return this.isOutScope;
   }

   public Boolean getIsNeedPicture() {
      return this.isNeedPicture;
   }

   public Boolean getIsNeedFence() {
      return this.isNeedFence;
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

   public LocalDateTime getOvertimeWorkingTime() {
      return this.overtimeWorkingTime;
   }

   public LocalDateTime getOvertimeClosingTime() {
      return this.overtimeClosingTime;
   }

   public LocalDateTime getMorningWorkingTimeConfig() {
      return this.morningWorkingTimeConfig;
   }

   public LocalDateTime getMorningClosingTimeConfig() {
      return this.morningClosingTimeConfig;
   }

   public LocalDateTime getAfternoonWorkingTimeConfig() {
      return this.afternoonWorkingTimeConfig;
   }

   public LocalDateTime getAfternoonClosingTimeConfig() {
      return this.afternoonClosingTimeConfig;
   }

   public List<ProjectManageAttendanceFenceDTO> getFenceDTOList() {
      return this.fenceDTOList;
   }

   public ProjectManageTodayAttendanceConfig setIsNeedClock(final Boolean isNeedClock) {
      this.isNeedClock = isNeedClock;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setIsOutScope(final Boolean isOutScope) {
      this.isOutScope = isOutScope;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setIsNeedPicture(final Boolean isNeedPicture) {
      this.isNeedPicture = isNeedPicture;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setIsNeedFence(final Boolean isNeedFence) {
      this.isNeedFence = isNeedFence;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setMorningWorkingTimeConfig(final LocalDateTime morningWorkingTimeConfig) {
      this.morningWorkingTimeConfig = morningWorkingTimeConfig;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setMorningClosingTimeConfig(final LocalDateTime morningClosingTimeConfig) {
      this.morningClosingTimeConfig = morningClosingTimeConfig;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setAfternoonWorkingTimeConfig(final LocalDateTime afternoonWorkingTimeConfig) {
      this.afternoonWorkingTimeConfig = afternoonWorkingTimeConfig;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setAfternoonClosingTimeConfig(final LocalDateTime afternoonClosingTimeConfig) {
      this.afternoonClosingTimeConfig = afternoonClosingTimeConfig;
      return this;
   }

   public ProjectManageTodayAttendanceConfig setFenceDTOList(final List<ProjectManageAttendanceFenceDTO> fenceDTOList) {
      this.fenceDTOList = fenceDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageTodayAttendanceConfig(isNeedClock="
         + this.getIsNeedClock()
         + ", isOutScope="
         + this.getIsOutScope()
         + ", isNeedPicture="
         + this.getIsNeedPicture()
         + ", isNeedFence="
         + this.getIsNeedFence()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", overtimeWorkingTime="
         + this.getOvertimeWorkingTime()
         + ", overtimeClosingTime="
         + this.getOvertimeClosingTime()
         + ", morningWorkingTimeConfig="
         + this.getMorningWorkingTimeConfig()
         + ", morningClosingTimeConfig="
         + this.getMorningClosingTimeConfig()
         + ", afternoonWorkingTimeConfig="
         + this.getAfternoonWorkingTimeConfig()
         + ", afternoonClosingTimeConfig="
         + this.getAfternoonClosingTimeConfig()
         + ", fenceDTOList="
         + this.getFenceDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageTodayAttendanceConfig)) {
         return false;
      }

      ProjectManageTodayAttendanceConfig other = (ProjectManageTodayAttendanceConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isNeedClock = this.getIsNeedClock();
      Object other$isNeedClock = other.getIsNeedClock();
      if (this$isNeedClock == null ? other$isNeedClock == null : this$isNeedClock.equals(other$isNeedClock)) {
         Object this$isOutScope = this.getIsOutScope();
         Object other$isOutScope = other.getIsOutScope();
         if (this$isOutScope == null ? other$isOutScope == null : this$isOutScope.equals(other$isOutScope)) {
            Object this$isNeedPicture = this.getIsNeedPicture();
            Object other$isNeedPicture = other.getIsNeedPicture();
            if (this$isNeedPicture == null ? other$isNeedPicture == null : this$isNeedPicture.equals(other$isNeedPicture)) {
               Object this$isNeedFence = this.getIsNeedFence();
               Object other$isNeedFence = other.getIsNeedFence();
               if (this$isNeedFence == null ? other$isNeedFence == null : this$isNeedFence.equals(other$isNeedFence)) {
                  Object this$morningWorkingTime = this.getMorningWorkingTime();
                  Object other$morningWorkingTime = other.getMorningWorkingTime();
                  if (this$morningWorkingTime == null ? other$morningWorkingTime == null : this$morningWorkingTime.equals(other$morningWorkingTime)) {
                     Object this$morningClosingTime = this.getMorningClosingTime();
                     Object other$morningClosingTime = other.getMorningClosingTime();
                     if (this$morningClosingTime == null ? other$morningClosingTime == null : this$morningClosingTime.equals(other$morningClosingTime)) {
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
                              Object this$overtimeWorkingTime = this.getOvertimeWorkingTime();
                              Object other$overtimeWorkingTime = other.getOvertimeWorkingTime();
                              if (this$overtimeWorkingTime == null
                                 ? other$overtimeWorkingTime == null
                                 : this$overtimeWorkingTime.equals(other$overtimeWorkingTime)) {
                                 Object this$overtimeClosingTime = this.getOvertimeClosingTime();
                                 Object other$overtimeClosingTime = other.getOvertimeClosingTime();
                                 if (this$overtimeClosingTime == null
                                    ? other$overtimeClosingTime == null
                                    : this$overtimeClosingTime.equals(other$overtimeClosingTime)) {
                                    Object this$morningWorkingTimeConfig = this.getMorningWorkingTimeConfig();
                                    Object other$morningWorkingTimeConfig = other.getMorningWorkingTimeConfig();
                                    if (this$morningWorkingTimeConfig == null
                                       ? other$morningWorkingTimeConfig == null
                                       : this$morningWorkingTimeConfig.equals(other$morningWorkingTimeConfig)) {
                                       Object this$morningClosingTimeConfig = this.getMorningClosingTimeConfig();
                                       Object other$morningClosingTimeConfig = other.getMorningClosingTimeConfig();
                                       if (this$morningClosingTimeConfig == null
                                          ? other$morningClosingTimeConfig == null
                                          : this$morningClosingTimeConfig.equals(other$morningClosingTimeConfig)) {
                                          Object this$afternoonWorkingTimeConfig = this.getAfternoonWorkingTimeConfig();
                                          Object other$afternoonWorkingTimeConfig = other.getAfternoonWorkingTimeConfig();
                                          if (this$afternoonWorkingTimeConfig == null
                                             ? other$afternoonWorkingTimeConfig == null
                                             : this$afternoonWorkingTimeConfig.equals(other$afternoonWorkingTimeConfig)) {
                                             Object this$afternoonClosingTimeConfig = this.getAfternoonClosingTimeConfig();
                                             Object other$afternoonClosingTimeConfig = other.getAfternoonClosingTimeConfig();
                                             if (this$afternoonClosingTimeConfig == null
                                                ? other$afternoonClosingTimeConfig == null
                                                : this$afternoonClosingTimeConfig.equals(other$afternoonClosingTimeConfig)) {
                                                Object this$fenceDTOList = this.getFenceDTOList();
                                                Object other$fenceDTOList = other.getFenceDTOList();
                                                return this$fenceDTOList == null ? other$fenceDTOList == null : this$fenceDTOList.equals(other$fenceDTOList);
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
      return other instanceof ProjectManageTodayAttendanceConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isNeedClock = this.getIsNeedClock();
      result = result * 59 + ($isNeedClock == null ? 43 : $isNeedClock.hashCode());
      Object $isOutScope = this.getIsOutScope();
      result = result * 59 + ($isOutScope == null ? 43 : $isOutScope.hashCode());
      Object $isNeedPicture = this.getIsNeedPicture();
      result = result * 59 + ($isNeedPicture == null ? 43 : $isNeedPicture.hashCode());
      Object $isNeedFence = this.getIsNeedFence();
      result = result * 59 + ($isNeedFence == null ? 43 : $isNeedFence.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $overtimeWorkingTime = this.getOvertimeWorkingTime();
      result = result * 59 + ($overtimeWorkingTime == null ? 43 : $overtimeWorkingTime.hashCode());
      Object $overtimeClosingTime = this.getOvertimeClosingTime();
      result = result * 59 + ($overtimeClosingTime == null ? 43 : $overtimeClosingTime.hashCode());
      Object $morningWorkingTimeConfig = this.getMorningWorkingTimeConfig();
      result = result * 59 + ($morningWorkingTimeConfig == null ? 43 : $morningWorkingTimeConfig.hashCode());
      Object $morningClosingTimeConfig = this.getMorningClosingTimeConfig();
      result = result * 59 + ($morningClosingTimeConfig == null ? 43 : $morningClosingTimeConfig.hashCode());
      Object $afternoonWorkingTimeConfig = this.getAfternoonWorkingTimeConfig();
      result = result * 59 + ($afternoonWorkingTimeConfig == null ? 43 : $afternoonWorkingTimeConfig.hashCode());
      Object $afternoonClosingTimeConfig = this.getAfternoonClosingTimeConfig();
      result = result * 59 + ($afternoonClosingTimeConfig == null ? 43 : $afternoonClosingTimeConfig.hashCode());
      Object $fenceDTOList = this.getFenceDTOList();
      return result * 59 + ($fenceDTOList == null ? 43 : $fenceDTOList.hashCode());
   }

   public static class ProjectManageTodayAttendanceConfigBuilder {
      private Boolean isNeedClock;
      private Boolean isOutScope;
      private Boolean isNeedPicture;
      private Boolean isNeedFence;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private LocalDateTime morningWorkingTimeConfig;
      private LocalDateTime morningClosingTimeConfig;
      private LocalDateTime afternoonWorkingTimeConfig;
      private LocalDateTime afternoonClosingTimeConfig;
      private List<ProjectManageAttendanceFenceDTO> fenceDTOList;

      ProjectManageTodayAttendanceConfigBuilder() {
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder isNeedClock(final Boolean isNeedClock) {
         this.isNeedClock = isNeedClock;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder isOutScope(final Boolean isOutScope) {
         this.isOutScope = isOutScope;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder isNeedPicture(final Boolean isNeedPicture) {
         this.isNeedPicture = isNeedPicture;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder isNeedFence(final Boolean isNeedFence) {
         this.isNeedFence = isNeedFence;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder morningWorkingTimeConfig(final LocalDateTime morningWorkingTimeConfig) {
         this.morningWorkingTimeConfig = morningWorkingTimeConfig;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder morningClosingTimeConfig(final LocalDateTime morningClosingTimeConfig) {
         this.morningClosingTimeConfig = morningClosingTimeConfig;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder afternoonWorkingTimeConfig(
         final LocalDateTime afternoonWorkingTimeConfig
      ) {
         this.afternoonWorkingTimeConfig = afternoonWorkingTimeConfig;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder afternoonClosingTimeConfig(
         final LocalDateTime afternoonClosingTimeConfig
      ) {
         this.afternoonClosingTimeConfig = afternoonClosingTimeConfig;
         return this;
      }

      public ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder fenceDTOList(final List<ProjectManageAttendanceFenceDTO> fenceDTOList) {
         this.fenceDTOList = fenceDTOList;
         return this;
      }

      public ProjectManageTodayAttendanceConfig build() {
         return new ProjectManageTodayAttendanceConfig(
            this.isNeedClock,
            this.isOutScope,
            this.isNeedPicture,
            this.isNeedFence,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.overtimeWorkingTime,
            this.overtimeClosingTime,
            this.morningWorkingTimeConfig,
            this.morningClosingTimeConfig,
            this.afternoonWorkingTimeConfig,
            this.afternoonClosingTimeConfig,
            this.fenceDTOList
         );
      }

      @Override
      public String toString() {
         return "ProjectManageTodayAttendanceConfig.ProjectManageTodayAttendanceConfigBuilder(isNeedClock="
            + this.isNeedClock
            + ", isOutScope="
            + this.isOutScope
            + ", isNeedPicture="
            + this.isNeedPicture
            + ", isNeedFence="
            + this.isNeedFence
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", overtimeWorkingTime="
            + this.overtimeWorkingTime
            + ", overtimeClosingTime="
            + this.overtimeClosingTime
            + ", morningWorkingTimeConfig="
            + this.morningWorkingTimeConfig
            + ", morningClosingTimeConfig="
            + this.morningClosingTimeConfig
            + ", afternoonWorkingTimeConfig="
            + this.afternoonWorkingTimeConfig
            + ", afternoonClosingTimeConfig="
            + this.afternoonClosingTimeConfig
            + ", fenceDTOList="
            + this.fenceDTOList
            + ")";
      }
   }
}
