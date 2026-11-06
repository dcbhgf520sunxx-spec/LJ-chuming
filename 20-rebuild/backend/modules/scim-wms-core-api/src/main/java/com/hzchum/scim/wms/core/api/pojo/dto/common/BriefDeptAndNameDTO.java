package com.hzchum.scim.wms.core.api.pojo.dto.common;

public class BriefDeptAndNameDTO {
   private Long userId;
   private String name;
   private String deptName;

   public static BriefDeptAndNameDTO.BriefDeptAndNameDTOBuilder builder() {
      return new BriefDeptAndNameDTO.BriefDeptAndNameDTOBuilder();
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getName() {
      return this.name;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefDeptAndNameDTO)) {
         return false;
      }

      BriefDeptAndNameDTO other = (BriefDeptAndNameDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$deptName = this.getDeptName();
            Object other$deptName = other.getDeptName();
            return this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BriefDeptAndNameDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptName = this.getDeptName();
      return result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
   }

   @Override
   public String toString() {
      return "BriefDeptAndNameDTO(userId=" + this.getUserId() + ", name=" + this.getName() + ", deptName=" + this.getDeptName() + ")";
   }

   public BriefDeptAndNameDTO(final Long userId, final String name, final String deptName) {
      this.userId = userId;
      this.name = name;
      this.deptName = deptName;
   }

   public BriefDeptAndNameDTO() {
   }

   public static class BriefDeptAndNameDTOBuilder {
      private Long userId;
      private String name;
      private String deptName;

      BriefDeptAndNameDTOBuilder() {
      }

      public BriefDeptAndNameDTO.BriefDeptAndNameDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public BriefDeptAndNameDTO.BriefDeptAndNameDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BriefDeptAndNameDTO.BriefDeptAndNameDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public BriefDeptAndNameDTO build() {
         return new BriefDeptAndNameDTO(this.userId, this.name, this.deptName);
      }

      @Override
      public String toString() {
         return "BriefDeptAndNameDTO.BriefDeptAndNameDTOBuilder(userId=" + this.userId + ", name=" + this.name + ", deptName=" + this.deptName + ")";
      }
   }
}
