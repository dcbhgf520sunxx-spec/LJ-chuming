package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "物流管理V2")
public class SupplierPriceSaveVORequestParam extends SupplierPriceSaveDTOParam {
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体")
   @NotNull(message = "签订主体不能为空")
   private Long branchCompanyId;

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceSaveVORequestParam)) {
         return false;
      }

      SupplierPriceSaveVORequestParam other = (SupplierPriceSaveVORequestParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      return this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPriceSaveVORequestParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      return result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPriceSaveVORequestParam(branchCompanyId=" + this.getBranchCompanyId() + ")";
   }
}
