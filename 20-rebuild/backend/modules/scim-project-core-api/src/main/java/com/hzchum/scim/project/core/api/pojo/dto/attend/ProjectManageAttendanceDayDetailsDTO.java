package com.hzchum.scim.project.core.api.pojo.dto.attend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("考勤日详情信息")
public class ProjectManageAttendanceDayDetailsDTO {
   @ApiModelProperty(name = "projectManageRosterId", value = "花名册id", notes = "花名册id")
   private Long projectManageRosterId;
   @ApiModelProperty(name = "attendanceDate", value = "日期", notes = "日期")
   private LocalDate attendanceDate;
   @ApiModelProperty(name = "userName", value = "姓名", notes = "姓名")
   private String userName;
   @ApiModelProperty(name = "idCard", value = "身份证号", notes = "身份证号")
   private String idCard;
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
   @ApiModelProperty(name = "overtimeWorkingTime", value = "加班上班打卡时间", notes = "加班上班打卡时间")
   private LocalDateTime overtimeWorkingTime;
   @ApiModelProperty(name = "overtimeClosingTime", value = "加班下班打卡时间", notes = "加班下班打卡时间")
   private LocalDateTime overtimeClosingTime;
   @ApiModelProperty(name = "workHours", value = "标准工时", notes = "标准工时")
   private BigDecimal workHours;
   @ApiModelProperty(name = "actualHours", value = "实际普通工时", notes = "实际普通工时")
   private BigDecimal actualHours;
   @ApiModelProperty(name = "overHours", value = "加班工时", notes = "加班工时")
   private BigDecimal overHours;
   @ApiModelProperty(name = "attendStatus", value = "考勤状态", notes = "考勤状态")
   private Integer attendStatus;
   @JsonInclude
   @ApiModelProperty(name = "absenceHours", value = "缺勤工时", notes = "缺勤工时")
   private BigDecimal absenceHours;
   @JsonInclude
   @ApiModelProperty(name = "dateStr", value = "日期+星期", notes = "日期+星期")
   private String dateStr;
   @JsonInclude
   @ApiModelProperty(name = "totalHours", value = "总时长", notes = "总时长")
   private BigDecimal totalHours;
   @ApiModelProperty(name = "morningHours", value = "上午工时", notes = "上午工时")
   private BigDecimal morningHours;
   @ApiModelProperty(name = "afternoonHours", value = "下午工时", notes = "下午工时")
   private BigDecimal afternoonHours;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentDTOList;

   public static ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder builder() {
      return new ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder();
   }

   public ProjectManageAttendanceDayDetailsDTO() {
   }

   public ProjectManageAttendanceDayDetailsDTO(
      final Long projectManageRosterId,
      final LocalDate attendanceDate,
      final String userName,
      final String idCard,
      final String supplierName,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final BigDecimal workHours,
      final BigDecimal actualHours,
      final BigDecimal overHours,
      final Integer attendStatus,
      final BigDecimal absenceHours,
      final String dateStr,
      final BigDecimal totalHours,
      final BigDecimal morningHours,
      final BigDecimal afternoonHours,
      final List<AttachmentDTO> attachmentDTOList
   ) {
      this.projectManageRosterId = projectManageRosterId;
      this.attendanceDate = attendanceDate;
      this.userName = userName;
      this.idCard = idCard;
      this.supplierName = supplierName;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.workHours = workHours;
      this.actualHours = actualHours;
      this.overHours = overHours;
      this.attendStatus = attendStatus;
      this.absenceHours = absenceHours;
      this.dateStr = dateStr;
      this.totalHours = totalHours;
      this.morningHours = morningHours;
      this.afternoonHours = afternoonHours;
      this.attachmentDTOList = attachmentDTOList;
   }

   public Long getProjectManageRosterId() {
      return this.projectManageRosterId;
   }

