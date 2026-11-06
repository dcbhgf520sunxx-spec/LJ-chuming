package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("考勤汇总信息")
public class MesAttendanceSummaryDTO {
   @ApiModelProperty(name = "attendanceDate", value = "日期", notes = "日期")
   private String attendanceDate;
   @ApiModelProperty(name = "totalNumber", value = "应到人数", notes = "应到人数")
   private Integer standTotalNumber;
   @ApiModelProperty(name = "clockNumber", value = "实到人数", notes = "实到人数")
   private Integer standClockNumber;
   @ApiModelProperty(name = "absenteeNumber", value = "缺勤人数", notes = "缺勤人数")
   private Integer standAbsenteeNumber;
   @ApiModelProperty(name = "overTotalNumber", value = "应到人数", notes = "应到人数")
   private Integer overTotalNumber;
   @ApiModelProperty(name = "overClockNumber", value = "实到人数", notes = "实到人数")
   private Integer overClockNumber;
   @ApiModelProperty(name = "overAbsenteeNumber", value = "缺勤人数", notes = "缺勤人数")
   private Integer overAbsenteeNumber;

   public static MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder builder() {
      return new MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder();
   }

   public MesAttendanceSummaryDTO() {
   }

   public MesAttendanceSummaryDTO(
      final String attendanceDate,
      final Integer standTotalNumber,
      final Integer standClockNumber,
      final Integer standAbsenteeNumber,
      final Integer overTotalNumber,
      final Integer overClockNumber,
      final Integer overAbsenteeNumber
   ) {
      this.attendanceDate = attendanceDate;
      this.standTotalNumber = standTotalNumber;
      this.standClockNumber = standClockNumber;
      this.standAbsenteeNumber = standAbsenteeNumber;
      this.overTotalNumber = overTotalNumber;
      this.overClockNumber = overClockNumber;
      this.overAbsenteeNumber = overAbsenteeNumber;
   }

   public String getAttendanceDate() {
      return this.attendanceDate;
   }

   public Integer getStandTotalNumber() {
      return this.standTotalNumber;
   }

   public Integer getStandClockNumber() {
      return this.standClockNumber;
   }

   public Integer getStandAbsenteeNumber() {
      return this.standAbsenteeNumber;
   }

   public Integer getOverTotalNumber() {
      return this.overTotalNumber;
   }

   public Integer getOverClockNumber() {
      return this.overClockNumber;
   }

   public Integer getOverAbsenteeNumber() {
      return this.overAbsenteeNumber;
   }

   public MesAttendanceSummaryDTO setAttendanceDate(final String attendanceDate) {
      this.attendanceDate = attendanceDate;
      return this;
   }

   public MesAttendanceSummaryDTO setStandTotalNumber(final Integer standTotalNumber) {
      this.standTotalNumber = standTotalNumber;
      return this;
   }

   public MesAttendanceSummaryDTO setStandClockNumber(final Integer standClockNumber) {
      this.standClockNumber = standClockNumber;
      return this;
   }

   public MesAttendanceSummaryDTO setStandAbsenteeNumber(final Integer standAbsenteeNumber) {
      this.standAbsenteeNumber = standAbsenteeNumber;
      return this;
   }

   public MesAttendanceSummaryDTO setOverTotalNumber(final Integer overTotalNumber) {
      this.overTotalNumber = overTotalNumber;
      return this;
   }

   public MesAttendanceSummaryDTO setOverClockNumber(final Integer overClockNumber) {
      this.overClockNumber = overClockNumber;
      return this;
   }

   public MesAttendanceSummaryDTO setOverAbsenteeNumber(final Integer overAbsenteeNumber) {
      this.overAbsenteeNumber = overAbsenteeNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesAttendanceSummaryDTO(attendanceDate="
         + this.getAttendanceDate()
         + ", standTotalNumber="
         + this.getStandTotalNumber()
         + ", standClockNumber="
         + this.getStandClockNumber()
         + ", standAbsenteeNumber="
         + this.getStandAbsenteeNumber()
         + ", overTotalNumber="
         + this.getOverTotalNumber()
         + ", overClockNumber="
         + this.getOverClockNumber()
         + ", overAbsenteeNumber="
         + this.getOverAbsenteeNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAttendanceSummaryDTO)) {
         return false;
      }

