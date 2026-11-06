package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class SystemWatermarkConfigDTO {
   @NotNull(message = "参数不能为空!")
   @ApiModelProperty("是否启用水印:true启用 false禁用")
   private Boolean boolEnableWatermark;
   @ApiModelProperty("水印字体大小(mm)")
   private BigDecimal fontSize;
   @ApiModelProperty("水印间隔(mm)")
   private BigDecimal spacing;
   @ApiModelProperty("倾斜角度(-360°~360°)")
   private BigDecimal angle;
   @ApiModelProperty("透明度(0~1)")
   private BigDecimal transparency;

   public static SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder builder() {
      return new SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder();
   }

   public SystemWatermarkConfigDTO() {
   }

   public SystemWatermarkConfigDTO(
      final Boolean boolEnableWatermark, final BigDecimal fontSize, final BigDecimal spacing, final BigDecimal angle, final BigDecimal transparency
   ) {
      this.boolEnableWatermark = boolEnableWatermark;
      this.fontSize = fontSize;
      this.spacing = spacing;
      this.angle = angle;
      this.transparency = transparency;
   }

   public Boolean getBoolEnableWatermark() {
      return this.boolEnableWatermark;
   }

   public BigDecimal getFontSize() {
      return this.fontSize;
   }

   public BigDecimal getSpacing() {
      return this.spacing;
   }

   public BigDecimal getAngle() {
      return this.angle;
   }

   public BigDecimal getTransparency() {
      return this.transparency;
   }

   public void setBoolEnableWatermark(final Boolean boolEnableWatermark) {
      this.boolEnableWatermark = boolEnableWatermark;
   }

   public void setFontSize(final BigDecimal fontSize) {
      this.fontSize = fontSize;
   }

   public void setSpacing(final BigDecimal spacing) {
      this.spacing = spacing;
   }

   public void setAngle(final BigDecimal angle) {
      this.angle = angle;
   }

   public void setTransparency(final BigDecimal transparency) {
      this.transparency = transparency;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SystemWatermarkConfigDTO)) {
         return false;
      }

      SystemWatermarkConfigDTO other = (SystemWatermarkConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolEnableWatermark = this.getBoolEnableWatermark();
      Object other$boolEnableWatermark = other.getBoolEnableWatermark();
      if (this$boolEnableWatermark == null ? other$boolEnableWatermark == null : this$boolEnableWatermark.equals(other$boolEnableWatermark)) {
         Object this$fontSize = this.getFontSize();
         Object other$fontSize = other.getFontSize();
         if (this$fontSize == null ? other$fontSize == null : this$fontSize.equals(other$fontSize)) {
            Object this$spacing = this.getSpacing();
            Object other$spacing = other.getSpacing();
            if (this$spacing == null ? other$spacing == null : this$spacing.equals(other$spacing)) {
               Object this$angle = this.getAngle();
               Object other$angle = other.getAngle();
               if (this$angle == null ? other$angle == null : this$angle.equals(other$angle)) {
                  Object this$transparency = this.getTransparency();
                  Object other$transparency = other.getTransparency();
                  return this$transparency == null ? other$transparency == null : this$transparency.equals(other$transparency);
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
      return other instanceof SystemWatermarkConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolEnableWatermark = this.getBoolEnableWatermark();
      result = result * 59 + ($boolEnableWatermark == null ? 43 : $boolEnableWatermark.hashCode());
      Object $fontSize = this.getFontSize();
      result = result * 59 + ($fontSize == null ? 43 : $fontSize.hashCode());
      Object $spacing = this.getSpacing();
      result = result * 59 + ($spacing == null ? 43 : $spacing.hashCode());
      Object $angle = this.getAngle();
      result = result * 59 + ($angle == null ? 43 : $angle.hashCode());
      Object $transparency = this.getTransparency();
      return result * 59 + ($transparency == null ? 43 : $transparency.hashCode());
   }

   @Override
   public String toString() {
      return "SystemWatermarkConfigDTO(boolEnableWatermark="
         + this.getBoolEnableWatermark()
         + ", fontSize="
         + this.getFontSize()
         + ", spacing="
         + this.getSpacing()
         + ", angle="
         + this.getAngle()
         + ", transparency="
         + this.getTransparency()
         + ")";
   }

   public static class SystemWatermarkConfigDTOBuilder {
      private Boolean boolEnableWatermark;
      private BigDecimal fontSize;
      private BigDecimal spacing;
      private BigDecimal angle;
      private BigDecimal transparency;

      SystemWatermarkConfigDTOBuilder() {
      }

      public SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder boolEnableWatermark(final Boolean boolEnableWatermark) {
         this.boolEnableWatermark = boolEnableWatermark;
         return this;
      }

      public SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder fontSize(final BigDecimal fontSize) {
         this.fontSize = fontSize;
         return this;
      }

      public SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder spacing(final BigDecimal spacing) {
         this.spacing = spacing;
         return this;
      }

      public SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder angle(final BigDecimal angle) {
         this.angle = angle;
         return this;
      }

      public SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder transparency(final BigDecimal transparency) {
         this.transparency = transparency;
         return this;
      }

      public SystemWatermarkConfigDTO build() {
         return new SystemWatermarkConfigDTO(this.boolEnableWatermark, this.fontSize, this.spacing, this.angle, this.transparency);
      }

      @Override
      public String toString() {
         return "SystemWatermarkConfigDTO.SystemWatermarkConfigDTOBuilder(boolEnableWatermark="
            + this.boolEnableWatermark
            + ", fontSize="
            + this.fontSize
            + ", spacing="
            + this.spacing
            + ", angle="
            + this.angle
            + ", transparency="
            + this.transparency
            + ")";
      }
   }
}
