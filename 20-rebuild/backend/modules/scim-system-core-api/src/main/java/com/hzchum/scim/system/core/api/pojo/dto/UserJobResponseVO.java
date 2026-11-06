package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户与岗位信息返回类")
public class UserJobResponseVO {
   @ApiModelProperty(name = "userId", value = "用户id")
   private Long userId;
   @ApiModelProperty(name = "deptName", value = "用户名称")
   private String userName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "JobId", value = "岗位id")
   private Long JobId;

   public static UserJobResponseVO.UserJobResponseVOBuilder builder() {
      return new UserJobResponseVO.UserJobResponseVOBuilder();
   }

   public UserJobResponseVO() {
   }

   public UserJobResponseVO(final Long userId, final String userName, final Long JobId) {
      this.userId = userId;
      this.userName = userName;
      this.JobId = JobId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getJobId() {
      return this.JobId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setJobId(final Long JobId) {
      this.JobId = JobId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserJobResponseVO)) {
         return false;
      }

      UserJobResponseVO other = (UserJobResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$JobId = this.getJobId();
         Object other$JobId = other.getJobId();
         if (this$JobId == null ? other$JobId == null : this$JobId.equals(other$JobId)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserJobResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $JobId = this.getJobId();
      result = result * 59 + ($JobId == null ? 43 : $JobId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "UserJobResponseVO(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", JobId=" + this.getJobId() + ")";
   }

   public static class UserJobResponseVOBuilder {
      private Long userId;
      private String userName;
      private Long JobId;

      UserJobResponseVOBuilder() {
      }

      public UserJobResponseVO.UserJobResponseVOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public UserJobResponseVO.UserJobResponseVOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public UserJobResponseVO.UserJobResponseVOBuilder JobId(final Long JobId) {
         this.JobId = JobId;
         return this;
      }

      public UserJobResponseVO build() {
         return new UserJobResponseVO(this.userId, this.userName, this.JobId);
      }

      @Override
      public String toString() {
         return "UserJobResponseVO.UserJobResponseVOBuilder(userId=" + this.userId + ", userName=" + this.userName + ", JobId=" + this.JobId + ")";
      }
   }
}
