package com.hzchum.scim.system.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;

public class SteelClassificationMatchDTO {
   @ApiModelProperty("钢材配置id")
   private Long steelId;
   @ApiModelProperty("规格")
   private String spec;

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSpec() {
      return this.spec;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SteelClassificationMatchDTO)) {
         return false;
      } else {
         SteelClassificationMatchDTO other = (SteelClassificationMatchDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$steelId = this.getSteelId();
            Object other$steelId = other.getSteelId();
            if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
               Object this$spec = this.getSpec();
               Object other$spec = other.getSpec();
               return this$spec == null ? other$spec == null : this$spec.equals(other$spec);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelClassificationMatchDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $spec = this.getSpec();
      return result * 59 + ($spec == null ? 43 : $spec.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassificationMatchDTO(steelId=" + this.getSteelId() + ", spec=" + this.getSpec() + ")";
   }
}
