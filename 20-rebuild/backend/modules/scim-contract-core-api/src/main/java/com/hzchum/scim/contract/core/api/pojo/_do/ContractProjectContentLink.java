package com.hzchum.scim.contract.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
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

@ApiModel(description = "")
@Entity
@TableName("contract_project_content_link")
@Table(name = "contract_project_content_link")
public class ContractProjectContentLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目内容id")
   @Column(name = "project_content_id", columnDefinition = "bigint(20) COMMENT '项目内容id'")
   private Long projectContentId;
   @ApiModelProperty("项目id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'")
   private Long projectId;

   public static ContractProjectContentLink.ContractProjectContentLinkBuilder builder() {
      return new ContractProjectContentLink.ContractProjectContentLinkBuilder();
   }

   public ContractProjectContentLink() {
   }

   public ContractProjectContentLink(final Long id, final Long projectContentId, final Long projectId) {
      this.id = id;
      this.projectContentId = projectContentId;
      this.projectId = projectId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectContentId() {
      return this.projectContentId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectContentId(final Long projectContentId) {
      this.projectContentId = projectContentId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectContentLink)) {
         return false;
      }

      ContractProjectContentLink other = (ContractProjectContentLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectContentId = this.getProjectContentId();
         Object other$projectContentId = other.getProjectContentId();
         if (this$projectContentId == null ? other$projectContentId == null : this$projectContentId.equals(other$projectContentId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            return this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectContentLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectContentId = this.getProjectContentId();
      result = result * 59 + ($projectContentId == null ? 43 : $projectContentId.hashCode());
      Object $projectId = this.getProjectId();
      return result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectContentLink(id=" + this.getId() + ", projectContentId=" + this.getProjectContentId() + ", projectId=" + this.getProjectId() + ")";
   }

   public static class ContractProjectContentLinkBuilder {
      private Long id;
      private Long projectContentId;
      private Long projectId;

      ContractProjectContentLinkBuilder() {
      }

      public ContractProjectContentLink.ContractProjectContentLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectContentLink.ContractProjectContentLinkBuilder projectContentId(final Long projectContentId) {
         this.projectContentId = projectContentId;
         return this;
      }

      public ContractProjectContentLink.ContractProjectContentLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectContentLink build() {
         return new ContractProjectContentLink(this.id, this.projectContentId, this.projectId);
      }

      @Override
      public String toString() {
         return "ContractProjectContentLink.ContractProjectContentLinkBuilder(id="
            + this.id
            + ", projectContentId="
            + this.projectContentId
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
