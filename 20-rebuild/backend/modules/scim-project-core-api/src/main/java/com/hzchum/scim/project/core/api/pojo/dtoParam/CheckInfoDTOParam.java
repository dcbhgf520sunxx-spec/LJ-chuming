package com.hzchum.scim.project.core.api.pojo.dtoParam;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CheckInfoDTOParam {
   @NotNull(message = "单体不能为空")
   private Long monomerId;
   private String remark;
   @Valid
   @NotEmpty(message = "商务审核详情不能为空")
   private List<CheckDetailDTOParam> details;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<CheckDetailDTOParam> getDetails() {
      return this.details;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDetails(final List<CheckDetailDTOParam> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CheckInfoDTOParam)) {
         return false;
      }

      CheckInfoDTOParam other = (CheckInfoDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$details = this.getDetails();
            Object other$details = other.getDetails();
            return this$details == null ? other$details == null : this$details.equals(other$details);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CheckInfoDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "CheckInfoDTOParam(monomerId=" + this.getMonomerId() + ", remark=" + this.getRemark() + ", details=" + this.getDetails() + ")";
   }
}
