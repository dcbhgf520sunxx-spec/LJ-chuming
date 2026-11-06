package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("巡检点详情DTO")
public class ProjectInspectionDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "userName", notes = "巡检人员名字")
   private String userName;
   @ApiModelProperty(name = "projectInspectionDTOS", notes = "巡检点集合")
   private List<ProjectInspectionDTO> projectInspectionDTOS;
   @ApiModelProperty(name = "inspectionQuantity", notes = "巡检点数量")
   private Long inspectionQuantity;
   @ApiModelProperty(name = "patrolsTime", value = "巡检次数", notes = "巡检次数")
   private Integer patrolsTime;
   @ApiModelProperty(name = "avoidTime", value = "避开时间", notes = "避开时间 参考枚举参考枚举AvoidTimeEnum 1.周六 2.周日 3.周六日 ")
   private Integer avoidTime;
   @ApiModelProperty(name = "startTime", value = "巡检开始时间", notes = "巡检开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "巡检结束时间", notes = "巡检结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "intervalTime", notes = "扫码间隔时间(单位分钟 默认一分钟)")
   private Integer intervalTime;

   public static ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder builder() {
      return new ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder();
   }

   public ProjectInspectionDetailDTO() {
   }

   public ProjectInspectionDetailDTO(
      final Long id,
      final String userName,
      final List<ProjectInspectionDTO> projectInspectionDTOS,
      final Long inspectionQuantity,
      final Integer patrolsTime,
      final Integer avoidTime,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Integer intervalTime
   ) {
      this.id = id;
      this.userName = userName;
      this.projectInspectionDTOS = projectInspectionDTOS;
      this.inspectionQuantity = inspectionQuantity;
      this.patrolsTime = patrolsTime;
      this.avoidTime = avoidTime;
      this.startTime = startTime;
      this.endTime = endTime;
      this.intervalTime = intervalTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<ProjectInspectionDTO> getProjectInspectionDTOS() {
      return this.projectInspectionDTOS;
   }

   public Long getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getPatrolsTime() {
      return this.patrolsTime;
   }

   public Integer getAvoidTime() {
      return this.avoidTime;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Integer getIntervalTime() {
      return this.intervalTime;
   }

   public ProjectInspectionDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectInspectionDetailDTO setProjectInspectionDTOS(final List<ProjectInspectionDTO> projectInspectionDTOS) {
      this.projectInspectionDTOS = projectInspectionDTOS;
      return this;
   }

   public ProjectInspectionDetailDTO setInspectionQuantity(final Long inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   public ProjectInspectionDetailDTO setPatrolsTime(final Integer patrolsTime) {
      this.patrolsTime = patrolsTime;
      return this;
   }

   public ProjectInspectionDetailDTO setAvoidTime(final Integer avoidTime) {
      this.avoidTime = avoidTime;
      return this;
   }

   public ProjectInspectionDetailDTO setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public ProjectInspectionDetailDTO setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public ProjectInspectionDetailDTO setIntervalTime(final Integer intervalTime) {
      this.intervalTime = intervalTime;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionDetailDTO(id="
         + this.getId()
         + ", userName="
         + this.getUserName()
         + ", projectInspectionDTOS="
         + this.getProjectInspectionDTOS()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", patrolsTime="
         + this.getPatrolsTime()
         + ", avoidTime="
         + this.getAvoidTime()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", intervalTime="
         + this.getIntervalTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionDetailDTO)) {
         return false;
      }

      ProjectInspectionDetailDTO other = (ProjectInspectionDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectionQuantity = this.getInspectionQuantity();
         Object other$inspectionQuantity = other.getInspectionQuantity();
         if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
            Object this$patrolsTime = this.getPatrolsTime();
            Object other$patrolsTime = other.getPatrolsTime();
            if (this$patrolsTime == null ? other$patrolsTime == null : this$patrolsTime.equals(other$patrolsTime)) {
               Object this$avoidTime = this.getAvoidTime();
               Object other$avoidTime = other.getAvoidTime();
               if (this$avoidTime == null ? other$avoidTime == null : this$avoidTime.equals(other$avoidTime)) {
                  Object this$intervalTime = this.getIntervalTime();
                  Object other$intervalTime = other.getIntervalTime();
                  if (this$intervalTime == null ? other$intervalTime == null : this$intervalTime.equals(other$intervalTime)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$projectInspectionDTOS = this.getProjectInspectionDTOS();
                        Object other$projectInspectionDTOS = other.getProjectInspectionDTOS();
                        if (this$projectInspectionDTOS == null
                           ? other$projectInspectionDTOS == null
                           : this$projectInspectionDTOS.equals(other$projectInspectionDTOS)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $patrolsTime = this.getPatrolsTime();
      result = result * 59 + ($patrolsTime == null ? 43 : $patrolsTime.hashCode());
      Object $avoidTime = this.getAvoidTime();
      result = result * 59 + ($avoidTime == null ? 43 : $avoidTime.hashCode());
      Object $intervalTime = this.getIntervalTime();
      result = result * 59 + ($intervalTime == null ? 43 : $intervalTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $projectInspectionDTOS = this.getProjectInspectionDTOS();
      result = result * 59 + ($projectInspectionDTOS == null ? 43 : $projectInspectionDTOS.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   public static class ProjectInspectionDetailDTOBuilder {
      private Long id;
      private String userName;
      private List<ProjectInspectionDTO> projectInspectionDTOS;
      private Long inspectionQuantity;
      private Integer patrolsTime;
      private Integer avoidTime;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Integer intervalTime;

      ProjectInspectionDetailDTOBuilder() {
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder projectInspectionDTOS(final List<ProjectInspectionDTO> projectInspectionDTOS) {
         this.projectInspectionDTOS = projectInspectionDTOS;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder inspectionQuantity(final Long inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder patrolsTime(final Integer patrolsTime) {
         this.patrolsTime = patrolsTime;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder avoidTime(final Integer avoidTime) {
         this.avoidTime = avoidTime;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder intervalTime(final Integer intervalTime) {
         this.intervalTime = intervalTime;
         return this;
      }

      public ProjectInspectionDetailDTO build() {
         return new ProjectInspectionDetailDTO(
            this.id,
            this.userName,
            this.projectInspectionDTOS,
            this.inspectionQuantity,
            this.patrolsTime,
            this.avoidTime,
            this.startTime,
            this.endTime,
            this.intervalTime
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionDetailDTO.ProjectInspectionDetailDTOBuilder(id="
            + this.id
            + ", userName="
            + this.userName
            + ", projectInspectionDTOS="
            + this.projectInspectionDTOS
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", patrolsTime="
            + this.patrolsTime
            + ", avoidTime="
            + this.avoidTime
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", intervalTime="
            + this.intervalTime
            + ")";
      }
   }
}
