package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserCheckVO {
   @ApiModelProperty("用户id")
   @NotNull(message = "用户id不能为空")
   private Long id;
   @ApiModelProperty("用户姓名")
   private String name;
   @ApiModelProperty("用户电话")
   @NotNull(message = "用户电话不能为空")
   private String phone;
   @ApiModelProperty("车间信息")
   private List<@Valid IdAndNameDTO> workshops;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getPhone() {
      return this.phone;
   }

   public List<@Valid IdAndNameDTO> getWorkshops() {
      return this.workshops;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setWorkshops(final List<@Valid IdAndNameDTO> workshops) {
      this.workshops = workshops;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserCheckVO)) {
         return false;
      }

      UserCheckVO other = (UserCheckVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$phone = this.getPhone();
            Object other$phone = other.getPhone();
            if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
               Object this$workshops = this.getWorkshops();
               Object other$workshops = other.getWorkshops();
               return this$workshops == null ? other$workshops == null : this$workshops.equals(other$workshops);
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
      return other instanceof UserCheckVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $workshops = this.getWorkshops();
      return result * 59 + ($workshops == null ? 43 : $workshops.hashCode());
   }

   @Override
   public String toString() {
      return "UserCheckVO(id=" + this.getId() + ", name=" + this.getName() + ", phone=" + this.getPhone() + ", workshops=" + this.getWorkshops() + ")";
   }
}
