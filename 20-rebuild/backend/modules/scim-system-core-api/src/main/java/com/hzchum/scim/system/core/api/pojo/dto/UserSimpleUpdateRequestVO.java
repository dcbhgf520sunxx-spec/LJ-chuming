package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserSimpleUpdateRequestVO {
   @NotBlank(message = "用户姓名不能为空")
   @Length(max = 64, message = "用户姓名最大长度为64个字")
   private String name;
   @NotNull(message = "性别不能为空")
   private Integer sex;
   @NotBlank(message = "用户的手机号不能为空")
   @Pattern(regexp = "((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", message = "手机号格式错误")
   private String phone;

   public String getName() {
      return this.name;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getPhone() {
      return this.phone;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserSimpleUpdateRequestVO)) {
         return false;
      }

      UserSimpleUpdateRequestVO other = (UserSimpleUpdateRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sex = this.getSex();
      Object other$sex = other.getSex();
      if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$phone = this.getPhone();
            Object other$phone = other.getPhone();
            return this$phone == null ? other$phone == null : this$phone.equals(other$phone);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserSimpleUpdateRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      return result * 59 + ($phone == null ? 43 : $phone.hashCode());
   }

   @Override
   public String toString() {
      return "UserSimpleUpdateRequestVO(name=" + this.getName() + ", sex=" + this.getSex() + ", phone=" + this.getPhone() + ")";
   }
}
