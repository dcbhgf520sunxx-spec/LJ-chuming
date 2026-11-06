package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("点工审批参数")
public class MesTempWorkApprovalParam {
   @ApiModelProperty("点工ID")
   @NotNull(message = "点工ID不能为空")
   private Long tempWorkId;
   @ApiModelProperty("核算金额(元)")
   @NotNull(message = "核算金额不能为空")
   @Positive(message = "核算金额必须大于0")
   private BigDecimal calculateAmount;
   @ApiModelProperty("审批结果")
   @NotNull(message = "审批结果不能为空")
   @EnumValidator(value = CheckStatusEnum.class, message = "审批结果有误")
   private Integer approvalResult;
   @ApiModelProperty("备注")
   private String remark;

   public Long getTempWorkId() {
      return this.tempWorkId;
   }

   public BigDecimal getCalculateAmount() {
      return this.calculateAmount;
   }

   public Integer getApprovalResult() {
      return this.approvalResult;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setTempWorkId(final Long tempWorkId) {
      this.tempWorkId = tempWorkId;
   }

   public void setCalculateAmount(final BigDecimal calculateAmount) {
      this.calculateAmount = calculateAmount;
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

      if (!(o instanceof MesTempWorkApprovalParam)) {
         return false;
      }

      MesTempWorkApprovalParam other = (MesTempWorkApprovalParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$tempWorkId = this.getTempWorkId();
      Object other$tempWorkId = other.getTempWorkId();
      if (this$tempWorkId == null ? other$tempWorkId == null : this$tempWorkId.equals(other$tempWorkId)) {
         Object this$approvalResult = this.getApprovalResult();
         Object other$approvalResult = other.getApprovalResult();
         if (this$approvalResult == null ? other$approvalResult == null : this$approvalResult.equals(other$approvalResult)) {
            Object this$calculateAmount = this.getCalculateAmount();
            Object other$calculateAmount = other.getCalculateAmount();
            if (this$calculateAmount == null ? other$calculateAmount == null : this$calculateAmount.equals(other$calculateAmount)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MesTempWorkApprovalParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $tempWorkId = this.getTempWorkId();
      result = result * 59 + ($tempWorkId == null ? 43 : $tempWorkId.hashCode());
      Object $approvalResult = this.getApprovalResult();
      result = result * 59 + ($approvalResult == null ? 43 : $approvalResult.hashCode());
      Object $calculateAmount = this.getCalculateAmount();
      result = result * 59 + ($calculateAmount == null ? 43 : $calculateAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkApprovalParam(tempWorkId="
         + this.getTempWorkId()
         + ", calculateAmount="
         + this.getCalculateAmount()
         + ", approvalResult="
         + this.getApprovalResult()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
