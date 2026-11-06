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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "ProjectUserLink对象", description = "")
@TableName("sys_project_user_link")
@Table(name = "sys_project_user_link")
public class ProjectUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "project_id")
   @JsonProperty("project_id")
   @JSONField(name = "project_id")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "user_id")
   @JsonProperty("user_id")
   @JSONField(name = "user_id")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;

   public static ProjectUserLink.ProjectUserLinkBuilder builder() {
      return new ProjectUserLink.ProjectUserLinkBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public ProjectUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project_id")
   public ProjectUserLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("user_id")
   public ProjectUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectUserLink(id=" + this.getId() + ", projectId=" + this.getProjectId() + ", userId=" + this.getUserId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectUserLink)) {
         return false;
      }

      ProjectUserLink other = (ProjectUserLink)o;
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
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public ProjectUserLink(final Long id, final Long projectId, final Long userId) {
      this.id = id;
      this.projectId = projectId;
      this.userId = userId;
   }

   public ProjectUserLink() {
   }

   public static class ProjectUserLinkBuilder {
      private Long id;
      private Long projectId;
      private Long userId;

      ProjectUserLinkBuilder() {
      }

      @JsonProperty("id")
      public ProjectUserLink.ProjectUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project_id")
      public ProjectUserLink.ProjectUserLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("user_id")
      public ProjectUserLink.ProjectUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectUserLink build() {
         return new ProjectUserLink(this.id, this.projectId, this.userId);
      }

      @Override
      public String toString() {
         return "ProjectUserLink.ProjectUserLinkBuilder(id=" + this.id + ", projectId=" + this.projectId + ", userId=" + this.userId + ")";
      }
   }
}
