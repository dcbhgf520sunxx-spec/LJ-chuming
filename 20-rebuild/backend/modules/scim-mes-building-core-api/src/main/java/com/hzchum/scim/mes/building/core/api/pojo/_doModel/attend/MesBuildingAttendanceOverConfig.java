package com.hzchum.scim.mes.building.core.api.pojo._doModel.attend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingAttendanceOverConfig对象", description = "")
@Entity
@TableName("mes_building_attendance_over_config")
@Table(name = "mes_building_attendance_over_config")
@org.hibernate.annotations.Table(appliesTo = "mes_building_attendance_over_config")
public class MesBuildingAttendanceOverConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "departmentId", value = "部门ID", notes = "部门ID")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20)  COMMENT '部门ID'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "overtimeWorkingTime", value = "加班开始时间", notes = "加班开始时间")
   @TableField("overtime_working_time")
   @Column(name = "overtime_working_time", columnDefinition = "datetime  COMMENT '加班开始时间'", nullable = true)
   private LocalDateTime overtimeWorkingTime;
   @ApiModelProperty(name = "overtimeClosingTime", value = "加班结束时间", notes = "加班结束时间")
   @TableField("overtime_closing_time")
   @Column(name = "overtime_closing_time", columnDefinition = "datetime  COMMENT '加班结束时间'", nullable = true)
   private LocalDateTime overtimeClosingTime;
   @ApiModelProperty(name = "isCanDelay", value = "是否允许迟到", notes = "是否允许迟到")
   @TableField("is_can_delay")
   @Column(name = "is_can_delay", columnDefinition = "tinyint(1)  COMMENT '是否允许迟到'", nullable = true)
   private Boolean isCanDelay;
   @ApiModelProperty(name = "isCanEarly", value = "是否允许早退", notes = "是否允许早退")
   @TableField("is_can_early")
   @Column(name = "is_can_early", columnDefinition = "tinyint(1)  COMMENT '是否允许早退'", nullable = true)
   private Boolean isCanEarly;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         MesBuildingAttendanceOverConfig that = (MesBuildingAttendanceOverConfig)o;
         return this.overtimeWorkingTime.isEqual(that.overtimeWorkingTime)
            && this.overtimeClosingTime.isEqual(that.overtimeClosingTime)
            && this.departmentId.equals(that.departmentId)
            && this.isCanDelay.equals(that.isCanDelay)
            && this.isCanEarly.equals(that.isCanEarly);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), this.departmentId, this.overtimeWorkingTime, this.overtimeClosingTime, this.isCanDelay, this.isCanEarly);
   }

   public static MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder builder() {
      return new MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder();
   }

   public MesBuildingAttendanceOverConfig() {
   }

   public MesBuildingAttendanceOverConfig(
      final Long id,
      final Long departmentId,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final Boolean isCanDelay,
      final Boolean isCanEarly,
      final Long userId,
      final String userName
   ) {
      this.id = id;
      this.departmentId = departmentId;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.isCanDelay = isCanDelay;
      this.isCanEarly = isCanEarly;
      this.userId = userId;
      this.userName = userName;
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

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public MesBuildingAttendanceOverConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAttendanceOverConfig setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public MesBuildingAttendanceOverConfig setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
      return this;
   }

   public MesBuildingAttendanceOverConfig setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
      return this;
   }

   public MesBuildingAttendanceOverConfig setIsCanDelay(final Boolean isCanDelay) {
      this.isCanDelay = isCanDelay;
      return this;
   }

   public MesBuildingAttendanceOverConfig setIsCanEarly(final Boolean isCanEarly) {
      this.isCanEarly = isCanEarly;
      return this;
   }

   public MesBuildingAttendanceOverConfig setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesBuildingAttendanceOverConfig setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceOverConfig(id="
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
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class MesBuildingAttendanceOverConfigBuilder {
      private Long id;
      private Long departmentId;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private Boolean isCanDelay;
      private Boolean isCanEarly;
      private Long userId;
      private String userName;

      MesBuildingAttendanceOverConfigBuilder() {
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder isCanDelay(final Boolean isCanDelay) {
         this.isCanDelay = isCanDelay;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder isCanEarly(final Boolean isCanEarly) {
         this.isCanEarly = isCanEarly;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingAttendanceOverConfig build() {
         return new MesBuildingAttendanceOverConfig(
            this.id, this.departmentId, this.overtimeWorkingTime, this.overtimeClosingTime, this.isCanDelay, this.isCanEarly, this.userId, this.userName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceOverConfig.MesBuildingAttendanceOverConfigBuilder(id="
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
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
