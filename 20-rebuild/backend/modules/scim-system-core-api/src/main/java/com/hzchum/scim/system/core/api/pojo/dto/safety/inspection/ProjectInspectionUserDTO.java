package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("巡检线人员DTO")
public class ProjectInspectionUserDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "巡检人员id", notes = "巡检人员id")
   private Long userId;
   @ApiModelProperty(name = "userName", notes = "巡检人员名字")
   private String userName;
   @ApiModelProperty(name = "inspectionList", notes = "巡检点列表")
   private List<ProjectInspectionDTO> inspectionList;
   @ApiModelProperty(name = "patrolsTime", value = "巡检次数", notes = "巡检次数")
   private Integer patrolsTime;
   @ApiModelProperty(name = "avoidTime", value = "避开时间", notes = "避开时间 参考枚举参考枚举AvoidTimeEnum 1.周六 2.周日 3.周六日 ")
   private Integer avoidTime;
   @ApiModelProperty(name = "startTime", value = "巡检开始时间", notes = "巡检开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "巡检结束时间", notes = "巡检结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "status", value = "线路状态", notes = "线路状态")
   private Boolean status;
   @ApiModelProperty(name = "isSort", notes = "是否需要排序 1.需要排序  0.不需要")
   private Integer isSort;
   @ApiModelProperty(name = "intervalTime", notes = "扫码间隔时间(单位分钟 默认一分钟)")
   private Integer intervalTime;
   @ApiModelProperty(name = "mandatoryInspection", value = "是否强制巡检")
   private boolean mandatoryInspection;

   public static ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder builder() {
      return new ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder();
   }

   public ProjectInspectionUserDTO() {
   }

   public ProjectInspectionUserDTO(
      final Long id,
      final Long userId,
      final String userName,
      final List<ProjectInspectionDTO> inspectionList,
      final Integer patrolsTime,
      final Integer avoidTime,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Boolean status,
      final Integer isSort,
      final Integer intervalTime,
      final boolean mandatoryInspection
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.inspectionList = inspectionList;
      this.patrolsTime = patrolsTime;
      this.avoidTime = avoidTime;
      this.startTime = startTime;
      this.endTime = endTime;
      this.status = status;
      this.isSort = isSort;
      this.intervalTime = intervalTime;
      this.mandatoryInspection = mandatoryInspection;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<ProjectInspectionDTO> getInspectionList() {
      return this.inspectionList;
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

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getIsSort() {
      return this.isSort;
   }

   public Integer getIntervalTime() {
      return this.intervalTime;
   }

   public boolean isMandatoryInspection() {
      return this.mandatoryInspection;
   }

   public ProjectInspectionUserDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionUserDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectInspectionUserDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectInspectionUserDTO setInspectionList(final List<ProjectInspectionDTO> inspectionList) {
      this.inspectionList = inspectionList;
      return this;
   }

   public ProjectInspectionUserDTO setPatrolsTime(final Integer patrolsTime) {
      this.patrolsTime = patrolsTime;
      return this;
   }

   public ProjectInspectionUserDTO setAvoidTime(final Integer avoidTime) {
      this.avoidTime = avoidTime;
      return this;
   }

   public ProjectInspectionUserDTO setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public ProjectInspectionUserDTO setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public ProjectInspectionUserDTO setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public ProjectInspectionUserDTO setIsSort(final Integer isSort) {
      this.isSort = isSort;
      return this;
   }

   public ProjectInspectionUserDTO setIntervalTime(final Integer intervalTime) {
      this.intervalTime = intervalTime;
      return this;
   }

   public ProjectInspectionUserDTO setMandatoryInspection(final boolean mandatoryInspection) {
      this.mandatoryInspection = mandatoryInspection;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionUserDTO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", inspectionList="
         + this.getInspectionList()
         + ", patrolsTime="
         + this.getPatrolsTime()
         + ", avoidTime="
         + this.getAvoidTime()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", status="
         + this.getStatus()
         + ", isSort="
         + this.getIsSort()
         + ", intervalTime="
         + this.getIntervalTime()
         + ", mandatoryInspection="
         + this.isMandatoryInspection()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionUserDTO)) {
         return false;
      }

      ProjectInspectionUserDTO other = (ProjectInspectionUserDTO)o;
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
               Object this$avoidTime = this.getAvoidTime();
               Object other$avoidTime = other.getAvoidTime();
               if (this$avoidTime == null ? other$avoidTime == null : this$avoidTime.equals(other$avoidTime)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$isSort = this.getIsSort();
                     Object other$isSort = other.getIsSort();
                     if (this$isSort == null ? other$isSort == null : this$isSort.equals(other$isSort)) {
                        Object this$intervalTime = this.getIntervalTime();
                        Object other$intervalTime = other.getIntervalTime();
                        if (this$intervalTime == null ? other$intervalTime == null : this$intervalTime.equals(other$intervalTime)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                              Object this$inspectionList = this.getInspectionList();
                              Object other$inspectionList = other.getInspectionList();
                              if (this$inspectionList == null ? other$inspectionList == null : this$inspectionList.equals(other$inspectionList)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionUserDTO;
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
      Object $avoidTime = this.getAvoidTime();
      result = result * 59 + ($avoidTime == null ? 43 : $avoidTime.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $isSort = this.getIsSort();
      result = result * 59 + ($isSort == null ? 43 : $isSort.hashCode());
      Object $intervalTime = this.getIntervalTime();
      result = result * 59 + ($intervalTime == null ? 43 : $intervalTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $inspectionList = this.getInspectionList();
      result = result * 59 + ($inspectionList == null ? 43 : $inspectionList.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   public static class ProjectInspectionUserDTOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private List<ProjectInspectionDTO> inspectionList;
      private Integer patrolsTime;
      private Integer avoidTime;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Boolean status;
      private Integer isSort;
      private Integer intervalTime;
      private boolean mandatoryInspection;

      ProjectInspectionUserDTOBuilder() {
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder inspectionList(final List<ProjectInspectionDTO> inspectionList) {
         this.inspectionList = inspectionList;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder patrolsTime(final Integer patrolsTime) {
         this.patrolsTime = patrolsTime;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder avoidTime(final Integer avoidTime) {
         this.avoidTime = avoidTime;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder isSort(final Integer isSort) {
         this.isSort = isSort;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder intervalTime(final Integer intervalTime) {
         this.intervalTime = intervalTime;
         return this;
      }

      public ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder mandatoryInspection(final boolean mandatoryInspection) {
         this.mandatoryInspection = mandatoryInspection;
         return this;
      }

      public ProjectInspectionUserDTO build() {
         return new ProjectInspectionUserDTO(
            this.id,
            this.userId,
            this.userName,
            this.inspectionList,
            this.patrolsTime,
            this.avoidTime,
            this.startTime,
            this.endTime,
            this.status,
            this.isSort,
            this.intervalTime,
            this.mandatoryInspection
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionUserDTO.ProjectInspectionUserDTOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", inspectionList="
            + this.inspectionList
            + ", patrolsTime="
            + this.patrolsTime
            + ", avoidTime="
            + this.avoidTime
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", status="
            + this.status
            + ", isSort="
            + this.isSort
            + ", intervalTime="
            + this.intervalTime
            + ", mandatoryInspection="
            + this.mandatoryInspection
            + ")";
      }
   }
}
