package com.hzchum.scim.project.core.api.pojo.dto.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("考勤汇总信息")
public class ProjectManageAttendanceSummaryDTO {
   @ApiModelProperty(name = "attendanceDate", value = "日期", notes = "日期")
   private String attendanceDate;
   @ApiModelProperty(name = "totalNumber", value = "应到人数", notes = "应到人数")
   private Integer totalNumber;
   @ApiModelProperty(name = "clockNumber", value = "打卡人数", notes = "打卡人数")
   private Integer clockNumber;
   @ApiModelProperty(name = "absenteeNumber", value = "矿工人数", notes = "矿工人数")
   private Integer absenteeNumber;

   public static ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder builder() {
      return new ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder();
   }

   public ProjectManageAttendanceSummaryDTO() {
   }

   public ProjectManageAttendanceSummaryDTO(final String attendanceDate, final Integer totalNumber, final Integer clockNumber, final Integer absenteeNumber) {
      this.attendanceDate = attendanceDate;
      this.totalNumber = totalNumber;
      this.clockNumber = clockNumber;
      this.absenteeNumber = absenteeNumber;
   }

   public String getAttendanceDate() {
      return this.attendanceDate;
   }

   public Integer getTotalNumber() {
      return this.totalNumber;
   }

   public Integer getClockNumber() {
      return this.clockNumber;
   }

   public Integer getAbsenteeNumber() {
      return this.absenteeNumber;
   }

   public ProjectManageAttendanceSummaryDTO setAttendanceDate(final String attendanceDate) {
      this.attendanceDate = attendanceDate;
      return this;
   }

   public ProjectManageAttendanceSummaryDTO setTotalNumber(final Integer totalNumber) {
      this.totalNumber = totalNumber;
      return this;
   }

   public ProjectManageAttendanceSummaryDTO setClockNumber(final Integer clockNumber) {
      this.clockNumber = clockNumber;
      return this;
   }

   public ProjectManageAttendanceSummaryDTO setAbsenteeNumber(final Integer absenteeNumber) {
      this.absenteeNumber = absenteeNumber;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceSummaryDTO(attendanceDate="
         + this.getAttendanceDate()
         + ", totalNumber="
         + this.getTotalNumber()
         + ", clockNumber="
         + this.getClockNumber()
         + ", absenteeNumber="
         + this.getAbsenteeNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceSummaryDTO)) {
         return false;
      }

      ProjectManageAttendanceSummaryDTO other = (ProjectManageAttendanceSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalNumber = this.getTotalNumber();
      Object other$totalNumber = other.getTotalNumber();
      if (this$totalNumber == null ? other$totalNumber == null : this$totalNumber.equals(other$totalNumber)) {
         Object this$clockNumber = this.getClockNumber();
         Object other$clockNumber = other.getClockNumber();
         if (this$clockNumber == null ? other$clockNumber == null : this$clockNumber.equals(other$clockNumber)) {
            Object this$absenteeNumber = this.getAbsenteeNumber();
            Object other$absenteeNumber = other.getAbsenteeNumber();
            if (this$absenteeNumber == null ? other$absenteeNumber == null : this$absenteeNumber.equals(other$absenteeNumber)) {
               Object this$attendanceDate = this.getAttendanceDate();
               Object other$attendanceDate = other.getAttendanceDate();
               return this$attendanceDate == null ? other$attendanceDate == null : this$attendanceDate.equals(other$attendanceDate);
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
      return other instanceof ProjectManageAttendanceSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalNumber = this.getTotalNumber();
      result = result * 59 + ($totalNumber == null ? 43 : $totalNumber.hashCode());
      Object $clockNumber = this.getClockNumber();
      result = result * 59 + ($clockNumber == null ? 43 : $clockNumber.hashCode());
      Object $absenteeNumber = this.getAbsenteeNumber();
      result = result * 59 + ($absenteeNumber == null ? 43 : $absenteeNumber.hashCode());
      Object $attendanceDate = this.getAttendanceDate();
      return result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
   }

   public static class ProjectManageAttendanceSummaryDTOBuilder {
      private String attendanceDate;
      private Integer totalNumber;
      private Integer clockNumber;
      private Integer absenteeNumber;

      ProjectManageAttendanceSummaryDTOBuilder() {
      }

      public ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder attendanceDate(final String attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder totalNumber(final Integer totalNumber) {
         this.totalNumber = totalNumber;
         return this;
      }

      public ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder clockNumber(final Integer clockNumber) {
         this.clockNumber = clockNumber;
         return this;
      }

      public ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder absenteeNumber(final Integer absenteeNumber) {
         this.absenteeNumber = absenteeNumber;
         return this;
      }

      public ProjectManageAttendanceSummaryDTO build() {
         return new ProjectManageAttendanceSummaryDTO(this.attendanceDate, this.totalNumber, this.clockNumber, this.absenteeNumber);
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceSummaryDTO.ProjectManageAttendanceSummaryDTOBuilder(attendanceDate="
            + this.attendanceDate
            + ", totalNumber="
            + this.totalNumber
            + ", clockNumber="
            + this.clockNumber
            + ", absenteeNumber="
            + this.absenteeNumber
            + ")";
      }
   }
}
