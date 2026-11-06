package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysLog对象", description = "")
@Entity
@TableName("sys_log")
@Table(name = "sys_log")
@org.hibernate.annotations.Table(appliesTo = "sys_log")
public class SysLog extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classMethod", value = "方法名称", notes = "方法名称")
   @TableField("class_method")
   @Column(name = "class_method", columnDefinition = "varchar(255)  COMMENT '方法名称'", nullable = true)
   private String classMethod;
   @ApiModelProperty(name = "errorInfo", value = "错误信息", notes = "错误信息")
   @TableField("error_info")
   @Column(name = "error_info", columnDefinition = "varchar(255)  COMMENT '错误信息'", nullable = true)
   private String errorInfo;
   @ApiModelProperty(name = "ip", value = "ip地址", notes = "ip地址")
   @TableField("ip")
   @Column(name = "ip", columnDefinition = "varchar(255)  COMMENT 'ip地址'", nullable = true)
   private String ip;
   @ApiModelProperty(name = "method", value = "请求方式", notes = "请求方式")
   @TableField("method")
   @Column(name = "method", columnDefinition = "varchar(255)  COMMENT '请求方式'", nullable = true)
   private String method;
   @ApiModelProperty(name = "spendTime", value = "耗时", notes = "耗时")
   @TableField("spend_time")
   @Column(name = "spend_time", columnDefinition = "bigint(20)  COMMENT '耗时'", nullable = true)
   private Long spendTime;
   @ApiModelProperty(name = "url", value = "请求地址", notes = "请求地址")
   @TableField("url")
   @Column(name = "url", columnDefinition = "varchar(255)  COMMENT '请求地址'", nullable = true)
   private String url;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "用户名称", notes = "用户名称")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(255)  COMMENT '用户名称'", nullable = true)
   private String userName;

   public static SysLog.SysLogBuilder builder() {
      return new SysLog.SysLogBuilder();
   }

   public SysLog() {
   }

   public SysLog(
      final Long id,
      final String classMethod,
      final String errorInfo,
      final String ip,
      final String method,
      final Long spendTime,
      final String url,
      final Long userId,
      final String userName
   ) {
      this.id = id;
      this.classMethod = classMethod;
      this.errorInfo = errorInfo;
      this.ip = ip;
      this.method = method;
      this.spendTime = spendTime;
      this.url = url;
      this.userId = userId;
      this.userName = userName;
   }

   public Long getId() {
      return this.id;
   }

   public String getClassMethod() {
      return this.classMethod;
   }

   public String getErrorInfo() {
      return this.errorInfo;
   }

   public String getIp() {
      return this.ip;
   }

   public String getMethod() {
      return this.method;
   }

   public Long getSpendTime() {
      return this.spendTime;
   }

   public String getUrl() {
      return this.url;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public SysLog setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysLog setClassMethod(final String classMethod) {
      this.classMethod = classMethod;
      return this;
   }

   public SysLog setErrorInfo(final String errorInfo) {
      this.errorInfo = errorInfo;
      return this;
   }

   public SysLog setIp(final String ip) {
      this.ip = ip;
      return this;
   }

   public SysLog setMethod(final String method) {
      this.method = method;
      return this;
   }

   public SysLog setSpendTime(final Long spendTime) {
      this.spendTime = spendTime;
      return this;
   }

   public SysLog setUrl(final String url) {
      this.url = url;
      return this;
   }

   public SysLog setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SysLog setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "SysLog(id="
         + this.getId()
         + ", classMethod="
         + this.getClassMethod()
         + ", errorInfo="
         + this.getErrorInfo()
         + ", ip="
         + this.getIp()
         + ", method="
         + this.getMethod()
         + ", spendTime="
         + this.getSpendTime()
         + ", url="
         + this.getUrl()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysLog)) {
         return false;
      }

      SysLog other = (SysLog)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$spendTime = this.getSpendTime();
         Object other$spendTime = other.getSpendTime();
         if (this$spendTime == null ? other$spendTime == null : this$spendTime.equals(other$spendTime)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$classMethod = this.getClassMethod();
               Object other$classMethod = other.getClassMethod();
               if (this$classMethod == null ? other$classMethod == null : this$classMethod.equals(other$classMethod)) {
                  Object this$errorInfo = this.getErrorInfo();
                  Object other$errorInfo = other.getErrorInfo();
                  if (this$errorInfo == null ? other$errorInfo == null : this$errorInfo.equals(other$errorInfo)) {
                     Object this$ip = this.getIp();
                     Object other$ip = other.getIp();
                     if (this$ip == null ? other$ip == null : this$ip.equals(other$ip)) {
                        Object this$method = this.getMethod();
                        Object other$method = other.getMethod();
                        if (this$method == null ? other$method == null : this$method.equals(other$method)) {
                           Object this$url = this.getUrl();
                           Object other$url = other.getUrl();
                           if (this$url == null ? other$url == null : this$url.equals(other$url)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysLog;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $spendTime = this.getSpendTime();
      result = result * 59 + ($spendTime == null ? 43 : $spendTime.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $classMethod = this.getClassMethod();
      result = result * 59 + ($classMethod == null ? 43 : $classMethod.hashCode());
      Object $errorInfo = this.getErrorInfo();
      result = result * 59 + ($errorInfo == null ? 43 : $errorInfo.hashCode());
      Object $ip = this.getIp();
      result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
      Object $method = this.getMethod();
      result = result * 59 + ($method == null ? 43 : $method.hashCode());
      Object $url = this.getUrl();
      result = result * 59 + ($url == null ? 43 : $url.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class SysLogBuilder {
      private Long id;
      private String classMethod;
      private String errorInfo;
      private String ip;
      private String method;
      private Long spendTime;
      private String url;
      private Long userId;
      private String userName;

      SysLogBuilder() {
      }

      public SysLog.SysLogBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysLog.SysLogBuilder classMethod(final String classMethod) {
         this.classMethod = classMethod;
         return this;
      }

      public SysLog.SysLogBuilder errorInfo(final String errorInfo) {
         this.errorInfo = errorInfo;
         return this;
      }

      public SysLog.SysLogBuilder ip(final String ip) {
         this.ip = ip;
         return this;
      }

      public SysLog.SysLogBuilder method(final String method) {
         this.method = method;
         return this;
      }

      public SysLog.SysLogBuilder spendTime(final Long spendTime) {
         this.spendTime = spendTime;
         return this;
      }

      public SysLog.SysLogBuilder url(final String url) {
         this.url = url;
         return this;
      }

      public SysLog.SysLogBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysLog.SysLogBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SysLog build() {
         return new SysLog(this.id, this.classMethod, this.errorInfo, this.ip, this.method, this.spendTime, this.url, this.userId, this.userName);
      }

      @Override
      public String toString() {
         return "SysLog.SysLogBuilder(id="
            + this.id
            + ", classMethod="
            + this.classMethod
            + ", errorInfo="
            + this.errorInfo
            + ", ip="
            + this.ip
            + ", method="
            + this.method
            + ", spendTime="
            + this.spendTime
            + ", url="
            + this.url
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
