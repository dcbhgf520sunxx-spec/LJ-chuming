package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.Set;
import javax.validation.constraints.NotNull;

public class JobUserUpdateDTO {
   @NotNull(message = "岗位id不能为空")
   private Long jobId;
   private Set<Long> userIds;

   public Long getJobId() {
      return this.jobId;
   }

   public Set<Long> getUserIds() {
      return this.userIds;
   }

   public void setJobId(final Long jobId) {
      this.jobId = jobId;
   }

   public void setUserIds(final Set<Long> userIds) {
      this.userIds = userIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof JobUserUpdateDTO)) {
         return false;
      } else {
         JobUserUpdateDTO other = (JobUserUpdateDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$userIds = this.getUserIds();
               Object other$userIds = other.getUserIds();
               return this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof JobUserUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   @Override
   public String toString() {
      return "JobUserUpdateDTO(jobId=" + this.getJobId() + ", userIds=" + this.getUserIds() + ")";
   }
}
