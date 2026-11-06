package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Department对象", description = "部门表")
@Entity
@TableName("sys_department")
@Table(name = "sys_department")
public class Department extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "introduction", value = "描述介绍")
   @TableField("introduction")
   @Column(name = "introduction", columnDefinition = "varchar(255) comment '描述介绍'")
   private String introduction;
   @ApiModelProperty(name = "name", value = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "pid", value = "父级部门ID")
   @TableField("pid")
   @Column(name = "pid", columnDefinition = "bigint(20) default 0 comment '父级部门ID'", nullable = false)
   private Long pid;
   @ApiModelProperty(name = "sort", value = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default 1 comment '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "parentOrgCode", value = "SHR上级部门编码")
   @TableField("parent_org_code")
   @Column(name = "parent_org_code", columnDefinition = "varchar(50) comment 'SHR上级部门编码'")
   private String parentOrgCode;
   @ApiModelProperty(name = "orgCode", value = "SHR部门编码")
   @TableField("org_code")
   @Column(name = "org_code", columnDefinition = "varchar(50) comment 'SHR部门编码'")
   private String orgCode;
   @ApiModelProperty(name = "oaDeptId", value = "OA部门id")
   @TableField("oa_dept_id")
   @Column(name = "oa_dept_id", columnDefinition = "bigint(20) default 0 comment 'OA部门ID'")
   private Long oaDeptId;
   @ApiModelProperty(name = "status", value = "部门状态(1,启用。0,禁用)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int default 1 comment '部门状态'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "deptType", value = "部门类型")
   @TableField("dept_type")
   @Column(name = "dept_type", columnDefinition = "int(11) default 1 comment '部门类型 1编制内 2编制外'")
   private Integer deptType;

   public static Department.DepartmentBuilder builder() {
      return new Department.DepartmentBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getIntroduction() {
      return this.introduction;
   }

   public String getName() {
      return this.name;
   }

   public Long getPid() {
      return this.pid;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getParentOrgCode() {
      return this.parentOrgCode;
   }

   public String getOrgCode() {
      return this.orgCode;
   }

   public Long getOaDeptId() {
      return this.oaDeptId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getDeptType() {
      return this.deptType;
   }

   public Department setId(final Long id) {
      this.id = id;
      return this;
   }

   public Department setIntroduction(final String introduction) {
      this.introduction = introduction;
      return this;
   }

   public Department setName(final String name) {
      this.name = name;
      return this;
   }

   public Department setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   public Department setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public Department setParentOrgCode(final String parentOrgCode) {
      this.parentOrgCode = parentOrgCode;
      return this;
   }

   public Department setOrgCode(final String orgCode) {
      this.orgCode = orgCode;
      return this;
   }

   public Department setOaDeptId(final Long oaDeptId) {
      this.oaDeptId = oaDeptId;
      return this;
   }

   public Department setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public Department setDeptType(final Integer deptType) {
      this.deptType = deptType;
      return this;
   }

   @Override
   public String toString() {
      return "Department(id="
         + this.getId()
         + ", introduction="
         + this.getIntroduction()
         + ", name="
         + this.getName()
         + ", pid="
         + this.getPid()
         + ", sort="
         + this.getSort()
         + ", parentOrgCode="
         + this.getParentOrgCode()
         + ", orgCode="
         + this.getOrgCode()
         + ", oaDeptId="
         + this.getOaDeptId()
         + ", status="
         + this.getStatus()
         + ", deptType="
         + this.getDeptType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Department)) {
         return false;
      }

      Department other = (Department)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$oaDeptId = this.getOaDeptId();
               Object other$oaDeptId = other.getOaDeptId();
               if (this$oaDeptId == null ? other$oaDeptId == null : this$oaDeptId.equals(other$oaDeptId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$deptType = this.getDeptType();
                     Object other$deptType = other.getDeptType();
                     if (this$deptType == null ? other$deptType == null : this$deptType.equals(other$deptType)) {
                        Object this$introduction = this.getIntroduction();
                        Object other$introduction = other.getIntroduction();
                        if (this$introduction == null ? other$introduction == null : this$introduction.equals(other$introduction)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$parentOrgCode = this.getParentOrgCode();
                              Object other$parentOrgCode = other.getParentOrgCode();
                              if (this$parentOrgCode == null ? other$parentOrgCode == null : this$parentOrgCode.equals(other$parentOrgCode)) {
                                 Object this$orgCode = this.getOrgCode();
                                 Object other$orgCode = other.getOrgCode();
                                 return this$orgCode == null ? other$orgCode == null : this$orgCode.equals(other$orgCode);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Department;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $oaDeptId = this.getOaDeptId();
      result = result * 59 + ($oaDeptId == null ? 43 : $oaDeptId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $deptType = this.getDeptType();
      result = result * 59 + ($deptType == null ? 43 : $deptType.hashCode());
      Object $introduction = this.getIntroduction();
      result = result * 59 + ($introduction == null ? 43 : $introduction.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $parentOrgCode = this.getParentOrgCode();
      result = result * 59 + ($parentOrgCode == null ? 43 : $parentOrgCode.hashCode());
      Object $orgCode = this.getOrgCode();
      return result * 59 + ($orgCode == null ? 43 : $orgCode.hashCode());
   }

   public Department(
      final Long id,
      final String introduction,
      final String name,
      final Long pid,
      final Integer sort,
      final String parentOrgCode,
      final String orgCode,
      final Long oaDeptId,
      final Integer status,
      final Integer deptType
   ) {
      this.id = id;
      this.introduction = introduction;
      this.name = name;
      this.pid = pid;
      this.sort = sort;
      this.parentOrgCode = parentOrgCode;
      this.orgCode = orgCode;
      this.oaDeptId = oaDeptId;
      this.status = status;
      this.deptType = deptType;
   }

   public Department() {
   }

   public static class DepartmentBuilder {
      private Long id;
      private String introduction;
      private String name;
      private Long pid;
      private Integer sort;
      private String parentOrgCode;
      private String orgCode;
      private Long oaDeptId;
      private Integer status;
      private Integer deptType;

      DepartmentBuilder() {
      }

      public Department.DepartmentBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public Department.DepartmentBuilder introduction(final String introduction) {
         this.introduction = introduction;
         return this;
      }

      public Department.DepartmentBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public Department.DepartmentBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public Department.DepartmentBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public Department.DepartmentBuilder parentOrgCode(final String parentOrgCode) {
         this.parentOrgCode = parentOrgCode;
         return this;
      }

      public Department.DepartmentBuilder orgCode(final String orgCode) {
         this.orgCode = orgCode;
         return this;
      }

      public Department.DepartmentBuilder oaDeptId(final Long oaDeptId) {
         this.oaDeptId = oaDeptId;
         return this;
      }

      public Department.DepartmentBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public Department.DepartmentBuilder deptType(final Integer deptType) {
         this.deptType = deptType;
         return this;
      }

      public Department build() {
         return new Department(
            this.id, this.introduction, this.name, this.pid, this.sort, this.parentOrgCode, this.orgCode, this.oaDeptId, this.status, this.deptType
         );
      }

      @Override
      public String toString() {
         return "Department.DepartmentBuilder(id="
            + this.id
            + ", introduction="
            + this.introduction
            + ", name="
            + this.name
            + ", pid="
            + this.pid
            + ", sort="
            + this.sort
            + ", parentOrgCode="
            + this.parentOrgCode
            + ", orgCode="
            + this.orgCode
            + ", oaDeptId="
            + this.oaDeptId
            + ", status="
            + this.status
            + ", deptType="
            + this.deptType
            + ")";
      }
   }
}
