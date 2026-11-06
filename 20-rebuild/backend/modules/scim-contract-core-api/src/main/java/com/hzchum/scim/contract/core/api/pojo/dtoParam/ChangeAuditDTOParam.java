package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("项目变更审核类")
public class ChangeAuditDTOParam {
   @ApiModelProperty(name = "id", value = "项目变更id")
   @NotNull(message = "项目变更id不能为空")
   private Long id;
   @ApiModelProperty(name = "auditStatus", value = "审核状态")
   @Min(value = 2L, message = "审核状态传值错误! 2审核通过 4审核驳回")
   @Max(value = 4L, message = "审核状态传值错误! 2审核通过 4审核驳回")
   @NotNull(message = "审核状态不能为空")
   private Integer auditStatus;
   @ApiModelProperty(name = "remark", value = "审核说明")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeAuditDTOParam)) {
         return false;
      }

      ChangeAuditDTOParam other = (ChangeAuditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ChangeAuditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeAuditDTOParam(id=" + this.getId() + ", auditStatus=" + this.getAuditStatus() + ", remark=" + this.getRemark() + ")";
   }
}
