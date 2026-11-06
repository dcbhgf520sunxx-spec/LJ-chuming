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
@ApiModel(value = "UserRoleLink对象", description = "")
@TableName("sys_user_role_link")
@Table(name = "sys_user_role_link")
public class UserRoleLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "role_id")
   @JsonProperty("role_id")
   @JSONField(name = "role_id")
   @TableField("role_id")
   @Column(name = "role_id")
   private Long roleId;
   @ApiModelProperty(name = "user_id")
   @JsonProperty("user_id")
   @JSONField(name = "user_id")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;

   public static UserRoleLink.UserRoleLinkBuilder builder() {
      return new UserRoleLink.UserRoleLinkBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getRoleId() {
      return this.roleId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public UserRoleLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("role_id")
   public UserRoleLink setRoleId(final Long roleId) {
      this.roleId = roleId;
      return this;
   }

   @JsonProperty("user_id")
   public UserRoleLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "UserRoleLink(id=" + this.getId() + ", roleId=" + this.getRoleId() + ", userId=" + this.getUserId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserRoleLink)) {
         return false;
      }

      UserRoleLink other = (UserRoleLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$roleId = this.getRoleId();
         Object other$roleId = other.getRoleId();
         if (this$roleId == null ? other$roleId == null : this$roleId.equals(other$roleId)) {
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
      return other instanceof UserRoleLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $roleId = this.getRoleId();
      result = result * 59 + ($roleId == null ? 43 : $roleId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public UserRoleLink(final Long id, final Long roleId, final Long userId) {
      this.id = id;
      this.roleId = roleId;
      this.userId = userId;
   }

   public UserRoleLink() {
   }

   public static class UserRoleLinkBuilder {
      private Long id;
      private Long roleId;
      private Long userId;

      UserRoleLinkBuilder() {
      }

      @JsonProperty("id")
      public UserRoleLink.UserRoleLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("role_id")
      public UserRoleLink.UserRoleLinkBuilder roleId(final Long roleId) {
         this.roleId = roleId;
         return this;
      }

      @JsonProperty("user_id")
      public UserRoleLink.UserRoleLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public UserRoleLink build() {
         return new UserRoleLink(this.id, this.roleId, this.userId);
      }

      @Override
      public String toString() {
         return "UserRoleLink.UserRoleLinkBuilder(id=" + this.id + ", roleId=" + this.roleId + ", userId=" + this.userId + ")";
      }
   }
}
