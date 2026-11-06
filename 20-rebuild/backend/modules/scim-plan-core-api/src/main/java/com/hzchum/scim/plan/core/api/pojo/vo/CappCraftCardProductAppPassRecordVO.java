package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP app焊接焊接电流电压 响应参数")
public class CappCraftCardProductAppPassRecordVO {
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   private String electricity;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   private String voltage;

   public String getElectricity() {
      return this.electricity;
   }

   public String getVoltage() {
      return this.voltage;
   }

   public void setElectricity(final String electricity) {
      this.electricity = electricity;
   }

   public void setVoltage(final String voltage) {
      this.voltage = voltage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappCraftCardProductAppPassRecordVO)) {
         return false;
      } else {
         CappCraftCardProductAppPassRecordVO other = (CappCraftCardProductAppPassRecordVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$electricity = this.getElectricity();
            Object other$electricity = other.getElectricity();
            if (this$electricity == null ? other$electricity == null : this$electricity.equals(other$electricity)) {
               Object this$voltage = this.getVoltage();
               Object other$voltage = other.getVoltage();
               return this$voltage == null ? other$voltage == null : this$voltage.equals(other$voltage);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductAppPassRecordVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $electricity = this.getElectricity();
      result = result * 59 + ($electricity == null ? 43 : $electricity.hashCode());
      Object $voltage = this.getVoltage();
      return result * 59 + ($voltage == null ? 43 : $voltage.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppPassRecordVO(electricity=" + this.getElectricity() + ", voltage=" + this.getVoltage() + ")";
   }
}
