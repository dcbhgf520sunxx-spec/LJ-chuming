package com.hzchum.scim.project.core.api.pojo._doModel.attend;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "ProjectManageAttendance对象", description = "")
@Entity
@TableName("project_manage_attendance")
@Table(name = "project_manage_attendance", indexes = @Index(name = "attendanceDate", columnList = "attendance_date"))
@org.hibernate.annotations.Table(appliesTo = "project_manage_attendance")
public class ProjectManageAttendance extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "劳务id", notes = "劳务id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "int(20)  COMMENT '劳务id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "int(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "attendanceDate", value = "考勤日期", notes = "考勤日期")
   @TableField("attendance_date")
   @Column(name = "attendance_date", columnDefinition = "date  COMMENT '考勤日期'", nullable = false)
   private LocalDate attendanceDate;
   @ApiModelProperty(name = "workType", value = "工种", notes = "工种")
   @TableField("work_type")
   @Column(name = "work_type", columnDefinition = "int(11)  COMMENT '工种'", nullable = false)
   private Integer workType;
   @ApiModelProperty(name = "name", value = "姓名", notes = "姓名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '姓名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "projectManageRosterId", value = "花名册id", notes = "花名册id")
   @TableField("project_manage_roster_id")
   @Column(name = "project_manage_roster_id", columnDefinition = "int(20)  COMMENT '花名册id'", nullable = false)
   private Long projectManageRosterId;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = true)
   private Long userId;
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
   @ApiModelProperty(name = "overtimeWorkingTime", value = "加班上班打卡时间", notes = "加班上班打卡时间")
   @TableField("overtime_working_time")
   @Column(name = "overtime_working_time", columnDefinition = "datetime  COMMENT '加班上班打卡时间'", nullable = true)
   private LocalDateTime overtimeWorkingTime;
   @ApiModelProperty(name = "overtimeClosingTime", value = "加班下班打卡时间", notes = "加班下班打卡时间")
   @TableField("overtime_closing_time")
   @Column(name = "overtime_closing_time", columnDefinition = "datetime  COMMENT '加班下班打卡时间'", nullable = true)
   private LocalDateTime overtimeClosingTime;
   @ApiModelProperty(name = "attendanceTimeConfigurationId", value = "考勤配置id", notes = "考勤配置id")
   @TableField("attendance_time_configuration_id")
   @Column(name = "attendance_time_configuration_id", columnDefinition = "int(11)  COMMENT '考勤配置id'", nullable = false)
   private Long attendanceTimeConfigurationId;
   @ApiModelProperty(name = "point", value = "实际考勤打卡点位", notes = "实际考勤打卡点位")
   @TableField("point")
   @Column(name = "point", columnDefinition = "varchar(1024)  COMMENT '实际考勤打卡点位'")
   private String point;
   @ApiModelProperty(name = "attendStatus", value = "考勤状态", notes = "考勤状态")
   @TableField("attend_status")
   @Column(name = "attend_status", columnDefinition = "int(5) default'1' COMMENT '考勤状态'", nullable = false)
   private Integer attendStatus;
   @ApiModelProperty(name = "isCancel", value = "考勤是否作废", notes = "考勤是否作废")
   @TableField("is_cancel")
   @Column(name = "is_cancel", columnDefinition = "tinyint(1)  COMMENT '考勤是否作废'", nullable = false)
   private Boolean isCancel;
   @ApiModelProperty(name = "morningWorkingTimeConfig", value = "配置时间", notes = "配置时间")
   @TableField("morning_working_time_config")
   @Column(name = "morning_working_time_config", columnDefinition = "datetime  COMMENT '配置时间'", nullable = true)
   private LocalDateTime morningWorkingTimeConfig;
   @ApiModelProperty(name = "morningClosingTimeConfig", value = "配置时间", notes = "配置时间")
   @TableField("morning_closing_time_config")
   @Column(name = "morning_closing_time_config", columnDefinition = "datetime  COMMENT '配置时间'", nullable = true)
   private LocalDateTime morningClosingTimeConfig;
   @ApiModelProperty(name = "afternoonWorkingTimeConfig", value = "配置时间", notes = "配置时间")
   @TableField("afternoon_working_time_config")
   @Column(name = "afternoon_working_time_config", columnDefinition = "datetime  COMMENT '配置时间'", nullable = true)
   private LocalDateTime afternoonWorkingTimeConfig;
   @ApiModelProperty(name = "afternoonClosingTimeConfig", value = "配置时间", notes = "配置时间")
   @TableField("afternoon_closing_time_config")
   @Column(name = "afternoon_closing_time_config", columnDefinition = "datetime  COMMENT '配置时间'", nullable = true)
   private LocalDateTime afternoonClosingTimeConfig;
   @ApiModelProperty(name = "attachmentIds", value = "打卡附件", notes = "打卡附件")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '打卡附件'", nullable = true)
   private String attachmentIds;

   public static ProjectManageAttendance.ProjectManageAttendanceBuilder builder() {
      return new ProjectManageAttendance.ProjectManageAttendanceBuilder();
   }

   public ProjectManageAttendance() {
   }

   public ProjectManageAttendance(
      final Long id,
      final Long supplierId,
      final Long projectId,
      final LocalDate attendanceDate,
      final Integer workType,
      final String name,
      final Long projectManageRosterId,
      final Long userId,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final Long attendanceTimeConfigurationId,
      final String point,
      final Integer attendStatus,
      final Boolean isCancel,
      final LocalDateTime morningWorkingTimeConfig,
      final LocalDateTime morningClosingTimeConfig,
      final LocalDateTime afternoonWorkingTimeConfig,
      final LocalDateTime afternoonClosingTimeConfig,
      final String attachmentIds
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.projectId = projectId;
      this.attendanceDate = attendanceDate;
      this.workType = workType;
      this.name = name;
      this.projectManageRosterId = projectManageRosterId;
      this.userId = userId;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.attendanceTimeConfigurationId = attendanceTimeConfigurationId;
      this.point = point;
      this.attendStatus = attendStatus;
      this.isCancel = isCancel;
      this.morningWorkingTimeConfig = morningWorkingTimeConfig;
      this.morningClosingTimeConfig = morningClosingTimeConfig;
      this.afternoonWorkingTimeConfig = afternoonWorkingTimeConfig;
      this.afternoonClosingTimeConfig = afternoonClosingTimeConfig;
      this.attachmentIds = attachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getAttendanceDate() {
      return this.attendanceDate;
   }

   public Integer getWorkType() {
      return this.workType;
   }

   public String getName() {
      return this.name;
   }

   public Long getProjectManageRosterId() {
      return this.projectManageRosterId;
   }

   public Long getUserId() {
      return this.userId;
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

   public Long getAttendanceTimeConfigurationId() {
      return this.attendanceTimeConfigurationId;
   }

   public String getPoint() {
      return this.point;
   }

   public Integer getAttendStatus() {
      return this.attendStatus;
   }

   public Boolean getIsCancel() {
      return this.isCancel;
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

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public ProjectManageAttendance setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageAttendance setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectManageAttendance setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectManageAttendance setAttendanceDate(final LocalDate attendanceDate) {
      this.attendanceDate = attendanceDate;
      return this;
   }

   public ProjectManageAttendance setWorkType(final Integer workType) {
      this.workType = workType;
      return this;
   }

   public ProjectManageAttendance setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectManageAttendance setProjectManageRosterId(final Long projectManageRosterId) {
      this.projectManageRosterId = projectManageRosterId;
      return this;
   }

   public ProjectManageAttendance setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectManageAttendance setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public ProjectManageAttendance setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public ProjectManageAttendance setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public ProjectManageAttendance setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public ProjectManageAttendance setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
      return this;
   }

   public ProjectManageAttendance setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
      return this;
   }

   public ProjectManageAttendance setAttendanceTimeConfigurationId(final Long attendanceTimeConfigurationId) {
      this.attendanceTimeConfigurationId = attendanceTimeConfigurationId;
      return this;
   }

   public ProjectManageAttendance setPoint(final String point) {
      this.point = point;
      return this;
   }

   public ProjectManageAttendance setAttendStatus(final Integer attendStatus) {
      this.attendStatus = attendStatus;
      return this;
   }

   public ProjectManageAttendance setIsCancel(final Boolean isCancel) {
      this.isCancel = isCancel;
      return this;
   }

   public ProjectManageAttendance setMorningWorkingTimeConfig(final LocalDateTime morningWorkingTimeConfig) {
      this.morningWorkingTimeConfig = morningWorkingTimeConfig;
      return this;
   }

   public ProjectManageAttendance setMorningClosingTimeConfig(final LocalDateTime morningClosingTimeConfig) {
      this.morningClosingTimeConfig = morningClosingTimeConfig;
      return this;
   }

   public ProjectManageAttendance setAfternoonWorkingTimeConfig(final LocalDateTime afternoonWorkingTimeConfig) {
      this.afternoonWorkingTimeConfig = afternoonWorkingTimeConfig;
      return this;
   }

   public ProjectManageAttendance setAfternoonClosingTimeConfig(final LocalDateTime afternoonClosingTimeConfig) {
      this.afternoonClosingTimeConfig = afternoonClosingTimeConfig;
      return this;
   }

   public ProjectManageAttendance setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageAttendance(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", projectId="
         + this.getProjectId()
         + ", attendanceDate="
         + this.getAttendanceDate()
         + ", workType="
         + this.getWorkType()
         + ", name="
         + this.getName()
         + ", projectManageRosterId="
         + this.getProjectManageRosterId()
         + ", userId="
         + this.getUserId()
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
         + ", attendanceTimeConfigurationId="
         + this.getAttendanceTimeConfigurationId()
         + ", point="
         + this.getPoint()
         + ", attendStatus="
         + this.getAttendStatus()
         + ", isCancel="
         + this.getIsCancel()
         + ", morningWorkingTimeConfig="
         + this.getMorningWorkingTimeConfig()
         + ", morningClosingTimeConfig="
         + this.getMorningClosingTimeConfig()
         + ", afternoonWorkingTimeConfig="
         + this.getAfternoonWorkingTimeConfig()
         + ", afternoonClosingTimeConfig="
         + this.getAfternoonClosingTimeConfig()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendance)) {
         return false;
      }

      ProjectManageAttendance other = (ProjectManageAttendance)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$workType = this.getWorkType();
               Object other$workType = other.getWorkType();
               if (this$workType == null ? other$workType == null : this$workType.equals(other$workType)) {
                  Object this$projectManageRosterId = this.getProjectManageRosterId();
                  Object other$projectManageRosterId = other.getProjectManageRosterId();
                  if (this$projectManageRosterId == null ? other$projectManageRosterId == null : this$projectManageRosterId.equals(other$projectManageRosterId)
                     )
                   {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$attendanceTimeConfigurationId = this.getAttendanceTimeConfigurationId();
                        Object other$attendanceTimeConfigurationId = other.getAttendanceTimeConfigurationId();
                        if (this$attendanceTimeConfigurationId == null
                           ? other$attendanceTimeConfigurationId == null
                           : this$attendanceTimeConfigurationId.equals(other$attendanceTimeConfigurationId)) {
                           Object this$attendStatus = this.getAttendStatus();
                           Object other$attendStatus = other.getAttendStatus();
                           if (this$attendStatus == null ? other$attendStatus == null : this$attendStatus.equals(other$attendStatus)) {
                              Object this$isCancel = this.getIsCancel();
                              Object other$isCancel = other.getIsCancel();
                              if (this$isCancel == null ? other$isCancel == null : this$isCancel.equals(other$isCancel)) {
                                 Object this$attendanceDate = this.getAttendanceDate();
                                 Object other$attendanceDate = other.getAttendanceDate();
                                 if (this$attendanceDate == null ? other$attendanceDate == null : this$attendanceDate.equals(other$attendanceDate)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                         Object this$point = this.getPoint();
                                                         Object other$point = other.getPoint();
                                                         if (this$point == null ? other$point == null : this$point.equals(other$point)) {
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
                                                                        Object this$attachmentIds = this.getAttachmentIds();
                                                                        Object other$attachmentIds = other.getAttachmentIds();
                                                                        return this$attachmentIds == null
                                                                           ? other$attachmentIds == null
                                                                           : this$attachmentIds.equals(other$attachmentIds);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManageAttendance;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workType = this.getWorkType();
      result = result * 59 + ($workType == null ? 43 : $workType.hashCode());
      Object $projectManageRosterId = this.getProjectManageRosterId();
      result = result * 59 + ($projectManageRosterId == null ? 43 : $projectManageRosterId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $attendanceTimeConfigurationId = this.getAttendanceTimeConfigurationId();
      result = result * 59 + ($attendanceTimeConfigurationId == null ? 43 : $attendanceTimeConfigurationId.hashCode());
      Object $attendStatus = this.getAttendStatus();
      result = result * 59 + ($attendStatus == null ? 43 : $attendStatus.hashCode());
      Object $isCancel = this.getIsCancel();
      result = result * 59 + ($isCancel == null ? 43 : $isCancel.hashCode());
      Object $attendanceDate = this.getAttendanceDate();
      result = result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $morningWorkingTimeConfig = this.getMorningWorkingTimeConfig();
      result = result * 59 + ($morningWorkingTimeConfig == null ? 43 : $morningWorkingTimeConfig.hashCode());
      Object $morningClosingTimeConfig = this.getMorningClosingTimeConfig();
      result = result * 59 + ($morningClosingTimeConfig == null ? 43 : $morningClosingTimeConfig.hashCode());
      Object $afternoonWorkingTimeConfig = this.getAfternoonWorkingTimeConfig();
      result = result * 59 + ($afternoonWorkingTimeConfig == null ? 43 : $afternoonWorkingTimeConfig.hashCode());
      Object $afternoonClosingTimeConfig = this.getAfternoonClosingTimeConfig();
      result = result * 59 + ($afternoonClosingTimeConfig == null ? 43 : $afternoonClosingTimeConfig.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class ProjectManageAttendanceBuilder {
      private Long id;
      private Long supplierId;
      private Long projectId;
      private LocalDate attendanceDate;
      private Integer workType;
      private String name;
      private Long projectManageRosterId;
      private Long userId;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private Long attendanceTimeConfigurationId;
      private String point;
      private Integer attendStatus;
      private Boolean isCancel;
      private LocalDateTime morningWorkingTimeConfig;
      private LocalDateTime morningClosingTimeConfig;
      private LocalDateTime afternoonWorkingTimeConfig;
      private LocalDateTime afternoonClosingTimeConfig;
      private String attachmentIds;

      ProjectManageAttendanceBuilder() {
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder attendanceDate(final LocalDate attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder workType(final Integer workType) {
         this.workType = workType;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder projectManageRosterId(final Long projectManageRosterId) {
         this.projectManageRosterId = projectManageRosterId;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder attendanceTimeConfigurationId(final Long attendanceTimeConfigurationId) {
         this.attendanceTimeConfigurationId = attendanceTimeConfigurationId;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder attendStatus(final Integer attendStatus) {
         this.attendStatus = attendStatus;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder isCancel(final Boolean isCancel) {
         this.isCancel = isCancel;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder morningWorkingTimeConfig(final LocalDateTime morningWorkingTimeConfig) {
         this.morningWorkingTimeConfig = morningWorkingTimeConfig;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder morningClosingTimeConfig(final LocalDateTime morningClosingTimeConfig) {
         this.morningClosingTimeConfig = morningClosingTimeConfig;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder afternoonWorkingTimeConfig(final LocalDateTime afternoonWorkingTimeConfig) {
         this.afternoonWorkingTimeConfig = afternoonWorkingTimeConfig;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder afternoonClosingTimeConfig(final LocalDateTime afternoonClosingTimeConfig) {
         this.afternoonClosingTimeConfig = afternoonClosingTimeConfig;
         return this;
      }

      public ProjectManageAttendance.ProjectManageAttendanceBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectManageAttendance build() {
         return new ProjectManageAttendance(
            this.id,
            this.supplierId,
            this.projectId,
            this.attendanceDate,
            this.workType,
            this.name,
            this.projectManageRosterId,
            this.userId,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.overtimeWorkingTime,
            this.overtimeClosingTime,
            this.attendanceTimeConfigurationId,
            this.point,
            this.attendStatus,
            this.isCancel,
            this.morningWorkingTimeConfig,
            this.morningClosingTimeConfig,
            this.afternoonWorkingTimeConfig,
            this.afternoonClosingTimeConfig,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "ProjectManageAttendance.ProjectManageAttendanceBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", projectId="
            + this.projectId
            + ", attendanceDate="
            + this.attendanceDate
            + ", workType="
            + this.workType
            + ", name="
            + this.name
            + ", projectManageRosterId="
            + this.projectManageRosterId
            + ", userId="
            + this.userId
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
            + ", attendanceTimeConfigurationId="
            + this.attendanceTimeConfigurationId
            + ", point="
            + this.point
            + ", attendStatus="
            + this.attendStatus
            + ", isCancel="
            + this.isCancel
            + ", morningWorkingTimeConfig="
            + this.morningWorkingTimeConfig
            + ", morningClosingTimeConfig="
            + this.morningClosingTimeConfig
            + ", afternoonWorkingTimeConfig="
            + this.afternoonWorkingTimeConfig
            + ", afternoonClosingTimeConfig="
            + this.afternoonClosingTimeConfig
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
