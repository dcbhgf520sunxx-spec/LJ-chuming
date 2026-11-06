package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.User;
import java.util.List;

public class DepartmentUserTreeResponseVO {
   private Long id;
   private String name;
   private Long pid;
   private List<DepartmentUserTreeResponseVO> deptList;
   private List<User> userList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getPid() {
      return this.pid;
   }

   public List<DepartmentUserTreeResponseVO> getDeptList() {
      return this.deptList;
   }

   public List<User> getUserList() {
      return this.userList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setDeptList(final List<DepartmentUserTreeResponseVO> deptList) {
      this.deptList = deptList;
   }

   public void setUserList(final List<User> userList) {
      this.userList = userList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DepartmentUserTreeResponseVO)) {
         return false;
      }

      DepartmentUserTreeResponseVO other = (DepartmentUserTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$deptList = this.getDeptList();
               Object other$deptList = other.getDeptList();
               if (this$deptList == null ? other$deptList == null : this$deptList.equals(other$deptList)) {
                  Object this$userList = this.getUserList();
                  Object other$userList = other.getUserList();
                  return this$userList == null ? other$userList == null : this$userList.equals(other$userList);
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
      return other instanceof DepartmentUserTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptList = this.getDeptList();
      result = result * 59 + ($deptList == null ? 43 : $deptList.hashCode());
      Object $userList = this.getUserList();
      return result * 59 + ($userList == null ? 43 : $userList.hashCode());
   }

   @Override
   public String toString() {
      return "DepartmentUserTreeResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", pid="
         + this.getPid()
         + ", deptList="
         + this.getDeptList()
         + ", userList="
         + this.getUserList()
         + ")";
   }
}
