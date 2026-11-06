package com.hzchum.scim.mes.building.core.api.pojo._doModel.attend;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "MesBuildingAttendance对象", description = "")
@Entity
@TableName("mes_building_attendance")
@Table(name = "mes_building_attendance", indexes = @Index(name = "attendanceDate", columnList = "attendance_date"))
@org.hibernate.annotations.Table(appliesTo = "mes_building_attendance")
public class MesBuildingAttendance extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "分包id", notes = "分包id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "int(20)  COMMENT '分包id'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "attendanceDate", value = "考勤日期", notes = "考勤日期")
   @TableField("attendance_date")
   @Column(name = "attendance_date", columnDefinition = "date  COMMENT '考勤日期'", nullable = false)
   private LocalDate attendanceDate;
   @ApiModelProperty(name = "workType", value = "工种", notes = "工种")
   @TableField("work_type")
   @Column(name = "work_type", columnDefinition = "varchar(255)  COMMENT '工种'", nullable = false)
   private String workType;
   @ApiModelProperty(name = "name", value = "姓名", notes = "姓名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '姓名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "rosterId", value = "花名册id", notes = "花名册id")
   @TableField("roster_id")
   @Column(name = "roster_id", columnDefinition = "int(20)  COMMENT '花名册id'", nullable = false)
   private Long rosterId;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = true)
   private Long userId;
   @ApiModelProperty("身份证号")
   @TableField("id_number")
   @Column(name = "id_number", columnDefinition = "varchar(255) COMMENT '身份证号'", nullable = true)
   private String idNumber;
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
   @ApiModelProperty(name = "overtimeWorkingTimeJson", value = "加班上班打卡记录", notes = "加班上班打卡记录")
   @TableField(value = "overtime_working_time_json", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "overtime_working_time_json", columnDefinition = "varchar(2047)  COMMENT '加班上班打卡记录'", nullable = true)
   private String overtimeWorkingTimeJson;
   @ApiModelProperty(name = "overtimeClosingTimeJson", value = "加班下班打卡记录", notes = "加班下班打卡记录")
   @TableField(value = "overtime_closing_time_json", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "overtime_closing_time_json", columnDefinition = "varchar(2047)  COMMENT '加班下班打卡记录'", nullable = true)
   private String overtimeClosingTimeJson;
   @ApiModelProperty(name = "standConfigId", value = "基础配置id", notes = "基础配置id")
   @TableField("stand_config_id")
   @Column(name = "stand_config_id", columnDefinition = "bigint(20)  COMMENT '基础配置id'", nullable = true)
   private Long standConfigId;
   @ApiModelProperty(name = "overConfigIds", value = "加班配置ids", notes = "加班配置ids")
   @TableField(value = "over_config_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "over_config_ids", columnDefinition = "varchar(1024) COMMENT '加班配置ids'", nullable = true)
   private String overConfigIds;
   @ApiModelProperty(name = "point", value = "实际考勤打卡点位", notes = "实际考勤打卡点位")
   @TableField("point")
   @Column(name = "point", columnDefinition = "varchar(1024)  COMMENT '实际考勤打卡点位'", nullable = true)
   private String point;
   @ApiModelProperty(name = "attendStatus", value = "考勤状态", notes = "考勤状态")
   @TableField("attend_status")
   @Column(name = "attend_status", columnDefinition = "int(5) default '0' COMMENT '考勤状态'", nullable = false)
   private Integer attendStatus;
   @ApiModelProperty(name = "overStatus", value = "加班考勤状态", notes = "加班考勤状态")
   @TableField("over_status")
   @Column(name = "over_status", columnDefinition = "int(5)  default '0' COMMENT '加班考勤状态'", nullable = false)
   private Integer overStatus;

   public static MesBuildingAttendance.MesBuildingAttendanceBuilder builder() {
      return new MesBuildingAttendance.MesBuildingAttendanceBuilder();
   }

   public MesBuildingAttendance() {
   }

   public MesBuildingAttendance(
      final Long id,
      final Long supplierId,
      final LocalDate attendanceDate,
      final String workType,
      final String name,
      final Long rosterId,
      final Long userId,
      final String idNumber,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final String overtimeWorkingTimeJson,
      final String overtimeClosingTimeJson,
      final Long standConfigId,
      final String overConfigIds,
      final String point,
      final Integer attendStatus,
      final Integer overStatus
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.attendanceDate = attendanceDate;
      this.workType = workType;
      this.name = name;
      this.rosterId = rosterId;
      this.userId = userId;
      this.idNumber = idNumber;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.overtimeWorkingTimeJson = overtimeWorkingTimeJson;
      this.overtimeClosingTimeJson = overtimeClosingTimeJson;
      this.standConfigId = standConfigId;
      this.overConfigIds = overConfigIds;
      this.point = point;
      this.attendStatus = attendStatus;
      this.overStatus = overStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public LocalDate getAttendanceDate() {
      return this.attendanceDate;
   }

   public String getWorkType() {
      return this.workType;
   }

   public String getName() {
      return this.name;
   }

   public Long getRosterId() {
      return this.rosterId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getIdNumber() {
      return this.idNumber;
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

   public String getOvertimeWorkingTimeJson() {
      return this.overtimeWorkingTimeJson;
   }

   public String getOvertimeClosingTimeJson() {
      return this.overtimeClosingTimeJson;
   }

   public Long getStandConfigId() {
      return this.standConfigId;
   }

   public String getOverConfigIds() {
      return this.overConfigIds;
   }

   public String getPoint() {
      return this.point;
   }

   public Integer getAttendStatus() {
      return this.attendStatus;
   }

   public Integer getOverStatus() {
      return this.overStatus;
   }

   public MesBuildingAttendance setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAttendance setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public MesBuildingAttendance setAttendanceDate(final LocalDate attendanceDate) {
      this.attendanceDate = attendanceDate;
      return this;
   }

   public MesBuildingAttendance setWorkType(final String workType) {
      this.workType = workType;
      return this;
   }

   public MesBuildingAttendance setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingAttendance setRosterId(final Long rosterId) {
      this.rosterId = rosterId;
      return this;
   }

   public MesBuildingAttendance setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesBuildingAttendance setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public MesBuildingAttendance setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public MesBuildingAttendance setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public MesBuildingAttendance setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public MesBuildingAttendance setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public MesBuildingAttendance setOvertimeWorkingTimeJson(final String overtimeWorkingTimeJson) {
      this.overtimeWorkingTimeJson = overtimeWorkingTimeJson;
      return this;
   }

   public MesBuildingAttendance setOvertimeClosingTimeJson(final String overtimeClosingTimeJson) {
      this.overtimeClosingTimeJson = overtimeClosingTimeJson;
      return this;
   }

   public MesBuildingAttendance setStandConfigId(final Long standConfigId) {
      this.standConfigId = standConfigId;
      return this;
   }

   public MesBuildingAttendance setOverConfigIds(final String overConfigIds) {
      this.overConfigIds = overConfigIds;
      return this;
   }

   public MesBuildingAttendance setPoint(final String point) {
      this.point = point;
      return this;
   }

   public MesBuildingAttendance setAttendStatus(final Integer attendStatus) {
      this.attendStatus = attendStatus;
      return this;
   }

   public MesBuildingAttendance setOverStatus(final Integer overStatus) {
      this.overStatus = overStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAttendance(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", attendanceDate="
         + this.getAttendanceDate()
         + ", workType="
         + this.getWorkType()
         + ", name="
         + this.getName()
         + ", rosterId="
         + this.getRosterId()
         + ", userId="
         + this.getUserId()
         + ", idNumber="
         + this.getIdNumber()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", overtimeWorkingTimeJson="
         + this.getOvertimeWorkingTimeJson()
         + ", overtimeClosingTimeJson="
         + this.getOvertimeClosingTimeJson()
         + ", standConfigId="
         + this.getStandConfigId()
         + ", overConfigIds="
         + this.getOverConfigIds()
         + ", point="
         + this.getPoint()
         + ", attendStatus="
         + this.getAttendStatus()
         + ", overStatus="
         + this.getOverStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendance)) {
         return false;
      }

      MesBuildingAttendance other = (MesBuildingAttendance)o;
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
            Object this$rosterId = this.getRosterId();
            Object other$rosterId = other.getRosterId();
            if (this$rosterId == null ? other$rosterId == null : this$rosterId.equals(other$rosterId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$standConfigId = this.getStandConfigId();
                  Object other$standConfigId = other.getStandConfigId();
                  if (this$standConfigId == null ? other$standConfigId == null : this$standConfigId.equals(other$standConfigId)) {
                     Object this$attendStatus = this.getAttendStatus();
                     Object other$attendStatus = other.getAttendStatus();
                     if (this$attendStatus == null ? other$attendStatus == null : this$attendStatus.equals(other$attendStatus)) {
                        Object this$overStatus = this.getOverStatus();
                        Object other$overStatus = other.getOverStatus();
                        if (this$overStatus == null ? other$overStatus == null : this$overStatus.equals(other$overStatus)) {
                           Object this$attendanceDate = this.getAttendanceDate();
                           Object other$attendanceDate = other.getAttendanceDate();
                           if (this$attendanceDate == null ? other$attendanceDate == null : this$attendanceDate.equals(other$attendanceDate)) {
                              Object this$workType = this.getWorkType();
                              Object other$workType = other.getWorkType();
                              if (this$workType == null ? other$workType == null : this$workType.equals(other$workType)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$idNumber = this.getIdNumber();
                                    Object other$idNumber = other.getIdNumber();
                                    if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
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
                                                   Object this$overtimeWorkingTimeJson = this.getOvertimeWorkingTimeJson();
                                                   Object other$overtimeWorkingTimeJson = other.getOvertimeWorkingTimeJson();
                                                   if (this$overtimeWorkingTimeJson == null
                                                      ? other$overtimeWorkingTimeJson == null
                                                      : this$overtimeWorkingTimeJson.equals(other$overtimeWorkingTimeJson)) {
                                                      Object this$overtimeClosingTimeJson = this.getOvertimeClosingTimeJson();
                                                      Object other$overtimeClosingTimeJson = other.getOvertimeClosingTimeJson();
                                                      if (this$overtimeClosingTimeJson == null
                                                         ? other$overtimeClosingTimeJson == null
                                                         : this$overtimeClosingTimeJson.equals(other$overtimeClosingTimeJson)) {
                                                         Object this$overConfigIds = this.getOverConfigIds();
                                                         Object other$overConfigIds = other.getOverConfigIds();
                                                         if (this$overConfigIds == null
                                                            ? other$overConfigIds == null
                                                            : this$overConfigIds.equals(other$overConfigIds)) {
                                                            Object this$point = this.getPoint();
                                                            Object other$point = other.getPoint();
                                                            return this$point == null ? other$point == null : this$point.equals(other$point);
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
      return other instanceof MesBuildingAttendance;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $rosterId = this.getRosterId();
      result = result * 59 + ($rosterId == null ? 43 : $rosterId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $standConfigId = this.getStandConfigId();
      result = result * 59 + ($standConfigId == null ? 43 : $standConfigId.hashCode());
      Object $attendStatus = this.getAttendStatus();
      result = result * 59 + ($attendStatus == null ? 43 : $attendStatus.hashCode());
      Object $overStatus = this.getOverStatus();
      result = result * 59 + ($overStatus == null ? 43 : $overStatus.hashCode());
      Object $attendanceDate = this.getAttendanceDate();
      result = result * 59 + ($attendanceDate == null ? 43 : $attendanceDate.hashCode());
      Object $workType = this.getWorkType();
      result = result * 59 + ($workType == null ? 43 : $workType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $overtimeWorkingTimeJson = this.getOvertimeWorkingTimeJson();
      result = result * 59 + ($overtimeWorkingTimeJson == null ? 43 : $overtimeWorkingTimeJson.hashCode());
      Object $overtimeClosingTimeJson = this.getOvertimeClosingTimeJson();
      result = result * 59 + ($overtimeClosingTimeJson == null ? 43 : $overtimeClosingTimeJson.hashCode());
      Object $overConfigIds = this.getOverConfigIds();
      result = result * 59 + ($overConfigIds == null ? 43 : $overConfigIds.hashCode());
      Object $point = this.getPoint();
      return result * 59 + ($point == null ? 43 : $point.hashCode());
   }

   public static class MesBuildingAttendanceBuilder {
      private Long id;
      private Long supplierId;
      private LocalDate attendanceDate;
      private String workType;
      private String name;
      private Long rosterId;
      private Long userId;
      private String idNumber;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private String overtimeWorkingTimeJson;
      private String overtimeClosingTimeJson;
      private Long standConfigId;
      private String overConfigIds;
      private String point;
      private Integer attendStatus;
      private Integer overStatus;

      MesBuildingAttendanceBuilder() {
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder attendanceDate(final LocalDate attendanceDate) {
         this.attendanceDate = attendanceDate;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder workType(final String workType) {
         this.workType = workType;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder rosterId(final Long rosterId) {
         this.rosterId = rosterId;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder overtimeWorkingTimeJson(final String overtimeWorkingTimeJson) {
         this.overtimeWorkingTimeJson = overtimeWorkingTimeJson;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder overtimeClosingTimeJson(final String overtimeClosingTimeJson) {
         this.overtimeClosingTimeJson = overtimeClosingTimeJson;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder standConfigId(final Long standConfigId) {
         this.standConfigId = standConfigId;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder overConfigIds(final String overConfigIds) {
         this.overConfigIds = overConfigIds;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder attendStatus(final Integer attendStatus) {
         this.attendStatus = attendStatus;
         return this;
      }

      public MesBuildingAttendance.MesBuildingAttendanceBuilder overStatus(final Integer overStatus) {
         this.overStatus = overStatus;
         return this;
      }

      public MesBuildingAttendance build() {
         return new MesBuildingAttendance(
            this.id,
            this.supplierId,
            this.attendanceDate,
            this.workType,
            this.name,
            this.rosterId,
            this.userId,
            this.idNumber,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.overtimeWorkingTimeJson,
            this.overtimeClosingTimeJson,
            this.standConfigId,
            this.overConfigIds,
            this.point,
            this.attendStatus,
            this.overStatus
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendance.MesBuildingAttendanceBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", attendanceDate="
            + this.attendanceDate
            + ", workType="
            + this.workType
            + ", name="
            + this.name
            + ", rosterId="
            + this.rosterId
            + ", userId="
            + this.userId
            + ", idNumber="
            + this.idNumber
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", overtimeWorkingTimeJson="
            + this.overtimeWorkingTimeJson
            + ", overtimeClosingTimeJson="
            + this.overtimeClosingTimeJson
            + ", standConfigId="
            + this.standConfigId
            + ", overConfigIds="
            + this.overConfigIds
            + ", point="
            + this.point
            + ", attendStatus="
            + this.attendStatus
            + ", overStatus="
            + this.overStatus
            + ")";
      }
   }
}
