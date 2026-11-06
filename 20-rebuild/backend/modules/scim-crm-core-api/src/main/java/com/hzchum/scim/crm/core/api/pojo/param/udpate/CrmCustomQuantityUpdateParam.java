package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmCustomQuantityUpdateParam {
   @ApiModelProperty(name = "userIds", value = "人员id", notes = "人员id")
   private List<Long> userIds;
   @ApiModelProperty(name = "projectQuota", value = "可挂载项目数量", notes = "可挂载项目数量")
   private Integer projectQuota;

   public CrmCustomQuantityUpdateParam(final List<Long> userIds, final Integer projectQuota) {
      this.userIds = userIds;
      this.projectQuota = projectQuota;
   }

   public CrmCustomQuantityUpdateParam() {
   }

   public List<Long> getUserIds() {
      return this.userIds;
   }

   public Integer getProjectQuota() {
      return this.projectQuota;
   }

   public void setUserIds(final List<Long> userIds) {
      this.userIds = userIds;
   }

   public void setProjectQuota(final Integer projectQuota) {
      this.projectQuota = projectQuota;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmCustomQuantityUpdateParam)) {
         return false;
      } else {
         CrmCustomQuantityUpdateParam other = (CrmCustomQuantityUpdateParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectQuota = this.getProjectQuota();
            Object other$projectQuota = other.getProjectQuota();
            if (this$projectQuota == null ? other$projectQuota == null : this$projectQuota.equals(other$projectQuota)) {
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
      return other instanceof CrmCustomQuantityUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectQuota = this.getProjectQuota();
      result = result * 59 + ($projectQuota == null ? 43 : $projectQuota.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   @Override
   public String toString() {
      return "CrmCustomQuantityUpdateParam(userIds=" + this.getUserIds() + ", projectQuota=" + this.getProjectQuota() + ")";
   }
}
