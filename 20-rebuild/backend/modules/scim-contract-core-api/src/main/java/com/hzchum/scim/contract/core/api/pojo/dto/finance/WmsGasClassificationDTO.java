package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("科目表气体种类dto")
public class WmsGasClassificationDTO extends NameInfo {
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsGasClassificationDTO)) {
         return false;
      }

      WmsGasClassificationDTO other = (WmsGasClassificationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$accountingUnit = this.getAccountingUnit();
      Object other$accountingUnit = other.getAccountingUnit();
      return this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsGasClassificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "WmsGasClassificationDTO(accountingUnit=" + this.getAccountingUnit() + ")";
   }
}
