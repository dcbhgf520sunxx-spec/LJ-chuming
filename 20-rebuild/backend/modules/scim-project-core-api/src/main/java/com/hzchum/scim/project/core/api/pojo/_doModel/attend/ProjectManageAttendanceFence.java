package com.hzchum.scim.project.core.api.pojo._doModel.attend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectManageAttendanceFence对象", description = "")
@Entity
@TableName("project_manage_attendance_fence")
@Table(name = "project_manage_attendance_fence")
@org.hibernate.annotations.Table(appliesTo = "project_manage_attendance_fence")
public class ProjectManageAttendanceFence extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "int(20)  COMMENT '所属项目'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "point", value = "点位", notes = "点位")
   @TableField("point")
   @Column(name = "point", columnDefinition = "varchar(2048)  COMMENT '点位'", nullable = false)
   private String point;
   @ApiModelProperty(name = "sort", value = "序号", notes = "序号")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '序号'", nullable = true)
   private Integer sort;

   public static ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder builder() {
      return new ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder();
   }

   public ProjectManageAttendanceFence() {
   }

   public ProjectManageAttendanceFence(final Long id, final Long projectId, final String point, final Integer sort) {
      this.id = id;
      this.projectId = projectId;
      this.point = point;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getPoint() {
      return this.point;
   }

   public Integer getSort() {
      return this.sort;
   }

   public ProjectManageAttendanceFence setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageAttendanceFence setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectManageAttendanceFence setPoint(final String point) {
      this.point = point;
      return this;
   }

   public ProjectManageAttendanceFence setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceFence(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", point="
         + this.getPoint()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceFence)) {
         return false;
      }

      ProjectManageAttendanceFence other = (ProjectManageAttendanceFence)o;
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
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$point = this.getPoint();
               Object other$point = other.getPoint();
               return this$point == null ? other$point == null : this$point.equals(other$point);
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
      return other instanceof ProjectManageAttendanceFence;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $point = this.getPoint();
      return result * 59 + ($point == null ? 43 : $point.hashCode());
   }

   public static class ProjectManageAttendanceFenceBuilder {
      private Long id;
      private Long projectId;
      private String point;
      private Integer sort;

      ProjectManageAttendanceFenceBuilder() {
      }

      public ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public ProjectManageAttendanceFence build() {
         return new ProjectManageAttendanceFence(this.id, this.projectId, this.point, this.sort);
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceFence.ProjectManageAttendanceFenceBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", point="
            + this.point
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
