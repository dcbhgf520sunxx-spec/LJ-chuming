package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import java.time.LocalDateTime;
import java.util.List;

public class UserResponseVO {
   private Long id;
   private String username;
   private String name;
   private Integer sex;
   private String phone;
   private String email;
   private String password;
   private LocalDateTime createTime;
   private LocalDateTime lastPasswordResetDate;
   private List<Role> roles;
   private Department dept;
   private Long deptId;
   private Job job;
   private Boolean enabled;
   private Integer sort;
   private Boolean isDeepen;
   private String userCode;
   private Integer userType;
   private Long oaSubDeptId;
   private String oaSubDeptName;
   private Long oaDeptId;
   private Long oaUserId;

   public Long getId() {
      return this.id;
   }

   public String getUsername() {
      return this.username;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPassword() {
      return this.password;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getLastPasswordResetDate() {
      return this.lastPasswordResetDate;
   }

   public List<Role> getRoles() {
      return this.roles;
   }

   public Department getDept() {
      return this.dept;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Job getJob() {
      return this.job;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getIsDeepen() {
      return this.isDeepen;
   }

   public String getUserCode() {
      return this.userCode;
   }

   public Integer getUserType() {
      return this.userType;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setPassword(final String password) {
      this.password = password;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setLastPasswordResetDate(final LocalDateTime lastPasswordResetDate) {
      this.lastPasswordResetDate = lastPasswordResetDate;
   }

   public void setRoles(final List<Role> roles) {
      this.roles = roles;
   }

   public void setDept(final Department dept) {
      this.dept = dept;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setJob(final Job job) {
      this.job = job;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setIsDeepen(final Boolean isDeepen) {
      this.isDeepen = isDeepen;
   }

   public void setUserCode(final String userCode) {
      this.userCode = userCode;
   }

   public void setUserType(final Integer userType) {
      this.userType = userType;
   }

   public void setOaSubDeptId(final Long oaSubDeptId) {
      this.oaSubDeptId = oaSubDeptId;
   }

   public void setOaSubDeptName(final String oaSubDeptName) {
      this.oaSubDeptName = oaSubDeptName;
   }

   public void setOaDeptId(final Long oaDeptId) {
      this.oaDeptId = oaDeptId;
   }

   public void setOaUserId(final Long oaUserId) {
      this.oaUserId = oaUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserResponseVO)) {
         return false;
      }

      UserResponseVO other = (UserResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sex = this.getSex();
         Object other$sex = other.getSex();
         if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
            Object this$deptId = this.getDeptId();
            Object other$deptId = other.getDeptId();
            if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$isDeepen = this.getIsDeepen();
                     Object other$isDeepen = other.getIsDeepen();
                     if (this$isDeepen == null ? other$isDeepen == null : this$isDeepen.equals(other$isDeepen)) {
                        Object this$userType = this.getUserType();
                        Object other$userType = other.getUserType();
                        if (this$userType == null ? other$userType == null : this$userType.equals(other$userType)) {
                           Object this$oaSubDeptId = this.getOaSubDeptId();
                           Object other$oaSubDeptId = other.getOaSubDeptId();
                           if (this$oaSubDeptId == null ? other$oaSubDeptId == null : this$oaSubDeptId.equals(other$oaSubDeptId)) {
                              Object this$oaDeptId = this.getOaDeptId();
                              Object other$oaDeptId = other.getOaDeptId();
                              if (this$oaDeptId == null ? other$oaDeptId == null : this$oaDeptId.equals(other$oaDeptId)) {
                                 Object this$oaUserId = this.getOaUserId();
                                 Object other$oaUserId = other.getOaUserId();
                                 if (this$oaUserId == null ? other$oaUserId == null : this$oaUserId.equals(other$oaUserId)) {
                                    Object this$username = this.getUsername();
                                    Object other$username = other.getUsername();
                                    if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$phone = this.getPhone();
                                          Object other$phone = other.getPhone();
                                          if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                             Object this$email = this.getEmail();
                                             Object other$email = other.getEmail();
                                             if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                                                Object this$password = this.getPassword();
                                                Object other$password = other.getPassword();
                                                if (this$password == null ? other$password == null : this$password.equals(other$password)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                      Object this$lastPasswordResetDate = this.getLastPasswordResetDate();
                                                      Object other$lastPasswordResetDate = other.getLastPasswordResetDate();
                                                      if (this$lastPasswordResetDate == null
                                                         ? other$lastPasswordResetDate == null
                                                         : this$lastPasswordResetDate.equals(other$lastPasswordResetDate)) {
                                                         Object this$roles = this.getRoles();
                                                         Object other$roles = other.getRoles();
                                                         if (this$roles == null ? other$roles == null : this$roles.equals(other$roles)) {
                                                            Object this$dept = this.getDept();
                                                            Object other$dept = other.getDept();
                                                            if (this$dept == null ? other$dept == null : this$dept.equals(other$dept)) {
                                                               Object this$job = this.getJob();
                                                               Object other$job = other.getJob();
                                                               if (this$job == null ? other$job == null : this$job.equals(other$job)) {
                                                                  Object this$userCode = this.getUserCode();
                                                                  Object other$userCode = other.getUserCode();
                                                                  if (this$userCode == null ? other$userCode == null : this$userCode.equals(other$userCode)) {
                                                                     Object this$oaSubDeptName = this.getOaSubDeptName();
                                                                     Object other$oaSubDeptName = other.getOaSubDeptName();
                                                                     return this$oaSubDeptName == null
                                                                        ? other$oaSubDeptName == null
                                                                        : this$oaSubDeptName.equals(other$oaSubDeptName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof UserResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $isDeepen = this.getIsDeepen();
      result = result * 59 + ($isDeepen == null ? 43 : $isDeepen.hashCode());
      Object $userType = this.getUserType();
      result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
      Object $oaSubDeptId = this.getOaSubDeptId();
      result = result * 59 + ($oaSubDeptId == null ? 43 : $oaSubDeptId.hashCode());
      Object $oaDeptId = this.getOaDeptId();
      result = result * 59 + ($oaDeptId == null ? 43 : $oaDeptId.hashCode());
      Object $oaUserId = this.getOaUserId();
      result = result * 59 + ($oaUserId == null ? 43 : $oaUserId.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $password = this.getPassword();
      result = result * 59 + ($password == null ? 43 : $password.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $lastPasswordResetDate = this.getLastPasswordResetDate();
      result = result * 59 + ($lastPasswordResetDate == null ? 43 : $lastPasswordResetDate.hashCode());
      Object $roles = this.getRoles();
      result = result * 59 + ($roles == null ? 43 : $roles.hashCode());
      Object $dept = this.getDept();
      result = result * 59 + ($dept == null ? 43 : $dept.hashCode());
      Object $job = this.getJob();
      result = result * 59 + ($job == null ? 43 : $job.hashCode());
      Object $userCode = this.getUserCode();
      result = result * 59 + ($userCode == null ? 43 : $userCode.hashCode());
      Object $oaSubDeptName = this.getOaSubDeptName();
      return result * 59 + ($oaSubDeptName == null ? 43 : $oaSubDeptName.hashCode());
   }

   @Override
   public String toString() {
      return "UserResponseVO(id="
         + this.getId()
         + ", username="
         + this.getUsername()
         + ", name="
         + this.getName()
         + ", sex="
         + this.getSex()
         + ", phone="
         + this.getPhone()
         + ", email="
         + this.getEmail()
         + ", password="
         + this.getPassword()
         + ", createTime="
         + this.getCreateTime()
         + ", lastPasswordResetDate="
         + this.getLastPasswordResetDate()
         + ", roles="
         + this.getRoles()
         + ", dept="
         + this.getDept()
         + ", deptId="
         + this.getDeptId()
         + ", job="
         + this.getJob()
         + ", enabled="
         + this.getEnabled()
         + ", sort="
         + this.getSort()
         + ", isDeepen="
         + this.getIsDeepen()
         + ", userCode="
         + this.getUserCode()
         + ", userType="
         + this.getUserType()
         + ", oaSubDeptId="
         + this.getOaSubDeptId()
         + ", oaSubDeptName="
         + this.getOaSubDeptName()
         + ", oaDeptId="
         + this.getOaDeptId()
         + ", oaUserId="
         + this.getOaUserId()
         + ")";
   }
}
