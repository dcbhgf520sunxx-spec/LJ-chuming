package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回对象")
public class ZhongNanUserInfoDTO {
   @JsonProperty("人员id")
   private String id;
   @JsonProperty("人员名称")
   private String lastname;
   @JsonProperty("性别")
   private String sex;
   @JsonProperty("身份证号")
   private String certificatenum;
   @JsonProperty("分部id")
   private String subcompanyid1;
   @JsonProperty("分部编码")
   private String subcompanycode;
   @JsonProperty("分部名称")
   private String subcompanyname;
   @JsonProperty("部门Id")
   private String departmentid;
   @JsonProperty("部门编码")
   private String departmentcode;
   @JsonProperty("部门名称")
   private String departmentname;
   @JsonProperty("岗位id")
   private String jobtitle;
   @JsonProperty("编号")
   private String workcode;
   @JsonProperty("手机号")
   private String mobile;
   @JsonProperty("邮箱")
   private String email;
   @JsonProperty("登入名")
   private String loginid;
   @JsonProperty("状态(状态: 0 试用 1 正式 2 临时 3 试用延期 4 解聘 5 离职 6 退休 7 无效 )")
   private String status;

   public static ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder builder() {
      return new ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder();
   }

   public ZhongNanUserInfoDTO() {
   }

   public ZhongNanUserInfoDTO(
      final String id,
      final String lastname,
      final String sex,
      final String certificatenum,
      final String subcompanyid1,
      final String subcompanycode,
      final String subcompanyname,
      final String departmentid,
      final String departmentcode,
      final String departmentname,
      final String jobtitle,
      final String workcode,
      final String mobile,
      final String email,
      final String loginid,
      final String status
   ) {
      this.id = id;
      this.lastname = lastname;
      this.sex = sex;
      this.certificatenum = certificatenum;
      this.subcompanyid1 = subcompanyid1;
      this.subcompanycode = subcompanycode;
      this.subcompanyname = subcompanyname;
      this.departmentid = departmentid;
      this.departmentcode = departmentcode;
      this.departmentname = departmentname;
      this.jobtitle = jobtitle;
      this.workcode = workcode;
      this.mobile = mobile;
      this.email = email;
      this.loginid = loginid;
      this.status = status;
   }

