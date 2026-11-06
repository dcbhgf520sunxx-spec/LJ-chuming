package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "CAPP 焊接数据采集记录修改  请求参数")
public class CappCraftCardWeldingGatherUpdateDTO {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   private BigDecimal electricity;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   private BigDecimal voltage;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getElectricity() {
      return this.electricity;
   }

   public BigDecimal getVoltage() {
      return this.voltage;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setElectricity(final BigDecimal electricity) {
      this.electricity = electricity;
   }

   public void setVoltage(final BigDecimal voltage) {
      this.voltage = voltage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardWeldingGatherUpdateDTO)) {
         return false;
      }

      CappCraftCardWeldingGatherUpdateDTO other = (CappCraftCardWeldingGatherUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$electricity = this.getElectricity();
         Object other$electricity = other.getElectricity();
         if (this$electricity == null ? other$electricity == null : this$electricity.equals(other$electricity)) {
            Object this$voltage = this.getVoltage();
            Object other$voltage = other.getVoltage();
            return this$voltage == null ? other$voltage == null : this$voltage.equals(other$voltage);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardWeldingGatherUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $electricity = this.getElectricity();
      result = result * 59 + ($electricity == null ? 43 : $electricity.hashCode());
      Object $voltage = this.getVoltage();
      return result * 59 + ($voltage == null ? 43 : $voltage.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardWeldingGatherUpdateDTO(id=" + this.getId() + ", electricity=" + this.getElectricity() + ", voltage=" + this.getVoltage() + ")";
   }
}
