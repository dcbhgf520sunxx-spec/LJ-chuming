package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Job对象", description = "岗位表")
@Entity
@TableName("sys_job")
@Table(name = "sys_job")
public class Job extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "dept_id")
   @JsonProperty("dept_id")
   @JSONField(name = "dept_id")
   @TableField("dept_id")
   @Column(name = "dept_id")
   private Long deptId;
   @ApiModelProperty(name = "enabled")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled")
   private Integer enabled;
   @ApiModelProperty(name = "is_admin")
   @JsonProperty("is_admin")
   @JSONField(name = "is_admin")
   @TableField("is_admin")
   @Column(name = "is_admin")
   private Integer isAdmin;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "sort")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "jobType", value = "岗位类型")
   @TableField("job_type")
   @Column(name = "job_type", columnDefinition = "int(11) default 1 comment '岗位类型 1编制内 2编制外'")
   private Integer jobType;
   @ApiModelProperty(name = "orgCode", value = "SHR部门编码")
   @TableField("org_code")
   @Column(name = "org_code", columnDefinition = "varchar(50) comment 'SHR部门编码'")
   private String orgCode;
   @ApiModelProperty(name = "positionCode", value = "SHR岗位编码")
   @TableField("position_code")
   @Column(name = "position_code", columnDefinition = "varchar(50) comment 'SHR岗位编码'")
   private String positionCode;

   public static Job.JobBuilder builder() {
      return new Job.JobBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Integer getIsAdmin() {
      return this.isAdmin;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getJobType() {
      return this.jobType;
   }

   public String getOrgCode() {
      return this.orgCode;
   }

   public String getPositionCode() {
      return this.positionCode;
   }

   @JsonProperty("id")
   public Job setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("dept_id")
   public Job setDeptId(final Long deptId) {
      this.deptId = deptId;
      return this;
   }

   @JsonProperty("enabled")
   public Job setEnabled(final Integer enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("is_admin")
   public Job setIsAdmin(final Integer isAdmin) {
      this.isAdmin = isAdmin;
      return this;
   }

   @JsonProperty("name")
   public Job setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public Job setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public Job setJobType(final Integer jobType) {
      this.jobType = jobType;
      return this;
   }

   public Job setOrgCode(final String orgCode) {
      this.orgCode = orgCode;
      return this;
   }

   public Job setPositionCode(final String positionCode) {
      this.positionCode = positionCode;
      return this;
   }

   @Override
   public String toString() {
      return "Job(id="
         + this.getId()
         + ", deptId="
         + this.getDeptId()
         + ", enabled="
         + this.getEnabled()
         + ", isAdmin="
         + this.getIsAdmin()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", jobType="
         + this.getJobType()
         + ", orgCode="
         + this.getOrgCode()
         + ", positionCode="
         + this.getPositionCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Job)) {
         return false;
      }

      Job other = (Job)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$deptId = this.getDeptId();
         Object other$deptId = other.getDeptId();
         if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
            Object this$enabled = this.getEnabled();
            Object other$enabled = other.getEnabled();
            if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
               Object this$isAdmin = this.getIsAdmin();
               Object other$isAdmin = other.getIsAdmin();
               if (this$isAdmin == null ? other$isAdmin == null : this$isAdmin.equals(other$isAdmin)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$jobType = this.getJobType();
                     Object other$jobType = other.getJobType();
                     if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$orgCode = this.getOrgCode();
                           Object other$orgCode = other.getOrgCode();
                           if (this$orgCode == null ? other$orgCode == null : this$orgCode.equals(other$orgCode)) {
                              Object this$positionCode = this.getPositionCode();
                              Object other$positionCode = other.getPositionCode();
                              return this$positionCode == null ? other$positionCode == null : this$positionCode.equals(other$positionCode);
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
      return other instanceof Job;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $isAdmin = this.getIsAdmin();
      result = result * 59 + ($isAdmin == null ? 43 : $isAdmin.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $orgCode = this.getOrgCode();
      result = result * 59 + ($orgCode == null ? 43 : $orgCode.hashCode());
      Object $positionCode = this.getPositionCode();
      return result * 59 + ($positionCode == null ? 43 : $positionCode.hashCode());
   }

   public Job(
      final Long id,
      final Long deptId,
      final Integer enabled,
      final Integer isAdmin,
      final String name,
      final Integer sort,
      final Integer jobType,
      final String orgCode,
      final String positionCode
   ) {
      this.id = id;
      this.deptId = deptId;
      this.enabled = enabled;
      this.isAdmin = isAdmin;
      this.name = name;
      this.sort = sort;
      this.jobType = jobType;
      this.orgCode = orgCode;
      this.positionCode = positionCode;
   }

   public Job() {
   }

   public static class JobBuilder {
      private Long id;
      private Long deptId;
      private Integer enabled;
      private Integer isAdmin;
      private String name;
      private Integer sort;
      private Integer jobType;
      private String orgCode;
      private String positionCode;

      JobBuilder() {
      }

      @JsonProperty("id")
      public Job.JobBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("dept_id")
      public Job.JobBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      @JsonProperty("enabled")
      public Job.JobBuilder enabled(final Integer enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("is_admin")
      public Job.JobBuilder isAdmin(final Integer isAdmin) {
         this.isAdmin = isAdmin;
         return this;
      }

      @JsonProperty("name")
      public Job.JobBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public Job.JobBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public Job.JobBuilder jobType(final Integer jobType) {
         this.jobType = jobType;
         return this;
      }

      public Job.JobBuilder orgCode(final String orgCode) {
         this.orgCode = orgCode;
         return this;
      }

      public Job.JobBuilder positionCode(final String positionCode) {
         this.positionCode = positionCode;
         return this;
      }

      public Job build() {
         return new Job(this.id, this.deptId, this.enabled, this.isAdmin, this.name, this.sort, this.jobType, this.orgCode, this.positionCode);
      }

      @Override
      public String toString() {
         return "Job.JobBuilder(id="
            + this.id
            + ", deptId="
            + this.deptId
            + ", enabled="
            + this.enabled
            + ", isAdmin="
            + this.isAdmin
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", jobType="
            + this.jobType
            + ", orgCode="
            + this.orgCode
            + ", positionCode="
            + this.positionCode
            + ")";
      }
   }
}
