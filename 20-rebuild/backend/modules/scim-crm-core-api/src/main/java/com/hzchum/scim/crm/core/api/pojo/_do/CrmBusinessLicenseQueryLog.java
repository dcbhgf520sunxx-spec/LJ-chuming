package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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

@ApiModel(value = "CrmBusinessLicenseQueryLog对象", description = "用户工商信息查询记录")
@Entity
@TableName("crm_business_license_query_log")
@Table(name = "crm_business_license_query_log")
@org.hibernate.annotations.Table(appliesTo = "crm_business_license_query_log", comment = "用户工商信息查询记录")
public class CrmBusinessLicenseQueryLog extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "varchar(255)  COMMENT ''", nullable = false)
   private String type;
   @ApiModelProperty(name = "queryArg")
   @TableField("query_arg")
   @Column(name = "query_arg", columnDefinition = "varchar(255)  COMMENT '查询参数'", nullable = false)
   private String queryArg;

   public static CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder builder() {
      return new CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder();
   }

   public CrmBusinessLicenseQueryLog() {
   }

   public CrmBusinessLicenseQueryLog(final Long id, final Long userId, final String type, final String queryArg) {
      this.id = id;
      this.userId = userId;
      this.type = type;
      this.queryArg = queryArg;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getType() {
      return this.type;
   }

   public String getQueryArg() {
      return this.queryArg;
   }

   public CrmBusinessLicenseQueryLog setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBusinessLicenseQueryLog setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public CrmBusinessLicenseQueryLog setType(final String type) {
      this.type = type;
      return this;
   }

   public CrmBusinessLicenseQueryLog setQueryArg(final String queryArg) {
      this.queryArg = queryArg;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBusinessLicenseQueryLog(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", type="
         + this.getType()
         + ", queryArg="
         + this.getQueryArg()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBusinessLicenseQueryLog)) {
         return false;
      }

      CrmBusinessLicenseQueryLog other = (CrmBusinessLicenseQueryLog)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$queryArg = this.getQueryArg();
               Object other$queryArg = other.getQueryArg();
               return this$queryArg == null ? other$queryArg == null : this$queryArg.equals(other$queryArg);
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
      return other instanceof CrmBusinessLicenseQueryLog;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $queryArg = this.getQueryArg();
      return result * 59 + ($queryArg == null ? 43 : $queryArg.hashCode());
   }

   public static class CrmBusinessLicenseQueryLogBuilder {
      private Long id;
      private Long userId;
      private String type;
      private String queryArg;

      CrmBusinessLicenseQueryLogBuilder() {
      }

      public CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder queryArg(final String queryArg) {
         this.queryArg = queryArg;
         return this;
      }

      public CrmBusinessLicenseQueryLog build() {
         return new CrmBusinessLicenseQueryLog(this.id, this.userId, this.type, this.queryArg);
      }

      @Override
      public String toString() {
         return "CrmBusinessLicenseQueryLog.CrmBusinessLicenseQueryLogBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", type="
            + this.type
            + ", queryArg="
            + this.queryArg
            + ")";
      }
   }
}
