package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("用户部门岗位信息返回类")
public class DeptUserResponseVO {
   @ApiModelProperty(name = "deptId", value = "部门id")
   private Long deptId;
   @ApiModelProperty(name = "deptName", value = "部门名称")
   private String deptName;
   @ApiModelProperty(name = "deptId", value = "岗位id")
   private Long jobId;
   @ApiModelProperty(name = "deptName", value = "岗位名称")
   private String jobName;
   @ApiModelProperty(name = "userList", value = "用户信息")
   private List<UserJobResponseVO> userList;

   public static DeptUserResponseVO.DeptUserResponseVOBuilder builder() {
      return new DeptUserResponseVO.DeptUserResponseVOBuilder();
   }

   public DeptUserResponseVO() {
   }

   public DeptUserResponseVO(final Long deptId, final String deptName, final Long jobId, final String jobName, final List<UserJobResponseVO> userList) {
      this.deptId = deptId;
      this.deptName = deptName;
      this.jobId = jobId;
      this.jobName = jobName;
      this.userList = userList;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public String getJobName() {
      return this.jobName;
   }

   public List<UserJobResponseVO> getUserList() {
      return this.userList;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setJobId(final Long jobId) {
      this.jobId = jobId;
   }

   public void setJobName(final String jobName) {
      this.jobName = jobName;
   }

   public void setUserList(final List<UserJobResponseVO> userList) {
      this.userList = userList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeptUserResponseVO)) {
         return false;
      }

      DeptUserResponseVO other = (DeptUserResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$deptId = this.getDeptId();
      Object other$deptId = other.getDeptId();
      if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$deptName = this.getDeptName();
            Object other$deptName = other.getDeptName();
            if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
               Object this$jobName = this.getJobName();
               Object other$jobName = other.getJobName();
               if (this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName)) {
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
      return other instanceof DeptUserResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $userList = this.getUserList();
      return result * 59 + ($userList == null ? 43 : $userList.hashCode());
   }

   @Override
   public String toString() {
      return "DeptUserResponseVO(deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", jobId="
         + this.getJobId()
         + ", jobName="
         + this.getJobName()
         + ", userList="
         + this.getUserList()
         + ")";
   }

   public static class DeptUserResponseVOBuilder {
      private Long deptId;
      private String deptName;
      private Long jobId;
      private String jobName;
      private List<UserJobResponseVO> userList;

      DeptUserResponseVOBuilder() {
      }

      public DeptUserResponseVO.DeptUserResponseVOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public DeptUserResponseVO.DeptUserResponseVOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public DeptUserResponseVO.DeptUserResponseVOBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      public DeptUserResponseVO.DeptUserResponseVOBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      public DeptUserResponseVO.DeptUserResponseVOBuilder userList(final List<UserJobResponseVO> userList) {
         this.userList = userList;
         return this;
      }

      public DeptUserResponseVO build() {
         return new DeptUserResponseVO(this.deptId, this.deptName, this.jobId, this.jobName, this.userList);
      }

      @Override
      public String toString() {
         return "DeptUserResponseVO.DeptUserResponseVOBuilder(deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ", jobId="
            + this.jobId
            + ", jobName="
            + this.jobName
            + ", userList="
            + this.userList
            + ")";
      }
   }
}
