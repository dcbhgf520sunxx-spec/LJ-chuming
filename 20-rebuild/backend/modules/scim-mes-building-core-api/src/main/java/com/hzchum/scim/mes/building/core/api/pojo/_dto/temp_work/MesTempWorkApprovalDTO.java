package com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWorkApproval;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("点工审批DTO类")
public class MesTempWorkApprovalDTO extends MesTempWorkApproval {
   @ApiModelProperty("审批人名称")
   private String approverName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkApprovalDTO)) {
         return false;
      }

      MesTempWorkApprovalDTO other = (MesTempWorkApprovalDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$approverName = this.getApproverName();
      Object other$approverName = other.getApproverName();
      return this$approverName == null ? other$approverName == null : this$approverName.equals(other$approverName);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesTempWorkApprovalDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $approverName = this.getApproverName();
      return result * 59 + ($approverName == null ? 43 : $approverName.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkApprovalDTO(super=" + super.toString() + ", approverName=" + this.getApproverName() + ")";
   }

   public String getApproverName() {
      return this.approverName;
   }

   public void setApproverName(final String approverName) {
      this.approverName = approverName;
   }
}
