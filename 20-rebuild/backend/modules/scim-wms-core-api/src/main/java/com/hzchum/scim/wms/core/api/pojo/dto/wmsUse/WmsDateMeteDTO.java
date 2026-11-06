package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class WmsDateMeteDTO {
   @ApiModelProperty(name = "dateTime", value = "日期")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   private String dateTime;
   @ApiModelProperty(name = "mete", value = "出库量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   public static WmsDateMeteDTO.WmsDateMeteDTOBuilder builder() {
      return new WmsDateMeteDTO.WmsDateMeteDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("dateTime")
   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WmsDateMeteDTO)) {
         return false;
      } else {
         WmsDateMeteDTO other = (WmsDateMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsDateMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "WmsDateMeteDTO(dateTime=" + this.getDateTime() + ", mete=" + this.getMete() + ")";
   }

   public WmsDateMeteDTO(final String dateTime, final BigDecimal mete) {
      this.dateTime = dateTime;
      this.mete = mete;
   }

   public WmsDateMeteDTO() {
   }

   public static class WmsDateMeteDTOBuilder {
      private String dateTime;
      private BigDecimal mete;

      WmsDateMeteDTOBuilder() {
      }

      @JsonProperty("dateTime")
      public WmsDateMeteDTO.WmsDateMeteDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("mete")
      public WmsDateMeteDTO.WmsDateMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public WmsDateMeteDTO build() {
         return new WmsDateMeteDTO(this.dateTime, this.mete);
      }

      @Override
      public String toString() {
         return "WmsDateMeteDTO.WmsDateMeteDTOBuilder(dateTime=" + this.dateTime + ", mete=" + this.mete + ")";
      }
   }
}
