package com.hzchum.scim.common.core.api.pojo.dto.bochu;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("柏楚零件扩展属性DTO")
public class PropDTO {
   @JsonProperty("prop_name")
   @Alias("prop_name")
   private String propName;
   @JsonProperty("prop_value")
   @Alias("prop_value")
   private Object propValue;

   public String getPropName() {
      return this.propName;
   }

   public Object getPropValue() {
      return this.propValue;
   }

   @JsonProperty("prop_name")
   public void setPropName(final String propName) {
      this.propName = propName;
   }

   @JsonProperty("prop_value")
   public void setPropValue(final Object propValue) {
      this.propValue = propValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PropDTO)) {
         return false;
      } else {
         PropDTO other = (PropDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$propName = this.getPropName();
            Object other$propName = other.getPropName();
            if (this$propName == null ? other$propName == null : this$propName.equals(other$propName)) {
               Object this$propValue = this.getPropValue();
               Object other$propValue = other.getPropValue();
               return this$propValue == null ? other$propValue == null : this$propValue.equals(other$propValue);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PropDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $propName = this.getPropName();
      result = result * 59 + ($propName == null ? 43 : $propName.hashCode());
      Object $propValue = this.getPropValue();
      return result * 59 + ($propValue == null ? 43 : $propValue.hashCode());
   }

   @Override
   public String toString() {
      return "PropDTO(propName=" + this.getPropName() + ", propValue=" + this.getPropValue() + ")";
   }
}
