package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserUpdateDTOParam {
   @NotNull(message = "用户id不能为空")
   private Long id;
   @NotBlank(message = "用户名不能为空")
   private String username;
   @NotBlank(message = "用户姓名不能为空")
   @Length(max = 64, message = "用户姓名最大长度为64个字")
   private String name;
   @NotNull(message = "性别不能为空")
   private Integer sex;
   @NotBlank(message = "用户的手机号不能为空")
   @Pattern(regexp = "((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", message = "手机号格式错误")
   private String phone;
   @Email(message = "用户的邮箱地址格式错误")
   private String email;
   private List<Long> roleIds;
   private Long deptId;
   private Long jobId;
   private Boolean enabled;
   private Integer sort;
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

   public List<Long> getRoleIds() {
      return this.roleIds;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Integer getSort() {
      return this.sort;
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

   public void setRoleIds(final List<Long> roleIds) {
      this.roleIds = roleIds;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setJobId(final Long jobId) {
      this.jobId = jobId;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
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

      if (!(o instanceof UserUpdateDTOParam)) {
         return false;
      }

      UserUpdateDTOParam other = (UserUpdateDTOParam)o;
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
               Object this$jobId = this.getJobId();
               Object other$jobId = other.getJobId();
               if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                  Object this$enabled = this.getEnabled();
                  Object other$enabled = other.getEnabled();
                  if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
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
                                             Object this$roleIds = this.getRoleIds();
                                             Object other$roleIds = other.getRoleIds();
                                             if (this$roleIds == null ? other$roleIds == null : this$roleIds.equals(other$roleIds)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserUpdateDTOParam;
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
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
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
      Object $roleIds = this.getRoleIds();
      result = result * 59 + ($roleIds == null ? 43 : $roleIds.hashCode());
      Object $oaSubDeptName = this.getOaSubDeptName();
      return result * 59 + ($oaSubDeptName == null ? 43 : $oaSubDeptName.hashCode());
   }

   @Override
   public String toString() {
      return "UserUpdateDTOParam(id="
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
         + ", roleIds="
         + this.getRoleIds()
         + ", deptId="
         + this.getDeptId()
         + ", jobId="
         + this.getJobId()
         + ", enabled="
         + this.getEnabled()
         + ", sort="
         + this.getSort()
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
