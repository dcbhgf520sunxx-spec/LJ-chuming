package com.hzchum.scim.project.core.api.pojo._doModel.attend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectManageAttendanceConfig对象", description = "")
@Entity
@TableName("project_manage_attendance_config")
@Table(name = "project_manage_attendance_config")
@org.hibernate.annotations.Table(appliesTo = "project_manage_attendance_config")
public class ProjectManageAttendanceConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "int(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
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
   @ApiModelProperty(name = "punchTimes", value = "打卡次数", notes = "打卡次数")
   @TableField("punch_times")
   @Column(name = "punch_times", columnDefinition = "int(11)  COMMENT '打卡次数'", nullable = false)
   private Integer punchTimes;
   @ApiModelProperty(name = "workHours", value = "标准工时", notes = "标准工时")
   @TableField("work_hours")
   @Column(name = "work_hours", columnDefinition = "decimal(8,2)  COMMENT '标准工时'", nullable = false)
   private BigDecimal workHours;
   @ApiModelProperty(name = "supplierScope", value = "需要打卡分包商", notes = "需要打卡分包商")
   @TableField("supplier_scope")
   @Column(name = "supplier_scope", columnDefinition = "varchar(255)  COMMENT '需要打卡分包商'", nullable = false)
   private String supplierScope;
   @ApiModelProperty(name = "isClose", value = "是否关闭", notes = "是否关闭")
   @TableField("is_close")
   @Column(name = "is_close", columnDefinition = "tinyint(1)  COMMENT '是否关闭'", nullable = false)
   private Boolean isClose;
   @ApiModelProperty(name = "isOutScope", value = "允许迟到早退", notes = "允许迟到早退")
   @TableField("is_out_scope")
   @Column(name = "is_out_scope", columnDefinition = "tinyint(1)  COMMENT '允许迟到早退'", nullable = false)
   private Boolean isOutScope;
   @ApiModelProperty(name = "isNeedPicture", value = "是否需要拍照", notes = "是否需要拍照")
   @TableField("is_need_picture")
   @Column(name = "is_need_picture", columnDefinition = "tinyint(1)  COMMENT '是否需要拍照'", nullable = false)
   private Boolean isNeedPicture;
   @ApiModelProperty(name = "isNeedFence", value = "是否需要电子围栏", notes = "是否需要电子围栏")
   @TableField("is_need_fence")
   @Column(name = "is_need_fence", columnDefinition = "tinyint(1)  COMMENT '是否需要电子围栏'", nullable = false)
   private Boolean isNeedFence;

   public static ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder builder() {
      return new ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder();
   }

   public ProjectManageAttendanceConfig() {
   }

   public ProjectManageAttendanceConfig(
      final Long id,
      final Long projectId,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final Integer punchTimes,
      final BigDecimal workHours,
      final String supplierScope,
      final Boolean isClose,
      final Boolean isOutScope,
      final Boolean isNeedPicture,
      final Boolean isNeedFence
   ) {
      this.id = id;
      this.projectId = projectId;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.punchTimes = punchTimes;
      this.workHours = workHours;
      this.supplierScope = supplierScope;
      this.isClose = isClose;
      this.isOutScope = isOutScope;
      this.isNeedPicture = isNeedPicture;
      this.isNeedFence = isNeedFence;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Integer getPunchTimes() {
      return this.punchTimes;
   }

   public BigDecimal getWorkHours() {
      return this.workHours;
   }

   public String getSupplierScope() {
      return this.supplierScope;
   }

   public Boolean getIsClose() {
      return this.isClose;
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

   public ProjectManageAttendanceConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageAttendanceConfig setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectManageAttendanceConfig setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   public ProjectManageAttendanceConfig setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   public ProjectManageAttendanceConfig setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   public ProjectManageAttendanceConfig setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public ProjectManageAttendanceConfig setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
      return this;
   }

   public ProjectManageAttendanceConfig setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
      return this;
   }

   public ProjectManageAttendanceConfig setPunchTimes(final Integer punchTimes) {
      this.punchTimes = punchTimes;
      return this;
   }

   public ProjectManageAttendanceConfig setWorkHours(final BigDecimal workHours) {
      this.workHours = workHours;
      return this;
   }

   public ProjectManageAttendanceConfig setSupplierScope(final String supplierScope) {
      this.supplierScope = supplierScope;
      return this;
   }

   public ProjectManageAttendanceConfig setIsClose(final Boolean isClose) {
      this.isClose = isClose;
      return this;
   }

   public ProjectManageAttendanceConfig setIsOutScope(final Boolean isOutScope) {
      this.isOutScope = isOutScope;
      return this;
   }

   public ProjectManageAttendanceConfig setIsNeedPicture(final Boolean isNeedPicture) {
      this.isNeedPicture = isNeedPicture;
      return this;
   }

   public ProjectManageAttendanceConfig setIsNeedFence(final Boolean isNeedFence) {
      this.isNeedFence = isNeedFence;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceConfig(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
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
         + ", punchTimes="
         + this.getPunchTimes()
         + ", workHours="
         + this.getWorkHours()
         + ", supplierScope="
         + this.getSupplierScope()
         + ", isClose="
         + this.getIsClose()
         + ", isOutScope="
         + this.getIsOutScope()
         + ", isNeedPicture="
         + this.getIsNeedPicture()
         + ", isNeedFence="
         + this.getIsNeedFence()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceConfig)) {
         return false;
      }

      ProjectManageAttendanceConfig other = (ProjectManageAttendanceConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$punchTimes = this.getPunchTimes();
            Object other$punchTimes = other.getPunchTimes();
            if (this$punchTimes == null ? other$punchTimes == null : this$punchTimes.equals(other$punchTimes)) {
               Object this$isClose = this.getIsClose();
               Object other$isClose = other.getIsClose();
               if (this$isClose == null ? other$isClose == null : this$isClose.equals(other$isClose)) {
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
                              if (this$morningClosingTime == null ? other$morningClosingTime == null : this$morningClosingTime.equals(other$morningClosingTime)
                                 )
                               {
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
                                                Object this$supplierScope = this.getSupplierScope();
                                                Object other$supplierScope = other.getSupplierScope();
                                                return this$supplierScope == null
                                                   ? other$supplierScope == null
                                                   : this$supplierScope.equals(other$supplierScope);
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
      return other instanceof ProjectManageAttendanceConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $punchTimes = this.getPunchTimes();
      result = result * 59 + ($punchTimes == null ? 43 : $punchTimes.hashCode());
      Object $isClose = this.getIsClose();
      result = result * 59 + ($isClose == null ? 43 : $isClose.hashCode());
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
      Object $workHours = this.getWorkHours();
      result = result * 59 + ($workHours == null ? 43 : $workHours.hashCode());
      Object $supplierScope = this.getSupplierScope();
      return result * 59 + ($supplierScope == null ? 43 : $supplierScope.hashCode());
   }

   public static class ProjectManageAttendanceConfigBuilder {
      private Long id;
      private Long projectId;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private Integer punchTimes;
      private BigDecimal workHours;
      private String supplierScope;
      private Boolean isClose;
      private Boolean isOutScope;
      private Boolean isNeedPicture;
      private Boolean isNeedFence;

      ProjectManageAttendanceConfigBuilder() {
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder punchTimes(final Integer punchTimes) {
         this.punchTimes = punchTimes;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder workHours(final BigDecimal workHours) {
         this.workHours = workHours;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder supplierScope(final String supplierScope) {
         this.supplierScope = supplierScope;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder isClose(final Boolean isClose) {
         this.isClose = isClose;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder isOutScope(final Boolean isOutScope) {
         this.isOutScope = isOutScope;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder isNeedPicture(final Boolean isNeedPicture) {
         this.isNeedPicture = isNeedPicture;
         return this;
      }

      public ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder isNeedFence(final Boolean isNeedFence) {
         this.isNeedFence = isNeedFence;
         return this;
      }

      public ProjectManageAttendanceConfig build() {
         return new ProjectManageAttendanceConfig(
            this.id,
            this.projectId,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.overtimeWorkingTime,
            this.overtimeClosingTime,
            this.punchTimes,
            this.workHours,
            this.supplierScope,
            this.isClose,
            this.isOutScope,
            this.isNeedPicture,
            this.isNeedFence
         );
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceConfig.ProjectManageAttendanceConfigBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
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
            + ", punchTimes="
            + this.punchTimes
            + ", workHours="
            + this.workHours
            + ", supplierScope="
            + this.supplierScope
            + ", isClose="
            + this.isClose
            + ", isOutScope="
            + this.isOutScope
            + ", isNeedPicture="
            + this.isNeedPicture
            + ", isNeedFence="
            + this.isNeedFence
            + ")";
      }
   }
}
