package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("计量方式请求类")
public class MeasureModeDTOParam {
   @NotNull(message = "围护类型不能为空")
   @ApiModelProperty("围护类型")
   private Integer no;
   @NotNull(message = "计量方式不能为空")
   @Max(value = 2L, message = "围护计量方式大值超出范围")
   @Min(value = 1L, message = "围护计量方式小值超出范围")
   @ApiModelProperty("计量方式")
   private Integer measureMode;
   @NotNull(message = "工程量")
   @ApiModelProperty("工程量")
   private BigDecimal quantityWork;

   public static MeasureModeDTOParam.MeasureModeDTOParamBuilder builder() {
      return new MeasureModeDTOParam.MeasureModeDTOParamBuilder();
   }

   public MeasureModeDTOParam(final Integer no, final Integer measureMode, final BigDecimal quantityWork) {
      this.no = no;
      this.measureMode = measureMode;
      this.quantityWork = quantityWork;
   }

   public MeasureModeDTOParam() {
   }

   public Integer getNo() {
      return this.no;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public void setNo(final Integer no) {
      this.no = no;
   }

   public void setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MeasureModeDTOParam)) {
         return false;
      }

      MeasureModeDTOParam other = (MeasureModeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$no = this.getNo();
      Object other$no = other.getNo();
      if (this$no == null ? other$no == null : this$no.equals(other$no)) {
         Object this$measureMode = this.getMeasureMode();
         Object other$measureMode = other.getMeasureMode();
         if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
            Object this$quantityWork = this.getQuantityWork();
            Object other$quantityWork = other.getQuantityWork();
            return this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MeasureModeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $no = this.getNo();
      result = result * 59 + ($no == null ? 43 : $no.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   @Override
   public String toString() {
      return "MeasureModeDTOParam(no=" + this.getNo() + ", measureMode=" + this.getMeasureMode() + ", quantityWork=" + this.getQuantityWork() + ")";
   }

   public static class MeasureModeDTOParamBuilder {
      private Integer no;
      private Integer measureMode;
      private BigDecimal quantityWork;

      MeasureModeDTOParamBuilder() {
      }

      public MeasureModeDTOParam.MeasureModeDTOParamBuilder no(final Integer no) {
         this.no = no;
         return this;
      }

      public MeasureModeDTOParam.MeasureModeDTOParamBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      public MeasureModeDTOParam.MeasureModeDTOParamBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public MeasureModeDTOParam build() {
         return new MeasureModeDTOParam(this.no, this.measureMode, this.quantityWork);
      }

      @Override
      public String toString() {
         return "MeasureModeDTOParam.MeasureModeDTOParamBuilder(no="
            + this.no
            + ", measureMode="
            + this.measureMode
            + ", quantityWork="
            + this.quantityWork
            + ")";
      }
   }
}
