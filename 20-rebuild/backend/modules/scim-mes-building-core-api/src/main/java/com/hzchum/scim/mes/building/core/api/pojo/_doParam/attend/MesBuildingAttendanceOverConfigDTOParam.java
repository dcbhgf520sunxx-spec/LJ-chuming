package com.hzchum.scim.mes.building.core.api.pojo._doParam.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingAttendanceOverConfigDTOParam", description = "考勤加班配置参数")
public class MesBuildingAttendanceOverConfigDTOParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "departmentId", value = "部门ID", notes = "部门ID")
   @NotNull(message = "部门不能为空")
   private Long departmentId;
   @ApiModelProperty(name = "overtimeWorkingTime", value = "加班开始时间", notes = "加班开始时间")
   @NotNull(message = "加班开始时间不能为空")
   private LocalDateTime overtimeWorkingTime;
   @ApiModelProperty(name = "overtimeClosingTime", value = "加班结束时间", notes = "加班结束时间")
   @NotNull(message = "加班结束时间不能为空")
   private LocalDateTime overtimeClosingTime;
   @ApiModelProperty(name = "isCanDelay", value = "是否允许迟到", notes = "是否允许迟到")
   @NotNull(message = "打卡方式不能为空")
   private Boolean isCanDelay;
   @ApiModelProperty(name = "isCanEarly", value = "是否允许早退", notes = "是否允许早退")
   @NotNull(message = "打卡方式不能为空")
   private Boolean isCanEarly;
   @ApiModelProperty(name = "rosterIds", value = "劳务id", notes = "劳务id")
   @NotEmpty(message = "加班人员不能为空")
   private List<Long> rosterIds;

   public static MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder builder() {
      return new MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder();
   }

   public MesBuildingAttendanceOverConfigDTOParam() {
   }

   public MesBuildingAttendanceOverConfigDTOParam(
      final Long id,
      final Long departmentId,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final Boolean isCanDelay,
      final Boolean isCanEarly,
      final List<Long> rosterIds
   ) {
      this.id = id;
      this.departmentId = departmentId;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.isCanDelay = isCanDelay;
      this.isCanEarly = isCanEarly;
      this.rosterIds = rosterIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getOvertimeWorkingTime() {
      return this.overtimeWorkingTime;
   }

   public LocalDateTime getOvertimeClosingTime() {
      return this.overtimeClosingTime;
   }

   public Boolean getIsCanDelay() {
      return this.isCanDelay;
   }

   public Boolean getIsCanEarly() {
      return this.isCanEarly;
   }

   public List<Long> getRosterIds() {
      return this.rosterIds;
   }

   public MesBuildingAttendanceOverConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAttendanceOverConfigDTOParam setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public MesBuildingAttendanceOverConfigDTOParam setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
      return this;
   }

   public MesBuildingAttendanceOverConfigDTOParam setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
      return this;
   }

   public MesBuildingAttendanceOverConfigDTOParam setIsCanDelay(final Boolean isCanDelay) {
      this.isCanDelay = isCanDelay;
      return this;
   }

   public MesBuildingAttendanceOverConfigDTOParam setIsCanEarly(final Boolean isCanEarly) {
      this.isCanEarly = isCanEarly;
      return this;
   }

   public MesBuildingAttendanceOverConfigDTOParam setRosterIds(final List<Long> rosterIds) {
      this.rosterIds = rosterIds;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceOverConfigDTOParam)) {
         return false;
      }

      MesBuildingAttendanceOverConfigDTOParam other = (MesBuildingAttendanceOverConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$isCanDelay = this.getIsCanDelay();
            Object other$isCanDelay = other.getIsCanDelay();
            if (this$isCanDelay == null ? other$isCanDelay == null : this$isCanDelay.equals(other$isCanDelay)) {
               Object this$isCanEarly = this.getIsCanEarly();
               Object other$isCanEarly = other.getIsCanEarly();
               if (this$isCanEarly == null ? other$isCanEarly == null : this$isCanEarly.equals(other$isCanEarly)) {
                  Object this$overtimeWorkingTime = this.getOvertimeWorkingTime();
                  Object other$overtimeWorkingTime = other.getOvertimeWorkingTime();
                  if (this$overtimeWorkingTime == null ? other$overtimeWorkingTime == null : this$overtimeWorkingTime.equals(other$overtimeWorkingTime)) {
                     Object this$overtimeClosingTime = this.getOvertimeClosingTime();
                     Object other$overtimeClosingTime = other.getOvertimeClosingTime();
                     if (this$overtimeClosingTime == null ? other$overtimeClosingTime == null : this$overtimeClosingTime.equals(other$overtimeClosingTime)) {
                        Object this$rosterIds = this.getRosterIds();
                        Object other$rosterIds = other.getRosterIds();
                        return this$rosterIds == null ? other$rosterIds == null : this$rosterIds.equals(other$rosterIds);
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
      return other instanceof MesBuildingAttendanceOverConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $isCanDelay = this.getIsCanDelay();
      result = result * 59 + ($isCanDelay == null ? 43 : $isCanDelay.hashCode());
      Object $isCanEarly = this.getIsCanEarly();
      result = result * 59 + ($isCanEarly == null ? 43 : $isCanEarly.hashCode());
      Object $overtimeWorkingTime = this.getOvertimeWorkingTime();
      result = result * 59 + ($overtimeWorkingTime == null ? 43 : $overtimeWorkingTime.hashCode());
      Object $overtimeClosingTime = this.getOvertimeClosingTime();
      result = result * 59 + ($overtimeClosingTime == null ? 43 : $overtimeClosingTime.hashCode());
      Object $rosterIds = this.getRosterIds();
      return result * 59 + ($rosterIds == null ? 43 : $rosterIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceOverConfigDTOParam(id="
         + this.getId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", overtimeWorkingTime="
         + this.getOvertimeWorkingTime()
         + ", overtimeClosingTime="
         + this.getOvertimeClosingTime()
         + ", isCanDelay="
         + this.getIsCanDelay()
         + ", isCanEarly="
         + this.getIsCanEarly()
         + ", rosterIds="
         + this.getRosterIds()
         + ")";
   }

   public static class MesBuildingAttendanceOverConfigDTOParamBuilder {
      private Long id;
      private Long departmentId;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private Boolean isCanDelay;
      private Boolean isCanEarly;
      private List<Long> rosterIds;

      MesBuildingAttendanceOverConfigDTOParamBuilder() {
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder isCanDelay(final Boolean isCanDelay) {
         this.isCanDelay = isCanDelay;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder isCanEarly(final Boolean isCanEarly) {
         this.isCanEarly = isCanEarly;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder rosterIds(final List<Long> rosterIds) {
         this.rosterIds = rosterIds;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTOParam build() {
         return new MesBuildingAttendanceOverConfigDTOParam(
            this.id, this.departmentId, this.overtimeWorkingTime, this.overtimeClosingTime, this.isCanDelay, this.isCanEarly, this.rosterIds
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceOverConfigDTOParam.MesBuildingAttendanceOverConfigDTOParamBuilder(id="
            + this.id
            + ", departmentId="
            + this.departmentId
            + ", overtimeWorkingTime="
            + this.overtimeWorkingTime
            + ", overtimeClosingTime="
            + this.overtimeClosingTime
            + ", isCanDelay="
            + this.isCanDelay
            + ", isCanEarly="
            + this.isCanEarly
            + ", rosterIds="
            + this.rosterIds
            + ")";
      }
   }
}
