package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExcelTarget("MesAttendanceDayDetailsDTO")
@ApiModel("考勤日详情返回类")
public class MesAttendanceDayDetailsDTO {
   @ApiModelProperty(name = "rosterId", value = "花名册id", notes = "花名册id")
   private Long rosterId;
   @ApiModelProperty(name = "attendanceDate", value = "日期", notes = "日期")
   private LocalDate attendanceDate;
   @ApiModelProperty(name = "userName", value = "姓名", notes = "姓名")
   private String name;
   @ApiModelProperty(name = "deptName", value = "部门", notes = "部门")
   private String deptName;
   @ApiModelProperty(name = "wokeName", value = "工种", notes = "工种")
   private String wokeName;
   @ApiModelProperty(name = "supplierName", value = "分包商", notes = "分包商")
   private String supplierName;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "workHours", value = "标准工时", notes = "标准工时")
   private BigDecimal workHours;
   @ApiModelProperty(name = "overWorkHours", value = "加班标准工时", notes = "加班标准工时")
   private BigDecimal overWorkHours;
   @ApiModelProperty(name = "actualHours", value = "实际普通工时", notes = "实际普通工时")
   private BigDecimal actualHours;
   @ApiModelProperty(name = "overHours", value = "加班工时", notes = "加班工时")
   private BigDecimal overHours;
   @ApiModelProperty(name = "morningHours", value = "上午工时", notes = "上午工时")
   private BigDecimal morningHours;
   @ApiModelProperty(name = "afternoonHours", value = "下午工时", notes = "下午工时")
   private BigDecimal afternoonHours;
   @ApiModelProperty(name = "attendStatus", value = "常规考勤状态", notes = "常规考勤状态")
   private Integer attendStatus;
   @ApiModelProperty(name = "attendStatus", value = "加班考勤状态", notes = "加班考勤状态")
   private Integer overStatus;
   @JsonInclude
   @ApiModelProperty(name = "dateStr", value = "日期+星期", notes = "日期+星期")
   private String dateStr;
   @JsonInclude
   @ApiModelProperty(name = "totalHours", value = "总时长", notes = "总时长")
   private BigDecimal totalHours;
   @ApiModelProperty(name = "overClockDTOList", value = "考勤打卡列表", notes = "考勤打卡列表")
   List<MesBuildingAttendanceOverConfigDTO> overClockDTOList;
   @JsonInclude
   @ApiModelProperty(name = "dateStr", value = "加班上班字符串", notes = "加班上班字符串")
   private String workingStr;
   @JsonInclude
   @ApiModelProperty(name = "dateStr", value = "加班下班字符串", notes = "加班下班字符串")
   private String closingStr;
   @JsonInclude
   @ApiModelProperty(name = "absenceHours", value = "缺勤工时", notes = "缺勤工时")
   private BigDecimal absenceHours;

   public static MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder builder() {
      return new MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder();
   }

   public Long getRosterId() {
      return this.rosterId;
   }

   public LocalDate getAttendanceDate() {
      return this.attendanceDate;
   }

   public String getName() {
      return this.name;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public String getWokeName() {
      return this.wokeName;
   }

   public String getSupplierName() {
      return this.supplierName;
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

   public BigDecimal getWorkHours() {
      return this.workHours;
   }

   public BigDecimal getOverWorkHours() {
      return this.overWorkHours;
   }

   public BigDecimal getActualHours() {
      return this.actualHours;
   }

   public BigDecimal getOverHours() {
      return this.overHours;
   }

   public BigDecimal getMorningHours() {
      return this.morningHours;
   }

   public BigDecimal getAfternoonHours() {
      return this.afternoonHours;
   }

   public Integer getAttendStatus() {
      return this.attendStatus;
   }

   public Integer getOverStatus() {
      return this.overStatus;
   }

   public String getDateStr() {
      return this.dateStr;
   }

   public BigDecimal getTotalHours() {
      return this.totalHours;
   }

   public List<MesBuildingAttendanceOverConfigDTO> getOverClockDTOList() {
      return this.overClockDTOList;
   }

   public String getWorkingStr() {
      return this.workingStr;
   }

   public String getClosingStr() {
      return this.closingStr;
   }

   public BigDecimal getAbsenceHours() {
      return this.absenceHours;
   }

   public void setRosterId(final Long rosterId) {
      this.rosterId = rosterId;
   }

   public void setAttendanceDate(final LocalDate attendanceDate) {
      this.attendanceDate = attendanceDate;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setWokeName(final String wokeName) {
      this.wokeName = wokeName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
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

   public void setWorkHours(final BigDecimal workHours) {
      this.workHours = workHours;
   }

   public void setOverWorkHours(final BigDecimal overWorkHours) {
      this.overWorkHours = overWorkHours;
   }

   public void setActualHours(final BigDecimal actualHours) {
      this.actualHours = actualHours;
   }

   public void setOverHours(final BigDecimal overHours) {
      this.overHours = overHours;
   }

   public void setMorningHours(final BigDecimal morningHours) {
      this.morningHours = morningHours;
   }

   public void setAfternoonHours(final BigDecimal afternoonHours) {
      this.afternoonHours = afternoonHours;
   }

   public void setAttendStatus(final Integer attendStatus) {
      this.attendStatus = attendStatus;
   }

   public void setOverStatus(final Integer overStatus) {
      this.overStatus = overStatus;
   }

   public void setDateStr(final String dateStr) {
      this.dateStr = dateStr;
   }

   public void setTotalHours(final BigDecimal totalHours) {
      this.totalHours = totalHours;
   }

   public void setOverClockDTOList(final List<MesBuildingAttendanceOverConfigDTO> overClockDTOList) {
      this.overClockDTOList = overClockDTOList;
   }

   public void setWorkingStr(final String workingStr) {
      this.workingStr = workingStr;
   }

   public void setClosingStr(final String closingStr) {
      this.closingStr = closingStr;
   }

   public void setAbsenceHours(final BigDecimal absenceHours) {
      this.absenceHours = absenceHours;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAttendanceDayDetailsDTO)) {
         return false;
      }

      MesAttendanceDayDetailsDTO other = (MesAttendanceDayDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$rosterId = this.getRosterId();
      Object other$rosterId = other.getRosterId();
      if (this$rosterId == null ? other$rosterId == null : this$rosterId.equals(other$rosterId)) {
         Object this$attendStatus = this.getAttendStatus();
         Object other$attendStatus = other.getAttendStatus();
         if (this$attendStatus == null ? other$attendStatus == null : this$attendStatus.equals(other$attendStatus)) {
            Object this$overStatus = this.getOverStatus();
            Object other$overStatus = other.getOverStatus();
            if (this$overStatus == null ? other$overStatus == null : this$overStatus.equals(other$overStatus)) {
               Object this$attendanceDate = this.getAttendanceDate();
               Object other$attendanceDate = other.getAttendanceDate();
               if (this$attendanceDate == null ? other$attendanceDate == null : this$attendanceDate.equals(other$attendanceDate)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$deptName = this.getDeptName();
                     Object other$deptName = other.getDeptName();
                     if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                        Object this$wokeName = this.getWokeName();
                        Object other$wokeName = other.getWokeName();
                        if (this$wokeName == null ? other$wokeName == null : this$wokeName.equals(other$wokeName)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
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
                                          Object this$workHours = this.getWorkHours();
                                          Object other$workHours = other.getWorkHours();
                                          if (this$workHours == null ? other$workHours == null : this$workHours.equals(other$workHours)) {
                                             Object this$overWorkHours = this.getOverWorkHours();
                                             Object other$overWorkHours = other.getOverWorkHours();
                                             if (this$overWorkHours == null ? other$overWorkHours == null : this$overWorkHours.equals(other$overWorkHours)) {
                                                Object this$actualHours = this.getActualHours();
                                                Object other$actualHours = other.getActualHours();
                                                if (this$actualHours == null ? other$actualHours == null : this$actualHours.equals(other$actualHours)) {
                                                   Object this$overHours = this.getOverHours();
                                                   Object other$overHours = other.getOverHours();
                                                   if (this$overHours == null ? other$overHours == null : this$overHours.equals(other$overHours)) {
                                                      Object this$morningHours = this.getMorningHours();
                                                      Object other$morningHours = other.getMorningHours();
                                                      if (this$morningHours == null ? other$morningHours == null : this$morningHours.equals(other$morningHours)
                                                         )
                                                       {
                                                         Object this$afternoonHours = this.getAfternoonHours();
                                                         Object other$afternoonHours = other.getAfternoonHours();
                                                         if (this$afternoonHours == null
                                                            ? other$afternoonHours == null
                                                            : this$afternoonHours.equals(other$afternoonHours)) {
                                                            Object this$dateStr = this.getDateStr();
                                                            Object other$dateStr = other.getDateStr();
                                                            if (this$dateStr == null ? other$dateStr == null : this$dateStr.equals(other$dateStr)) {
                                                               Object this$totalHours = this.getTotalHours();
                                                               Object other$totalHours = other.getTotalHours();
                                                               if (this$totalHours == null
                                                                  ? other$totalHours == null
                                                                  : this$totalHours.equals(other$totalHours)) {
                                                                  Object this$overClockDTOList = this.getOverClockDTOList();
                                                                  Object other$overClockDTOList = other.getOverClockDTOList();
                                                                  if (this$overClockDTOList == null
                                                                     ? other$overClockDTOList == null
                                                                     : this$overClockDTOList.equals(other$overClockDTOList)) {
                                                                     Object this$workingStr = this.getWorkingStr();
                                                                     Object other$workingStr = other.getWorkingStr();
                                                                     if (this$workingStr == null
                                                                        ? other$workingStr == null
                                                                        : this$workingStr.equals(other$workingStr)) {
                                                                        Object this$closingStr = this.getClosingStr();
                                                                        Object other$closingStr = other.getClosingStr();
                                                                        if (this$closingStr == null
                                                                           ? other$closingStr == null
                                                                           : this$closingStr.equals(other$closingStr)) {
                                                                           Object this$absenceHours = this.getAbsenceHours();
                                                                           Object other$absenceHours = other.getAbsenceHours();
                                                                           return this$absenceHours == null
                                                                              ? other$absenceHours == null
                                                                              : this$absenceHours.equals(other$absenceHours);
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
      return other instanceof MesAttendanceDayDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $rosterId = this.getRosterId();
      result = result * 59 + ($rosterId == null ? 43 : $rosterId.hashCode());
      Object $attendStatus = this.getAttendStatus();
      result = result * 59 + ($attendStatus == null ? 43 : $attendStatus.hashCode());
      Object $overStatus = this.getOverStatus();
      result = result * 59 + ($overStatus == null ? 43 : $overStatus.hashCode());
      Object $attendanceDate = this.getAttendanceDate();
      result = result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $wokeName = this.getWokeName();
      result = result * 59 + ($wokeName == null ? 43 : $wokeName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $workHours = this.getWorkHours();
      result = result * 59 + ($workHours == null ? 43 : $workHours.hashCode());
      Object $overWorkHours = this.getOverWorkHours();
      result = result * 59 + ($overWorkHours == null ? 43 : $overWorkHours.hashCode());
      Object $actualHours = this.getActualHours();
      result = result * 59 + ($actualHours == null ? 43 : $actualHours.hashCode());
      Object $overHours = this.getOverHours();
      result = result * 59 + ($overHours == null ? 43 : $overHours.hashCode());
      Object $morningHours = this.getMorningHours();
      result = result * 59 + ($morningHours == null ? 43 : $morningHours.hashCode());
      Object $afternoonHours = this.getAfternoonHours();
      result = result * 59 + ($afternoonHours == null ? 43 : $afternoonHours.hashCode());
      Object $dateStr = this.getDateStr();
      result = result * 59 + ($dateStr == null ? 43 : $dateStr.hashCode());
      Object $totalHours = this.getTotalHours();
      result = result * 59 + ($totalHours == null ? 43 : $totalHours.hashCode());
      Object $overClockDTOList = this.getOverClockDTOList();
      result = result * 59 + ($overClockDTOList == null ? 43 : $overClockDTOList.hashCode());
      Object $workingStr = this.getWorkingStr();
      result = result * 59 + ($workingStr == null ? 43 : $workingStr.hashCode());
      Object $closingStr = this.getClosingStr();
      result = result * 59 + ($closingStr == null ? 43 : $closingStr.hashCode());
      Object $absenceHours = this.getAbsenceHours();
      return result * 59 + ($absenceHours == null ? 43 : $absenceHours.hashCode());
   }

   @Override
   public String toString() {
      return "MesAttendanceDayDetailsDTO(rosterId="
         + this.getRosterId()
         + ", attendanceDate="
         + this.getAttendanceDate()
         + ", name="
         + this.getName()
         + ", deptName="
         + this.getDeptName()
         + ", wokeName="
         + this.getWokeName()
         + ", supplierName="
         + this.getSupplierName()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", workHours="
         + this.getWorkHours()
         + ", overWorkHours="
         + this.getOverWorkHours()
         + ", actualHours="
         + this.getActualHours()
         + ", overHours="
         + this.getOverHours()
         + ", morningHours="
         + this.getMorningHours()
         + ", afternoonHours="
         + this.getAfternoonHours()
         + ", attendStatus="
         + this.getAttendStatus()
         + ", overStatus="
         + this.getOverStatus()
         + ", dateStr="
         + this.getDateStr()
         + ", totalHours="
         + this.getTotalHours()
         + ", overClockDTOList="
         + this.getOverClockDTOList()
         + ", workingStr="
         + this.getWorkingStr()
         + ", closingStr="
         + this.getClosingStr()
         + ", absenceHours="
         + this.getAbsenceHours()
         + ")";
   }

   public MesAttendanceDayDetailsDTO() {
   }

   public MesAttendanceDayDetailsDTO(
      final Long rosterId,
      final LocalDate attendanceDate,
      final String name,
      final String deptName,
      final String wokeName,
      final String supplierName,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final BigDecimal workHours,
      final BigDecimal overWorkHours,
      final BigDecimal actualHours,
      final BigDecimal overHours,
      final BigDecimal morningHours,
      final BigDecimal afternoonHours,
      final Integer attendStatus,
      final Integer overStatus,
      final String dateStr,
      final BigDecimal totalHours,
      final List<MesBuildingAttendanceOverConfigDTO> overClockDTOList,
      final String workingStr,
      final String closingStr,
      final BigDecimal absenceHours
   ) {
      this.rosterId = rosterId;
      this.attendanceDate = attendanceDate;
      this.name = name;
      this.deptName = deptName;
      this.wokeName = wokeName;
      this.supplierName = supplierName;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.workHours = workHours;
      this.overWorkHours = overWorkHours;
      this.actualHours = actualHours;
      this.overHours = overHours;
      this.morningHours = morningHours;
      this.afternoonHours = afternoonHours;
      this.attendStatus = attendStatus;
      this.overStatus = overStatus;
      this.dateStr = dateStr;
      this.totalHours = totalHours;
      this.overClockDTOList = overClockDTOList;
      this.workingStr = workingStr;
      this.closingStr = closingStr;
      this.absenceHours = absenceHours;
   }

   public static class MesAttendanceDayDetailsDTOBuilder {
      private Long rosterId;
      private LocalDate attendanceDate;
      private String name;
      private String deptName;
      private String wokeName;
      private String supplierName;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private BigDecimal workHours;
      private BigDecimal overWorkHours;
      private BigDecimal actualHours;
      private BigDecimal overHours;
      private BigDecimal morningHours;
      private BigDecimal afternoonHours;
      private Integer attendStatus;
      private Integer overStatus;
      private String dateStr;
      private BigDecimal totalHours;
      private List<MesBuildingAttendanceOverConfigDTO> overClockDTOList;
      private String workingStr;
      private String closingStr;
      private BigDecimal absenceHours;

      MesAttendanceDayDetailsDTOBuilder() {
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder rosterId(final Long rosterId) {
         this.rosterId = rosterId;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder attendanceDate(final LocalDate attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder wokeName(final String wokeName) {
         this.wokeName = wokeName;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder workHours(final BigDecimal workHours) {
         this.workHours = workHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder overWorkHours(final BigDecimal overWorkHours) {
         this.overWorkHours = overWorkHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder actualHours(final BigDecimal actualHours) {
         this.actualHours = actualHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder overHours(final BigDecimal overHours) {
         this.overHours = overHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder morningHours(final BigDecimal morningHours) {
         this.morningHours = morningHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder afternoonHours(final BigDecimal afternoonHours) {
         this.afternoonHours = afternoonHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder attendStatus(final Integer attendStatus) {
         this.attendStatus = attendStatus;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder overStatus(final Integer overStatus) {
         this.overStatus = overStatus;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder dateStr(final String dateStr) {
         this.dateStr = dateStr;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder totalHours(final BigDecimal totalHours) {
         this.totalHours = totalHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder overClockDTOList(final List<MesBuildingAttendanceOverConfigDTO> overClockDTOList) {
         this.overClockDTOList = overClockDTOList;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder workingStr(final String workingStr) {
         this.workingStr = workingStr;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder closingStr(final String closingStr) {
         this.closingStr = closingStr;
         return this;
      }

      public MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder absenceHours(final BigDecimal absenceHours) {
         this.absenceHours = absenceHours;
         return this;
      }

      public MesAttendanceDayDetailsDTO build() {
         return new MesAttendanceDayDetailsDTO(
            this.rosterId,
            this.attendanceDate,
            this.name,
            this.deptName,
            this.wokeName,
            this.supplierName,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.workHours,
            this.overWorkHours,
            this.actualHours,
            this.overHours,
            this.morningHours,
            this.afternoonHours,
            this.attendStatus,
            this.overStatus,
            this.dateStr,
            this.totalHours,
            this.overClockDTOList,
            this.workingStr,
            this.closingStr,
            this.absenceHours
         );
      }

      @Override
      public String toString() {
         return "MesAttendanceDayDetailsDTO.MesAttendanceDayDetailsDTOBuilder(rosterId="
            + this.rosterId
            + ", attendanceDate="
            + this.attendanceDate
            + ", name="
            + this.name
            + ", deptName="
            + this.deptName
            + ", wokeName="
            + this.wokeName
            + ", supplierName="
            + this.supplierName
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", workHours="
            + this.workHours
            + ", overWorkHours="
            + this.overWorkHours
            + ", actualHours="
            + this.actualHours
            + ", overHours="
            + this.overHours
            + ", morningHours="
            + this.morningHours
            + ", afternoonHours="
            + this.afternoonHours
            + ", attendStatus="
            + this.attendStatus
            + ", overStatus="
            + this.overStatus
            + ", dateStr="
            + this.dateStr
            + ", totalHours="
            + this.totalHours
            + ", overClockDTOList="
            + this.overClockDTOList
            + ", workingStr="
            + this.workingStr
            + ", closingStr="
            + this.closingStr
            + ", absenceHours="
            + this.absenceHours
            + ")";
      }
   }
}
