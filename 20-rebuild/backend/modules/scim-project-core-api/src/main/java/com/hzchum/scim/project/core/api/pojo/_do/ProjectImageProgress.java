package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "ProjectImageProgress对象", description = "形象进度 ")
@Entity
@TableName("project_image_progress")
@Table(name = "project_image_progress")
public class ProjectImageProgress extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "attachmentId", value = "附件id")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20) comment '附件id'", nullable = false)
   private Long attachmentId;

   public static ProjectImageProgress.ProjectImageProgressBuilder builder() {
      return new ProjectImageProgress.ProjectImageProgressBuilder();
   }

   public ProjectImageProgress() {
   }

   public ProjectImageProgress(final Long id, final Long projectId, final Long attachmentId) {
      this.id = id;
      this.projectId = projectId;
      this.attachmentId = attachmentId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public ProjectImageProgress setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectImageProgress setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectImageProgress setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectImageProgress(id=" + this.getId() + ", projectId=" + this.getProjectId() + ", attachmentId=" + this.getAttachmentId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectImageProgress)) {
         return false;
      }

      ProjectImageProgress other = (ProjectImageProgress)o;
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
            Object this$attachmentId = this.getAttachmentId();
            Object other$attachmentId = other.getAttachmentId();
            return this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectImageProgress;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   public static class ProjectImageProgressBuilder {
      private Long id;
      private Long projectId;
      private Long attachmentId;

      ProjectImageProgressBuilder() {
      }

      public ProjectImageProgress.ProjectImageProgressBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectImageProgress.ProjectImageProgressBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectImageProgress.ProjectImageProgressBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectImageProgress build() {
         return new ProjectImageProgress(this.id, this.projectId, this.attachmentId);
      }

      @Override
      public String toString() {
         return "ProjectImageProgress.ProjectImageProgressBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", attachmentId="
            + this.attachmentId
            + ")";
      }
   }
}
