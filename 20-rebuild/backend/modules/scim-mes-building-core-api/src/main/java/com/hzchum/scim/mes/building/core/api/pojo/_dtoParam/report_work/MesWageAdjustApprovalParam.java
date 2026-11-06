package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("工价调整审批Param")
public class MesWageAdjustApprovalParam {
   @ApiModelProperty("工价调整id")
   @NotNull(message = "工价调整不能为空")
   private Long wageAdjustId;
   @ApiModelProperty("审批结果")
   @NotNull(message = "审批结果不能为空")
   @EnumValidator(value = CheckStatusEnum.class, message = "审批结果有误")
   private Integer approvalResult;
   @ApiModelProperty("备注")
   private String remark;

   public Long getWageAdjustId() {
      return this.wageAdjustId;
   }

   public Integer getApprovalResult() {
      return this.approvalResult;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setWageAdjustId(final Long wageAdjustId) {
      this.wageAdjustId = wageAdjustId;
   }

   public void setApprovalResult(final Integer approvalResult) {
      this.approvalResult = approvalResult;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustApprovalParam)) {
         return false;
      }

      MesWageAdjustApprovalParam other = (MesWageAdjustApprovalParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$wageAdjustId = this.getWageAdjustId();
      Object other$wageAdjustId = other.getWageAdjustId();
      if (this$wageAdjustId == null ? other$wageAdjustId == null : this$wageAdjustId.equals(other$wageAdjustId)) {
         Object this$approvalResult = this.getApprovalResult();
         Object other$approvalResult = other.getApprovalResult();
         if (this$approvalResult == null ? other$approvalResult == null : this$approvalResult.equals(other$approvalResult)) {
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
      return other instanceof MesWageAdjustApprovalParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $wageAdjustId = this.getWageAdjustId();
      result = result * 59 + ($wageAdjustId == null ? 43 : $wageAdjustId.hashCode());
      Object $approvalResult = this.getApprovalResult();
      result = result * 59 + ($approvalResult == null ? 43 : $approvalResult.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustApprovalParam(wageAdjustId="
         + this.getWageAdjustId()
         + ", approvalResult="
         + this.getApprovalResult()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
