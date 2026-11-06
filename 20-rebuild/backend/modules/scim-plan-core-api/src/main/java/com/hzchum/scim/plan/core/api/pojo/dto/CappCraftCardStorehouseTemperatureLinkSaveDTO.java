package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

@ApiModel(description = "CAPP 焊接板厚对应温度信息配置 新增 请求参数")
public class CappCraftCardStorehouseTemperatureLinkSaveDTO {
   @ApiModelProperty(name = "thickness", value = "板厚", notes = "板厚")
   @Size(max = 200, message = "板厚不能超过200个字符")
   private String thickness;
   @ApiModelProperty(name = "preheatingTemperature", value = "预热温度", notes = "预热温度")
   @Size(max = 200, message = "预热温度不能超过200个字符")
   private String preheatingTemperature;
   @ApiModelProperty(name = "roadTemperature", value = "道间温度", notes = "道间温度")
   @Size(max = 200, message = "道间温度不能超过200个字符")
   private String roadTemperature;

   public String getThickness() {
      return this.thickness;
   }

   public String getPreheatingTemperature() {
      return this.preheatingTemperature;
   }

   public String getRoadTemperature() {
      return this.roadTemperature;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setPreheatingTemperature(final String preheatingTemperature) {
      this.preheatingTemperature = preheatingTemperature;
   }

   public void setRoadTemperature(final String roadTemperature) {
      this.roadTemperature = roadTemperature;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardStorehouseTemperatureLinkSaveDTO)) {
         return false;
      }

      CappCraftCardStorehouseTemperatureLinkSaveDTO other = (CappCraftCardStorehouseTemperatureLinkSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$thickness = this.getThickness();
      Object other$thickness = other.getThickness();
      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
         Object this$preheatingTemperature = this.getPreheatingTemperature();
         Object other$preheatingTemperature = other.getPreheatingTemperature();
         if (this$preheatingTemperature == null ? other$preheatingTemperature == null : this$preheatingTemperature.equals(other$preheatingTemperature)) {
            Object this$roadTemperature = this.getRoadTemperature();
            Object other$roadTemperature = other.getRoadTemperature();
            return this$roadTemperature == null ? other$roadTemperature == null : this$roadTemperature.equals(other$roadTemperature);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardStorehouseTemperatureLinkSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $preheatingTemperature = this.getPreheatingTemperature();
      result = result * 59 + ($preheatingTemperature == null ? 43 : $preheatingTemperature.hashCode());
      Object $roadTemperature = this.getRoadTemperature();
      return result * 59 + ($roadTemperature == null ? 43 : $roadTemperature.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseTemperatureLinkSaveDTO(thickness="
         + this.getThickness()
         + ", preheatingTemperature="
         + this.getPreheatingTemperature()
         + ", roadTemperature="
         + this.getRoadTemperature()
         + ")";
   }
}
