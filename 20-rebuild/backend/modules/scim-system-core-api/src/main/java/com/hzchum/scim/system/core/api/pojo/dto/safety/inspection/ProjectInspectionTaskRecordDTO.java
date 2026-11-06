package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("人员巡检任务DTO")
public class ProjectInspectionTaskRecordDTO {
   @ApiModelProperty(name = "巡检人员表id")
   private Long id;
   @ApiModelProperty(name = "userName", notes = "巡检负责人名字")
   private String userName;
   @ApiModelProperty(name = "startTime", notes = "巡检开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", notes = "巡检结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "intervalTime", notes = "扫码间隔时间(单位分钟 默认一分钟)")
   private Integer intervalTime;
   @ApiModelProperty(name = "inspectionDate", notes = "巡检日期")
   private LocalDate inspectionDate;
   @ApiModelProperty(name = "patrolsTime", notes = "本日巡检次数")
   private Integer patrolsTime;
   @ApiModelProperty(name = "projectInspectionTaskTimeAndAttachmentDTOS", notes = "巡检信息")
   private List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS;

   public static ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder builder() {
      return new ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder();
   }

   public ProjectInspectionTaskRecordDTO() {
   }

   public ProjectInspectionTaskRecordDTO(
      final Long id,
      final String userName,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Integer intervalTime,
      final LocalDate inspectionDate,
      final Integer patrolsTime,
      final List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS
   ) {
      this.id = id;
      this.userName = userName;
      this.startTime = startTime;
      this.endTime = endTime;
      this.intervalTime = intervalTime;
      this.inspectionDate = inspectionDate;
      this.patrolsTime = patrolsTime;
      this.projectInspectionTaskTimeAndAttachmentDTOS = projectInspectionTaskTimeAndAttachmentDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public String getUserName() {
      return this.userName;
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

   public LocalDate getInspectionDate() {
      return this.inspectionDate;
   }

   public Integer getPatrolsTime() {
      return this.patrolsTime;
   }

   public List<ProjectInspectionTaskTimeAndAttachmentDTO> getProjectInspectionTaskTimeAndAttachmentDTOS() {
      return this.projectInspectionTaskTimeAndAttachmentDTOS;
   }

   public ProjectInspectionTaskRecordDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setIntervalTime(final Integer intervalTime) {
      this.intervalTime = intervalTime;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setInspectionDate(final LocalDate inspectionDate) {
      this.inspectionDate = inspectionDate;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setPatrolsTime(final Integer patrolsTime) {
      this.patrolsTime = patrolsTime;
      return this;
   }

   public ProjectInspectionTaskRecordDTO setProjectInspectionTaskTimeAndAttachmentDTOS(
      final List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS
   ) {
      this.projectInspectionTaskTimeAndAttachmentDTOS = projectInspectionTaskTimeAndAttachmentDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionTaskRecordDTO(id="
         + this.getId()
         + ", userName="
         + this.getUserName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", intervalTime="
         + this.getIntervalTime()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", patrolsTime="
         + this.getPatrolsTime()
         + ", projectInspectionTaskTimeAndAttachmentDTOS="
         + this.getProjectInspectionTaskTimeAndAttachmentDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionTaskRecordDTO)) {
         return false;
      }

      ProjectInspectionTaskRecordDTO other = (ProjectInspectionTaskRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$intervalTime = this.getIntervalTime();
         Object other$intervalTime = other.getIntervalTime();
         if (this$intervalTime == null ? other$intervalTime == null : this$intervalTime.equals(other$intervalTime)) {
            Object this$patrolsTime = this.getPatrolsTime();
            Object other$patrolsTime = other.getPatrolsTime();
            if (this$patrolsTime == null ? other$patrolsTime == null : this$patrolsTime.equals(other$patrolsTime)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$startTime = this.getStartTime();
                  Object other$startTime = other.getStartTime();
                  if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                     Object this$endTime = this.getEndTime();
                     Object other$endTime = other.getEndTime();
                     if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                        Object this$inspectionDate = this.getInspectionDate();
                        Object other$inspectionDate = other.getInspectionDate();
                        if (this$inspectionDate == null ? other$inspectionDate == null : this$inspectionDate.equals(other$inspectionDate)) {
                           Object this$projectInspectionTaskTimeAndAttachmentDTOS = this.getProjectInspectionTaskTimeAndAttachmentDTOS();
                           Object other$projectInspectionTaskTimeAndAttachmentDTOS = other.getProjectInspectionTaskTimeAndAttachmentDTOS();
                           return this$projectInspectionTaskTimeAndAttachmentDTOS == null
                              ? other$projectInspectionTaskTimeAndAttachmentDTOS == null
                              : this$projectInspectionTaskTimeAndAttachmentDTOS.equals(other$projectInspectionTaskTimeAndAttachmentDTOS);
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
      return other instanceof ProjectInspectionTaskRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $intervalTime = this.getIntervalTime();
      result = result * 59 + ($intervalTime == null ? 43 : $intervalTime.hashCode());
      Object $patrolsTime = this.getPatrolsTime();
      result = result * 59 + ($patrolsTime == null ? 43 : $patrolsTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $inspectionDate = this.getInspectionDate();
      result = result * 59 + ($inspectionDate == null ? 43 : $inspectionDate.hashCode());
      Object $projectInspectionTaskTimeAndAttachmentDTOS = this.getProjectInspectionTaskTimeAndAttachmentDTOS();
      return result * 59 + ($projectInspectionTaskTimeAndAttachmentDTOS == null ? 43 : $projectInspectionTaskTimeAndAttachmentDTOS.hashCode());
   }

   public static class ProjectInspectionTaskRecordDTOBuilder {
      private Long id;
      private String userName;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Integer intervalTime;
      private LocalDate inspectionDate;
      private Integer patrolsTime;
      private List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS;

      ProjectInspectionTaskRecordDTOBuilder() {
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder intervalTime(final Integer intervalTime) {
         this.intervalTime = intervalTime;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder inspectionDate(final LocalDate inspectionDate) {
         this.inspectionDate = inspectionDate;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder patrolsTime(final Integer patrolsTime) {
         this.patrolsTime = patrolsTime;
         return this;
      }

      public ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder projectInspectionTaskTimeAndAttachmentDTOS(
         final List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS
      ) {
         this.projectInspectionTaskTimeAndAttachmentDTOS = projectInspectionTaskTimeAndAttachmentDTOS;
         return this;
      }

      public ProjectInspectionTaskRecordDTO build() {
         return new ProjectInspectionTaskRecordDTO(
            this.id,
            this.userName,
            this.startTime,
            this.endTime,
            this.intervalTime,
            this.inspectionDate,
            this.patrolsTime,
            this.projectInspectionTaskTimeAndAttachmentDTOS
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionTaskRecordDTO.ProjectInspectionTaskRecordDTOBuilder(id="
            + this.id
            + ", userName="
            + this.userName
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", intervalTime="
            + this.intervalTime
            + ", inspectionDate="
            + this.inspectionDate
            + ", patrolsTime="
            + this.patrolsTime
            + ", projectInspectionTaskTimeAndAttachmentDTOS="
            + this.projectInspectionTaskTimeAndAttachmentDTOS
            + ")";
      }
   }
}
