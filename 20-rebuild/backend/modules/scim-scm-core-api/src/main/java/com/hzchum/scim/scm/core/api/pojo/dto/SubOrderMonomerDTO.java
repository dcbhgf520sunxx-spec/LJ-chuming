package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分包订单-单体信息")
public class SubOrderMonomerDTO {
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubOrderMonomerDTO)) {
         return false;
      } else {
         SubOrderMonomerDTO other = (SubOrderMonomerDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$monomerName = this.getMonomerName();
               Object other$monomerName = other.getMonomerName();
               return this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubOrderMonomerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $monomerName = this.getMonomerName();
      return result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
   }

   @Override
   public String toString() {
      return "SubOrderMonomerDTO(monomerId=" + this.getMonomerId() + ", monomerName=" + this.getMonomerName() + ")";
   }
}
