package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectInspectionDTOParam", description = "巡检线路")
public class ProjectInspectionLineDTOParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "巡检人员id", notes = "巡检人员id")
   @NotNull
   private Long userId;
   @ApiModelProperty(name = "startTime", value = "巡检开始时间", notes = "巡检开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "巡检结束时间", notes = "巡检结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "patrolsTime", value = "巡检次数", notes = "巡检次数")
   private Integer patrolsTime;
   @ApiModelProperty(name = "intervalTime", notes = "扫码间隔时间")
   private Integer intervalTime;
   @ApiModelProperty(name = "mandatoryInspection", value = "是否强制巡检", notes = "是否强制巡检")
   private boolean mandatoryInspection;
   @ApiModelProperty(name = "avoidTime", value = "避开时间", notes = "避开时间 参考枚举参考枚举AvoidTimeEnum 1.周六 2.周日 3.周六日 ")
   private Integer avoidTime;
   @ApiModelProperty(name = "isSort", notes = "是否需要排序 1.需要排序  0.不需要")
   private Integer isSort;
   @ApiModelProperty(name = "projectInspectionDTOS", value = "巡检点位集合", notes = "巡检点位集合")
   private List<ProjectInspectionDTO> projectInspectionDTOS;

   public static ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder builder() {
      return new ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder();
   }

   public ProjectInspectionLineDTOParam() {
   }

   public ProjectInspectionLineDTOParam(
      final Long id,
      final Long userId,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Integer patrolsTime,
      final Integer intervalTime,
      final boolean mandatoryInspection,
      final Integer avoidTime,
      final Integer isSort,
      final List<ProjectInspectionDTO> projectInspectionDTOS
   ) {
      this.id = id;
      this.userId = userId;
      this.startTime = startTime;
      this.endTime = endTime;
      this.patrolsTime = patrolsTime;
      this.intervalTime = intervalTime;
      this.mandatoryInspection = mandatoryInspection;
      this.avoidTime = avoidTime;
      this.isSort = isSort;
      this.projectInspectionDTOS = projectInspectionDTOS;
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

   public Integer getIntervalTime() {
      return this.intervalTime;
   }

   public boolean isMandatoryInspection() {
      return this.mandatoryInspection;
   }

   public Integer getAvoidTime() {
      return this.avoidTime;
   }

   public Integer getIsSort() {
      return this.isSort;
   }

   public List<ProjectInspectionDTO> getProjectInspectionDTOS() {
      return this.projectInspectionDTOS;
   }

   public ProjectInspectionLineDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionLineDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectInspectionLineDTOParam setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public ProjectInspectionLineDTOParam setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public ProjectInspectionLineDTOParam setPatrolsTime(final Integer patrolsTime) {
      this.patrolsTime = patrolsTime;
      return this;
   }

   public ProjectInspectionLineDTOParam setIntervalTime(final Integer intervalTime) {
      this.intervalTime = intervalTime;
      return this;
   }

   public ProjectInspectionLineDTOParam setMandatoryInspection(final boolean mandatoryInspection) {
      this.mandatoryInspection = mandatoryInspection;
      return this;
   }

   public ProjectInspectionLineDTOParam setAvoidTime(final Integer avoidTime) {
      this.avoidTime = avoidTime;
      return this;
   }

   public ProjectInspectionLineDTOParam setIsSort(final Integer isSort) {
      this.isSort = isSort;
      return this;
   }

   public ProjectInspectionLineDTOParam setProjectInspectionDTOS(final List<ProjectInspectionDTO> projectInspectionDTOS) {
      this.projectInspectionDTOS = projectInspectionDTOS;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionLineDTOParam)) {
         return false;
      }

      ProjectInspectionLineDTOParam other = (ProjectInspectionLineDTOParam)o;
      if (!other.canEqual(this)) {
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
               Object this$intervalTime = this.getIntervalTime();
               Object other$intervalTime = other.getIntervalTime();
               if (this$intervalTime == null ? other$intervalTime == null : this$intervalTime.equals(other$intervalTime)) {
                  Object this$avoidTime = this.getAvoidTime();
                  Object other$avoidTime = other.getAvoidTime();
                  if (this$avoidTime == null ? other$avoidTime == null : this$avoidTime.equals(other$avoidTime)) {
                     Object this$isSort = this.getIsSort();
                     Object other$isSort = other.getIsSort();
                     if (this$isSort == null ? other$isSort == null : this$isSort.equals(other$isSort)) {
                        Object this$startTime = this.getStartTime();
                        Object other$startTime = other.getStartTime();
                        if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                           Object this$endTime = this.getEndTime();
                           Object other$endTime = other.getEndTime();
                           if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                              Object this$projectInspectionDTOS = this.getProjectInspectionDTOS();
                              Object other$projectInspectionDTOS = other.getProjectInspectionDTOS();
                              return this$projectInspectionDTOS == null
                                 ? other$projectInspectionDTOS == null
                                 : this$projectInspectionDTOS.equals(other$projectInspectionDTOS);
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
      return other instanceof ProjectInspectionLineDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isMandatoryInspection() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $patrolsTime = this.getPatrolsTime();
      result = result * 59 + ($patrolsTime == null ? 43 : $patrolsTime.hashCode());
      Object $intervalTime = this.getIntervalTime();
      result = result * 59 + ($intervalTime == null ? 43 : $intervalTime.hashCode());
      Object $avoidTime = this.getAvoidTime();
      result = result * 59 + ($avoidTime == null ? 43 : $avoidTime.hashCode());
      Object $isSort = this.getIsSort();
      result = result * 59 + ($isSort == null ? 43 : $isSort.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $projectInspectionDTOS = this.getProjectInspectionDTOS();
      return result * 59 + ($projectInspectionDTOS == null ? 43 : $projectInspectionDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInspectionLineDTOParam(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", patrolsTime="
         + this.getPatrolsTime()
         + ", intervalTime="
         + this.getIntervalTime()
         + ", mandatoryInspection="
         + this.isMandatoryInspection()
         + ", avoidTime="
         + this.getAvoidTime()
         + ", isSort="
         + this.getIsSort()
         + ", projectInspectionDTOS="
         + this.getProjectInspectionDTOS()
         + ")";
   }

   public static class ProjectInspectionLineDTOParamBuilder {
      private Long id;
      private Long userId;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Integer patrolsTime;
      private Integer intervalTime;
      private boolean mandatoryInspection;
      private Integer avoidTime;
      private Integer isSort;
      private List<ProjectInspectionDTO> projectInspectionDTOS;

      ProjectInspectionLineDTOParamBuilder() {
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder patrolsTime(final Integer patrolsTime) {
         this.patrolsTime = patrolsTime;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder intervalTime(final Integer intervalTime) {
         this.intervalTime = intervalTime;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder mandatoryInspection(final boolean mandatoryInspection) {
         this.mandatoryInspection = mandatoryInspection;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder avoidTime(final Integer avoidTime) {
         this.avoidTime = avoidTime;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder isSort(final Integer isSort) {
         this.isSort = isSort;
         return this;
      }

      public ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder projectInspectionDTOS(final List<ProjectInspectionDTO> projectInspectionDTOS) {
         this.projectInspectionDTOS = projectInspectionDTOS;
         return this;
      }

      public ProjectInspectionLineDTOParam build() {
         return new ProjectInspectionLineDTOParam(
            this.id,
            this.userId,
            this.startTime,
            this.endTime,
            this.patrolsTime,
            this.intervalTime,
            this.mandatoryInspection,
            this.avoidTime,
            this.isSort,
            this.projectInspectionDTOS
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionLineDTOParam.ProjectInspectionLineDTOParamBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", patrolsTime="
            + this.patrolsTime
            + ", intervalTime="
            + this.intervalTime
            + ", mandatoryInspection="
            + this.mandatoryInspection
            + ", avoidTime="
            + this.avoidTime
            + ", isSort="
            + this.isSort
            + ", projectInspectionDTOS="
            + this.projectInspectionDTOS
            + ")";
      }
   }
}