   public LocalDate getAttendanceDate() {
      return this.attendanceDate;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getIdCard() {
      return this.idCard;
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

   public LocalDateTime getOvertimeWorkingTime() {
      return this.overtimeWorkingTime;
   }

   public LocalDateTime getOvertimeClosingTime() {
      return this.overtimeClosingTime;
   }

   public BigDecimal getWorkHours() {
      return this.workHours;
   }

   public BigDecimal getActualHours() {
      return this.actualHours;
   }

   public BigDecimal getOverHours() {
      return this.overHours;
   }

   public Integer getAttendStatus() {
      return this.attendStatus;
   }

   public BigDecimal getAbsenceHours() {
      return this.absenceHours;
   }

   public String getDateStr() {
      return this.dateStr;
   }

   public BigDecimal getTotalHours() {
      return this.totalHours;
   }

   public BigDecimal getMorningHours() {
      return this.morningHours;
   }

   public BigDecimal getAfternoonHours() {
      return this.afternoonHours;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public ProjectManageAttendanceDayDetailsDTO setProjectManageRosterId(final Long projectManageRosterId) {
      this.projectManageRosterId = projectManageRosterId;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAttendanceDate(final LocalDate attendanceDate) {
      this.attendanceDate = attendanceDate;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setIdCard(final String idCard) {
      this.idCard = idCard;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setWorkHours(final BigDecimal workHours) {
      this.workHours = workHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setActualHours(final BigDecimal actualHours) {
      this.actualHours = actualHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setOverHours(final BigDecimal overHours) {
      this.overHours = overHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAttendStatus(final Integer attendStatus) {
      this.attendStatus = attendStatus;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAbsenceHours(final BigDecimal absenceHours) {
      this.absenceHours = absenceHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setDateStr(final String dateStr) {
      this.dateStr = dateStr;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setTotalHours(final BigDecimal totalHours) {
      this.totalHours = totalHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setMorningHours(final BigDecimal morningHours) {
      this.morningHours = morningHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAfternoonHours(final BigDecimal afternoonHours) {
      this.afternoonHours = afternoonHours;
      return this;
   }

   public ProjectManageAttendanceDayDetailsDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceDayDetailsDTO(projectManageRosterId="
         + this.getProjectManageRosterId()
         + ", attendanceDate="
         + this.getAttendanceDate()
         + ", userName="
         + this.getUserName()
         + ", idCard="
         + this.getIdCard()
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
         + ", overtimeWorkingTime="
         + this.getOvertimeWorkingTime()
         + ", overtimeClosingTime="
         + this.getOvertimeClosingTime()
         + ", workHours="
         + this.getWorkHours()
         + ", actualHours="
         + this.getActualHours()
         + ", overHours="
         + this.getOverHours()
         + ", attendStatus="
         + this.getAttendStatus()
         + ", absenceHours="
         + this.getAbsenceHours()
         + ", dateStr="
         + this.getDateStr()
         + ", totalHours="
         + this.getTotalHours()
         + ", morningHours="
         + this.getMorningHours()
         + ", afternoonHours="
         + this.getAfternoonHours()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceDayDetailsDTO)) {
         return false;
      }

      ProjectManageAttendanceDayDetailsDTO other = (ProjectManageAttendanceDayDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectManageRosterId = this.getProjectManageRosterId();
      Object other$projectManageRosterId = other.getProjectManageRosterId();
      if (this$projectManageRosterId == null ? other$projectManageRosterId == null : this$projectManageRosterId.equals(other$projectManageRosterId)) {
         Object this$attendStatus = this.getAttendStatus();
         Object other$attendStatus = other.getAttendStatus();
         if (this$attendStatus == null ? other$attendStatus == null : this$attendStatus.equals(other$attendStatus)) {
            Object this$attendanceDate = this.getAttendanceDate();
            Object other$attendanceDate = other.getAttendanceDate();
            if (this$attendanceDate == null ? other$attendanceDate == null : this$attendanceDate.equals(other$attendanceDate)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$idCard = this.getIdCard();
                  Object other$idCard = other.getIdCard();
                  if (this$idCard == null ? other$idCard == null : this$idCard.equals(other$idCard)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
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
                                          Object this$workHours = this.getWorkHours();
                                          Object other$workHours = other.getWorkHours();
                                          if (this$workHours == null ? other$workHours == null : this$workHours.equals(other$workHours)) {
                                             Object this$actualHours = this.getActualHours();
                                             Object other$actualHours = other.getActualHours();
                                             if (this$actualHours == null ? other$actualHours == null : this$actualHours.equals(other$actualHours)) {
                                                Object this$overHours = this.getOverHours();
                                                Object other$overHours = other.getOverHours();
                                                if (this$overHours == null ? other$overHours == null : this$overHours.equals(other$overHours)) {
                                                   Object this$absenceHours = this.getAbsenceHours();
                                                   Object other$absenceHours = other.getAbsenceHours();
                                                   if (this$absenceHours == null ? other$absenceHours == null : this$absenceHours.equals(other$absenceHours)) {
                                                      Object this$dateStr = this.getDateStr();
                                                      Object other$dateStr = other.getDateStr();
                                                      if (this$dateStr == null ? other$dateStr == null : this$dateStr.equals(other$dateStr)) {
                                                         Object this$totalHours = this.getTotalHours();
                                                         Object other$totalHours = other.getTotalHours();
                                                         if (this$totalHours == null ? other$totalHours == null : this$totalHours.equals(other$totalHours)) {
                                                            Object this$morningHours = this.getMorningHours();
                                                            Object other$morningHours = other.getMorningHours();
                                                            if (this$morningHours == null
                                                               ? other$morningHours == null
                                                               : this$morningHours.equals(other$morningHours)) {
                                                               Object this$afternoonHours = this.getAfternoonHours();
                                                               Object other$afternoonHours = other.getAfternoonHours();
                                                               if (this$afternoonHours == null
                                                                  ? other$afternoonHours == null
                                                                  : this$afternoonHours.equals(other$afternoonHours)) {
                                                                  Object this$attachmentDTOList = this.getAttachmentDTOList();
                                                                  Object other$attachmentDTOList = other.getAttachmentDTOList();
                                                                  return this$attachmentDTOList == null
                                                                     ? other$attachmentDTOList == null
                                                                     : this$attachmentDTOList.equals(other$attachmentDTOList);
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
      return other instanceof ProjectManageAttendanceDayDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectManageRosterId = this.getProjectManageRosterId();
      result = result * 59 + ($projectManageRosterId == null ? 43 : $projectManageRosterId.hashCode());
      Object $attendStatus = this.getAttendStatus();
      result = result * 59 + ($attendStatus == null ? 43 : $attendStatus.hashCode());
      Object $attendanceDate = this.getAttendanceDate();
      result = result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $idCard = this.getIdCard();
      result = result * 59 + ($idCard == null ? 43 : $idCard.hashCode());
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
      Object $overtimeWorkingTime = this.getOvertimeWorkingTime();
      result = result * 59 + ($overtimeWorkingTime == null ? 43 : $overtimeWorkingTime.hashCode());
      Object $overtimeClosingTime = this.getOvertimeClosingTime();
      result = result * 59 + ($overtimeClosingTime == null ? 43 : $overtimeClosingTime.hashCode());
      Object $workHours = this.getWorkHours();
      result = result * 59 + ($workHours == null ? 43 : $workHours.hashCode());
      Object $actualHours = this.getActualHours();
      result = result * 59 + ($actualHours == null ? 43 : $actualHours.hashCode());
      Object $overHours = this.getOverHours();
      result = result * 59 + ($overHours == null ? 43 : $overHours.hashCode());
      Object $absenceHours = this.getAbsenceHours();
      result = result * 59 + ($absenceHours == null ? 43 : $absenceHours.hashCode());
      Object $dateStr = this.getDateStr();
      result = result * 59 + ($dateStr == null ? 43 : $dateStr.hashCode());
      Object $totalHours = this.getTotalHours();
      result = result * 59 + ($totalHours == null ? 43 : $totalHours.hashCode());
      Object $morningHours = this.getMorningHours();
      result = result * 59 + ($morningHours == null ? 43 : $morningHours.hashCode());
      Object $afternoonHours = this.getAfternoonHours();
      result = result * 59 + ($afternoonHours == null ? 43 : $afternoonHours.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
   }

   public static class ProjectManageAttendanceDayDetailsDTOBuilder {
      private Long projectManageRosterId;
      private LocalDate attendanceDate;
      private String userName;
      private String idCard;
      private String supplierName;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private BigDecimal workHours;
      private BigDecimal actualHours;
      private BigDecimal overHours;
      private Integer attendStatus;
      private BigDecimal absenceHours;
      private String dateStr;
      private BigDecimal totalHours;
      private BigDecimal morningHours;
      private BigDecimal afternoonHours;
      private List<AttachmentDTO> attachmentDTOList;

      ProjectManageAttendanceDayDetailsDTOBuilder() {
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder projectManageRosterId(final Long projectManageRosterId) {
         this.projectManageRosterId = projectManageRosterId;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder attendanceDate(final LocalDate attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder idCard(final String idCard) {
         this.idCard = idCard;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder workHours(final BigDecimal workHours) {
         this.workHours = workHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder actualHours(final BigDecimal actualHours) {
         this.actualHours = actualHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder overHours(final BigDecimal overHours) {
         this.overHours = overHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder attendStatus(final Integer attendStatus) {
         this.attendStatus = attendStatus;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder absenceHours(final BigDecimal absenceHours) {
         this.absenceHours = absenceHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder dateStr(final String dateStr) {
         this.dateStr = dateStr;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder totalHours(final BigDecimal totalHours) {
         this.totalHours = totalHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder morningHours(final BigDecimal morningHours) {
         this.morningHours = morningHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder afternoonHours(final BigDecimal afternoonHours) {
         this.afternoonHours = afternoonHours;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public ProjectManageAttendanceDayDetailsDTO build() {
         return new ProjectManageAttendanceDayDetailsDTO(
            this.projectManageRosterId,
            this.attendanceDate,
            this.userName,
            this.idCard,
            this.supplierName,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.overtimeWorkingTime,
            this.overtimeClosingTime,
            this.workHours,
            this.actualHours,
            this.overHours,
            this.attendStatus,
            this.absenceHours,
            this.dateStr,
            this.totalHours,
            this.morningHours,
            this.afternoonHours,
            this.attachmentDTOList
         );
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceDayDetailsDTO.ProjectManageAttendanceDayDetailsDTOBuilder(projectManageRosterId="
            + this.projectManageRosterId
            + ", attendanceDate="
            + this.attendanceDate
            + ", userName="
            + this.userName
            + ", idCard="
            + this.idCard
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
            + ", overtimeWorkingTime="
            + this.overtimeWorkingTime
            + ", overtimeClosingTime="
            + this.overtimeClosingTime
            + ", workHours="
            + this.workHours
            + ", actualHours="
            + this.actualHours
            + ", overHours="
            + this.overHours
            + ", attendStatus="
            + this.attendStatus
            + ", absenceHours="
            + this.absenceHours
            + ", dateStr="
            + this.dateStr
            + ", totalHours="
            + this.totalHours
            + ", morningHours="
            + this.morningHours
            + ", afternoonHours="
            + this.afternoonHours
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ")";
      }
   }
}
