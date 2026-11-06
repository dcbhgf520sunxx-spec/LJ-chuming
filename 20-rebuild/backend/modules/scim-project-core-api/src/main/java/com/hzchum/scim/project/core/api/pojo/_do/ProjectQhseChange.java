package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "ProjectQhseChange对象", description = "质安问题整改表 ")
@Entity
@TableName("project_qhse_change")
@Table(name = "project_qhse_change")
@org.hibernate.annotations.Table(appliesTo = "project_qhse_change", comment = "质安问题整改表 ")
public class ProjectQhseChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "problemId", value = "质安问题表id", notes = "质安问题表id")
   @JsonProperty("problemId")
   @JSONField(name = "problemId")
   @TableField("problem_id")
   @Column(name = "problem_id", columnDefinition = "bigint(20)  COMMENT '质安问题表id'", nullable = false)
   private Long problemId;
   @ApiModelProperty(name = "problemDesc", value = "问题描述", notes = "问题描述")
   @JsonProperty("problemDesc")
   @JSONField(name = "problemDesc")
   @TableField("problem_desc")
   @Column(name = "problem_desc", columnDefinition = "varchar(2048)  COMMENT '问题描述'")
   private String problemDesc;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改后图片", notes = "整改后图片")
   @JsonProperty("afterChangeImgs")
   @JSONField(name = "afterChangeImgs")
   @TableField("after_change_imgs")
   @Column(name = "after_change_imgs", columnDefinition = "varchar(2048)  COMMENT '整改后图片'")
   private String afterChangeImgs;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核2通过4驳回", notes = "审核状态 1未审核2通过4驳回")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '审核状态 1未审核2通过4驳回'", nullable = false)
   private Integer auditStatus;

   public static ProjectQhseChange.ProjectQhseChangeBuilder builder() {
      return new ProjectQhseChange.ProjectQhseChangeBuilder();
   }

   public ProjectQhseChange() {
   }

   public ProjectQhseChange(final Long id, final Long problemId, final String problemDesc, final String afterChangeImgs, final Integer auditStatus) {
      this.id = id;
      this.problemId = problemId;
      this.problemDesc = problemDesc;
      this.afterChangeImgs = afterChangeImgs;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public String getAfterChangeImgs() {
      return this.afterChangeImgs;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   @JsonProperty("id")
   public ProjectQhseChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("problemId")
   public ProjectQhseChange setProblemId(final Long problemId) {
      this.problemId = problemId;
      return this;
   }

   @JsonProperty("problemDesc")
   public ProjectQhseChange setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
      return this;
   }

   @JsonProperty("afterChangeImgs")
   public ProjectQhseChange setAfterChangeImgs(final String afterChangeImgs) {
      this.afterChangeImgs = afterChangeImgs;
      return this;
   }

   @JsonProperty("auditStatus")
   public ProjectQhseChange setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectQhseChange(id="
         + this.getId()
         + ", problemId="
         + this.getProblemId()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", afterChangeImgs="
         + this.getAfterChangeImgs()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseChange)) {
         return false;
      }

      ProjectQhseChange other = (ProjectQhseChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$problemId = this.getProblemId();
         Object other$problemId = other.getProblemId();
         if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
            Object this$auditStatus = this.getAuditStatus();
            Object other$auditStatus = other.getAuditStatus();
            if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
               Object this$problemDesc = this.getProblemDesc();
               Object other$problemDesc = other.getProblemDesc();
               if (this$problemDesc == null ? other$problemDesc == null : this$problemDesc.equals(other$problemDesc)) {
                  Object this$afterChangeImgs = this.getAfterChangeImgs();
                  Object other$afterChangeImgs = other.getAfterChangeImgs();
                  return this$afterChangeImgs == null ? other$afterChangeImgs == null : this$afterChangeImgs.equals(other$afterChangeImgs);
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
      return other instanceof ProjectQhseChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $afterChangeImgs = this.getAfterChangeImgs();
      return result * 59 + ($afterChangeImgs == null ? 43 : $afterChangeImgs.hashCode());
   }

   public static class ProjectQhseChangeBuilder {
      private Long id;
      private Long problemId;
      private String problemDesc;
      private String afterChangeImgs;
      private Integer auditStatus;

      ProjectQhseChangeBuilder() {
      }

      @JsonProperty("id")
      public ProjectQhseChange.ProjectQhseChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("problemId")
      public ProjectQhseChange.ProjectQhseChangeBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      @JsonProperty("problemDesc")
      public ProjectQhseChange.ProjectQhseChangeBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      @JsonProperty("afterChangeImgs")
      public ProjectQhseChange.ProjectQhseChangeBuilder afterChangeImgs(final String afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      @JsonProperty("auditStatus")
      public ProjectQhseChange.ProjectQhseChangeBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectQhseChange build() {
         return new ProjectQhseChange(this.id, this.problemId, this.problemDesc, this.afterChangeImgs, this.auditStatus);
      }

      @Override
      public String toString() {
         return "ProjectQhseChange.ProjectQhseChangeBuilder(id="
            + this.id
            + ", problemId="
            + this.problemId
            + ", problemDesc="
            + this.problemDesc
            + ", afterChangeImgs="
            + this.afterChangeImgs
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
