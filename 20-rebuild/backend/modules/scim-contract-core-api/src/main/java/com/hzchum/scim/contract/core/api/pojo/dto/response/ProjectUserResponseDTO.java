package com.hzchum.scim.contract.core.api.pojo.dto.response;

import java.util.List;
import java.util.Map;

public class ProjectUserResponseDTO {
   private Long deptId;
   private String depeName;
   private List<Map<String, Object>> userList;

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDepeName() {
      return this.depeName;
   }

   public List<Map<String, Object>> getUserList() {
      return this.userList;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDepeName(final String depeName) {
      this.depeName = depeName;
   }

   public void setUserList(final List<Map<String, Object>> userList) {
      this.userList = userList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectUserResponseDTO)) {
         return false;
      }

      ProjectUserResponseDTO other = (ProjectUserResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$deptId = this.getDeptId();
      Object other$deptId = other.getDeptId();
      if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
         Object this$depeName = this.getDepeName();
         Object other$depeName = other.getDepeName();
         if (this$depeName == null ? other$depeName == null : this$depeName.equals(other$depeName)) {
            Object this$userList = this.getUserList();
            Object other$userList = other.getUserList();
            return this$userList == null ? other$userList == null : this$userList.equals(other$userList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectUserResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $depeName = this.getDepeName();
      result = result * 59 + ($depeName == null ? 43 : $depeName.hashCode());
      Object $userList = this.getUserList();
      return result * 59 + ($userList == null ? 43 : $userList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectUserResponseDTO(deptId=" + this.getDeptId() + ", depeName=" + this.getDepeName() + ", userList=" + this.getUserList() + ")";
   }
}
