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

@ApiModel(value = "ProjectInspectionUserLink对象", description = "巡检线记录表")
@Entity
@TableName("project_inspection_user_link")
@Table(name = "project_inspection_user_link")
@org.hibernate.annotations.Table(appliesTo = "project_inspection_user_link", comment = "巡检线记录表 ")
public class ProjectInspectionUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectInspectionId", value = "巡检点id", notes = "巡检点id")
   @JsonProperty("projectInspectionId")
   @JSONField(name = "projectInspectionId")
   @TableField("project_inspection_id")
   @Column(name = "project_inspection_id", columnDefinition = "int(11)  COMMENT '巡检点id'", nullable = false)
   private Long projectInspectionId;
   @ApiModelProperty(name = "projectInspectionUserId", value = "巡检人员表id", notes = "巡检人员表id")
   @JsonProperty("projectInspectionUserId")
   @JSONField(name = "projectInspectionUserId")
   @TableField("project_inspection_user_id")
   @Column(name = "project_inspection_user_id", columnDefinition = "int(11)  COMMENT '巡检人员表id'")
   private Long projectInspectionUserId;
   @ApiModelProperty(name = "status", value = "巡检点位状态", notes = "巡检点位状态1.开启 0.暂停")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11)  COMMENT '巡检点位状态1.开启 0.暂停'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "sortNumber", value = "排序序号", notes = "排序序号")
   @JsonProperty("sortNumber")
   @JSONField(name = "sortNumber")
   @TableField("sort_number")
   @Column(name = "sort_number", columnDefinition = "int(11)  COMMENT '排序序号'")
   private Integer sortNumber;

   public static ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder builder() {
      return new ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder();
   }

   public ProjectInspectionUserLink() {
   }

   public ProjectInspectionUserLink(
      final Long id, final Long projectInspectionId, final Long projectInspectionUserId, final Integer status, final Integer sortNumber
   ) {
      this.id = id;
      this.projectInspectionId = projectInspectionId;
      this.projectInspectionUserId = projectInspectionUserId;
      this.status = status;
      this.sortNumber = sortNumber;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectInspectionId() {
      return this.projectInspectionId;
   }

   public Long getProjectInspectionUserId() {
      return this.projectInspectionUserId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   @JsonProperty("id")
   public ProjectInspectionUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectInspectionId")
   public ProjectInspectionUserLink setProjectInspectionId(final Long projectInspectionId) {
      this.projectInspectionId = projectInspectionId;
      return this;
   }

   @JsonProperty("projectInspectionUserId")
   public ProjectInspectionUserLink setProjectInspectionUserId(final Long projectInspectionUserId) {
      this.projectInspectionUserId = projectInspectionUserId;
      return this;
   }

   @JsonProperty("status")
   public ProjectInspectionUserLink setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("sortNumber")
   public ProjectInspectionUserLink setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionUserLink(id="
         + this.getId()
         + ", projectInspectionId="
         + this.getProjectInspectionId()
         + ", projectInspectionUserId="
         + this.getProjectInspectionUserId()
         + ", status="
         + this.getStatus()
         + ", sortNumber="
         + this.getSortNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionUserLink)) {
         return false;
      }

      ProjectInspectionUserLink other = (ProjectInspectionUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectInspectionId = this.getProjectInspectionId();
         Object other$projectInspectionId = other.getProjectInspectionId();
         if (this$projectInspectionId == null ? other$projectInspectionId == null : this$projectInspectionId.equals(other$projectInspectionId)) {
            Object this$projectInspectionUserId = this.getProjectInspectionUserId();
            Object other$projectInspectionUserId = other.getProjectInspectionUserId();
            if (this$projectInspectionUserId == null
               ? other$projectInspectionUserId == null
               : this$projectInspectionUserId.equals(other$projectInspectionUserId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$sortNumber = this.getSortNumber();
                  Object other$sortNumber = other.getSortNumber();
                  return this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectInspectionId = this.getProjectInspectionId();
      result = result * 59 + ($projectInspectionId == null ? 43 : $projectInspectionId.hashCode());
      Object $projectInspectionUserId = this.getProjectInspectionUserId();
      result = result * 59 + ($projectInspectionUserId == null ? 43 : $projectInspectionUserId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $sortNumber = this.getSortNumber();
      return result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
   }

   public static class ProjectInspectionUserLinkBuilder {
      private Long id;
      private Long projectInspectionId;
      private Long projectInspectionUserId;
      private Integer status;
      private Integer sortNumber;

      ProjectInspectionUserLinkBuilder() {
      }

      @JsonProperty("id")
      public ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectInspectionId")
      public ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder projectInspectionId(final Long projectInspectionId) {
         this.projectInspectionId = projectInspectionId;
         return this;
      }

      @JsonProperty("projectInspectionUserId")
      public ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder projectInspectionUserId(final Long projectInspectionUserId) {
         this.projectInspectionUserId = projectInspectionUserId;
         return this;
      }

      @JsonProperty("status")
      public ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("sortNumber")
      public ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public ProjectInspectionUserLink build() {
         return new ProjectInspectionUserLink(this.id, this.projectInspectionId, this.projectInspectionUserId, this.status, this.sortNumber);
      }

      @Override
      public String toString() {
         return "ProjectInspectionUserLink.ProjectInspectionUserLinkBuilder(id="
            + this.id
            + ", projectInspectionId="
            + this.projectInspectionId
            + ", projectInspectionUserId="
            + this.projectInspectionUserId
            + ", status="
            + this.status
            + ", sortNumber="
            + this.sortNumber
            + ")";
      }
   }
}