      MesAttendanceSummaryDTO other = (MesAttendanceSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$standTotalNumber = this.getStandTotalNumber();
      Object other$standTotalNumber = other.getStandTotalNumber();
      if (this$standTotalNumber == null ? other$standTotalNumber == null : this$standTotalNumber.equals(other$standTotalNumber)) {
         Object this$standClockNumber = this.getStandClockNumber();
         Object other$standClockNumber = other.getStandClockNumber();
         if (this$standClockNumber == null ? other$standClockNumber == null : this$standClockNumber.equals(other$standClockNumber)) {
            Object this$standAbsenteeNumber = this.getStandAbsenteeNumber();
            Object other$standAbsenteeNumber = other.getStandAbsenteeNumber();
            if (this$standAbsenteeNumber == null ? other$standAbsenteeNumber == null : this$standAbsenteeNumber.equals(other$standAbsenteeNumber)) {
               Object this$overTotalNumber = this.getOverTotalNumber();
               Object other$overTotalNumber = other.getOverTotalNumber();
               if (this$overTotalNumber == null ? other$overTotalNumber == null : this$overTotalNumber.equals(other$overTotalNumber)) {
                  Object this$overClockNumber = this.getOverClockNumber();
                  Object other$overClockNumber = other.getOverClockNumber();
                  if (this$overClockNumber == null ? other$overClockNumber == null : this$overClockNumber.equals(other$overClockNumber)) {
                     Object this$overAbsenteeNumber = this.getOverAbsenteeNumber();
                     Object other$overAbsenteeNumber = other.getOverAbsenteeNumber();
                     if (this$overAbsenteeNumber == null ? other$overAbsenteeNumber == null : this$overAbsenteeNumber.equals(other$overAbsenteeNumber)) {
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
      return other instanceof MesAttendanceSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $standTotalNumber = this.getStandTotalNumber();
      result = result * 59 + ($standTotalNumber == null ? 43 : $standTotalNumber.hashCode());
      Object $standClockNumber = this.getStandClockNumber();
      result = result * 59 + ($standClockNumber == null ? 43 : $standClockNumber.hashCode());
      Object $standAbsenteeNumber = this.getStandAbsenteeNumber();
      result = result * 59 + ($standAbsenteeNumber == null ? 43 : $standAbsenteeNumber.hashCode());
      Object $overTotalNumber = this.getOverTotalNumber();
      result = result * 59 + ($overTotalNumber == null ? 43 : $overTotalNumber.hashCode());
      Object $overClockNumber = this.getOverClockNumber();
      result = result * 59 + ($overClockNumber == null ? 43 : $overClockNumber.hashCode());
      Object $overAbsenteeNumber = this.getOverAbsenteeNumber();
      result = result * 59 + ($overAbsenteeNumber == null ? 43 : $overAbsenteeNumber.hashCode());
      Object $attendanceDate = this.getAttendanceDate();
      return result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
   }

   public static class MesAttendanceSummaryDTOBuilder {
      private String attendanceDate;
      private Integer standTotalNumber;
      private Integer standClockNumber;
      private Integer standAbsenteeNumber;
      private Integer overTotalNumber;
      private Integer overClockNumber;
      private Integer overAbsenteeNumber;

      MesAttendanceSummaryDTOBuilder() {
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder attendanceDate(final String attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder standTotalNumber(final Integer standTotalNumber) {
         this.standTotalNumber = standTotalNumber;
         return this;
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder standClockNumber(final Integer standClockNumber) {
         this.standClockNumber = standClockNumber;
         return this;
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder standAbsenteeNumber(final Integer standAbsenteeNumber) {
         this.standAbsenteeNumber = standAbsenteeNumber;
         return this;
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder overTotalNumber(final Integer overTotalNumber) {
         this.overTotalNumber = overTotalNumber;
         return this;
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder overClockNumber(final Integer overClockNumber) {
         this.overClockNumber = overClockNumber;
         return this;
      }

      public MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder overAbsenteeNumber(final Integer overAbsenteeNumber) {
         this.overAbsenteeNumber = overAbsenteeNumber;
         return this;
      }

      public MesAttendanceSummaryDTO build() {
         return new MesAttendanceSummaryDTO(
            this.attendanceDate,
            this.standTotalNumber,
            this.standClockNumber,
            this.standAbsenteeNumber,
            this.overTotalNumber,
            this.overClockNumber,
            this.overAbsenteeNumber
         );
      }

      @Override
      public String toString() {
         return "MesAttendanceSummaryDTO.MesAttendanceSummaryDTOBuilder(attendanceDate="
            + this.attendanceDate
            + ", standTotalNumber="
            + this.standTotalNumber
            + ", standClockNumber="
            + this.standClockNumber
            + ", standAbsenteeNumber="
            + this.standAbsenteeNumber
            + ", overTotalNumber="
            + this.overTotalNumber
            + ", overClockNumber="
            + this.overClockNumber
            + ", overAbsenteeNumber="
            + this.overAbsenteeNumber
            + ")";
      }
   }
}
