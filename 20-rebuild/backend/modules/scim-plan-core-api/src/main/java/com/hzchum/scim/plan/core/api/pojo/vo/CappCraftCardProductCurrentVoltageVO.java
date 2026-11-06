package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "CAPP 焊接工艺产品道次电流电压 响应参数")
public class CappCraftCardProductCurrentVoltageVO {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   private BigDecimal electricity;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   private BigDecimal voltage;

   CappCraftCardProductCurrentVoltageVO(final Long id, final LocalDateTime createTime, final BigDecimal electricity, final BigDecimal voltage) {
      this.id = id;
      this.createTime = createTime;
      this.electricity = electricity;
      this.voltage = voltage;
   }

   public static CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder builder() {
      return new CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
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

      if (!(o instanceof CappCraftCardProductCurrentVoltageVO)) {
         return false;
      }

      CappCraftCardProductCurrentVoltageVO other = (CappCraftCardProductCurrentVoltageVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductCurrentVoltageVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $electricity = this.getElectricity();
      result = result * 59 + ($electricity == null ? 43 : $electricity.hashCode());
      Object $voltage = this.getVoltage();
      return result * 59 + ($voltage == null ? 43 : $voltage.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductCurrentVoltageVO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", electricity="
         + this.getElectricity()
         + ", voltage="
         + this.getVoltage()
         + ")";
   }

   public static class CappCraftCardProductCurrentVoltageVOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private BigDecimal electricity;
      private BigDecimal voltage;

      CappCraftCardProductCurrentVoltageVOBuilder() {
      }

      public CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder electricity(final BigDecimal electricity) {
         this.electricity = electricity;
         return this;
      }

      public CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder voltage(final BigDecimal voltage) {
         this.voltage = voltage;
         return this;
      }

      public CappCraftCardProductCurrentVoltageVO build() {
         return new CappCraftCardProductCurrentVoltageVO(this.id, this.createTime, this.electricity, this.voltage);
      }

      @Override
      public String toString() {
         return "CappCraftCardProductCurrentVoltageVO.CappCraftCardProductCurrentVoltageVOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", electricity="
            + this.electricity
            + ", voltage="
            + this.voltage
            + ")";
      }
   }
}
