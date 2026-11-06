package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ArtifactNumberQualifiedQuantityDTOParam {
   @ApiModelProperty(name = "number", value = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "boolQualified", value = "是否合格")
   @JsonProperty("boolQualified")
   @JSONField(name = "boolQualified")
   private Boolean boolQualified;

   public Integer getNumber() {
      return this.number;
   }

   public Boolean getBoolQualified() {
      return this.boolQualified;
   }

   @JsonProperty("number")
   public void setNumber(final Integer number) {
      this.number = number;
   }

   @JsonProperty("boolQualified")
   public void setBoolQualified(final Boolean boolQualified) {
      this.boolQualified = boolQualified;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactNumberQualifiedQuantityDTOParam)) {
         return false;
      } else {
         ArtifactNumberQualifiedQuantityDTOParam other = (ArtifactNumberQualifiedQuantityDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$boolQualified = this.getBoolQualified();
               Object other$boolQualified = other.getBoolQualified();
               return this$boolQualified == null ? other$boolQualified == null : this$boolQualified.equals(other$boolQualified);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactNumberQualifiedQuantityDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolQualified = this.getBoolQualified();
      return result * 59 + ($boolQualified == null ? 43 : $boolQualified.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactNumberQualifiedQuantityDTOParam(number=" + this.getNumber() + ", boolQualified=" + this.getBoolQualified() + ")";
   }
}
