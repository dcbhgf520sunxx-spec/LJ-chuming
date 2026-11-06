package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("整改报告-审核类")
public class ProjectQhseChangeAuditDTOParam {
   @ApiModelProperty("整改报告ID")
   @NotNull(message = "整改报告ID不能为空")
   Long id;
   @ApiModelProperty("审核状态 2通过 4驳回")
   @NotNull(message = "审核状态不能为空")
   Integer auditStatus;

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectQhseChangeAuditDTOParam)) {
         return false;
      } else {
         ProjectQhseChangeAuditDTOParam other = (ProjectQhseChangeAuditDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               return this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseChangeAuditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      return result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseChangeAuditDTOParam(id=" + this.getId() + ", auditStatus=" + this.getAuditStatus() + ")";
   }
}
