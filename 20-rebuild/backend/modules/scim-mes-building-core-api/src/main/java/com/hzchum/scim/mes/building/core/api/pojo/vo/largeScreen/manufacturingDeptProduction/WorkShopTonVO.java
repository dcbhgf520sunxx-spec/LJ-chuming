package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class WorkShopTonVO {
   @ApiModelProperty(name = "workShopId", value = "车间id")
   private Long workShopId;
   @ApiModelProperty(name = "dateValue", value = "时间")
   private String dateValue;
   @ApiModelProperty(name = "ton", value = "吨重")
   private BigDecimal ton;
   @ApiModelProperty(name = "workShopShortName", value = "车间简称")
   private String workShopShortName;
   @ApiModelProperty(name = "quarter", value = "季度")
   private String quarter;

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getDateValue() {
      return this.dateValue;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   public String getWorkShopShortName() {
      return this.workShopShortName;
   }

   public String getQuarter() {
      return this.quarter;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setDateValue(final String dateValue) {
      this.dateValue = dateValue;
   }

   public void setTon(final BigDecimal ton) {
      this.ton = ton;
   }

   public void setWorkShopShortName(final String workShopShortName) {
      this.workShopShortName = workShopShortName;
   }

   public void setQuarter(final String quarter) {
      this.quarter = quarter;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkShopTonVO)) {
         return false;
      }

      WorkShopTonVO other = (WorkShopTonVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$dateValue = this.getDateValue();
         Object other$dateValue = other.getDateValue();
         if (this$dateValue == null ? other$dateValue == null : this$dateValue.equals(other$dateValue)) {
            Object this$ton = this.getTon();
            Object other$ton = other.getTon();
            if (this$ton == null ? other$ton == null : this$ton.equals(other$ton)) {
               Object this$workShopShortName = this.getWorkShopShortName();
               Object other$workShopShortName = other.getWorkShopShortName();
               if (this$workShopShortName == null ? other$workShopShortName == null : this$workShopShortName.equals(other$workShopShortName)) {
                  Object this$quarter = this.getQuarter();
                  Object other$quarter = other.getQuarter();
                  return this$quarter == null ? other$quarter == null : this$quarter.equals(other$quarter);
               } else {
                  return false;
               }
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
      return other instanceof WorkShopTonVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $dateValue = this.getDateValue();
      result = result * 59 + ($dateValue == null ? 43 : $dateValue.hashCode());
      Object $ton = this.getTon();
      result = result * 59 + ($ton == null ? 43 : $ton.hashCode());
      Object $workShopShortName = this.getWorkShopShortName();
      result = result * 59 + ($workShopShortName == null ? 43 : $workShopShortName.hashCode());
      Object $quarter = this.getQuarter();
      return result * 59 + ($quarter == null ? 43 : $quarter.hashCode());
   }

   @Override
   public String toString() {
      return "WorkShopTonVO(workShopId="
         + this.getWorkShopId()
         + ", dateValue="
         + this.getDateValue()
         + ", ton="
         + this.getTon()
         + ", workShopShortName="
         + this.getWorkShopShortName()
         + ", quarter="
         + this.getQuarter()
         + ")";
   }
}
