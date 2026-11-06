package com.hzchum.scim.system.core.api.pojo._do;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("绑定钢板配置")
public class SteelPlateConfigDTO {
   @ApiModelProperty("是否绑定钢板配置 true关联 false不关联)")
   @NotNull(message = "参数不能为空")
   private Boolean steelPlateType;

   public static SteelPlateConfigDTO.SteelPlateConfigDTOBuilder builder() {
      return new SteelPlateConfigDTO.SteelPlateConfigDTOBuilder();
   }

   public Boolean getSteelPlateType() {
      return this.steelPlateType;
   }

   public void setSteelPlateType(final Boolean steelPlateType) {
      this.steelPlateType = steelPlateType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelPlateConfigDTO)) {
         return false;
      }

      SteelPlateConfigDTO other = (SteelPlateConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelPlateType = this.getSteelPlateType();
      Object other$steelPlateType = other.getSteelPlateType();
      return this$steelPlateType == null ? other$steelPlateType == null : this$steelPlateType.equals(other$steelPlateType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelPlateConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelPlateType = this.getSteelPlateType();
      return result * 59 + ($steelPlateType == null ? 43 : $steelPlateType.hashCode());
   }

   @Override
   public String toString() {
      return "SteelPlateConfigDTO(steelPlateType=" + this.getSteelPlateType() + ")";
   }

   public SteelPlateConfigDTO() {
   }

   public SteelPlateConfigDTO(final Boolean steelPlateType) {
      this.steelPlateType = steelPlateType;
   }

   public static class SteelPlateConfigDTOBuilder {
      private Boolean steelPlateType;

      SteelPlateConfigDTOBuilder() {
      }

      public SteelPlateConfigDTO.SteelPlateConfigDTOBuilder steelPlateType(final Boolean steelPlateType) {
         this.steelPlateType = steelPlateType;
         return this;
      }

      public SteelPlateConfigDTO build() {
         return new SteelPlateConfigDTO(this.steelPlateType);
      }

      @Override
      public String toString() {
         return "SteelPlateConfigDTO.SteelPlateConfigDTOBuilder(steelPlateType=" + this.steelPlateType + ")";
      }
   }
}
