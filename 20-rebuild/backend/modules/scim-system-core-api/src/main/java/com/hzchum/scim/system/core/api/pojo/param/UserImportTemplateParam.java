package com.hzchum.scim.system.core.api.pojo.param;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("UserImportTemplateParam")
public class UserImportTemplateParam {
   @Excel(name = "序号", width = 20.0)
   private Integer orderNo;
   @Excel(name = "员工编号", width = 20.0)
   private String username;
   @Excel(name = "姓名", width = 20.0)
   private String name;
   @Excel(name = "手机号码", width = 20.0)
   private String phone;
   @Excel(name = "性别(男/女)", width = 20.0)
   private Integer sex;
   @Excel(name = "邮箱(选填)", width = 20.0)
   private String email;
   @Excel(name = "部门(选填)", width = 20.0)
   private String dept;
   @Excel(name = "岗位(选填)", width = 20.0)
   private String job;
   @Excel(name = "角色(选填)", width = 20.0)
   private String role;
   @Excel(name = "排序(选填)", width = 20.0)
   private Integer sort;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getUsername() {
      return this.username;
   }

   public String getName() {
      return this.name;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getEmail() {
      return this.email;
   }

   public String getDept() {
      return this.dept;
   }

   public String getJob() {
      return this.job;
   }

   public String getRole() {
      return this.role;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setDept(final String dept) {
      this.dept = dept;
   }

   public void setJob(final String job) {
      this.job = job;
   }

   public void setRole(final String role) {
      this.role = role;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserImportTemplateParam)) {
         return false;
      }

      UserImportTemplateParam other = (UserImportTemplateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$sex = this.getSex();
         Object other$sex = other.getSex();
         if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
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
                           Object this$dept = this.getDept();
                           Object other$dept = other.getDept();
                           if (this$dept == null ? other$dept == null : this$dept.equals(other$dept)) {
                              Object this$job = this.getJob();
                              Object other$job = other.getJob();
                              if (this$job == null ? other$job == null : this$job.equals(other$job)) {
                                 Object this$role = this.getRole();
                                 Object other$role = other.getRole();
                                 return this$role == null ? other$role == null : this$role.equals(other$role);
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
      return other instanceof UserImportTemplateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
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
      Object $dept = this.getDept();
      result = result * 59 + ($dept == null ? 43 : $dept.hashCode());
      Object $job = this.getJob();
      result = result * 59 + ($job == null ? 43 : $job.hashCode());
      Object $role = this.getRole();
      return result * 59 + ($role == null ? 43 : $role.hashCode());
   }

   @Override
   public String toString() {
      return "UserImportTemplateParam(orderNo="
         + this.getOrderNo()
         + ", username="
         + this.getUsername()
         + ", name="
         + this.getName()
         + ", phone="
         + this.getPhone()
         + ", sex="
         + this.getSex()
         + ", email="
         + this.getEmail()
         + ", dept="
         + this.getDept()
         + ", job="
         + this.getJob()
         + ", role="
         + this.getRole()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
