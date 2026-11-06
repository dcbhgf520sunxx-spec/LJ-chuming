package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("部门树响应类")
public class DepartmentTree {
   private Long id;
   private Long pid;
   private Long oaDeptId;
   private String orgCode;
   private String parentOrgCode;
   private Integer status;
   private String name;
   private String introduction;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private Integer sort;
   private Integer deptType;
   private List<DepartmentTree> children;

   public Long getId() {
      return this.id;
   }

   public Long getPid() {
      return this.pid;
   }

   public Long getOaDeptId() {
      return this.oaDeptId;
   }

   public String getOrgCode() {
      return this.orgCode;
   }

   public String getParentOrgCode() {
      return this.parentOrgCode;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getName() {
      return this.name;
   }

   public String getIntroduction() {
      return this.introduction;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getDeptType() {
      return this.deptType;
   }

   public List<DepartmentTree> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setOaDeptId(final Long oaDeptId) {
      this.oaDeptId = oaDeptId;
   }

   public void setOrgCode(final String orgCode) {
      this.orgCode = orgCode;
   }

   public void setParentOrgCode(final String parentOrgCode) {
      this.parentOrgCode = parentOrgCode;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIntroduction(final String introduction) {
      this.introduction = introduction;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setDeptType(final Integer deptType) {
      this.deptType = deptType;
   }

   public void setChildren(final List<DepartmentTree> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DepartmentTree)) {
         return false;
      }

      DepartmentTree other = (DepartmentTree)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$oaDeptId = this.getOaDeptId();
            Object other$oaDeptId = other.getOaDeptId();
            if (this$oaDeptId == null ? other$oaDeptId == null : this$oaDeptId.equals(other$oaDeptId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$deptType = this.getDeptType();
                     Object other$deptType = other.getDeptType();
                     if (this$deptType == null ? other$deptType == null : this$deptType.equals(other$deptType)) {
                        Object this$orgCode = this.getOrgCode();
                        Object other$orgCode = other.getOrgCode();
                        if (this$orgCode == null ? other$orgCode == null : this$orgCode.equals(other$orgCode)) {
                           Object this$parentOrgCode = this.getParentOrgCode();
                           Object other$parentOrgCode = other.getParentOrgCode();
                           if (this$parentOrgCode == null ? other$parentOrgCode == null : this$parentOrgCode.equals(other$parentOrgCode)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$introduction = this.getIntroduction();
                                 Object other$introduction = other.getIntroduction();
                                 if (this$introduction == null ? other$introduction == null : this$introduction.equals(other$introduction)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                       Object this$updateTime = this.getUpdateTime();
                                       Object other$updateTime = other.getUpdateTime();
                                       if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                          Object this$children = this.getChildren();
                                          Object other$children = other.getChildren();
                                          return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof DepartmentTree;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $oaDeptId = this.getOaDeptId();
      result = result * 59 + ($oaDeptId == null ? 43 : $oaDeptId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $deptType = this.getDeptType();
      result = result * 59 + ($deptType == null ? 43 : $deptType.hashCode());
      Object $orgCode = this.getOrgCode();
      result = result * 59 + ($orgCode == null ? 43 : $orgCode.hashCode());
      Object $parentOrgCode = this.getParentOrgCode();
      result = result * 59 + ($parentOrgCode == null ? 43 : $parentOrgCode.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $introduction = this.getIntroduction();
      result = result * 59 + ($introduction == null ? 43 : $introduction.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "DepartmentTree(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", oaDeptId="
         + this.getOaDeptId()
         + ", orgCode="
         + this.getOrgCode()
         + ", parentOrgCode="
         + this.getParentOrgCode()
         + ", status="
         + this.getStatus()
         + ", name="
         + this.getName()
         + ", introduction="
         + this.getIntroduction()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", sort="
         + this.getSort()
         + ", deptType="
         + this.getDeptType()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
