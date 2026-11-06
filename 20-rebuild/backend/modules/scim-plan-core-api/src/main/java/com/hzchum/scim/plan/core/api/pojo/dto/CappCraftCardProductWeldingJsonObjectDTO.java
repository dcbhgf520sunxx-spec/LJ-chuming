package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "CAPP 焊接工艺mark文件转json")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CappCraftCardProductWeldingJsonObjectDTO {
   @JsonProperty("markName")
   private String markName;
   @JsonProperty("jointName")
   private String jointName;
   @JsonProperty("deviceName")
   private String deviceName;
   @JsonProperty("weldingName")
   private String weldingName;

   public String getMarkName() {
      return this.markName;
   }

   public String getJointName() {
      return this.jointName;
   }

   public String getDeviceName() {
      return this.deviceName;
   }

   public String getWeldingName() {
      return this.weldingName;
   }

   @JsonProperty("markName")
   public void setMarkName(final String markName) {
      this.markName = markName;
   }

   @JsonProperty("jointName")
   public void setJointName(final String jointName) {
      this.jointName = jointName;
   }

   @JsonProperty("deviceName")
   public void setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
   }

   @JsonProperty("weldingName")
   public void setWeldingName(final String weldingName) {
      this.weldingName = weldingName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductWeldingJsonObjectDTO)) {
         return false;
      }

      CappCraftCardProductWeldingJsonObjectDTO other = (CappCraftCardProductWeldingJsonObjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$markName = this.getMarkName();
      Object other$markName = other.getMarkName();
      if (this$markName == null ? other$markName == null : this$markName.equals(other$markName)) {
         Object this$jointName = this.getJointName();
         Object other$jointName = other.getJointName();
         if (this$jointName == null ? other$jointName == null : this$jointName.equals(other$jointName)) {
            Object this$deviceName = this.getDeviceName();
            Object other$deviceName = other.getDeviceName();
            if (this$deviceName == null ? other$deviceName == null : this$deviceName.equals(other$deviceName)) {
               Object this$weldingName = this.getWeldingName();
               Object other$weldingName = other.getWeldingName();
               return this$weldingName == null ? other$weldingName == null : this$weldingName.equals(other$weldingName);
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
      return other instanceof CappCraftCardProductWeldingJsonObjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $markName = this.getMarkName();
      result = result * 59 + ($markName == null ? 43 : $markName.hashCode());
      Object $jointName = this.getJointName();
      result = result * 59 + ($jointName == null ? 43 : $jointName.hashCode());
      Object $deviceName = this.getDeviceName();
      result = result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
      Object $weldingName = this.getWeldingName();
      return result * 59 + ($weldingName == null ? 43 : $weldingName.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductWeldingJsonObjectDTO(markName="
         + this.getMarkName()
         + ", jointName="
         + this.getJointName()
         + ", deviceName="
         + this.getDeviceName()
         + ", weldingName="
         + this.getWeldingName()
         + ")";
   }
}
