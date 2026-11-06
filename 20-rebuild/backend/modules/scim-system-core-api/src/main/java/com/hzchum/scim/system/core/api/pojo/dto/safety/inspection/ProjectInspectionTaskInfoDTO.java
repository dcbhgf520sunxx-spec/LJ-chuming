package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("巡检记录DTO")
public class ProjectInspectionTaskInfoDTO {
   @ApiModelProperty(name = "id", notes = "巡检人员表id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "巡检人员名字")
   private String name;
   @ApiModelProperty(name = "inspectionTime", notes = "巡检扫码日期")
   private LocalDateTime inspectionTime;
   @ApiModelProperty(name = "inspectionDate", notes = "巡检日期")
   private LocalDate inspectionDate;
   @ApiModelProperty(name = "avoidTime", value = "避开时间", notes = "避开时间 参考枚举参考枚举AvoidTimeEnum 1.周六 2.周日 3.周六日 ")
   private Integer avoidTime;
   @ApiModelProperty(name = "completeState", notes = "完成状态 1.正常完成 2.非正常完成 3.缺勤")
   private Integer completeState;
   @ApiModelProperty(name = "projectInspectionCount", notes = "巡检点位数量")
   private Integer projectInspectionCount;
   @ApiModelProperty(name = "totalInspect", notes = "需巡检")
   private Integer totalInspect;
   @ApiModelProperty(name = "inspected", notes = "已巡")
   private Integer inspected;
   @ApiModelProperty(name = "notInspected", notes = "未巡")
   private Integer notInspected;
   @ApiModelProperty(name = "hazardCount", notes = "隐患数")
   private Integer hazardCount;
   @ApiModelProperty(name = "projectInspectionDTOS", notes = "巡检点信息")
   private List<ProjectInspectionDTO> projectInspectionDTOS;

   public static ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder builder() {
      return new ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder();
   }

   public ProjectInspectionTaskInfoDTO() {
   }

   public ProjectInspectionTaskInfoDTO(
      final Long id,
      final String name,
      final LocalDateTime inspectionTime,
      final LocalDate inspectionDate,
      final Integer avoidTime,
      final Integer completeState,
      final Integer projectInspectionCount,
      final Integer totalInspect,
      final Integer inspected,
      final Integer notInspected,
      final Integer hazardCount,
      final List<ProjectInspectionDTO> projectInspectionDTOS
   ) {
      this.id = id;
      this.name = name;
      this.inspectionTime = inspectionTime;
      this.inspectionDate = inspectionDate;
      this.avoidTime = avoidTime;
      this.completeState = completeState;
      this.projectInspectionCount = projectInspectionCount;
      this.totalInspect = totalInspect;
      this.inspected = inspected;
      this.notInspected = notInspected;
      this.hazardCount = hazardCount;
      this.projectInspectionDTOS = projectInspectionDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDateTime getInspectionTime() {
      return this.inspectionTime;
   }

   public LocalDate getInspectionDate() {
      return this.inspectionDate;
   }

   public Integer getAvoidTime() {
      return this.avoidTime;
   }

   public Integer getCompleteState() {
      return this.completeState;
   }

   public Integer getProjectInspectionCount() {
      return this.projectInspectionCount;
   }

   public Integer getTotalInspect() {
      return this.totalInspect;
   }

   public Integer getInspected() {
      return this.inspected;
   }

   public Integer getNotInspected() {
      return this.notInspected;
   }

   public Integer getHazardCount() {
      return this.hazardCount;
   }

   public List<ProjectInspectionDTO> getProjectInspectionDTOS() {
      return this.projectInspectionDTOS;
   }

   public ProjectInspectionTaskInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setInspectionTime(final LocalDateTime inspectionTime) {
      this.inspectionTime = inspectionTime;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setInspectionDate(final LocalDate inspectionDate) {
      this.inspectionDate = inspectionDate;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setAvoidTime(final Integer avoidTime) {
      this.avoidTime = avoidTime;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setCompleteState(final Integer completeState) {
      this.completeState = completeState;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setProjectInspectionCount(final Integer projectInspectionCount) {
      this.projectInspectionCount = projectInspectionCount;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setTotalInspect(final Integer totalInspect) {
      this.totalInspect = totalInspect;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setInspected(final Integer inspected) {
      this.inspected = inspected;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setNotInspected(final Integer notInspected) {
      this.notInspected = notInspected;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setHazardCount(final Integer hazardCount) {
      this.hazardCount = hazardCount;
      return this;
   }

   public ProjectInspectionTaskInfoDTO setProjectInspectionDTOS(final List<ProjectInspectionDTO> projectInspectionDTOS) {
      this.projectInspectionDTOS = projectInspectionDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionTaskInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", inspectionTime="
         + this.getInspectionTime()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", avoidTime="
         + this.getAvoidTime()
         + ", completeState="
         + this.getCompleteState()
         + ", projectInspectionCount="
         + this.getProjectInspectionCount()
         + ", totalInspect="
         + this.getTotalInspect()
         + ", inspected="
         + this.getInspected()
         + ", notInspected="
         + this.getNotInspected()
         + ", hazardCount="
         + this.getHazardCount()
         + ", projectInspectionDTOS="
         + this.getProjectInspectionDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionTaskInfoDTO)) {
         return false;
      }

      ProjectInspectionTaskInfoDTO other = (ProjectInspectionTaskInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$avoidTime = this.getAvoidTime();
         Object other$avoidTime = other.getAvoidTime();
         if (this$avoidTime == null ? other$avoidTime == null : this$avoidTime.equals(other$avoidTime)) {
            Object this$completeState = this.getCompleteState();
            Object other$completeState = other.getCompleteState();
            if (this$completeState == null ? other$completeState == null : this$completeState.equals(other$completeState)) {
               Object this$projectInspectionCount = this.getProjectInspectionCount();
               Object other$projectInspectionCount = other.getProjectInspectionCount();
               if (this$projectInspectionCount == null
                  ? other$projectInspectionCount == null
                  : this$projectInspectionCount.equals(other$projectInspectionCount)) {
                  Object this$totalInspect = this.getTotalInspect();
                  Object other$totalInspect = other.getTotalInspect();
                  if (this$totalInspect == null ? other$totalInspect == null : this$totalInspect.equals(other$totalInspect)) {
                     Object this$inspected = this.getInspected();
                     Object other$inspected = other.getInspected();
                     if (this$inspected == null ? other$inspected == null : this$inspected.equals(other$inspected)) {
                        Object this$notInspected = this.getNotInspected();
                        Object other$notInspected = other.getNotInspected();
                        if (this$notInspected == null ? other$notInspected == null : this$notInspected.equals(other$notInspected)) {
                           Object this$hazardCount = this.getHazardCount();
                           Object other$hazardCount = other.getHazardCount();
                           if (this$hazardCount == null ? other$hazardCount == null : this$hazardCount.equals(other$hazardCount)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$inspectionTime = this.getInspectionTime();
                                 Object other$inspectionTime = other.getInspectionTime();
                                 if (this$inspectionTime == null ? other$inspectionTime == null : this$inspectionTime.equals(other$inspectionTime)) {
                                    Object this$inspectionDate = this.getInspectionDate();
                                    Object other$inspectionDate = other.getInspectionDate();
                                    if (this$inspectionDate == null ? other$inspectionDate == null : this$inspectionDate.equals(other$inspectionDate)) {
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
      return other instanceof ProjectInspectionTaskInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $avoidTime = this.getAvoidTime();
      result = result * 59 + ($avoidTime == null ? 43 : $avoidTime.hashCode());
      Object $completeState = this.getCompleteState();
      result = result * 59 + ($completeState == null ? 43 : $completeState.hashCode());
      Object $projectInspectionCount = this.getProjectInspectionCount();
      result = result * 59 + ($projectInspectionCount == null ? 43 : $projectInspectionCount.hashCode());
      Object $totalInspect = this.getTotalInspect();
      result = result * 59 + ($totalInspect == null ? 43 : $totalInspect.hashCode());
      Object $inspected = this.getInspected();
      result = result * 59 + ($inspected == null ? 43 : $inspected.hashCode());
      Object $notInspected = this.getNotInspected();
      result = result * 59 + ($notInspected == null ? 43 : $notInspected.hashCode());
      Object $hazardCount = this.getHazardCount();
      result = result * 59 + ($hazardCount == null ? 43 : $hazardCount.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $inspectionTime = this.getInspectionTime();
      result = result * 59 + ($inspectionTime == null ? 43 : $inspectionTime.hashCode());
      Object $inspectionDate = this.getInspectionDate();
      result = result * 59 + ($inspectionDate == null ? 43 : $inspectionDate.hashCode());
      Object $projectInspectionDTOS = this.getProjectInspectionDTOS();
      return result * 59 + ($projectInspectionDTOS == null ? 43 : $projectInspectionDTOS.hashCode());
   }

   public static class ProjectInspectionTaskInfoDTOBuilder {
      private Long id;
      private String name;
      private LocalDateTime inspectionTime;
      private LocalDate inspectionDate;
      private Integer avoidTime;
      private Integer completeState;
      private Integer projectInspectionCount;
      private Integer totalInspect;
      private Integer inspected;
      private Integer notInspected;
      private Integer hazardCount;
      private List<ProjectInspectionDTO> projectInspectionDTOS;

      ProjectInspectionTaskInfoDTOBuilder() {
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder inspectionTime(final LocalDateTime inspectionTime) {
         this.inspectionTime = inspectionTime;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder inspectionDate(final LocalDate inspectionDate) {
         this.inspectionDate = inspectionDate;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder avoidTime(final Integer avoidTime) {
         this.avoidTime = avoidTime;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder completeState(final Integer completeState) {
         this.completeState = completeState;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder projectInspectionCount(final Integer projectInspectionCount) {
         this.projectInspectionCount = projectInspectionCount;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder totalInspect(final Integer totalInspect) {
         this.totalInspect = totalInspect;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder inspected(final Integer inspected) {
         this.inspected = inspected;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder notInspected(final Integer notInspected) {
         this.notInspected = notInspected;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder hazardCount(final Integer hazardCount) {
         this.hazardCount = hazardCount;
         return this;
      }

      public ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder projectInspectionDTOS(final List<ProjectInspectionDTO> projectInspectionDTOS) {
         this.projectInspectionDTOS = projectInspectionDTOS;
         return this;
      }

      public ProjectInspectionTaskInfoDTO build() {
         return new ProjectInspectionTaskInfoDTO(
            this.id,
            this.name,
            this.inspectionTime,
            this.inspectionDate,
            this.avoidTime,
            this.completeState,
            this.projectInspectionCount,
            this.totalInspect,
            this.inspected,
            this.notInspected,
            this.hazardCount,
            this.projectInspectionDTOS
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionTaskInfoDTO.ProjectInspectionTaskInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", inspectionTime="
            + this.inspectionTime
            + ", inspectionDate="
            + this.inspectionDate
            + ", avoidTime="
            + this.avoidTime
            + ", completeState="
            + this.completeState
            + ", projectInspectionCount="
            + this.projectInspectionCount
            + ", totalInspect="
            + this.totalInspect
            + ", inspected="
            + this.inspected
            + ", notInspected="
            + this.notInspected
            + ", hazardCount="
            + this.hazardCount
            + ", projectInspectionDTOS="
            + this.projectInspectionDTOS
            + ")";
      }
   }
}
