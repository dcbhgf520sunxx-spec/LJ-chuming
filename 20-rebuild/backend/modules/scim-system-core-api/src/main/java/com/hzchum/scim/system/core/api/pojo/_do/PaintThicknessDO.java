package com.hzchum.scim.system.core.api.pojo._do;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("漆膜厚度配置")
public class PaintThicknessDO {
   @ApiModelProperty("是否启用")
   @NotNull(message = "是否启用不能为空！")
   private Boolean enable;
   @NotNull(message = "检测方式不能为空！")
   @ApiModelProperty(value = "检测方式", notes = "1.全量检测：构件“完成”漆膜厚度检测才可通过质检 2.快速检测：构件“未完成”漆膜厚度检测也可通过质检，检测不作为通过质检的硬性条件")
   private Integer detectionWay;
   @ApiModelProperty("适用的工序id")
   private List<Long> processes;
   @ApiModelProperty("最小厚度")
   private BigDecimal minThickness;
   @ApiModelProperty("最大厚度")
   private BigDecimal maxThickness;
   @NotNull(message = "是否必须在范围之内不能为空！")
   @ApiModelProperty("是否必须在范围之内")
   private Boolean mustScope;
   @NotNull(message = "是否支持手动填充漆膜厚度不能为空！")
   @ApiModelProperty("是否支持手动填充漆膜厚度")
   private Boolean allowManualFill;

   public static PaintThicknessDO.PaintThicknessDOBuilder builder() {
      return new PaintThicknessDO.PaintThicknessDOBuilder();
   }

   public Boolean getEnable() {
      return this.enable;
   }

   public Integer getDetectionWay() {
      return this.detectionWay;
   }

   public List<Long> getProcesses() {
      return this.processes;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   public Boolean getMustScope() {
      return this.mustScope;
   }

   public Boolean getAllowManualFill() {
      return this.allowManualFill;
   }

   public void setEnable(final Boolean enable) {
      this.enable = enable;
   }

   public void setDetectionWay(final Integer detectionWay) {
      this.detectionWay = detectionWay;
   }

   public void setProcesses(final List<Long> processes) {
      this.processes = processes;
   }

   public void setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
   }

   public void setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
   }

   public void setMustScope(final Boolean mustScope) {
      this.mustScope = mustScope;
   }

   public void setAllowManualFill(final Boolean allowManualFill) {
      this.allowManualFill = allowManualFill;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintThicknessDO)) {
         return false;
      }

      PaintThicknessDO other = (PaintThicknessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enable = this.getEnable();
      Object other$enable = other.getEnable();
      if (this$enable == null ? other$enable == null : this$enable.equals(other$enable)) {
         Object this$detectionWay = this.getDetectionWay();
         Object other$detectionWay = other.getDetectionWay();
         if (this$detectionWay == null ? other$detectionWay == null : this$detectionWay.equals(other$detectionWay)) {
            Object this$mustScope = this.getMustScope();
            Object other$mustScope = other.getMustScope();
            if (this$mustScope == null ? other$mustScope == null : this$mustScope.equals(other$mustScope)) {
               Object this$allowManualFill = this.getAllowManualFill();
               Object other$allowManualFill = other.getAllowManualFill();
               if (this$allowManualFill == null ? other$allowManualFill == null : this$allowManualFill.equals(other$allowManualFill)) {
                  Object this$processes = this.getProcesses();
                  Object other$processes = other.getProcesses();
                  if (this$processes == null ? other$processes == null : this$processes.equals(other$processes)) {
                     Object this$minThickness = this.getMinThickness();
                     Object other$minThickness = other.getMinThickness();
                     if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
                        Object this$maxThickness = this.getMaxThickness();
                        Object other$maxThickness = other.getMaxThickness();
                        return this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaintThicknessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enable = this.getEnable();
      result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
      Object $detectionWay = this.getDetectionWay();
      result = result * 59 + ($detectionWay == null ? 43 : $detectionWay.hashCode());
      Object $mustScope = this.getMustScope();
      result = result * 59 + ($mustScope == null ? 43 : $mustScope.hashCode());
      Object $allowManualFill = this.getAllowManualFill();
      result = result * 59 + ($allowManualFill == null ? 43 : $allowManualFill.hashCode());
      Object $processes = this.getProcesses();
      result = result * 59 + ($processes == null ? 43 : $processes.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      return result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
   }

   @Override
   public String toString() {
      return "PaintThicknessDO(enable="
         + this.getEnable()
         + ", detectionWay="
         + this.getDetectionWay()
         + ", processes="
         + this.getProcesses()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", mustScope="
         + this.getMustScope()
         + ", allowManualFill="
         + this.getAllowManualFill()
         + ")";
   }

   public PaintThicknessDO() {
   }

   public PaintThicknessDO(
      final Boolean enable,
      final Integer detectionWay,
      final List<Long> processes,
      final BigDecimal minThickness,
      final BigDecimal maxThickness,
      final Boolean mustScope,
      final Boolean allowManualFill
   ) {
      this.enable = enable;
      this.detectionWay = detectionWay;
      this.processes = processes;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
      this.mustScope = mustScope;
      this.allowManualFill = allowManualFill;
   }

   public static class PaintThicknessDOBuilder {
      private Boolean enable;
      private Integer detectionWay;
      private List<Long> processes;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;
      private Boolean mustScope;
      private Boolean allowManualFill;

      PaintThicknessDOBuilder() {
      }

      public PaintThicknessDO.PaintThicknessDOBuilder enable(final Boolean enable) {
         this.enable = enable;
         return this;
      }

      public PaintThicknessDO.PaintThicknessDOBuilder detectionWay(final Integer detectionWay) {
         this.detectionWay = detectionWay;
         return this;
      }

      public PaintThicknessDO.PaintThicknessDOBuilder processes(final List<Long> processes) {
         this.processes = processes;
         return this;
      }

      public PaintThicknessDO.PaintThicknessDOBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      public PaintThicknessDO.PaintThicknessDOBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      public PaintThicknessDO.PaintThicknessDOBuilder mustScope(final Boolean mustScope) {
         this.mustScope = mustScope;
         return this;
      }

      public PaintThicknessDO.PaintThicknessDOBuilder allowManualFill(final Boolean allowManualFill) {
         this.allowManualFill = allowManualFill;
         return this;
      }

      public PaintThicknessDO build() {
         return new PaintThicknessDO(this.enable, this.detectionWay, this.processes, this.minThickness, this.maxThickness, this.mustScope, this.allowManualFill);
      }

      @Override
      public String toString() {
         return "PaintThicknessDO.PaintThicknessDOBuilder(enable="
            + this.enable
            + ", detectionWay="
            + this.detectionWay
            + ", processes="
            + this.processes
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", mustScope="
            + this.mustScope
            + ", allowManualFill="
            + this.allowManualFill
            + ")";
      }
   }
}
