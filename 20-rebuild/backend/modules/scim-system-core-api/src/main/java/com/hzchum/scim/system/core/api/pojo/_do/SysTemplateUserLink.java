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

@ApiModel(value = "SysTemplateUserLink对象", description = "")
@Entity
@TableName("sys_template_user_link")
@Table(name = "sys_template_user_link")
public class SysTemplateUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "templateId")
   @JsonProperty("templateId")
   @JSONField(name = "templateId")
   @TableField("template_id")
   @Column(name = "template_id")
   private Long templateId;
   @ApiModelProperty(name = "userId")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;

   public static SysTemplateUserLink.SysTemplateUserLinkBuilder builder() {
      return new SysTemplateUserLink.SysTemplateUserLinkBuilder();
   }

   public SysTemplateUserLink() {
   }

   public SysTemplateUserLink(final Long id, final Long templateId, final Long userId) {
      this.id = id;
      this.templateId = templateId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTemplateId() {
      return this.templateId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public SysTemplateUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("templateId")
   public SysTemplateUserLink setTemplateId(final Long templateId) {
      this.templateId = templateId;
      return this;
   }

   @JsonProperty("userId")
   public SysTemplateUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "SysTemplateUserLink(id=" + this.getId() + ", templateId=" + this.getTemplateId() + ", userId=" + this.getUserId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysTemplateUserLink)) {
         return false;
      }

      SysTemplateUserLink other = (SysTemplateUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$templateId = this.getTemplateId();
         Object other$templateId = other.getTemplateId();
         if (this$templateId == null ? other$templateId == null : this$templateId.equals(other$templateId)) {
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
      return other instanceof SysTemplateUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $templateId = this.getTemplateId();
      result = result * 59 + ($templateId == null ? 43 : $templateId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class SysTemplateUserLinkBuilder {
      private Long id;
      private Long templateId;
      private Long userId;

      SysTemplateUserLinkBuilder() {
      }

      @JsonProperty("id")
      public SysTemplateUserLink.SysTemplateUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("templateId")
      public SysTemplateUserLink.SysTemplateUserLinkBuilder templateId(final Long templateId) {
         this.templateId = templateId;
         return this;
      }

      @JsonProperty("userId")
      public SysTemplateUserLink.SysTemplateUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysTemplateUserLink build() {
         return new SysTemplateUserLink(this.id, this.templateId, this.userId);
      }

      @Override
      public String toString() {
         return "SysTemplateUserLink.SysTemplateUserLinkBuilder(id=" + this.id + ", templateId=" + this.templateId + ", userId=" + this.userId + ")";
      }
   }
}
