package com.hzchum.scim.contract.core.api.pojo._do;

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
@ApiModel(value = "ProjectBranchCompanyLink对象", description = "项目分支机构关联表")
@TableName("project_branch_company_link")
@Table(name = "project_branch_company_link")
@org.hibernate.annotations.Table(appliesTo = "project_branch_company_link", comment = "项目分支机构关联表")
public class ProjectBranchCompanyLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "branchCompanyId")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20) default 2 COMMENT '分支机构ID'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) default 2 COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyLevel")
   @TableField("branch_company_level")
   @Column(name = "branch_company_level", columnDefinition = "int COMMENT '分支机构层级 一级单位 二级单位'", nullable = false)
   private Integer branchCompanyLevel;

   public static ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder builder() {
      return new ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder();
   }

   public ProjectBranchCompanyLink() {
   }

   public ProjectBranchCompanyLink(final Long id, final Long branchCompanyId, final Long projectId, final Integer branchCompanyLevel) {
      this.id = id;
      this.branchCompanyId = branchCompanyId;
      this.projectId = projectId;
      this.branchCompanyLevel = branchCompanyLevel;
   }

   public Long getId() {
      return this.id;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBranchCompanyLevel() {
      return this.branchCompanyLevel;
   }

   @JsonProperty("id")
   public ProjectBranchCompanyLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectBranchCompanyLink setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ProjectBranchCompanyLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectBranchCompanyLink setBranchCompanyLevel(final Integer branchCompanyLevel) {
      this.branchCompanyLevel = branchCompanyLevel;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectBranchCompanyLink(id="
         + this.getId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyLevel="
         + this.getBranchCompanyLevel()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBranchCompanyLink)) {
         return false;
      }

      ProjectBranchCompanyLink other = (ProjectBranchCompanyLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$branchCompanyLevel = this.getBranchCompanyLevel();
               Object other$branchCompanyLevel = other.getBranchCompanyLevel();
               return this$branchCompanyLevel == null ? other$branchCompanyLevel == null : this$branchCompanyLevel.equals(other$branchCompanyLevel);
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
      return other instanceof ProjectBranchCompanyLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyLevel = this.getBranchCompanyLevel();
      return result * 59 + ($branchCompanyLevel == null ? 43 : $branchCompanyLevel.hashCode());
   }

   public static class ProjectBranchCompanyLinkBuilder {
      private Long id;
      private Long branchCompanyId;
      private Long projectId;
      private Integer branchCompanyLevel;

      ProjectBranchCompanyLinkBuilder() {
      }

      @JsonProperty("id")
      public ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder branchCompanyLevel(final Integer branchCompanyLevel) {
         this.branchCompanyLevel = branchCompanyLevel;
         return this;
      }

      public ProjectBranchCompanyLink build() {
         return new ProjectBranchCompanyLink(this.id, this.branchCompanyId, this.projectId, this.branchCompanyLevel);
      }

      @Override
      public String toString() {
         return "ProjectBranchCompanyLink.ProjectBranchCompanyLinkBuilder(id="
            + this.id
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", projectId="
            + this.projectId
            + ", branchCompanyLevel="
            + this.branchCompanyLevel
            + ")";
      }
   }
}
