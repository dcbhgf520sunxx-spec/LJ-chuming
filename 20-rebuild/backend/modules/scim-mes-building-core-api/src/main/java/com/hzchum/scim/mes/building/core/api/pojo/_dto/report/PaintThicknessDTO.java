package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "PaintThicknessDTO", description = "漆膜厚度检测记录")
public class PaintThicknessDTO {
   @ApiModelProperty(name = "name", notes = "检测点")
   private String name;
   @ApiModelProperty(name = "thickness", notes = "漆膜厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "createTime", notes = "漆膜检测时间")
   private LocalDateTime detectionTime;
   @ApiModelProperty(name = "number", notes = "码号")
   private int number;

   public PaintThicknessDTO(final String name, final BigDecimal thickness, final LocalDateTime detectionTime, final int number) {
      this.name = name;
      this.thickness = thickness;
      this.detectionTime = detectionTime;
      this.number = number;
   }

   public PaintThicknessDTO() {
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public LocalDateTime getDetectionTime() {
      return this.detectionTime;
   }

   public int getNumber() {
      return this.number;
   }

   public PaintThicknessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public PaintThicknessDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public PaintThicknessDTO setDetectionTime(final LocalDateTime detectionTime) {
      this.detectionTime = detectionTime;
      return this;
   }

   public PaintThicknessDTO setNumber(final int number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "PaintThicknessDTO(name="
         + this.getName()
         + ", thickness="
         + this.getThickness()
         + ", detectionTime="
         + this.getDetectionTime()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintThicknessDTO)) {
         return false;
      }

      PaintThicknessDTO other = (PaintThicknessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getNumber() != other.getNumber()) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$thickness = this.getThickness();
         Object other$thickness = other.getThickness();
         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
            Object this$detectionTime = this.getDetectionTime();
            Object other$detectionTime = other.getDetectionTime();
            return this$detectionTime == null ? other$detectionTime == null : this$detectionTime.equals(other$detectionTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaintThicknessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getNumber();
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $detectionTime = this.getDetectionTime();
      return result * 59 + ($detectionTime == null ? 43 : $detectionTime.hashCode());
   }
}
