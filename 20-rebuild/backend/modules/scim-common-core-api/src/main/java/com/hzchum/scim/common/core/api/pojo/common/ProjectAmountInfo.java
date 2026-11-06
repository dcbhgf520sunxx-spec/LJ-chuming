package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目-金额")
public class ProjectAmountInfo {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("金额")
   private BigDecimal amount;

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectAmountInfo)) {
         return false;
      } else {
         ProjectAmountInfo other = (ProjectAmountInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectAmountInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAmountInfo(projectId=" + this.getProjectId() + ", amount=" + this.getAmount() + ")";
   }
}
