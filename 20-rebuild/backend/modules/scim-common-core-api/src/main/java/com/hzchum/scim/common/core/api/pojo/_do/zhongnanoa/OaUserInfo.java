package com.hzchum.scim.common.core.api.pojo._do.zhongnanoa;

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

@ApiModel(value = "中南oa用户", description = "中南oa用户")
@Entity
@TableName("oa_user_info")
@Table(name = "oa_user_info")
@org.hibernate.annotations.Table(appliesTo = "oa_user_info", comment = "中南oa用户")
public class OaUserInfo extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "lastname", value = "人员名称", notes = "人员名称")
   @TableField("last_name")
   @Column(name = "last_name", columnDefinition = "varchar(20) COMMENT '人员名称'")
   private String lastname;
   @JsonProperty("性别")
   @JSONField(name = "sex")
   @TableField("sex")
   @Column(name = "sex", columnDefinition = "varchar(20) COMMENT '性别'")
   private String sex;
   @JsonProperty("身份证号")
   @JSONField(name = "certificatenum")
   @TableField("certificatenum")
   @Column(name = "certificatenum", columnDefinition = "varchar(20) COMMENT '身份证号'")
   private String certificatenum;
   @JsonProperty("分部编码")
   @JSONField(name = "subcompanycode")
   @TableField("subcompany_code")
   @Column(name = "subcompany_code", columnDefinition = "varchar(20) COMMENT '分部编码'")
   private String subcompanycode;
   @JsonProperty("分部名称")
   @JSONField(name = "subcompanyname")
   @TableField("subcompany_name")
   @Column(name = "subcompany_name", columnDefinition = "varchar(20) COMMENT '分部名称'")
   private String subcompanyname;
   @JsonProperty("部门编码")
   @JSONField(name = "departmentcode")
   @TableField("department_code")
   @Column(name = "department_code", columnDefinition = "varchar(20) COMMENT '部门编码'")
   private String departmentcode;
   @JsonProperty("部门名称")
   @JSONField(name = "departmentname")
   @TableField("department_name")
   @Column(name = "department_name", columnDefinition = "varchar(20) COMMENT '部门名称'")
   private String departmentname;
   @JsonProperty("岗位id")
   @JSONField(name = "jobtitle")
   @TableField("jobtitle")
   @Column(name = "jobtitle", columnDefinition = "varchar(20) COMMENT '岗位id'")
   private String jobtitle;
   @JsonProperty("编号")
   @JSONField(name = "workcode")
   @TableField("work_code")
   @Column(name = "work_code", columnDefinition = "varchar(20) COMMENT '编号'")
   private String workcode;
   @JsonProperty("状态(状态: 0 试用 1 正式 2 临时 3 试用延期 4 解聘 5 离职 6 退休 7 无效 )")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "varchar(20) COMMENT '状态'")
   private String status;

   public static OaUserInfo.OaUserInfoBuilder builder() {
      return new OaUserInfo.OaUserInfoBuilder();
   }

   public OaUserInfo() {
   }

   public OaUserInfo(
      final Long id,
      final String lastname,
      final String sex,
      final String certificatenum,
      final String subcompanycode,
      final String subcompanyname,
      final String departmentcode,
      final String departmentname,
      final String jobtitle,
      final String workcode,
      final String status
   ) {
      this.id = id;
      this.lastname = lastname;
      this.sex = sex;
      this.certificatenum = certificatenum;
      this.subcompanycode = subcompanycode;
      this.subcompanyname = subcompanyname;
      this.departmentcode = departmentcode;
      this.departmentname = departmentname;
      this.jobtitle = jobtitle;
      this.workcode = workcode;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getLastname() {
      return this.lastname;
   }

   public String getSex() {
      return this.sex;
   }

   public String getCertificatenum() {
      return this.certificatenum;
   }

   public String getSubcompanycode() {
      return this.subcompanycode;
   }

   public String getSubcompanyname() {
      return this.subcompanyname;
   }

   public String getDepartmentcode() {
      return this.departmentcode;
   }

   public String getDepartmentname() {
      return this.departmentname;
   }

   public String getJobtitle() {
      return this.jobtitle;
   }

   public String getWorkcode() {
      return this.workcode;
   }

   public String getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public OaUserInfo setId(final Long id) {
      this.id = id;
      return this;
   }

   public OaUserInfo setLastname(final String lastname) {
      this.lastname = lastname;
      return this;
   }

   @JsonProperty("性别")
   public OaUserInfo setSex(final String sex) {
      this.sex = sex;
      return this;
   }

   @JsonProperty("身份证号")
   public OaUserInfo setCertificatenum(final String certificatenum) {
      this.certificatenum = certificatenum;
      return this;
   }

   @JsonProperty("分部编码")
   public OaUserInfo setSubcompanycode(final String subcompanycode) {
      this.subcompanycode = subcompanycode;
      return this;
   }

   @JsonProperty("分部名称")
   public OaUserInfo setSubcompanyname(final String subcompanyname) {
      this.subcompanyname = subcompanyname;
      return this;
   }

   @JsonProperty("部门编码")
   public OaUserInfo setDepartmentcode(final String departmentcode) {
      this.departmentcode = departmentcode;
      return this;
   }

   @JsonProperty("部门名称")
   public OaUserInfo setDepartmentname(final String departmentname) {
      this.departmentname = departmentname;
      return this;
   }

   @JsonProperty("岗位id")
   public OaUserInfo setJobtitle(final String jobtitle) {
      this.jobtitle = jobtitle;
      return this;
   }

   @JsonProperty("编号")
   public OaUserInfo setWorkcode(final String workcode) {
      this.workcode = workcode;
      return this;
   }

   @JsonProperty("状态(状态: 0 试用 1 正式 2 临时 3 试用延期 4 解聘 5 离职 6 退休 7 无效 )")
   public OaUserInfo setStatus(final String status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "OaUserInfo(id="
         + this.getId()
         + ", lastname="
         + this.getLastname()
         + ", sex="
         + this.getSex()
         + ", certificatenum="
         + this.getCertificatenum()
         + ", subcompanycode="
         + this.getSubcompanycode()
         + ", subcompanyname="
         + this.getSubcompanyname()
         + ", departmentcode="
         + this.getDepartmentcode()
         + ", departmentname="
         + this.getDepartmentname()
         + ", jobtitle="
         + this.getJobtitle()
         + ", workcode="
         + this.getWorkcode()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaUserInfo)) {
         return false;
      }

      OaUserInfo other = (OaUserInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$lastname = this.getLastname();
         Object other$lastname = other.getLastname();
         if (this$lastname == null ? other$lastname == null : this$lastname.equals(other$lastname)) {
            Object this$sex = this.getSex();
            Object other$sex = other.getSex();
            if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
               Object this$certificatenum = this.getCertificatenum();
               Object other$certificatenum = other.getCertificatenum();
               if (this$certificatenum == null ? other$certificatenum == null : this$certificatenum.equals(other$certificatenum)) {
                  Object this$subcompanycode = this.getSubcompanycode();
                  Object other$subcompanycode = other.getSubcompanycode();
                  if (this$subcompanycode == null ? other$subcompanycode == null : this$subcompanycode.equals(other$subcompanycode)) {
                     Object this$subcompanyname = this.getSubcompanyname();
                     Object other$subcompanyname = other.getSubcompanyname();
                     if (this$subcompanyname == null ? other$subcompanyname == null : this$subcompanyname.equals(other$subcompanyname)) {
                        Object this$departmentcode = this.getDepartmentcode();
                        Object other$departmentcode = other.getDepartmentcode();
                        if (this$departmentcode == null ? other$departmentcode == null : this$departmentcode.equals(other$departmentcode)) {
                           Object this$departmentname = this.getDepartmentname();
                           Object other$departmentname = other.getDepartmentname();
                           if (this$departmentname == null ? other$departmentname == null : this$departmentname.equals(other$departmentname)) {
                              Object this$jobtitle = this.getJobtitle();
                              Object other$jobtitle = other.getJobtitle();
                              if (this$jobtitle == null ? other$jobtitle == null : this$jobtitle.equals(other$jobtitle)) {
                                 Object this$workcode = this.getWorkcode();
                                 Object other$workcode = other.getWorkcode();
                                 if (this$workcode == null ? other$workcode == null : this$workcode.equals(other$workcode)) {
                                    Object this$status = this.getStatus();
                                    Object other$status = other.getStatus();
                                    return this$status == null ? other$status == null : this$status.equals(other$status);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof OaUserInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $lastname = this.getLastname();
      result = result * 59 + ($lastname == null ? 43 : $lastname.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $certificatenum = this.getCertificatenum();
      result = result * 59 + ($certificatenum == null ? 43 : $certificatenum.hashCode());
      Object $subcompanycode = this.getSubcompanycode();
      result = result * 59 + ($subcompanycode == null ? 43 : $subcompanycode.hashCode());
      Object $subcompanyname = this.getSubcompanyname();
      result = result * 59 + ($subcompanyname == null ? 43 : $subcompanyname.hashCode());
      Object $departmentcode = this.getDepartmentcode();
      result = result * 59 + ($departmentcode == null ? 43 : $departmentcode.hashCode());
      Object $departmentname = this.getDepartmentname();
      result = result * 59 + ($departmentname == null ? 43 : $departmentname.hashCode());
      Object $jobtitle = this.getJobtitle();
      result = result * 59 + ($jobtitle == null ? 43 : $jobtitle.hashCode());
      Object $workcode = this.getWorkcode();
      result = result * 59 + ($workcode == null ? 43 : $workcode.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   public static class OaUserInfoBuilder {
      private Long id;
      private String lastname;
      private String sex;
      private String certificatenum;
      private String subcompanycode;
      private String subcompanyname;
      private String departmentcode;
      private String departmentname;
      private String jobtitle;
      private String workcode;
      private String status;

      OaUserInfoBuilder() {
      }

      @JsonProperty("id")
      public OaUserInfo.OaUserInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OaUserInfo.OaUserInfoBuilder lastname(final String lastname) {
         this.lastname = lastname;
         return this;
      }

      @JsonProperty("性别")
      public OaUserInfo.OaUserInfoBuilder sex(final String sex) {
         this.sex = sex;
         return this;
      }

      @JsonProperty("身份证号")
      public OaUserInfo.OaUserInfoBuilder certificatenum(final String certificatenum) {
         this.certificatenum = certificatenum;
         return this;
      }

      @JsonProperty("分部编码")
      public OaUserInfo.OaUserInfoBuilder subcompanycode(final String subcompanycode) {
         this.subcompanycode = subcompanycode;
         return this;
      }

      @JsonProperty("分部名称")
      public OaUserInfo.OaUserInfoBuilder subcompanyname(final String subcompanyname) {
         this.subcompanyname = subcompanyname;
         return this;
      }

      @JsonProperty("部门编码")
      public OaUserInfo.OaUserInfoBuilder departmentcode(final String departmentcode) {
         this.departmentcode = departmentcode;
         return this;
      }

      @JsonProperty("部门名称")
      public OaUserInfo.OaUserInfoBuilder departmentname(final String departmentname) {
         this.departmentname = departmentname;
         return this;
      }

      @JsonProperty("岗位id")
      public OaUserInfo.OaUserInfoBuilder jobtitle(final String jobtitle) {
         this.jobtitle = jobtitle;
         return this;
      }

      @JsonProperty("编号")
      public OaUserInfo.OaUserInfoBuilder workcode(final String workcode) {
         this.workcode = workcode;
         return this;
      }

      @JsonProperty("状态(状态: 0 试用 1 正式 2 临时 3 试用延期 4 解聘 5 离职 6 退休 7 无效 )")
      public OaUserInfo.OaUserInfoBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public OaUserInfo build() {
         return new OaUserInfo(
            this.id,
            this.lastname,
            this.sex,
            this.certificatenum,
            this.subcompanycode,
            this.subcompanyname,
            this.departmentcode,
            this.departmentname,
            this.jobtitle,
            this.workcode,
            this.status
         );
      }

      @Override
      public String toString() {
         return "OaUserInfo.OaUserInfoBuilder(id="
            + this.id
            + ", lastname="
            + this.lastname
            + ", sex="
            + this.sex
            + ", certificatenum="
            + this.certificatenum
            + ", subcompanycode="
            + this.subcompanycode
            + ", subcompanyname="
            + this.subcompanyname
            + ", departmentcode="
            + this.departmentcode
            + ", departmentname="
            + this.departmentname
            + ", jobtitle="
            + this.jobtitle
            + ", workcode="
            + this.workcode
            + ", status="
            + this.status
            + ")";
      }
   }
}
