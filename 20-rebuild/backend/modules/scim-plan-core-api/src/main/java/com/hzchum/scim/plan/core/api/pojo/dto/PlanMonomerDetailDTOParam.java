package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("单体详情新增类")
public class PlanMonomerDetailDTOParam {
   @ApiModelProperty(name = "type", value = "类型 产品类型  1结构件 2压型彩板 4夹芯板  8桁架楼承板 16压型楼承板  32折边件")
   @NotNull(message = "单体详情type不能为空")
   private Integer type;
   @ApiModelProperty(name = "date", value = "计划完成日期")
   @NotNull(message = "单体详情完成日期不能为空")
   private LocalDate date;
   @ApiModelProperty(name = "mete", value = "量 ")
   @NotNull(message = "单体详情量不能为空")
   @Min(value = 0L, message = "单体详情量不能为负数")
   private BigDecimal mete;

   public static PlanMonomerDetailDTOParam.PlanMonomerDetailDTOParamBuilder builder() {
      return new PlanMonomerDetailDTOParam.PlanMonomerDetailDTOParamBuilder();
   }

   public PlanMonomerDetailDTOParam() {
   }

   public PlanMonomerDetailDTOParam(final Integer type, final LocalDate date, final BigDecimal mete) {
      this.type = type;
      this.date = date;
      this.mete = mete;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerDetailDTOParam)) {
         return false;
      }

      PlanMonomerDetailDTOParam other = (PlanMonomerDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanMonomerDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMonomerDetailDTOParam(type=" + this.getType() + ", date=" + this.getDate() + ", mete=" + this.getMete() + ")";
   }

   public static class PlanMonomerDetailDTOParamBuilder {
      private Integer type;
      private LocalDate date;
      private BigDecimal mete;

      PlanMonomerDetailDTOParamBuilder() {
      }

      public PlanMonomerDetailDTOParam.PlanMonomerDetailDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanMonomerDetailDTOParam.PlanMonomerDetailDTOParamBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public PlanMonomerDetailDTOParam.PlanMonomerDetailDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PlanMonomerDetailDTOParam build() {
         return new PlanMonomerDetailDTOParam(this.type, this.date, this.mete);
      }

      @Override
      public String toString() {
         return "PlanMonomerDetailDTOParam.PlanMonomerDetailDTOParamBuilder(type=" + this.type + ", date=" + this.date + ", mete=" + this.mete + ")";
      }
   }
}
