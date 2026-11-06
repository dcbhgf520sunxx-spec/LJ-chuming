package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;

public class MonomerArtifactSnDTOParam {
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("构件编号")
   private String serialNumber;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonomerArtifactSnDTOParam)) {
         return false;
      } else {
         MonomerArtifactSnDTOParam other = (MonomerArtifactSnDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerArtifactSnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerArtifactSnDTOParam(monomerId=" + this.getMonomerId() + ", serialNumber=" + this.getSerialNumber() + ")";
   }
}
