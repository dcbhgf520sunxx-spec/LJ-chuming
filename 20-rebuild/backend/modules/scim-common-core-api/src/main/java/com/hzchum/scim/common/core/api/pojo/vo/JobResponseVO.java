package com.hzchum.scim.common.core.api.pojo.vo;

import java.time.LocalDateTime;

public class JobResponseVO {
   private Long id;
   private String name;
   private Integer sort;
   private Integer enabled;
   private String deptSuperiorName;
   private Long deptId;
   private String deptName;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public String getDeptSuperiorName() {
      return this.deptSuperiorName;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setEnabled(final Integer enabled) {
      this.enabled = enabled;
   }

   public void setDeptSuperiorName(final String deptSuperiorName) {
      this.deptSuperiorName = deptSuperiorName;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JobResponseVO)) {
         return false;
      }

      JobResponseVO other = (JobResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$enabled = this.getEnabled();
            Object other$enabled = other.getEnabled();
            if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
               Object this$deptId = this.getDeptId();
               Object other$deptId = other.getDeptId();
               if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$deptSuperiorName = this.getDeptSuperiorName();
                     Object other$deptSuperiorName = other.getDeptSuperiorName();
                     if (this$deptSuperiorName == null ? other$deptSuperiorName == null : this$deptSuperiorName.equals(other$deptSuperiorName)) {
                        Object this$deptName = this.getDeptName();
                        Object other$deptName = other.getDeptName();
                        if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$updateTime = this.getUpdateTime();
                              Object other$updateTime = other.getUpdateTime();
                              return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof JobResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptSuperiorName = this.getDeptSuperiorName();
      result = result * 59 + ($deptSuperiorName == null ? 43 : $deptSuperiorName.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "JobResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", enabled="
         + this.getEnabled()
         + ", deptSuperiorName="
         + this.getDeptSuperiorName()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }
}
