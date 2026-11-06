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

@ApiModel(value = "MonomerUserLink对象", description = "单体深化负责人表")
@Entity
@TableName("sys_monomer_user_link")
@Table(name = "sys_monomer_user_link")
public class MonomerUserLink extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "名称")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "deepenedPersonId", notes = "深化人id")
   @TableField("deepened_person_id")
   @Column(name = "deepened_person_id", columnDefinition = "bigint(20) comment '深化人id'", nullable = false)
   private Long deepenedPersonId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) comment '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "createUserId", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) comment '创建人ID'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "deepenedPersonName", notes = "深化人名字")
   @TableField("deepened_person_name")
   @Column(name = "deepened_person_name", columnDefinition = "varchar(255) comment '深化人名字'", nullable = false)
   private String deepenedPersonName;

   public static MonomerUserLink.MonomerUserLinkBuilder builder() {
      return new MonomerUserLink.MonomerUserLinkBuilder();
   }

   public MonomerUserLink() {
   }

   public MonomerUserLink(
      final Long id, final Long projectId, final Long deepenedPersonId, final Long monomerId, final Long createUserId, final String deepenedPersonName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.deepenedPersonId = deepenedPersonId;
      this.monomerId = monomerId;
      this.createUserId = createUserId;
      this.deepenedPersonName = deepenedPersonName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getDeepenedPersonId() {
      return this.deepenedPersonId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getDeepenedPersonName() {
      return this.deepenedPersonName;
   }

   @JsonProperty("id")
   public MonomerUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MonomerUserLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MonomerUserLink setDeepenedPersonId(final Long deepenedPersonId) {
      this.deepenedPersonId = deepenedPersonId;
      return this;
   }

   public MonomerUserLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MonomerUserLink setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public MonomerUserLink setDeepenedPersonName(final String deepenedPersonName) {
      this.deepenedPersonName = deepenedPersonName;
      return this;
   }

   @Override
   public String toString() {
      return "MonomerUserLink(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", deepenedPersonId="
         + this.getDeepenedPersonId()
         + ", monomerId="
         + this.getMonomerId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", deepenedPersonName="
         + this.getDeepenedPersonName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerUserLink)) {
         return false;
      }

      MonomerUserLink other = (MonomerUserLink)o;
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
            Object this$deepenedPersonId = this.getDeepenedPersonId();
            Object other$deepenedPersonId = other.getDeepenedPersonId();
            if (this$deepenedPersonId == null ? other$deepenedPersonId == null : this$deepenedPersonId.equals(other$deepenedPersonId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$deepenedPersonName = this.getDeepenedPersonName();
                     Object other$deepenedPersonName = other.getDeepenedPersonName();
                     return this$deepenedPersonName == null ? other$deepenedPersonName == null : this$deepenedPersonName.equals(other$deepenedPersonName);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MonomerUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $deepenedPersonId = this.getDeepenedPersonId();
      result = result * 59 + ($deepenedPersonId == null ? 43 : $deepenedPersonId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $deepenedPersonName = this.getDeepenedPersonName();
      return result * 59 + ($deepenedPersonName == null ? 43 : $deepenedPersonName.hashCode());
   }

   public static class MonomerUserLinkBuilder {
      private Long id;
      private Long projectId;
      private Long deepenedPersonId;
      private Long monomerId;
      private Long createUserId;
      private String deepenedPersonName;

      MonomerUserLinkBuilder() {
      }

      @JsonProperty("id")
      public MonomerUserLink.MonomerUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MonomerUserLink.MonomerUserLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MonomerUserLink.MonomerUserLinkBuilder deepenedPersonId(final Long deepenedPersonId) {
         this.deepenedPersonId = deepenedPersonId;
         return this;
      }

      public MonomerUserLink.MonomerUserLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MonomerUserLink.MonomerUserLinkBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MonomerUserLink.MonomerUserLinkBuilder deepenedPersonName(final String deepenedPersonName) {
         this.deepenedPersonName = deepenedPersonName;
         return this;
      }

      public MonomerUserLink build() {
         return new MonomerUserLink(this.id, this.projectId, this.deepenedPersonId, this.monomerId, this.createUserId, this.deepenedPersonName);
      }

      @Override
      public String toString() {
         return "MonomerUserLink.MonomerUserLinkBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", deepenedPersonId="
            + this.deepenedPersonId
            + ", monomerId="
            + this.monomerId
            + ", createUserId="
            + this.createUserId
            + ", deepenedPersonName="
            + this.deepenedPersonName
            + ")";
      }
   }
}