   public String getId() {
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

   public String getSubcompanyid1() {
      return this.subcompanyid1;
   }

   public String getSubcompanycode() {
      return this.subcompanycode;
   }

   public String getSubcompanyname() {
      return this.subcompanyname;
   }

   public String getDepartmentid() {
      return this.departmentid;
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

   public String getMobile() {
      return this.mobile;
   }

   public String getEmail() {
      return this.email;
   }

   public String getLoginid() {
      return this.loginid;
   }

   public String getStatus() {
      return this.status;
   }

   @JsonProperty("人员id")
   public ZhongNanUserInfoDTO setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("人员名称")
   public ZhongNanUserInfoDTO setLastname(final String lastname) {
      this.lastname = lastname;
      return this;
   }

   @JsonProperty("性别")
   public ZhongNanUserInfoDTO setSex(final String sex) {
      this.sex = sex;
      return this;
   }

   @JsonProperty("身份证号")
   public ZhongNanUserInfoDTO setCertificatenum(final String certificatenum) {
      this.certificatenum = certificatenum;
      return this;
   }

   @JsonProperty("分部id")
   public ZhongNanUserInfoDTO setSubcompanyid1(final String subcompanyid1) {
      this.subcompanyid1 = subcompanyid1;
      return this;
   }

   @JsonProperty("分部编码")
   public ZhongNanUserInfoDTO setSubcompanycode(final String subcompanycode) {
      this.subcompanycode = subcompanycode;
      return this;
   }

   @JsonProperty("分部名称")
   public ZhongNanUserInfoDTO setSubcompanyname(final String subcompanyname) {
      this.subcompanyname = subcompanyname;
      return this;
   }

   @JsonProperty("部门Id")
   public ZhongNanUserInfoDTO setDepartmentid(final String departmentid) {
      this.departmentid = departmentid;
      return this;
   }

   @JsonProperty("部门编码")
   public ZhongNanUserInfoDTO setDepartmentcode(final String departmentcode) {
      this.departmentcode = departmentcode;
      return this;
   }

   @JsonProperty("部门名称")
   public ZhongNanUserInfoDTO setDepartmentname(final String departmentname) {
      this.departmentname = departmentname;
      return this;
   }

   @JsonProperty("岗位id")
   public ZhongNanUserInfoDTO setJobtitle(final String jobtitle) {
      this.jobtitle = jobtitle;
      return this;
   }

   @JsonProperty("编号")
   public ZhongNanUserInfoDTO setWorkcode(final String workcode) {
      this.workcode = workcode;
      return this;
   }

   @JsonProperty("手机号")
   public ZhongNanUserInfoDTO setMobile(final String mobile) {
      this.mobile = mobile;
      return this;
   }

   @JsonProperty("邮箱")
   public ZhongNanUserInfoDTO setEmail(final String email) {
      this.email = email;
      return this;
   }

   @JsonProperty("登入名")
   public ZhongNanUserInfoDTO setLoginid(final String loginid) {
      this.loginid = loginid;
      return this;
   }

   @JsonProperty("状态(状态: 0 试用 1 正式 2 临时 3 试用延期 4 解聘 5 离职 6 退休 7 无效 )")
   public ZhongNanUserInfoDTO setStatus(final String status) {
      this.status = status;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanUserInfoDTO)) {
         return false;
      }

      ZhongNanUserInfoDTO other = (ZhongNanUserInfoDTO)o;
      if (!other.canEqual(this)) {
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
                  Object this$subcompanyid1 = this.getSubcompanyid1();
                  Object other$subcompanyid1 = other.getSubcompanyid1();
                  if (this$subcompanyid1 == null ? other$subcompanyid1 == null : this$subcompanyid1.equals(other$subcompanyid1)) {
                     Object this$subcompanycode = this.getSubcompanycode();
                     Object other$subcompanycode = other.getSubcompanycode();
                     if (this$subcompanycode == null ? other$subcompanycode == null : this$subcompanycode.equals(other$subcompanycode)) {
                        Object this$subcompanyname = this.getSubcompanyname();
                        Object other$subcompanyname = other.getSubcompanyname();
                        if (this$subcompanyname == null ? other$subcompanyname == null : this$subcompanyname.equals(other$subcompanyname)) {
                           Object this$departmentid = this.getDepartmentid();
                           Object other$departmentid = other.getDepartmentid();
                           if (this$departmentid == null ? other$departmentid == null : this$departmentid.equals(other$departmentid)) {
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
                                          Object this$mobile = this.getMobile();
                                          Object other$mobile = other.getMobile();
                                          if (this$mobile == null ? other$mobile == null : this$mobile.equals(other$mobile)) {
                                             Object this$email = this.getEmail();
                                             Object other$email = other.getEmail();
                                             if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                                                Object this$loginid = this.getLoginid();
                                                Object other$loginid = other.getLoginid();
                                                if (this$loginid == null ? other$loginid == null : this$loginid.equals(other$loginid)) {
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
      return other instanceof ZhongNanUserInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $lastname = this.getLastname();
      result = result * 59 + ($lastname == null ? 43 : $lastname.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $certificatenum = this.getCertificatenum();
      result = result * 59 + ($certificatenum == null ? 43 : $certificatenum.hashCode());
      Object $subcompanyid1 = this.getSubcompanyid1();
      result = result * 59 + ($subcompanyid1 == null ? 43 : $subcompanyid1.hashCode());
      Object $subcompanycode = this.getSubcompanycode();
      result = result * 59 + ($subcompanycode == null ? 43 : $subcompanycode.hashCode());
      Object $subcompanyname = this.getSubcompanyname();
      result = result * 59 + ($subcompanyname == null ? 43 : $subcompanyname.hashCode());
      Object $departmentid = this.getDepartmentid();
      result = result * 59 + ($departmentid == null ? 43 : $departmentid.hashCode());
      Object $departmentcode = this.getDepartmentcode();
      result = result * 59 + ($departmentcode == null ? 43 : $departmentcode.hashCode());
      Object $departmentname = this.getDepartmentname();
      result = result * 59 + ($departmentname == null ? 43 : $departmentname.hashCode());
      Object $jobtitle = this.getJobtitle();
      result = result * 59 + ($jobtitle == null ? 43 : $jobtitle.hashCode());
      Object $workcode = this.getWorkcode();
      result = result * 59 + ($workcode == null ? 43 : $workcode.hashCode());
      Object $mobile = this.getMobile();
      result = result * 59 + ($mobile == null ? 43 : $mobile.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $loginid = this.getLoginid();
      result = result * 59 + ($loginid == null ? 43 : $loginid.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanUserInfoDTO(id="
         + this.getId()
         + ", lastname="
         + this.getLastname()
         + ", sex="
         + this.getSex()
         + ", certificatenum="
         + this.getCertificatenum()
         + ", subcompanyid1="
         + this.getSubcompanyid1()
         + ", subcompanycode="
         + this.getSubcompanycode()
         + ", subcompanyname="
         + this.getSubcompanyname()
         + ", departmentid="
         + this.getDepartmentid()
         + ", departmentcode="
         + this.getDepartmentcode()
         + ", departmentname="
         + this.getDepartmentname()
         + ", jobtitle="
         + this.getJobtitle()
         + ", workcode="
         + this.getWorkcode()
         + ", mobile="
         + this.getMobile()
         + ", email="
         + this.getEmail()
         + ", loginid="
         + this.getLoginid()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class ZhongNanUserInfoDTOBuilder {
      private String id;
      private String lastname;
      private String sex;
      private String certificatenum;
      private String subcompanyid1;
      private String subcompanycode;
      private String subcompanyname;
      private String departmentid;
      private String departmentcode;
      private String departmentname;
      private String jobtitle;
      private String workcode;
      private String mobile;
      private String email;
      private String loginid;
      private String status;

      ZhongNanUserInfoDTOBuilder() {
      }

      @JsonProperty("人员id")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("人员名称")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder lastname(final String lastname) {
         this.lastname = lastname;
         return this;
      }

      @JsonProperty("性别")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder sex(final String sex) {
         this.sex = sex;
         return this;
      }

      @JsonProperty("身份证号")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder certificatenum(final String certificatenum) {
         this.certificatenum = certificatenum;
         return this;
      }

      @JsonProperty("分部id")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder subcompanyid1(final String subcompanyid1) {
         this.subcompanyid1 = subcompanyid1;
         return this;
      }

      @JsonProperty("分部编码")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder subcompanycode(final String subcompanycode) {
         this.subcompanycode = subcompanycode;
         return this;
      }

      @JsonProperty("分部名称")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder subcompanyname(final String subcompanyname) {
         this.subcompanyname = subcompanyname;
         return this;
      }

      @JsonProperty("部门Id")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder departmentid(final String departmentid) {
         this.departmentid = departmentid;
         return this;
      }

      @JsonProperty("部门编码")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder departmentcode(final String departmentcode) {
         this.departmentcode = departmentcode;
         return this;
      }

      @JsonProperty("部门名称")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder departmentname(final String departmentname) {
         this.departmentname = departmentname;
         return this;
      }

      @JsonProperty("岗位id")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder jobtitle(final String jobtitle) {
         this.jobtitle = jobtitle;
         return this;
      }

      @JsonProperty("编号")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder workcode(final String workcode) {
         this.workcode = workcode;
         return this;
      }

      @JsonProperty("手机号")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder mobile(final String mobile) {
         this.mobile = mobile;
         return this;
      }

      @JsonProperty("邮箱")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder email(final String email) {
         this.email = email;
         return this;
      }

      @JsonProperty("登入名")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder loginid(final String loginid) {
         this.loginid = loginid;
         return this;
      }

      @JsonProperty("状态(状态: 0 试用 1 正式 2 临时 3 试用延期 4 解聘 5 离职 6 退休 7 无效 )")
      public ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public ZhongNanUserInfoDTO build() {
         return new ZhongNanUserInfoDTO(
            this.id,
            this.lastname,
            this.sex,
            this.certificatenum,
            this.subcompanyid1,
            this.subcompanycode,
            this.subcompanyname,
            this.departmentid,
            this.departmentcode,
            this.departmentname,
            this.jobtitle,
            this.workcode,
            this.mobile,
            this.email,
            this.loginid,
            this.status
         );
      }

      @Override
      public String toString() {
         return "ZhongNanUserInfoDTO.ZhongNanUserInfoDTOBuilder(id="
            + this.id
            + ", lastname="
            + this.lastname
            + ", sex="
            + this.sex
            + ", certificatenum="
            + this.certificatenum
            + ", subcompanyid1="
            + this.subcompanyid1
            + ", subcompanycode="
            + this.subcompanycode
            + ", subcompanyname="
            + this.subcompanyname
            + ", departmentid="
            + this.departmentid
            + ", departmentcode="
            + this.departmentcode
            + ", departmentname="
            + this.departmentname
            + ", jobtitle="
            + this.jobtitle
            + ", workcode="
            + this.workcode
            + ", mobile="
            + this.mobile
            + ", email="
            + this.email
            + ", loginid="
            + this.loginid
            + ", status="
            + this.status
            + ")";
      }
   }
}
