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

@ApiModel(value = "ProjectPaymentProblemLink对象", description = "付款和质安问题关联表 ")
@Entity
@TableName("project_payment_problem_link")
@Table(name = "project_payment_problem_link")
@org.hibernate.annotations.Table(appliesTo = "project_payment_problem_link", comment = "付款和质安问题关联表 ")
public class ProjectPaymentProblemLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "paymentId", value = "付款表ID", notes = "付款表ID")
   @JsonProperty("paymentId")
   @JSONField(name = "paymentId")
   @TableField("payment_id")
   @Column(name = "payment_id", columnDefinition = "bigint(20)  COMMENT '付款表ID'", nullable = false)
   private Long paymentId;
   @ApiModelProperty(name = "problemId", value = "质安问题表ID", notes = "质安问题表ID")
   @JsonProperty("problemId")
   @JSONField(name = "problemId")
   @TableField("problem_id")
   @Column(name = "problem_id", columnDefinition = "bigint(20)  COMMENT '质安问题表ID'", nullable = false)
   private Long problemId;
   @ApiModelProperty(name = "auditStatus", value = "付款审核状态", notes = "付款审核状态")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '付款审核状态'", nullable = false)
   private Integer auditStatus;

   public static ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder builder() {
      return new ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder();
   }

   public ProjectPaymentProblemLink() {
   }

   public ProjectPaymentProblemLink(final Long id, final Long paymentId, final Long problemId, final Integer auditStatus) {
      this.id = id;
      this.paymentId = paymentId;
      this.problemId = problemId;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaymentId() {
      return this.paymentId;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   @JsonProperty("id")
   public ProjectPaymentProblemLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("paymentId")
   public ProjectPaymentProblemLink setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
      return this;
   }

   @JsonProperty("problemId")
   public ProjectPaymentProblemLink setProblemId(final Long problemId) {
      this.problemId = problemId;
      return this;
   }

   @JsonProperty("auditStatus")
   public ProjectPaymentProblemLink setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectPaymentProblemLink(id="
         + this.getId()
         + ", paymentId="
         + this.getPaymentId()
         + ", problemId="
         + this.getProblemId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPaymentProblemLink)) {
         return false;
      }

      ProjectPaymentProblemLink other = (ProjectPaymentProblemLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentId = this.getPaymentId();
         Object other$paymentId = other.getPaymentId();
         if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
            Object this$problemId = this.getProblemId();
            Object other$problemId = other.getProblemId();
            if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               return this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus);
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
      return other instanceof ProjectPaymentProblemLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      return result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
   }

   public static class ProjectPaymentProblemLinkBuilder {
      private Long id;
      private Long paymentId;
      private Long problemId;
      private Integer auditStatus;

      ProjectPaymentProblemLinkBuilder() {
      }

      @JsonProperty("id")
      public ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("paymentId")
      public ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder paymentId(final Long paymentId) {
         this.paymentId = paymentId;
         return this;
      }

      @JsonProperty("problemId")
      public ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      @JsonProperty("auditStatus")
      public ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectPaymentProblemLink build() {
         return new ProjectPaymentProblemLink(this.id, this.paymentId, this.problemId, this.auditStatus);
      }

      @Override
      public String toString() {
         return "ProjectPaymentProblemLink.ProjectPaymentProblemLinkBuilder(id="
            + this.id
            + ", paymentId="
            + this.paymentId
            + ", problemId="
            + this.problemId
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
