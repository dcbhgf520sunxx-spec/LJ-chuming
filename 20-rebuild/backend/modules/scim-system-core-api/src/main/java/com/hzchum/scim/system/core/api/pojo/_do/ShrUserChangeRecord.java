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

@Entity
@ApiModel(value = "shrUser变化记录表对象", description = "")
@TableName("shr_user_change_record")
@Table(name = "shr_user_change_record")
public class ShrUserChangeRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "deptName", value = "部门名称")
   @TableField("dept_name")
   @Column(name = "dept_name", columnDefinition = "varchar(512) comment '部门名称'")
   private String deptName;
   @ApiModelProperty(name = "jobName", value = "岗位名称")
   @TableField("job_name")
   @Column(name = "job_name", columnDefinition = "varchar(512) comment '岗位名称'")
   private String jobName;
   @ApiModelProperty(name = "name", value = "姓名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '姓名'")
   private String name;
   @ApiModelProperty(name = "phone", value = "电话号码")
   @TableField("phone")
   @Column(name = "phone", columnDefinition = "varchar(255) comment '电话号码'")
   private String phone;
   @ApiModelProperty(name = "userType", value = "用户类型")
   @TableField("user_type")
   @Column(name = "user_type", columnDefinition = "int(11) default 1 comment '用户类型 1编制内 4编制外。UserTypeEnum'")
   private Integer userType;
   @ApiModelProperty(name = "crudType", value = "操作类型")
   @TableField("crud_type")
   @Column(name = "crud_type", columnDefinition = "int(11) default 1 comment '用户类型 1新增 2修改。UserTypeEnum'")
   private Integer crudType;

   public static ShrUserChangeRecord.ShrUserChangeRecordBuilder builder() {
      return new ShrUserChangeRecord.ShrUserChangeRecordBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public String getJobName() {
      return this.jobName;
   }

   public String getName() {
      return this.name;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getUserType() {
      return this.userType;
   }

   public Integer getCrudType() {
      return this.crudType;
   }

   public ShrUserChangeRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public ShrUserChangeRecord setDeptName(final String deptName) {
      this.deptName = deptName;
      return this;
   }

   public ShrUserChangeRecord setJobName(final String jobName) {
      this.jobName = jobName;
      return this;
   }

   public ShrUserChangeRecord setName(final String name) {
      this.name = name;
      return this;
   }

   public ShrUserChangeRecord setPhone(final String phone) {
      this.phone = phone;
      return this;
   }

   public ShrUserChangeRecord setUserType(final Integer userType) {
      this.userType = userType;
      return this;
   }

   public ShrUserChangeRecord setCrudType(final Integer crudType) {
      this.crudType = crudType;
      return this;
   }

   @Override
   public String toString() {
      return "ShrUserChangeRecord(id="
         + this.getId()
         + ", deptName="
         + this.getDeptName()
         + ", jobName="
         + this.getJobName()
         + ", name="
         + this.getName()
         + ", phone="
         + this.getPhone()
         + ", userType="
         + this.getUserType()
         + ", crudType="
         + this.getCrudType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShrUserChangeRecord)) {
         return false;
      }

      ShrUserChangeRecord other = (ShrUserChangeRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userType = this.getUserType();
         Object other$userType = other.getUserType();
         if (this$userType == null ? other$userType == null : this$userType.equals(other$userType)) {
            Object this$crudType = this.getCrudType();
            Object other$crudType = other.getCrudType();
            if (this$crudType == null ? other$crudType == null : this$crudType.equals(other$crudType)) {
               Object this$deptName = this.getDeptName();
               Object other$deptName = other.getDeptName();
               if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                  Object this$jobName = this.getJobName();
                  Object other$jobName = other.getJobName();
                  if (this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName)) {
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
      return other instanceof ShrUserChangeRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userType = this.getUserType();
      result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
      Object $crudType = this.getCrudType();
      result = result * 59 + ($crudType == null ? 43 : $crudType.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      return result * 59 + ($phone == null ? 43 : $phone.hashCode());
   }

   public ShrUserChangeRecord(
      final Long id, final String deptName, final String jobName, final String name, final String phone, final Integer userType, final Integer crudType
   ) {
      this.id = id;
      this.deptName = deptName;
      this.jobName = jobName;
      this.name = name;
      this.phone = phone;
      this.userType = userType;
      this.crudType = crudType;
   }

   public ShrUserChangeRecord() {
   }

   public static class ShrUserChangeRecordBuilder {
      private Long id;
      private String deptName;
      private String jobName;
      private String name;
      private String phone;
      private Integer userType;
      private Integer crudType;

      ShrUserChangeRecordBuilder() {
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder userType(final Integer userType) {
         this.userType = userType;
         return this;
      }

      public ShrUserChangeRecord.ShrUserChangeRecordBuilder crudType(final Integer crudType) {
         this.crudType = crudType;
         return this;
      }

      public ShrUserChangeRecord build() {
         return new ShrUserChangeRecord(this.id, this.deptName, this.jobName, this.name, this.phone, this.userType, this.crudType);
      }

      @Override
      public String toString() {
         return "ShrUserChangeRecord.ShrUserChangeRecordBuilder(id="
            + this.id
            + ", deptName="
            + this.deptName
            + ", jobName="
            + this.jobName
            + ", name="
            + this.name
            + ", phone="
            + this.phone
            + ", userType="
            + this.userType
            + ", crudType="
            + this.crudType
            + ")";
      }
   }
}
