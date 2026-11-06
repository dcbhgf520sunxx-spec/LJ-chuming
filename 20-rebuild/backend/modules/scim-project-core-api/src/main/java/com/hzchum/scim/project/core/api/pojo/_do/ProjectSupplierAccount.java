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

@ApiModel(value = "ProjectSupplierAccount对象", description = "项目管理分包商账号表 ")
@Entity
@TableName("project_supplier_account")
@Table(name = "project_supplier_account")
@org.hibernate.annotations.Table(appliesTo = "project_supplier_account", comment = "项目管理分包商账号表 ")
public class ProjectSupplierAccount extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名称", notes = "供应商名称")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '供应商名称'", nullable = false)
   private String supplierName;
   @ApiModelProperty(name = "userId", value = "用户ID", notes = "用户ID")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "userId", columnDefinition = "bigint(20)  COMMENT '用户表ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "username", value = "账号", notes = "账号")
   @JsonProperty("username")
   @JSONField(name = "username")
   @TableField("username")
   @Column(name = "username", columnDefinition = "varchar(64)  COMMENT '账号'", nullable = false)
   private String username;
   @ApiModelProperty(name = "password", value = "密码", notes = "密码")
   @JsonProperty("password")
   @JSONField(name = "password")
   @TableField("password")
   @Column(name = "password", columnDefinition = "varchar(64)  COMMENT '密码'")
   private String password;
   @ApiModelProperty(name = "boolStatus", value = "账号状态 1启用 0禁用", notes = "账号状态 1启用 0禁用")
   @JsonProperty("boolStatus")
   @JSONField(name = "boolStatus")
   @TableField("bool_status")
   @Column(name = "bool_status", columnDefinition = "tinyint(1) default '1' COMMENT '账号状态 1启用 0禁用'", nullable = false)
   private Boolean boolStatus;

   public static ProjectSupplierAccount.ProjectSupplierAccountBuilder builder() {
      return new ProjectSupplierAccount.ProjectSupplierAccountBuilder();
   }

   public ProjectSupplierAccount() {
   }

   public ProjectSupplierAccount(
      final Long id,
      final Long supplierId,
      final String supplierName,
      final Long userId,
      final String username,
      final String password,
      final Boolean boolStatus
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.userId = userId;
      this.username = username;
      this.password = password;
      this.boolStatus = boolStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   @JsonProperty("id")
   public ProjectSupplierAccount setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectSupplierAccount setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public ProjectSupplierAccount setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("userId")
   public ProjectSupplierAccount setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("username")
   public ProjectSupplierAccount setUsername(final String username) {
      this.username = username;
      return this;
   }

   @JsonProperty("password")
   public ProjectSupplierAccount setPassword(final String password) {
      this.password = password;
      return this;
   }

   @JsonProperty("boolStatus")
   public ProjectSupplierAccount setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSupplierAccount(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", userId="
         + this.getUserId()
         + ", username="
         + this.getUsername()
         + ", password="
         + this.getPassword()
         + ", boolStatus="
         + this.getBoolStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSupplierAccount)) {
         return false;
      }

      ProjectSupplierAccount other = (ProjectSupplierAccount)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$boolStatus = this.getBoolStatus();
               Object other$boolStatus = other.getBoolStatus();
               if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                  Object this$supplierName = this.getSupplierName();
                  Object other$supplierName = other.getSupplierName();
                  if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                     Object this$username = this.getUsername();
                     Object other$username = other.getUsername();
                     if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                        Object this$password = this.getPassword();
                        Object other$password = other.getPassword();
                        return this$password == null ? other$password == null : this$password.equals(other$password);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSupplierAccount;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $password = this.getPassword();
      return result * 59 + ($password == null ? 43 : $password.hashCode());
   }

   public static class ProjectSupplierAccountBuilder {
      private Long id;
      private Long supplierId;
      private String supplierName;
      private Long userId;
      private String username;
      private String password;
      private Boolean boolStatus;

      ProjectSupplierAccountBuilder() {
      }

      @JsonProperty("id")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("userId")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("username")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder username(final String username) {
         this.username = username;
         return this;
      }

      @JsonProperty("password")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder password(final String password) {
         this.password = password;
         return this;
      }

      @JsonProperty("boolStatus")
      public ProjectSupplierAccount.ProjectSupplierAccountBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ProjectSupplierAccount build() {
         return new ProjectSupplierAccount(this.id, this.supplierId, this.supplierName, this.userId, this.username, this.password, this.boolStatus);
      }

      @Override
      public String toString() {
         return "ProjectSupplierAccount.ProjectSupplierAccountBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", userId="
            + this.userId
            + ", username="
            + this.username
            + ", password="
            + this.password
            + ", boolStatus="
            + this.boolStatus
            + ")";
      }
   }
}
