package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class MesBuildingPaintTechnologyQueryParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名", notes = "项目名")
   private String projectName;
   @ApiModelProperty(name = "startTime", value = "开始时间", notes = "开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "结束时间", notes = "结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "paintCalculateStatus", value = "油漆计算状态: 1未计算 2部分计算 4全部计算", notes = "油漆计算状态: 1未计算 2部分计算 4全部计算")
   private Integer paintCalculateStatus;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Integer getPaintCalculateStatus() {
      return this.paintCalculateStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setPaintCalculateStatus(final Integer paintCalculateStatus) {
      this.paintCalculateStatus = paintCalculateStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintTechnologyQueryParam)) {
         return false;
      }

      MesBuildingPaintTechnologyQueryParam other = (MesBuildingPaintTechnologyQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$paintCalculateStatus = this.getPaintCalculateStatus();
         Object other$paintCalculateStatus = other.getPaintCalculateStatus();
         if (this$paintCalculateStatus == null ? other$paintCalculateStatus == null : this$paintCalculateStatus.equals(other$paintCalculateStatus)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPaintTechnologyQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $paintCalculateStatus = this.getPaintCalculateStatus();
      result = result * 59 + ($paintCalculateStatus == null ? 43 : $paintCalculateStatus.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPaintTechnologyQueryParam(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", paintCalculateStatus="
         + this.getPaintCalculateStatus()
         + ")";
   }
}
