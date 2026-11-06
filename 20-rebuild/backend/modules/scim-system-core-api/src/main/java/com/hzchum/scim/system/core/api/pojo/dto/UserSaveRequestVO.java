package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel("用户新增请求类")
public class UserSaveRequestVO {
   @ApiModelProperty("用户编号")
   @NotBlank(message = "用户编号不能为空")
   private String username;
   @NotBlank(message = "用户的姓名不能为空")
   @Size(max = 64, message = "用户姓名最大长度为64个字")
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
   @Min(1L)
   private Integer sort;

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

   public Integer getSort() {
      return this.sort;
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

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserSaveRequestVO)) {
         return false;
      }

      UserSaveRequestVO other = (UserSaveRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sex = this.getSex();
      Object other$sex = other.getSex();
      if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
         Object this$deptId = this.getDeptId();
         Object other$deptId = other.getDeptId();
         if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
                              return this$roleIds == null ? other$roleIds == null : this$roleIds.equals(other$roleIds);
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
      return other instanceof UserSaveRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $roleIds = this.getRoleIds();
      return result * 59 + ($roleIds == null ? 43 : $roleIds.hashCode());
   }

   @Override
   public String toString() {
      return "UserSaveRequestVO(username="
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
         + ", sort="
         + this.getSort()
         + ")";
   }
}
