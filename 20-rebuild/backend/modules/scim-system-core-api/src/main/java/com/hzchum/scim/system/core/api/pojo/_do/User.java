package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "User对象", description = "")
@TableName("sys_user")
@Table(name = "sys_user")
public class User extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "ddUserId", value = "钉钉用户ID")
   @TableField("dd_user_id")
   @Column(name = "dd_user_id", columnDefinition = "varchar(255) comment '钉钉用户ID'")
   private String ddUserId;
   @ApiModelProperty(name = "department_id", value = "部门ID")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20) comment '部门ID'")
   private Long departmentId;
   @ApiModelProperty(name = "ddDeptId")
   @TableField("dd_dept_id")
   @Column(name = "dd_dept_id")
   private Long ddDeptId;
   @ApiModelProperty(name = "email", value = "电子邮件")
   @TableField("email")
   @Column(name = "email", columnDefinition = "varchar(255) comment '电子邮件'")
   private String email;
   @ApiModelProperty(name = "is_enabled", value = "开启状态 true启用 false禁用")
   @TableField("is_enabled")
   @Column(name = "is_enabled", columnDefinition = "tinyint(1) default 1 comment '开启状态 1启用 0禁用'", nullable = false)
   private Boolean isEnabled;
   @ApiModelProperty(name = "job_id", value = "岗位ID")
   @TableField(value = "job_id", fill = FieldFill.UPDATE)
   @Column(name = "job_id", columnDefinition = "bigint(20) comment '岗位id'")
   private Long jobId;
   @ApiModelProperty(name = "last_password_reset_date", value = "上次修改密码时间")
   @TableField("last_password_reset_date")
   @Column(name = "last_password_reset_date", columnDefinition = "datetime(6) comment '上次修改密码时间'")
   private LocalDateTime lastPasswordResetDate;
   @ApiModelProperty(name = "name", value = "姓名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '姓名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "password", value = "密码")
   @TableField("password")
   @Column(name = "password", columnDefinition = "varchar(255) comment '密码'", nullable = false)
   private String password;
   @ApiModelProperty(name = "phone", value = "电话号码")
   @TableField("phone")
   @Column(name = "phone", columnDefinition = "varchar(255) comment '电话号码'")
   private String phone;
   @ApiModelProperty(name = "sex", value = "性别 0男 1女")
   @TableField("sex")
   @Column(name = "sex", columnDefinition = "int(11) default 0 comment '性别 0男 1女'", nullable = false)
   private Integer sex;
   @ApiModelProperty(name = "username", value = "用户登录账号")
   @TableField("username")
   @Column(name = "username", columnDefinition = "varchar(255) comment '用户登录账号'", nullable = false)
   private String username;
   @ApiModelProperty(name = "is_deepen", value = "开启状态 true启用 false禁用")
   @TableField("is_deepen")
   @Column(name = "is_deepen", columnDefinition = "tinyint(1) default 0 comment '开启状态 1 深化用户 0 普通用户'", nullable = false)
   private Boolean isDeepen;
   @ApiModelProperty(name = "inventory_notify_perm")
   @JsonProperty("inventory_notify_perm")
   @JSONField(name = "inventory_notify_perm")
   @TableField("inventory_notify_perm")
   @Column(name = "inventory_notify_perm")
   private Boolean inventoryNotifyPerm;
   @ApiModelProperty(name = "userType")
   @TableField("user_type")
   @Column(name = "user_type", columnDefinition = "int(11) default 1 comment '用户类型 1普通公司用户(编制内) 2临时分包商用户，4中南劳务人员（编制外）'", nullable = false)
   private Integer userType;
   @ApiModelProperty(name = "sort", value = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default 1 comment '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "openId", value = "劳务小程序id", notes = "劳务小程序id")
   @JsonProperty("openId")
   @JSONField(name = "openId")
   @TableField("open_id")
   @Column(name = "open_id", columnDefinition = "varchar(255)  COMMENT '劳务小程序id'")
   private String openId;
   @ApiModelProperty(name = "oaSubDeptId", value = "OA分部门id")
   @TableField("oa_sub_dept_id")
   @Column(name = "oa_sub_dept_id", columnDefinition = "bigint(20) comment 'OA分部门id'", nullable = true)
   private Long oaSubDeptId;
   @ApiModelProperty(name = "oaSubDeptName", value = "OA分部门名称")
   @TableField("oa_sub_dept_name")
   @Column(name = "oa_sub_dept_name", columnDefinition = "varchar(50) comment 'OA分部门名称'", nullable = true)
   private String oaSubDeptName;
   @ApiModelProperty(name = "oaDeptId", value = "OA部门id")
   @TableField("oa_dept_id")
   @Column(name = "oa_dept_id", columnDefinition = "bigint(20) comment 'OA部门ID'", nullable = true)
   private Long oaDeptId;
   @ApiModelProperty(name = "oaUserId", value = "OA人员id")
   @TableField("oa_user_id")
   @Column(name = "oa_user_id", columnDefinition = "bigint(20)  comment 'OA人员id'", nullable = true)
   private Long oaUserId;
   @ApiModelProperty(name = "userCode", value = "shr人员编号")
   @TableField("user_code")
   @Column(name = "user_code", columnDefinition = "varchar(50) comment 'shr人员编号'", nullable = true)
   private String userCode;
   @ApiModelProperty(name = "deptCode", value = "shr部门编号")
   @TableField("dept_code")
   @Column(name = "dept_code", columnDefinition = "varchar(50)  comment 'shr部门编号'", nullable = true)
   private String deptCode;
   @ApiModelProperty(name = "positionCode", value = "shr岗位编号")
   @TableField("position_code")
   @Column(name = "position_code", columnDefinition = "varchar(50)  comment 'shr岗位编号'", nullable = true)
   private String positionCode;
   @ApiModelProperty(name = "registrationId", notes = "设备id")
   @JsonProperty("registrationId")
   @JSONField(name = "registrationId")
   @TableField("registration_id")
   @Column(name = "registration_id", columnDefinition = "varchar(255)  COMMENT '设备id'")
   private String registrationId;
   @ApiModelProperty(name = "platform", notes = "平台类型")
   @JsonProperty("platform")
   @JSONField(name = "platform")
   @TableField("platform")
   @Column(name = "platform", columnDefinition = "varchar(1048)  COMMENT '平台类型'")
   private String platform;

   public static User.UserBuilder builder() {
      return new User.UserBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getDdUserId() {
      return this.ddUserId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public Long getDdDeptId() {
      return this.ddDeptId;
   }

   public String getEmail() {
      return this.email;
   }

   public Boolean getIsEnabled() {
      return this.isEnabled;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public LocalDateTime getLastPasswordResetDate() {
      return this.lastPasswordResetDate;
   }

   public String getName() {
      return this.name;
   }

   public String getPassword() {
      return this.password;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getUsername() {
      return this.username;
   }

   public Boolean getIsDeepen() {
      return this.isDeepen;
   }

   public Boolean getInventoryNotifyPerm() {
      return this.inventoryNotifyPerm;
   }

   public Integer getUserType() {
      return this.userType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getOpenId() {
      return this.openId;
   }

   public Long getOaSubDeptId() {
      return this.oaSubDeptId;
   }

   public String getOaSubDeptName() {
      return this.oaSubDeptName;
   }

   public Long getOaDeptId() {
      return this.oaDeptId;
   }

   public Long getOaUserId() {
      return this.oaUserId;
   }

   public String getUserCode() {
      return this.userCode;
   }

   public String getDeptCode() {
      return this.deptCode;
   }

   public String getPositionCode() {
      return this.positionCode;
   }

   public String getRegistrationId() {
      return this.registrationId;
   }

   public String getPlatform() {
      return this.platform;
   }

   public User setId(final Long id) {
      this.id = id;
      return this;
   }

   public User setDdUserId(final String ddUserId) {
      this.ddUserId = ddUserId;
      return this;
   }

   public User setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public User setDdDeptId(final Long ddDeptId) {
      this.ddDeptId = ddDeptId;
      return this;
   }

   public User setEmail(final String email) {
      this.email = email;
      return this;
   }

   public User setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
      return this;
   }

   public User setJobId(final Long jobId) {
      this.jobId = jobId;
      return this;
   }

   public User setLastPasswordResetDate(final LocalDateTime lastPasswordResetDate) {
      this.lastPasswordResetDate = lastPasswordResetDate;
      return this;
   }

   public User setName(final String name) {
      this.name = name;
      return this;
   }

   public User setPassword(final String password) {
      this.password = password;
      return this;
   }

   public User setPhone(final String phone) {
      this.phone = phone;
      return this;
   }

   public User setSex(final Integer sex) {
      this.sex = sex;
      return this;
   }

   public User setUsername(final String username) {
      this.username = username;
      return this;
   }

   public User setIsDeepen(final Boolean isDeepen) {
      this.isDeepen = isDeepen;
      return this;
   }

   @JsonProperty("inventory_notify_perm")
   public User setInventoryNotifyPerm(final Boolean inventoryNotifyPerm) {
      this.inventoryNotifyPerm = inventoryNotifyPerm;
      return this;
   }

   public User setUserType(final Integer userType) {
      this.userType = userType;
      return this;
   }

   public User setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("openId")
   public User setOpenId(final String openId) {
      this.openId = openId;
      return this;
   }

   public User setOaSubDeptId(final Long oaSubDeptId) {
      this.oaSubDeptId = oaSubDeptId;
      return this;
   }

   public User setOaSubDeptName(final String oaSubDeptName) {
      this.oaSubDeptName = oaSubDeptName;
      return this;
   }

   public User setOaDeptId(final Long oaDeptId) {
      this.oaDeptId = oaDeptId;
      return this;
   }

   public User setOaUserId(final Long oaUserId) {
      this.oaUserId = oaUserId;
      return this;
   }

   public User setUserCode(final String userCode) {
      this.userCode = userCode;
      return this;
   }

   public User setDeptCode(final String deptCode) {
      this.deptCode = deptCode;
      return this;
   }

   public User setPositionCode(final String positionCode) {
      this.positionCode = positionCode;
      return this;
   }

   @JsonProperty("registrationId")
   public User setRegistrationId(final String registrationId) {
      this.registrationId = registrationId;
      return this;
   }

   @JsonProperty("platform")
   public User setPlatform(final String platform) {
      this.platform = platform;
      return this;
   }

   @Override
   public String toString() {
      return "User(id="
         + this.getId()
         + ", ddUserId="
         + this.getDdUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", ddDeptId="
         + this.getDdDeptId()
         + ", email="
         + this.getEmail()
         + ", isEnabled="
         + this.getIsEnabled()
         + ", jobId="
         + this.getJobId()
         + ", lastPasswordResetDate="
         + this.getLastPasswordResetDate()
         + ", name="
         + this.getName()
         + ", password="
         + this.getPassword()
         + ", phone="
         + this.getPhone()
         + ", sex="
         + this.getSex()
         + ", username="
         + this.getUsername()
         + ", isDeepen="
         + this.getIsDeepen()
         + ", inventoryNotifyPerm="
         + this.getInventoryNotifyPerm()
         + ", userType="
         + this.getUserType()
         + ", sort="
         + this.getSort()
         + ", openId="
         + this.getOpenId()
         + ", oaSubDeptId="
         + this.getOaSubDeptId()
         + ", oaSubDeptName="
         + this.getOaSubDeptName()
         + ", oaDeptId="
         + this.getOaDeptId()
         + ", oaUserId="
         + this.getOaUserId()
         + ", userCode="
         + this.getUserCode()
         + ", deptCode="
         + this.getDeptCode()
         + ", positionCode="
         + this.getPositionCode()
         + ", registrationId="
         + this.getRegistrationId()
         + ", platform="
         + this.getPlatform()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof User)) {
         return false;
      }

      User other = (User)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$ddDeptId = this.getDdDeptId();
            Object other$ddDeptId = other.getDdDeptId();
            if (this$ddDeptId == null ? other$ddDeptId == null : this$ddDeptId.equals(other$ddDeptId)) {
               Object this$isEnabled = this.getIsEnabled();
               Object other$isEnabled = other.getIsEnabled();
               if (this$isEnabled == null ? other$isEnabled == null : this$isEnabled.equals(other$isEnabled)) {
                  Object this$jobId = this.getJobId();
                  Object other$jobId = other.getJobId();
                  if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                     Object this$sex = this.getSex();
                     Object other$sex = other.getSex();
                     if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
                        Object this$isDeepen = this.getIsDeepen();
                        Object other$isDeepen = other.getIsDeepen();
                        if (this$isDeepen == null ? other$isDeepen == null : this$isDeepen.equals(other$isDeepen)) {
                           Object this$inventoryNotifyPerm = this.getInventoryNotifyPerm();
                           Object other$inventoryNotifyPerm = other.getInventoryNotifyPerm();
                           if (this$inventoryNotifyPerm == null
                              ? other$inventoryNotifyPerm == null
                              : this$inventoryNotifyPerm.equals(other$inventoryNotifyPerm)) {
                              Object this$userType = this.getUserType();
                              Object other$userType = other.getUserType();
                              if (this$userType == null ? other$userType == null : this$userType.equals(other$userType)) {
                                 Object this$sort = this.getSort();
                                 Object other$sort = other.getSort();
                                 if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                    Object this$oaSubDeptId = this.getOaSubDeptId();
                                    Object other$oaSubDeptId = other.getOaSubDeptId();
                                    if (this$oaSubDeptId == null ? other$oaSubDeptId == null : this$oaSubDeptId.equals(other$oaSubDeptId)) {
                                       Object this$oaDeptId = this.getOaDeptId();
                                       Object other$oaDeptId = other.getOaDeptId();
                                       if (this$oaDeptId == null ? other$oaDeptId == null : this$oaDeptId.equals(other$oaDeptId)) {
                                          Object this$oaUserId = this.getOaUserId();
                                          Object other$oaUserId = other.getOaUserId();
                                          if (this$oaUserId == null ? other$oaUserId == null : this$oaUserId.equals(other$oaUserId)) {
                                             Object this$ddUserId = this.getDdUserId();
                                             Object other$ddUserId = other.getDdUserId();
                                             if (this$ddUserId == null ? other$ddUserId == null : this$ddUserId.equals(other$ddUserId)) {
                                                Object this$email = this.getEmail();
                                                Object other$email = other.getEmail();
                                                if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                                                   Object this$lastPasswordResetDate = this.getLastPasswordResetDate();
                                                   Object other$lastPasswordResetDate = other.getLastPasswordResetDate();
                                                   if (this$lastPasswordResetDate == null
                                                      ? other$lastPasswordResetDate == null
                                                      : this$lastPasswordResetDate.equals(other$lastPasswordResetDate)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$password = this.getPassword();
                                                         Object other$password = other.getPassword();
                                                         if (this$password == null ? other$password == null : this$password.equals(other$password)) {
                                                            Object this$phone = this.getPhone();
                                                            Object other$phone = other.getPhone();
                                                            if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                               Object this$username = this.getUsername();
                                                               Object other$username = other.getUsername();
                                                               if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                                                                  Object this$openId = this.getOpenId();
                                                                  Object other$openId = other.getOpenId();
                                                                  if (this$openId == null ? other$openId == null : this$openId.equals(other$openId)) {
                                                                     Object this$oaSubDeptName = this.getOaSubDeptName();
                                                                     Object other$oaSubDeptName = other.getOaSubDeptName();
                                                                     if (this$oaSubDeptName == null
                                                                        ? other$oaSubDeptName == null
                                                                        : this$oaSubDeptName.equals(other$oaSubDeptName)) {
                                                                        Object this$userCode = this.getUserCode();
                                                                        Object other$userCode = other.getUserCode();
                                                                        if (this$userCode == null
                                                                           ? other$userCode == null
                                                                           : this$userCode.equals(other$userCode)) {
                                                                           Object this$deptCode = this.getDeptCode();
                                                                           Object other$deptCode = other.getDeptCode();
                                                                           if (this$deptCode == null
                                                                              ? other$deptCode == null
                                                                              : this$deptCode.equals(other$deptCode)) {
                                                                              Object this$positionCode = this.getPositionCode();
                                                                              Object other$positionCode = other.getPositionCode();
                                                                              if (this$positionCode == null
                                                                                 ? other$positionCode == null
                                                                                 : this$positionCode.equals(other$positionCode)) {
                                                                                 Object this$registrationId = this.getRegistrationId();
                                                                                 Object other$registrationId = other.getRegistrationId();
                                                                                 if (this$registrationId == null
                                                                                    ? other$registrationId == null
                                                                                    : this$registrationId.equals(other$registrationId)) {
                                                                                    Object this$platform = this.getPlatform();
                                                                                    Object other$platform = other.getPlatform();
                                                                                    return this$platform == null
                                                                                       ? other$platform == null
                                                                                       : this$platform.equals(other$platform);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof User;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $ddDeptId = this.getDdDeptId();
      result = result * 59 + ($ddDeptId == null ? 43 : $ddDeptId.hashCode());
      Object $isEnabled = this.getIsEnabled();
      result = result * 59 + ($isEnabled == null ? 43 : $isEnabled.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $isDeepen = this.getIsDeepen();
      result = result * 59 + ($isDeepen == null ? 43 : $isDeepen.hashCode());
      Object $inventoryNotifyPerm = this.getInventoryNotifyPerm();
      result = result * 59 + ($inventoryNotifyPerm == null ? 43 : $inventoryNotifyPerm.hashCode());
      Object $userType = this.getUserType();
      result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $oaSubDeptId = this.getOaSubDeptId();
      result = result * 59 + ($oaSubDeptId == null ? 43 : $oaSubDeptId.hashCode());
      Object $oaDeptId = this.getOaDeptId();
      result = result * 59 + ($oaDeptId == null ? 43 : $oaDeptId.hashCode());
      Object $oaUserId = this.getOaUserId();
      result = result * 59 + ($oaUserId == null ? 43 : $oaUserId.hashCode());
      Object $ddUserId = this.getDdUserId();
      result = result * 59 + ($ddUserId == null ? 43 : $ddUserId.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $lastPasswordResetDate = this.getLastPasswordResetDate();
      result = result * 59 + ($lastPasswordResetDate == null ? 43 : $lastPasswordResetDate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $password = this.getPassword();
      result = result * 59 + ($password == null ? 43 : $password.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $openId = this.getOpenId();
      result = result * 59 + ($openId == null ? 43 : $openId.hashCode());
      Object $oaSubDeptName = this.getOaSubDeptName();
      result = result * 59 + ($oaSubDeptName == null ? 43 : $oaSubDeptName.hashCode());
      Object $userCode = this.getUserCode();
      result = result * 59 + ($userCode == null ? 43 : $userCode.hashCode());
      Object $deptCode = this.getDeptCode();
      result = result * 59 + ($deptCode == null ? 43 : $deptCode.hashCode());
      Object $positionCode = this.getPositionCode();
      result = result * 59 + ($positionCode == null ? 43 : $positionCode.hashCode());
      Object $registrationId = this.getRegistrationId();
      result = result * 59 + ($registrationId == null ? 43 : $registrationId.hashCode());
      Object $platform = this.getPlatform();
      return result * 59 + ($platform == null ? 43 : $platform.hashCode());
   }

   public User(
      final Long id,
      final String ddUserId,
      final Long departmentId,
      final Long ddDeptId,
      final String email,
      final Boolean isEnabled,
      final Long jobId,
      final LocalDateTime lastPasswordResetDate,
      final String name,
      final String password,
      final String phone,
      final Integer sex,
      final String username,
      final Boolean isDeepen,
      final Boolean inventoryNotifyPerm,
      final Integer userType,
      final Integer sort,
      final String openId,
      final Long oaSubDeptId,
      final String oaSubDeptName,
      final Long oaDeptId,
      final Long oaUserId,
      final String userCode,
      final String deptCode,
      final String positionCode,
      final String registrationId,
      final String platform
   ) {
      this.id = id;
      this.ddUserId = ddUserId;
      this.departmentId = departmentId;
      this.ddDeptId = ddDeptId;
      this.email = email;
      this.isEnabled = isEnabled;
      this.jobId = jobId;
      this.lastPasswordResetDate = lastPasswordResetDate;
      this.name = name;
      this.password = password;
      this.phone = phone;
      this.sex = sex;
      this.username = username;
      this.isDeepen = isDeepen;
      this.inventoryNotifyPerm = inventoryNotifyPerm;
      this.userType = userType;
      this.sort = sort;
      this.openId = openId;
      this.oaSubDeptId = oaSubDeptId;
      this.oaSubDeptName = oaSubDeptName;
      this.oaDeptId = oaDeptId;
      this.oaUserId = oaUserId;
      this.userCode = userCode;
      this.deptCode = deptCode;
      this.positionCode = positionCode;
      this.registrationId = registrationId;
      this.platform = platform;
   }

   public User() {
   }

   public static class UserBuilder {
      private Long id;
      private String ddUserId;
      private Long departmentId;
      private Long ddDeptId;
      private String email;
      private Boolean isEnabled;
      private Long jobId;
      private LocalDateTime lastPasswordResetDate;
      private String name;
      private String password;
      private String phone;
      private Integer sex;
      private String username;
      private Boolean isDeepen;
      private Boolean inventoryNotifyPerm;
      private Integer userType;
      private Integer sort;
      private String openId;
      private Long oaSubDeptId;
      private String oaSubDeptName;
      private Long oaDeptId;
      private Long oaUserId;
      private String userCode;
      private String deptCode;
      private String positionCode;
      private String registrationId;
      private String platform;

      UserBuilder() {
      }

      public User.UserBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public User.UserBuilder ddUserId(final String ddUserId) {
         this.ddUserId = ddUserId;
         return this;
      }

      public User.UserBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public User.UserBuilder ddDeptId(final Long ddDeptId) {
         this.ddDeptId = ddDeptId;
         return this;
      }

      public User.UserBuilder email(final String email) {
         this.email = email;
         return this;
      }

      public User.UserBuilder isEnabled(final Boolean isEnabled) {
         this.isEnabled = isEnabled;
         return this;
      }

      public User.UserBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      public User.UserBuilder lastPasswordResetDate(final LocalDateTime lastPasswordResetDate) {
         this.lastPasswordResetDate = lastPasswordResetDate;
         return this;
      }

      public User.UserBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public User.UserBuilder password(final String password) {
         this.password = password;
         return this;
      }

      public User.UserBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public User.UserBuilder sex(final Integer sex) {
         this.sex = sex;
         return this;
      }

      public User.UserBuilder username(final String username) {
         this.username = username;
         return this;
      }

      public User.UserBuilder isDeepen(final Boolean isDeepen) {
         this.isDeepen = isDeepen;
         return this;
      }

      @JsonProperty("inventory_notify_perm")
      public User.UserBuilder inventoryNotifyPerm(final Boolean inventoryNotifyPerm) {
         this.inventoryNotifyPerm = inventoryNotifyPerm;
         return this;
      }

      public User.UserBuilder userType(final Integer userType) {
         this.userType = userType;
         return this;
      }

      public User.UserBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("openId")
      public User.UserBuilder openId(final String openId) {
         this.openId = openId;
         return this;
      }

      public User.UserBuilder oaSubDeptId(final Long oaSubDeptId) {
         this.oaSubDeptId = oaSubDeptId;
         return this;
      }

      public User.UserBuilder oaSubDeptName(final String oaSubDeptName) {
         this.oaSubDeptName = oaSubDeptName;
         return this;
      }

      public User.UserBuilder oaDeptId(final Long oaDeptId) {
         this.oaDeptId = oaDeptId;
         return this;
      }

      public User.UserBuilder oaUserId(final Long oaUserId) {
         this.oaUserId = oaUserId;
         return this;
      }

      public User.UserBuilder userCode(final String userCode) {
         this.userCode = userCode;
         return this;
      }

      public User.UserBuilder deptCode(final String deptCode) {
         this.deptCode = deptCode;
         return this;
      }

      public User.UserBuilder positionCode(final String positionCode) {
         this.positionCode = positionCode;
         return this;
      }

      @JsonProperty("registrationId")
      public User.UserBuilder registrationId(final String registrationId) {
         this.registrationId = registrationId;
         return this;
      }

      @JsonProperty("platform")
      public User.UserBuilder platform(final String platform) {
         this.platform = platform;
         return this;
      }

      public User build() {
         return new User(
            this.id,
            this.ddUserId,
            this.departmentId,
            this.ddDeptId,
            this.email,
            this.isEnabled,
            this.jobId,
            this.lastPasswordResetDate,
            this.name,
            this.password,
            this.phone,
            this.sex,
            this.username,
            this.isDeepen,
            this.inventoryNotifyPerm,
            this.userType,
            this.sort,
            this.openId,
            this.oaSubDeptId,
            this.oaSubDeptName,
            this.oaDeptId,
            this.oaUserId,
            this.userCode,
            this.deptCode,
            this.positionCode,
            this.registrationId,
            this.platform
         );
      }

      @Override
      public String toString() {
         return "User.UserBuilder(id="
            + this.id
            + ", ddUserId="
            + this.ddUserId
            + ", departmentId="
            + this.departmentId
            + ", ddDeptId="
            + this.ddDeptId
            + ", email="
            + this.email
            + ", isEnabled="
            + this.isEnabled
            + ", jobId="
            + this.jobId
            + ", lastPasswordResetDate="
            + this.lastPasswordResetDate
            + ", name="
            + this.name
            + ", password="
            + this.password
            + ", phone="
            + this.phone
            + ", sex="
            + this.sex
            + ", username="
            + this.username
            + ", isDeepen="
            + this.isDeepen
            + ", inventoryNotifyPerm="
            + this.inventoryNotifyPerm
            + ", userType="
            + this.userType
            + ", sort="
            + this.sort
            + ", openId="
            + this.openId
            + ", oaSubDeptId="
            + this.oaSubDeptId
            + ", oaSubDeptName="
            + this.oaSubDeptName
            + ", oaDeptId="
            + this.oaDeptId
            + ", oaUserId="
            + this.oaUserId
            + ", userCode="
            + this.userCode
            + ", deptCode="
            + this.deptCode
            + ", positionCode="
            + this.positionCode
            + ", registrationId="
            + this.registrationId
            + ", platform="
            + this.platform
            + ")";
      }
   }
}
