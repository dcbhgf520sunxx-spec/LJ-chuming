package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectInspectionUser对象", description = "人员巡检线表")
@Entity
@TableName("project_inspection_user")
@Table(name = "project_inspection_user")
@org.hibernate.annotations.Table(appliesTo = "project_inspection_user", comment = "人员巡检线表 ")
public class ProjectInspectionUser extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "巡检人员id", notes = "巡检人员id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '巡检人员id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "startTime", value = "巡检开始时间", notes = "巡检开始时间")
   @JsonProperty("startTime")
   @JSONField(name = "startTime")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime COMMENT '巡检开始时间'", nullable = false)
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "巡检结束时间", notes = "巡检结束时间")
   @JsonProperty("endTime")
   @JSONField(name = "endTime")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime  COMMENT '巡检结束时间'", nullable = false)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "patrolsTime", value = "巡检次数", notes = "巡检次数")
   @JsonProperty("patrolsTime")
   @JSONField(name = "patrolsTime")
   @TableField("patrols_time")
   @Column(name = "patrols_time", columnDefinition = "int(11)  COMMENT '巡检次数'", nullable = false)
   private Integer patrolsTime;
   @ApiModelProperty(name = "avoidTime", value = "避开时间", notes = "避开时间 参考枚举参考枚举AvoidTimeEnum 1.周六 2.周日 3.周六日 ")
   @JsonProperty("avoidTime")
   @JSONField(name = "avoidTime")
   @TableField("avoid_time")
   @Column(name = "avoid_time", columnDefinition = "int(11)  COMMENT '避开时间 参考枚举AvoidTimeEnum 1.周六 2.周日 3.周六日 '")
   private Integer avoidTime;
   @ApiModelProperty(name = "mandatoryInspection", value = "是否强制巡检")
   @JsonProperty("mandatoryInspection")
   @JSONField(name = "mandatoryInspection")
   @TableField("mandatory_inspection")
   @Column(name = "mandatory_inspection", columnDefinition = "int(11) default 0  COMMENT '是否强制巡检'", nullable = false)
   private boolean mandatoryInspection;
   @ApiModelProperty(name = "intervalTime", notes = "扫码间隔时间(单位分钟 默认一分钟)")
   @JsonProperty("intervalTime")
   @JSONField(name = "intervalTime")
   @TableField("interval_time")
   @Column(name = "interval_time", columnDefinition = "int(11)  COMMENT '扫码间隔时间(单位分钟) '")
   private Integer intervalTime;
   @ApiModelProperty(name = "status", notes = "线路状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) DEFAULT 1  COMMENT '线路状态'")
   private Boolean status;
   @ApiModelProperty(name = "isSort", notes = "是否需要排序 1.需要排序  0.不需要")
   @JsonProperty("isSort")
   @JSONField(name = "isSort")
   @TableField("is_sort")
   @Column(name = "is_sort", columnDefinition = "int(11)  COMMENT  '是否需要排序 1.需要排序  0.不需要'")
   private Integer isSort;

   public static ProjectInspectionUser.ProjectInspectionUserBuilder builder() {
      return new ProjectInspectionUser.ProjectInspectionUserBuilder();
   }

   public ProjectInspectionUser() {
   }

   public ProjectInspectionUser(
      final Long id,
      final Long userId,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Integer patrolsTime,
      final Integer avoidTime,
      final boolean mandatoryInspection,
      final Integer intervalTime,
      final Boolean status,
      final Integer isSort
   ) {
      this.id = id;
      this.userId = userId;
      this.startTime = startTime;
      this.endTime = endTime;
      this.patrolsTime = patrolsTime;
      this.avoidTime = avoidTime;
      this.mandatoryInspection = mandatoryInspection;
      this.intervalTime = intervalTime;
      this.status = status;
      this.isSort = isSort;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Integer getPatrolsTime() {
      return this.patrolsTime;
   }

   public Integer getAvoidTime() {
      return this.avoidTime;
   }

   public boolean isMandatoryInspection() {
      return this.mandatoryInspection;
   }

   public Integer getIntervalTime() {
      return this.intervalTime;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getIsSort() {
      return this.isSort;
   }

   @JsonProperty("id")
   public ProjectInspectionUser setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public ProjectInspectionUser setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("startTime")
   public ProjectInspectionUser setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @JsonProperty("endTime")
   public ProjectInspectionUser setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   @JsonProperty("patrolsTime")
   public ProjectInspectionUser setPatrolsTime(final Integer patrolsTime) {
      this.patrolsTime = patrolsTime;
      return this;
   }

   @JsonProperty("avoidTime")
   public ProjectInspectionUser setAvoidTime(final Integer avoidTime) {
      this.avoidTime = avoidTime;
      return this;
   }

   @JsonProperty("mandatoryInspection")
   public ProjectInspectionUser setMandatoryInspection(final boolean mandatoryInspection) {
      this.mandatoryInspection = mandatoryInspection;
      return this;
   }

   @JsonProperty("intervalTime")
   public ProjectInspectionUser setIntervalTime(final Integer intervalTime) {
      this.intervalTime = intervalTime;
      return this;
   }

   @JsonProperty("status")
   public ProjectInspectionUser setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("isSort")
   public ProjectInspectionUser setIsSort(final Integer isSort) {
      this.isSort = isSort;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionUser(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", patrolsTime="
         + this.getPatrolsTime()
         + ", avoidTime="
         + this.getAvoidTime()
         + ", mandatoryInspection="
         + this.isMandatoryInspection()
         + ", intervalTime="
         + this.getIntervalTime()
         + ", status="
         + this.getStatus()
         + ", isSort="
         + this.getIsSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionUser)) {
         return false;
      }

      ProjectInspectionUser other = (ProjectInspectionUser)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      if (this.isMandatoryInspection() != other.isMandatoryInspection()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$patrolsTime = this.getPatrolsTime();
            Object other$patrolsTime = other.getPatrolsTime();
            if (this$patrolsTime == null ? other$patrolsTime == null : this$patrolsTime.equals(other$patrolsTime)) {
               Object this$avoidTime = this.getAvoidTime();
               Object other$avoidTime = other.getAvoidTime();
               if (this$avoidTime == null ? other$avoidTime == null : this$avoidTime.equals(other$avoidTime)) {
                  Object this$intervalTime = this.getIntervalTime();
                  Object other$intervalTime = other.getIntervalTime();
                  if (this$intervalTime == null ? other$intervalTime == null : this$intervalTime.equals(other$intervalTime)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$isSort = this.getIsSort();
                        Object other$isSort = other.getIsSort();
                        if (this$isSort == null ? other$isSort == null : this$isSort.equals(other$isSort)) {
                           Object this$startTime = this.getStartTime();
                           Object other$startTime = other.getStartTime();
                           if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                              Object this$endTime = this.getEndTime();
                              Object other$endTime = other.getEndTime();
                              return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof ProjectInspectionUser;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      result = result * 59 + (this.isMandatoryInspection() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $patrolsTime = this.getPatrolsTime();
      result = result * 59 + ($patrolsTime == null ? 43 : $patrolsTime.hashCode());
      Object $avoidTime = this.getAvoidTime();
      result = result * 59 + ($avoidTime == null ? 43 : $avoidTime.hashCode());
      Object $intervalTime = this.getIntervalTime();
      result = result * 59 + ($intervalTime == null ? 43 : $intervalTime.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $isSort = this.getIsSort();
      result = result * 59 + ($isSort == null ? 43 : $isSort.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   public static class ProjectInspectionUserBuilder {
      private Long id;
      private Long userId;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Integer patrolsTime;
      private Integer avoidTime;
      private boolean mandatoryInspection;
      private Integer intervalTime;
      private Boolean status;
      private Integer isSort;

      ProjectInspectionUserBuilder() {
      }

      @JsonProperty("id")
      public ProjectInspectionUser.ProjectInspectionUserBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public ProjectInspectionUser.ProjectInspectionUserBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("startTime")
      public ProjectInspectionUser.ProjectInspectionUserBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      @JsonProperty("endTime")
      public ProjectInspectionUser.ProjectInspectionUserBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      @JsonProperty("patrolsTime")
      public ProjectInspectionUser.ProjectInspectionUserBuilder patrolsTime(final Integer patrolsTime) {
         this.patrolsTime = patrolsTime;
         return this;
      }

      @JsonProperty("avoidTime")
      public ProjectInspectionUser.ProjectInspectionUserBuilder avoidTime(final Integer avoidTime) {
         this.avoidTime = avoidTime;
         return this;
      }

      @JsonProperty("mandatoryInspection")
      public ProjectInspectionUser.ProjectInspectionUserBuilder mandatoryInspection(final boolean mandatoryInspection) {
         this.mandatoryInspection = mandatoryInspection;
         return this;
      }

      @JsonProperty("intervalTime")
      public ProjectInspectionUser.ProjectInspectionUserBuilder intervalTime(final Integer intervalTime) {
         this.intervalTime = intervalTime;
         return this;
      }

      @JsonProperty("status")
      public ProjectInspectionUser.ProjectInspectionUserBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("isSort")
      public ProjectInspectionUser.ProjectInspectionUserBuilder isSort(final Integer isSort) {
         this.isSort = isSort;
         return this;
      }

      public ProjectInspectionUser build() {
         return new ProjectInspectionUser(
            this.id,
            this.userId,
            this.startTime,
            this.endTime,
            this.patrolsTime,
            this.avoidTime,
            this.mandatoryInspection,
            this.intervalTime,
            this.status,
            this.isSort
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionUser.ProjectInspectionUserBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", patrolsTime="
            + this.patrolsTime
            + ", avoidTime="
            + this.avoidTime
            + ", mandatoryInspection="
            + this.mandatoryInspection
            + ", intervalTime="
            + this.intervalTime
            + ", status="
            + this.status
            + ", isSort="
            + this.isSort
            + ")";
      }
   }
}
