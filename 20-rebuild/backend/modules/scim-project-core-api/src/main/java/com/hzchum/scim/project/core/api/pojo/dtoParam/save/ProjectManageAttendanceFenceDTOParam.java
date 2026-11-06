package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectManageAttendanceFenceDTOParam", description = "考勤电子围栏参数")
public class ProjectManageAttendanceFenceDTOParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "points", notes = "电子围栏")
   private List<PointDTOParam> points;

   public static ProjectManageAttendanceFenceDTOParam.ProjectManageAttendanceFenceDTOParamBuilder builder() {
      return new ProjectManageAttendanceFenceDTOParam.ProjectManageAttendanceFenceDTOParamBuilder();
   }

   public ProjectManageAttendanceFenceDTOParam() {
   }

   public ProjectManageAttendanceFenceDTOParam(final Long id, final Long projectId, final List<PointDTOParam> points) {
      this.id = id;
      this.projectId = projectId;
      this.points = points;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<PointDTOParam> getPoints() {
      return this.points;
   }

   public ProjectManageAttendanceFenceDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageAttendanceFenceDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectManageAttendanceFenceDTOParam setPoints(final List<PointDTOParam> points) {
      this.points = points;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceFenceDTOParam)) {
         return false;
      }

      ProjectManageAttendanceFenceDTOParam other = (ProjectManageAttendanceFenceDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$points = this.getPoints();
            Object other$points = other.getPoints();
            return this$points == null ? other$points == null : this$points.equals(other$points);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManageAttendanceFenceDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $points = this.getPoints();
      return result * 59 + ($points == null ? 43 : $points.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceFenceDTOParam(id=" + this.getId() + ", projectId=" + this.getProjectId() + ", points=" + this.getPoints() + ")";
   }

   public static class ProjectManageAttendanceFenceDTOParamBuilder {
      private Long id;
      private Long projectId;
      private List<PointDTOParam> points;

      ProjectManageAttendanceFenceDTOParamBuilder() {
      }

      public ProjectManageAttendanceFenceDTOParam.ProjectManageAttendanceFenceDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageAttendanceFenceDTOParam.ProjectManageAttendanceFenceDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageAttendanceFenceDTOParam.ProjectManageAttendanceFenceDTOParamBuilder points(final List<PointDTOParam> points) {
         this.points = points;
         return this;
      }

      public ProjectManageAttendanceFenceDTOParam build() {
         return new ProjectManageAttendanceFenceDTOParam(this.id, this.projectId, this.points);
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceFenceDTOParam.ProjectManageAttendanceFenceDTOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", points="
            + this.points
            + ")";
      }
   }
}
